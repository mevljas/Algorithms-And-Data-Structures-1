# Challenge 3 - Drawing a complete binary tree
## Instructions
Write a short program in Java that draws a complete binary tree with n elements. The size of the tree (number of elements) should be given as an argument at the call. The tree should be drawn using all four traversal modes (level, straight, intermediate, and vice versa). Use a suitable library of graphic elements (say StdDraw) to draw the tree.

## Determining node positions
When solving, imagine that a tree of size n is drawn on a grid (width n and height log n). Each node is considered to be plotted at a certain position (x, y), where its deviation along the x axis is determined by its sequential location in the intermediate printout, and the y deviation by the level of the node in the tree. The positions of all nodes must be determined before drawing.

## Drawing a tree
It is appropriate to draw a tree in a special class. To make it easier to draw a tree, it makes sense to prepare methods that draw a specific node (circle with center (x, y)) and the connection between the nodes. After establishing the drawing surface, the drawing is performed by successive drawing (1) of connections to the father and nodes and then individual (2) nodes, of course taking into account the appropriate sequence of visits to the elements of the tree. Nodes can be visited in 4 ways (level, straight, intermediate and vice versa), each with its own method.  

We recommend using the StdDraw library (R.Sedgewick, Princeton) for drawing, which is available at http://introcs.cs.princeton.edu/java/stdlib/StdDraw.java

## Test class
In the Assigment3 test class, use the argument to obtain the size of the tree, establish a suitably large drawing area, and trigger the drawing of the tree.
