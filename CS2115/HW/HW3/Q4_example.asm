.data
	f: .byte 7, 6, 5, 4, 3, 2, 1, 0		# Array 'f' with initial values
	res1: .asciiz "h("			# Result prompt message (part 1)
	res2: .asciiz ") = "			# Result prompt message (part 2)
	nl: .asciiz "\n"

.text
	main:
    	li $t0, 0		# Initialize $t0 to 0 (i = 0)
    	
    	loop:
        beq $t0, 31, exit	# Exit loop when x = 30
        move $a0, $t0		# Move the current value of x to $a0 (to pass it to hx)
        
        jal hx			# Jump and link to the 'hx' function
        move $s0, $v0		# Move the result from 'hx' to $s0
	
	# Result prompt No1
        li $v0, 4		# Load the value 4 into register $v0 (print string)
        la $a0, res1		# Load the address of 'res1' into register $a0
        syscall
	
	# Middle
        li $v0, 1		# Load the value 1 into register $v0 (print integer)
        move $a0, $t0		# Move the current value of x to $a0
        syscall
	
	# Result prompt No2
        li $v0, 4		# Load the value 4 into register $v0 (print string)
        la $a0, res2		# Load the address of 'res2' into register $a0
        syscall

        # Print h(x) with new line
        li $v0, 1		# Load the value 1 into register $v0 (print integer)
        move $a0, $s0		# Move the result value from $s0 to $a0
        syscall	
        
        li $v0, 4		# Load the value 4 into register $v0 (print string)
        la $a0, nl		# Load the address of 'nl' into register $a0
        syscall

        # Finish iteration -> i++
        addi $t0, $t0, 1	# Increment the value of $t0 by 1
        j loop			# Jump back to the beginning of the loop
        
    	exit:
        li $v0, 10		# Load the value 10 into register $v0 (exit program)
        syscall

	fx:	
    	la $t1, f		# Load the address of f into $t1
    	add $t1, $t1, $a0	# Add the value of $a0 to $t1
    	lb $v0, 0($t1)		# Load the byte at the address stored in $t1 into $v0
    	jr $ra			# Jump back to the return address

	hx:
    	li $t2, 7		# Load immediate value 7 into $t2
    	ble $a0, $t2, fx  	# If x <= 7, calculate f(x)
    
    	# Calculate h(x) recursively using h(x-1), h(x-2), h(x-3)
    	addi $sp, $sp, -16  # Allocate space on the stack for 4 int
    	sw $ra, 12($sp)     # Store the return address in the stack
    	sw $a0, 8($sp)      # Store the value of $a0 (h index) in the stack

    	addi $a0, $a0, -1   # Calculate x-1
    	jal hx		    # Call hx (h(x-1))
    	sw $v0, 4($sp)      # Store the result of h(x-1) in the stack

	lw $a0, 8($sp)      # Restore the original argument (h index)
    	addi $a0, $a0, -2   # Calculate x-2
    	jal hx		    # Call hx (h(x-2))
    	sw $v0, 0($sp)      # Store the result of h(x-2) in the stack

	lw $a0, 8($sp)	    # Restore the original argument (h index)
    	addi $a0, $a0, -3   # Calculate x-3
    	jal hx		    # Call hx (h(x-3))
    	
    	lw $t3, 0($sp)      # Load h(x-2) from the stack into $t3
    	sub $v0, $t3, $v0   # Calculate h(x-2) - h(x-3)
    	
	lw $t3, 4($sp)      # Load h(x-1) from the stack into $t3
	add $v0, $v0, $t3   # Calculate h(x-1) + (h(x-2) - h(x-3))

    	lw $ra, 12($sp)	    # Restore the return address
    	addi $sp, $sp, 16   # Deallocate space on the stack
    	jr $ra		    # Jump back to the return address
