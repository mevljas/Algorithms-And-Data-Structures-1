# Assigment 5 - sort the array of objects with a simple method
## Instructions
Write a program in Java that shows the sorting of an object field with improved simple replacement for editing by the selected attribute. The program should:

- sort objects of the **Person** type, representing persons
- generate an array of random people (selected sizes),
- use the simple swap method to arrange the sequence in ascending or descending order of any attribute,
- displays the trace of the implementation when editing, and
- enable multiple editing from a printout sequence.

## Class Person
The Person class contains the following attributes: **String last name, String first name, and int yearR**. There is also a constructor, a comparison method and a printout method in the class.

A constructor without arguments should generate a person with random data. You can use static fields with pre-prepared names and surnames for this purpose. Years of birth should be within reasonable limits.

To compare, use the Comparable interface approach:
```
interface Comparable {
  public int compareTo (Object o);
}
```
The method must allow comparison by any attribute, for which you can choose the approach by setting the static attribute static int atr. The value of this determines which of the three attributes the comparison should be performed by. The strings should be compared in alphabetical order and the numbers in value.

The set atr option should also specify the attribute displayed by the toString () method.

## Sorting
The Person [] t array is sorted according to the selected attribute with the improved ordinary replacement bubblesort (Comparable [] a), where you sort only up to the place of the last replacement.

It should be noted that sorting can be ascending or descending. To do this, you can use the static direction attribute (both must be set to the correct value before editing), similar to selecting atr. When editing, a trace should be displayed at the end of each implementation of the outer loop - all elements of the field (values of the selected attribute) are displayed in one line, with a vertical line (|) separating the arranged part from the unordered one.

## Test class

Perform the following procedure in the test class:
```
 Enter the size n

 Generate field tt. containing n random persons

  Loop:

     Copy tt to t

     Print the field t

     Enter and set atr

     Enter and set the direction

     Edit t with plain replacement (contains printout of traces)

     Choose repeat or end
 ```
