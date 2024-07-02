.data
	prompt: .asciiz "Please enter an integer x: \n"
	
	
.text

	li $v0, 4
	la $a0, prompt
	syscall
	
	li $v0, 5
	syscall
	move $t0, $v0
	
	beq $t0, 0, zero
	beq $t0, 1, one
	beq $t0, 2, two
	beq $t0, 3, three
	beq $t0, 4, four
	beq $t0, 5, five
	beq $t0, 6, six
	beq $t0, 7, seven
	
	zero:
		li $a0, 5
		j print
	
	one:
		li $a0, 7
		j print
	
	two:
		li $a0, 8
		j print
	
	three:
		li $a0, 5
		j print
	
	four:
		li $a0, 4
		j print
		
	five:
		li $a0, 3
		j print
		
	six:
		li $a0, 2
		j print
		
	seven:
		li $a0, 9
		j print
		
	print:
		li $v0, 1
		syscall
		
		li $v0, 10
		syscall
		
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	