# Assigment 2 - Experimental evaluation of complexity
Write a program in the Java programming language to empirically compare two algorithms for finding an element in an ordered table:

- a simple sequential search and
- binary search.
Run both algorithms multiple times for different table sizes. In doing so, measure and calculate the average search time. Print the times for both algorithms. We suggest that you solve the challenge gradually according to the following points.

a) Generating test cases
To generate test cases, write a method that returns a (ordered) table of integers with values from 1 to n for a given n. Eg.

- int [] generateTable (int n)

b) Implementation of both element search algorithms
Write both algorithms for finding the element. Eg.

- int findLinear (int [] a, int v)
- int findBinary (int [] a, int l, int r, int v)  

In this case, a is the table of elements, v is the sought value, l is the left boundary in the table and r is the right boundary in the table. What is the value of l and r on the first call to findBinary (...)?

c) Performing one test for a table of length n
Write methods (for each search method your own method) that measure the average search time in a table of length n. Eg.

- long timeLinear (int n)
- long timeBinary (int n)  

Each of the methods should perform the following:

- Create a table of length n using the method you implemented earlier.
- starts measuring time.
- Then repeat the following 1000 times
    - Creates a random number between 1 and n.
    - Finds the number in the table.
- Stop timing.
- Calculates the average.  

Measure the execution time as follows:
```
long startTime = System.nanoTime ();
// search for an item
long executionTime = System.nanoTime () - startTime;
```

d) Experimental evaluation of algorithms
Submit the source code of this assignment to the e-classroom.

For n ∈ values [105,…, 106], wtih step size 10^4 table the average execution time. Print a table with three columns:

- the first column should contain n,
- the second average time to perform a simple search,
- and the third is the average binary search time.  

Example printout:
```
   n | linear | dvoisko |
--------- + -------------- + ------------------
    100000 | 20662 | 61
    110000 | 21444 | 66
    120000 | 22135 | 66
    130000 | 22706 | 67
    140000 | 23433 | 62
    150000 | 23751 | 71
      ... ... ...
```
e) Think
- Why are the times different for you than in the table above?
- Which algorithm is faster?
- When could a slower algorithm be faster?
- How does time depend on the size of the task (linear, square, ...)?
- Is the time dependence of the binary search closer to linear or constant?
f) Graphic display - optional, but fun and educational
Draw a graph of the measured runtime values above as a function of table length. We recommend using the StdLib library and the StdDraw class for rendering. For color execution, you need to add 6 lines to the above solution.

As a last resort, you can also use other options:
- You can use a spreadsheet program (OpenOffice, Excel, ...).
- Draw directly from Java using a simple jMathPlot library. You can find an easy introduction to using this library at the link.
- etc.
