.data
	prompt: .asciiz "Please enter an integer: \n"
.text
	li $v0, 4
	la $a0, prompt
	syscall
	li $v0, 5
	syscall
	move $t0, $v0
	
	li $v0, 4
	la $a0, prompt
	syscall
	li $v0, 5
	syscall
	move $t1, $v0
	
	li $v0, 4
	la $a0, prompt
	syscall
	li $v0, 5
	syscall
	move $t2, $v0
	
	li $v0, 4
	la $a0, prompt
	syscall
	li $v0, 5
	syscall
	move $t3, $v0
	
	add $t0, $t0, $t1
	mult $t0, $t2
	mflo $t0
	and $t0, $t0, $t3
	
	move $a0, $t0
	li $v0, 1
	syscall
	
	li $v0, 10
	syscall
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	