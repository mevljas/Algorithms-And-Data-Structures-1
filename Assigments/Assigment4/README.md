# Assigment 4 - Different implementations of the priority queue
Write a program in Java that implements a **priority queue** in three different ways and compare the time complexity of all three implementations in a test class. The priority queue should be implemented with:

- unsorted array,
- the maximum heap implicitly written with the array and
- the maximum heap explicitly written to the associated Node objects.

The complexity test should be performed by a large number of random insertions, eliminations and printouts of the first elements (numbers), and the result should be expressed by time and the number of shifts and comparisons.  

The following class and interfaces are available:  
```
class CollectionException extends Exception {
    public CollectionException (String msg) {
         super (msg);
    }
}
```
```
interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";

    boolean isEmpty ();
    int size ();
    String toString ();
}
```
```
interface Queue <T> extends Collection {
    T front () throws CollectionException;
    void enqueue (T x);
    T dequeue () throws CollectionException;
}
```
```
interface PriorityQueue <T extends Comparable> extends Queue <T> {
}
```
## Priority queue
The priority queue contains elements (objects of the generic type **T** that are **Comparable**) that can be compared in size (using the compareTo method). It differs from the ordinary queue in that it always excludes from the queue that element which is highest in priority.

### Three implementations
For each implementation, write your own class that appropriately defines the internal structure and all the necessary methods:

- **ArrayPQ** for execution where elements are stored in an unordered array,
- **ArrayHeapPQ** to implicitly execute the maximum heap with the and array  
- **LinkedHeapPQ** to explicitly execute the maximum heap with associated **Node** objects representing nodes of the binary tree.
In both array implementations, the initial capacity should be 64, but in case of lack of space, a corresponding increase in the field capacity is arranged with the **resize** method, which doubles the current array capacity. For both heap designs, perform all three methods correctly (inserting, removing, and returning the first element) according to the structure used.

## Speed comparison
In the **Assigment4** test class, perform a speed comparison of all three priority type implementations. To do this, perform a sequence of the same operations on all three: say, first fill all three with a larger number of elements (say 1000 random numbers - Integer objects), and then perform many (say 500) consecutive eliminations (largest element), insertions (random) elements) and printouts of the first (largest) elements. At the same time, measure the **time (in ms)** for each implementation, count the **number of shifts** (= adjustments of the variable type T) and **comparisons** (= calls to the **compareTo** method).
  
Print the result in tabular form. 
```
Objects: Integer  


Operations: 1000 enqueue + 500 (dequeue + enqueue + front)  

Implementation              Time [ms]       Shifts      Comparison  

--------------------------------------------------- ------------------------------------  

Unordered array (64.2x)     xx              xx          xx  

Implicit heap (64.2x)       xx              xx          xx  

Explicit heap               xx              xx          xx
```

Adjust the execution of the experiment (number and type of operations) so that you get a clear result.
