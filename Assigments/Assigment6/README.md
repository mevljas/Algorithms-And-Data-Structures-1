# Assigment 6 - Quick sequence sorting realized with a linked list
## Instructions
Write a Java class LinkedSequence that implements an abstract data type sequence using a two-way linear linked list without a guard.

Use the following classes and interfaces in the solution:
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
    // static final String ERR_MSG_FULL = "Collection is full.";
    boolean isEmpty ();
    // boolean isFull ();
    int count ();
    String toString ();
}
```
```
interface Sequence <T extends Comparable> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get (int i) throws CollectionException;
    T set (int i, T x) throws CollectionException;
    void insert (int i, T x) throws CollectionException;
    T delete (int i) throws CollectionException;
}
```
In addition to the classes and interfaces you learned about in one of the previous challenges, there are:

- **Sequence <T extends Comparable>** generic interface (abstract data type) for a sequence of (comparable) elements, which is a special type of collection.
  
The Sequence interface can only store elements that are comparable to each other (objects from classes that implement the Comparable interface).

In the Test class Assigment6, display the editing of a sequence of objects of type Person with an improved quick editing method (quicksort), which you adjust accordingly for this purpose. The improvement refers to switching partition editing by normal insertion when the partition size falls below a certain limit. The method should display the number of shifts and comparisons after execution.


## Two-way linear linked list without a guard
The **LinkedSequence <T extends Comparable>** class should contain an internal **Node** class that represents one member of the one-way linked list of elements - this contains the value (generic type T) and the values next and prev - linking to the next and previous link in order:
```
class Node {
    T value;
    Node next, prev;
}
```
The list should be accessible via the **first** attribute, which, if the sequence contains elements, points to the first member in the list, otherwise it has a value of null (because the required implementation does not have a guard).

Because the list is linear (not circular), the successor to the last article is **null**.

In case of problems, an exception of type **CollectionException** should be triggered, which also contains an exception due to an incorrect index in the sequence (**ERR_MSG_INDEX**). Because the linked list is a dynamic structure, an error due to a loaded collection (ERR_MSG_FULL) cannot occur.

## Sort the sequence of objects of type Person
In the **Assigment6** test class, check the operation of a sequence by first creating a sequence of Person-type objects, and then sorting it with an improved quicksort method.

The improvement refers to the use of normal insertion, which is used when the partition size falls below a certain size. The size is passed as a parameter when the edit method is called.

The method should count the number of movements and comparisons during editing and print them out after execution.

**Optional alternative solution:** Consider a more optimal implementation of the algorithm that would make better use of our execution of the sequence (say, replacing indexes with links to objects ...). Where would such an editing method be located? Implement such a solution.



## Test class
Perform the following procedure in the test class:
```
 Enter the size of the sequence n
 Generate a sequence of z1 containing n random persons (with sequential intrusion to 1st place)
 Loop:
   Rewrite the sequence z1 into the sequence z2
   Enter and set atr
   Enter and set the direction
   Print the sequence z2
   Enter a size in (to switch to normal insertion)
   Edit z2 with quick edit for switch size in (method displays number of shifts and comparisons)
   Print the (edited) sequence z2
   Choose repeat or end
  
 ```
