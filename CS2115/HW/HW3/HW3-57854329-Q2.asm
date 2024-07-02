.data
	project: .space 60
	prompt: .asciiz "Please enter the project name: \n"
	text: .asciiz "My name is LIU Hengche. My student ID is 57854329. My project name is "
	period: .asciiz "."
	
.text	
	li $v0, 4
	la $a0, prompt
	syscall

	li $v0, 8
	la $a0, project
	li $a1, 60
	syscall
	
	li $v0, 4
	la $a0, text
	syscall
	
	li $v0, 4
	la $a0, project
	syscall
	
	li $v0, 4
	la $a0, period
	syscall
	
	li $v0, 10
	syscall
	
	
	
	
