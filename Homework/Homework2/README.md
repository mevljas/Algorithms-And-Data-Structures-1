# Sorting a sequence of numbers
## Instructions

Write a program in Java that shows and measures the editing of a sequence of integers using the various editing methods you learned in the lectures. The program should:
- sort the sequence (field) of integers it reads from standard input,
- use 8 different editing methods for sorting,
- allows you to sort ascending or descending,
- when sorting, it either prints the appropriate trace of the implementation or
- counts the number of shifts and comparisons for a given sequence.

## Sequence of numbers
The numbers are stored in the appropriate order, which is implemented as a array with the possibility of automatic expanding (resizable array). Make your own solution, the use of the Collection Framework is prohibited. The sequence of elements is filled with data from the (second line) of the **standard input**, all data is written in one (long) line.

**Example** (input of five numbers):
42 17 27 51 39  

## Sort settings
The sorting settings are read by the program from the (first line) of the standard input in the following order: operating mode, editing mode and editing direction. The mode of operation can be **trace** or **count**. The editing direction can be **up** (non-descending) and **down** (non-increasing). The sorting method is one of the following sorting algorithms (in the version you learned about in the lectures):

- **insert** - simple insertion
- **select** - simple selection
- **bubble** - improved normal replacement (scans only up to the last replacement location)
- **heap** - heap sorting
- **merge** - sorting by merging
- **quick** - quick sorting
- **radix** - root sorting
- **bucket** - sort with bins, where the number of bins is k = n / 2 (so v = (max − min + 1) / k, the bin index of the element x is ix = (x − min) / v).

## **Example** (to display non-drop-down quick edit traces):
trace quick up

## The printout
The display of the operation of an individual method is performed by printing a sort trace to the standard output. This means that in one line we print the elements of the sequence in order, whereby the line (|) indicates certain parts of the sequence. The first printout should be immediately before the editing (without lines), and then the printouts should follow as follows:

- in ordinary methods, the entire sequence is printed at the end of each execution of each outer loop, and the line separates the ordered part of the sequence from the unordered part of the sequence,
- when sorting with a heap, we first print the sequence when we build the heap, and then each time we fix the heap; the line divides the heap in the initial part of the sequence and the last edited part of the sequence.
- when sorting by merging, print the part of the sequence that is currently being sorted, and the line divides the left and right halves when merging. The printout is performed when it is divided into two parts and after merging both parts.
- in the case of quick sort, only the part of the sequence that is currently being sorted is displayed, always immediately after the distribution. Lines indicate sequence division points on the next recursive call. At the end, an ordered sequence (without lines) is displayed.
- in root sorting, print the sequence after sorting in each place (ones, tens, ...) without intermediate lines.
- when sorting with buckets, print the sequence by arranging them in n / 2 buckets (there should be a line between individual buckets) and then when editing by simple insertion (all buckets at once) after each execution of the outer loop (the line separates the arranged and unordered part).

## Examples (including calls):
```
trace insert up
42 17 27 51 39
42 17 27 51 39
17 42 | 27 51 39
17 27 42 | 51 39
17 27 42 51 | 39
17 27 39 42 51 |

trace select down
42 17 27 51 39
42 17 27 51 39
51 | 17 27 42 39
51 42 | 27 17 39
51 42 39 | 17 27
51 42 39 27 | 17

trace bubble down
42 17 27 51 39
42 17 27 51 39
51 | 42 17 27 39
51 42 39 | 17 27
51 42 39 27 | 17

trace heap up
42 17 27 51 39
42 17 27 51 39
51 42 27 17 39 |
42 39 27 17 | 51
39 17 27 | 42 51
27 17 | 39 42 51
17 | 27 39 42 51

trace merge up
42 17 27 51 39
42 17 27 51 39
42 17 27 | 51 39
42 17 | 27
42 | 17
17 42
17 27 42
51 | 39
39 51
17 27 39 42 51

trace quick down
42 17 27 51 39
42 17 27 51 39
51 | 42 | 27 17 39
39 | 27 | 17
51 42 39 27 17

trace radix up
42 17 27 51 39
42 17 27 51 39
51 42 17 27 39
17 27 39 42 51

trace bucket down
42 17 27 51 39
42 17 27 51 39
42 51 39 | 17 27
51 42 | 39 17 27
51 42 39 | 17 27
51 42 39 17 | 27
51 42 39 27 17 |
```
## Counting shifts and comparisons
In addition to tracking, the program must also allow counting the number of movements (ie element adjustments, for example the **swap()** method performs 3 movements) and the number of element comparisons (in the case of the last two methods the number of element locations in the table of counters c - the **getDigit()** method, if performed with this method). To this end, appropriate meters must be installed in the program. Triggering this mode of operation is the same as in the case of tracking, only the command is **count()**. The values of the number of movements and comparisons for three consecutive sorts with the selected method are displayed, namely:
- to sort the specified sequence in the selected direction,
- to sort an already arranged sequence in the selected direction, and
- to sort an already arranged sequence in the reverse direction.  

The values are written one after the other, separated by a space, with a line (|) between the three edits.

**Examples:**
```
count insert up
42 17 27 51 39
12 7 | 8 4 | 18 10

count select down
42 17 27 51 39
12 10 | 12 10 | 12 10

count bubble down
42 17 27 51 39
18 8 | 0 4 | 30 10

count heap up
42 17 27 51 39
24 12 | 30 12 | 24 10

count merge up
42 17 27 51 39
24 8 | 24 7 | 24 5

count quick down
42 17 27 51 39
14 10 | 16 18 | 16 16

count radix up
42 17 27 51 39
20 20 | 20 20 | 20 20

count bucket down
42 17 27 51 39
20 22 | 18 18 | 22 21
```
