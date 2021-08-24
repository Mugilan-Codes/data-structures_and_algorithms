# DSA

- [Algorithms and Data Structures - Full Course for Beginners from Treehouse](https://youtu.be/8hly31xKli0)

## Algorithms

> how to define and implement algorithm?

- The steps in the algorithm needs to be in a very specific order
- The steps also needs to be distinct
- The algorithm should produce a result
- The algorithm should complete in a finite amount of time

### Big O (Upper Bounds of an algorithm)

> It is the theoretical definition of the complexity of an algorithm as a function of the size.
>
> O(n) is an example of the notaion

- `O` is the `Order of magnitude of complexity`
- `(n)` is `A function of the size`

[8 time complexities that every programmer should know](https://adrianmejia.com/most-popular-algorithms-time-complexity-every-programmer-should-know-free-online-tutorial-course/)

> Polynomial Runtimes (Best to Worst)

- `O(1)` - Constant Time
- `O(log n)` _(or)_ `O(ln n)` - Logarithmic (or) Sublinear Runtime
- `O(n)` - Linear Time
- `O(n log n)` - Quasi-Linear Runtime (or) linearithmic
- `O(n^2)` - Quadratic Runtime
- `O(n^3)` - Cubic Runtime

> Brute force algorithm have a worst case of Exponential Runtime (_**`O(x^n)`**_)
>
> Travelling Salesman have a worst case of Factorial/Combinatorial Runtime (_**`O(n!)`**_)

### Sorting

#### Merge Sort

> Works on divide & conquer strategy

- Split the array into smaller single element arrays
- Sort and merge the smaller array to build a larger array

## Data Structures

> It is a data storage format. It is the collection of values and the format they are stored in, the relationships between the values in the collection as well as the operations applied on the data stored in the structure.

- In Java, arrays are **homogeneous containers** which means they can only contain values of same data type.
- In Python, list are **heterogeneous containers** which means they can contain values of different data types, while arrays (`The array.array class in Python is a thin wrapper around a C array and this introduces some limitations`) are **homogeneous containers**.

> Array is a contiguous data structure.
>
> Values are stored in blocks right next to each other without gaps.
>
> This makes retrieving values easier.

### Operations on Data Structures

- Access and read values
- Search for an arbitrary value
- Insert values at any point into the structure
- Delete values in the structure

#### Linked List

> Linked list can be a better tool than array if there is more inserts and deletes than accessing.
>
> It is a linear data structure where an element is stored in a separate object called a `Node` (Self Referential Objects)
>
> Node contains two information: the data value and a reference to the next node in the list. The first node is called `Head` and last node is called `Tail`

- There are two types
  - Singly Linked List
  - Doubly Linked List

## Language Features

### Python

- Module Name when import and invoked directly. [What does the if `__name__` == “`__main__`”: do?](https://www.geeksforgeeks.org/what-does-the-if-__name__-__main__-do/)

  ```py
  if __name__ == "__main__":
    print("Executed when invoked directly)
  else:
    print("Executed when imported)
  ```
