# Assigment 1 - Stack, double-ended queue and sequence
## Instructions
In this assigment, you will have fun with basic data structures. With a (static) field you will implement 3 APTs:

- stack,
- a queue with two ends and
- sequence.
If you tackle the task wisely, then it is enough to program only the execution of a queue with two ends.

The following class and interfaces are available:
```
class CollectionException extends Exception {
    public CollectionException (String msg) {
         super (msg);
    }
}


interface Collection {
    static final String ERR_MSG_EMPTY = "Collection is empty.";
    static final String ERR_MSG_FULL = "Collection is full.";

    boolean isEmpty ();
    boolean isFull ();
    int size ();
    String toString ();
}


interface Stack <T> extends Collection {
    T top () throws CollectionException;
    void push (T x) throws CollectionException;
    T pop () throws CollectionException;
}


interface Deque <T> extends Collection {
    T front () throws CollectionException;
    T back () throws CollectionException;
    void enqueue (T x) throws CollectionException;
    void enqueueFront (T x) throws CollectionException;
    T dequeue () throws CollectionException;
    T dequeueBack () throws CollectionException;
}


interface Sequence <T> extends Collection {
    static final String ERR_MSG_INDEX = "Wrong index in sequence.";
    T get (int i) throws CollectionException;
    void add (T x) throws CollectionException;
```

- CollectionException - an exception that you return in case of problems (overflow or underflow of a stack or queue),
- Collection - basic interface for the collection of elements,
- Stack <T> - generic interface (abstract data type) for the stack,
- Deque <T> - a generic interface for a double-ended queue and
- Sequence <T> - generic sequence interface.  
Stack <String> therefore represents a stack of strings, Deque <Double> a series of floating point numbers, etc.

Before you start programming, take a good look at the interfaces: all three (Stack <T>, Deque <T>, and Sequence <T>) extend the Collection, and most methods can cause an exception.

## A type with two ends
Use the (circular) array to implement the ArrayDeque <T> class, which implements all three APTs. Its definition should be as follows:
```
class ArrayDeque <T> implements Deque <T>, Stack <T>, Sequence <T> {
    private static final int DEFAULT_CAPACITY = 64;

    // Write your code here.
}
```
**a)** Implement all necessary methods.

**b)** Methods should throw a CollectionException in case of problems. For this purpose, you already have error messages defined:

- ERR_MSG_EMPTY - when there is a removal or demand for an item in an already empty collection, and
- ERR_MSG_FULL - when an item is added to an already full collection,
- ERR_MSG_INDEX - when an incorrect index occurs in the sequence.

**c)** All methods that remove elements should prevent loitering.

## Test class
Implement the Izziv1.java test class, which shows the (correct) execution of each operation for all three APTs.
