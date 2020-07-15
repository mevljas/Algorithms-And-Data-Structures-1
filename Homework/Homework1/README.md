# Programmable calculator
In the java programming language, write a programmable calculator that allows advanced computation (programming) with integers (int) numbers and arrays. The calculator allows you to:

- calculation of arithmetic expressions in reverse polish notation
- simple concatenation programming (with the help of a stack)
- implementation of simple software constructs (conditions, loops, functions).  
The calculator should read from standard input. Each line represents one expression consisting of several parts (strings) - each represents either a valid command, an integer, or a string of characters. There is always (at least) a space between individual parts of an expression. You can assume that all the inputs are syntactically and semantically correct in testing.
  
Implement the solution with the help of 42 stacks: main (index 0) and auxiliary (with indices from 1 to 41). The vast majority of commands operate over the main stack (with an index of 0. For commands that can be executed over any stack, the stack index is specifically determined by the number at the top of the main stack.
  
The calculator should support the following commands or. operations (over the main stack):
   
- echo - displays the top of the stack in the line (leaves the stack unchanged); if the stack is empty, prints a blank line
- pop - remove the top of the stack
- dup - double the top of the stack (x -> x x)
- dup2 - double the pair at the top of the stack (x y -> x y x y)
- swap - replaces the top two stack elements (x y -> y x)  
The following operations replace the top of the main stack with the corresponding result (x -> y):
  
- char - replaces the top of the stack with a character that has the ASCII / Unicode code of the top of the stack
- even - the top of the stack is replaced by 1, if the top is a barrel, otherwise by 0
- odd - the top of the stack is replaced by 1, if the top is odd, otherwise by 0
- !! - the top of the stack is replaced by the top factorial
- len - the top of the stack is replaced by the length of the element at the top
  
The following operations replace the top two elements of the main stack with the corresponding result (x y -> r):
  
- <> - compares the above two elements (x y) of the stack and pushes 1 (if x <> y) or 0 (if x == y) onto the stack
- <- compares the above two elements of the stack and pushes 1 (if x <y) or 0 (otherwise) onto the stack
- <= - compares the above two elements of the stack and pushes 1 (if x <= y) or 0 (otherwise) onto the stack
- == - compares the above two elements of the stack and pushes 1 (if x == y) or 0 (otherwise) onto the stack
-  >  - compares the above two elements of the stack and pushes 1 (if x> y) or 0 (otherwise) onto the stack
-  >= - compares the above two elements of the stack and pushes 1 (if x> = y) or 0 (otherwise) onto the stack
-  + - pushes the sum of the top two elements of the stack onto the stack
-  - - pushes the difference of the top two elements of the stack onto the stack
-  * - pushes the product of the top two elements of the stack onto the stack
- / - pushes the quotient (integer division) of the top two elements of the stack onto the stack
- % - pushes the residue onto the stack after dividing the element below the top with the element on top
- . - glass (merge, glue) the top two elements of the stack into one element (x y -> xy)
- rnd - pushes a random number to the stack, which has the value> = x and <= y
  
The following operations enable the execution of a conditional sentence (the fulfillment of a condition is stored in an internal variable):
  
- then - takes the top number from the main stack; if this is other than 0, set the condition to true
- else - denies fulfillment of the condition
- ? ... - any command starting with? Is executed (or not) according to the preset fulfillment of the condition
  
The following commands are available for working with any stack (main or auxiliary). In this case, the number at the top of the main stack determines the index of the stack over which the command is executed:
stack
- print - prints the contents of the stack in a line (with the index given at the top of the main stack) from bottom to top
- clear - empties the stack (with the index given at the top of the main stack)
- run - executes all commands on the (auxiliary) stack (with the index given at the top of the main stack) from bottom to top (the stack remains unchanged)
- loop - executes all commands on the (auxiliary) stack (with the index given at the top of the main stack) from bottom to top (the stack remains unchanged), repeating this as many times as given by the number below the top of the stack
- fun - writes as many following commands to the auxiliary stack (with the index given at the top of the main stack) as the number below the top of the main stack specifies
- move - transfers from the main stack to the auxiliary stack (with the index given at the top of the main stack) as many elements as the number below the top of the main stack determines (elements are transferred one after the other)
- reverse - reverses the order of all elements in the stack (with the index given at the top of the main stack) - u v x y z -> z y x v u
  
If the command is not in the list of the above, then it is a number or string that is pushed to the top of the main stack (push).
  
## Examples of implementation
In all cases, lines starting with> are entered into the program, and the rest are a printout of the program. Run the program with
```
java Naloga1

Some examples of operations:

> 0 -12 103 3131 -100 53 111 dup2 0 reverse 0 print
111 53 111 53 -100 3131 103 -12 0

> 41051 141 + echo -100 50 - echo
41192
-150

> 5 11 17 + + 10 * 0 print
330

> 5! echo even 0 print
120
1

> 70 90 rnd echo char echo
66
B

> 0 1 2 3 4 4 1 fun dup 0 reverse swap 2 2 move 0 print 1 print 2 print
0 1 2
dup 0 reverse swap
4 3

> 0 1 2 3 1 fun 0 reverse dup 1 run 0 print 2 1 loop 0 print
2 1 0 0

2 2 1 0 0 0

> 5 3 1 2 5 1 fun == then? Dup2 else? + 1 run 0 print
8

> 9 1 fun dup 0 reverse swap% dup then? 1? Run 24 10 0 print 1 run pop echo
24 10
2

> 3 1 fun 0 100 rnd 3 2 fun 5 1 loop 7 3 fun dup2 <= then? Pop else? Swap? Pop 3 4 fun 4 3 loop

1 print 2 print 3 print 4 print 2 run 0 print 4 run 0 print
0 100 rnd

5 1 loop

dup2 <= then? pop else? swap? pop

4 3 loop

34 96 12 48 25
12
```
## Other hints and tips

You can only use the java.util.Scanner library. All other libraries are not allowed or. required - libraries containing Java collections (eg ArrayList) from the Collection Framework are not explicitly allowed

To present the stacks, first write down the Stack interface (abstract data type) with the appropriate operations, and then implement it using a Java field. You can limit the stack size to 64. To make more stacks, write the Sequence entry.

Note that the entire expression (program) is written in one line, so before processing each input line, all stacks are empty and the fulfillment of the condition is set to FALSE.

You can use operations on Java primitive types (int) as arithmetic operations, and the Math.random () method to determine a random number.
 
