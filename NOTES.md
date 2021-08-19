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

> Polynomial Runtimes (Best to Worst)

- `O(1)` - Constant Time
- `O(log n)` _(or)_ `O(ln n)` - Logarithmic (or) Sublinear Runtime
- `O(n)` - Linear Time
- `O(n log n)` - Quasi-Linear Runtime
- `O(n^2)` - Quadratic Runtime
- `O(n^3)` - Cubic Runtime

> Brute force algorithm have a worst case of Exponential Runtime (_**`O(x^n)`**_)
>
> Travelling Salesman have a worst case of Factorial/Combinatorial Runtime (_**`O(n!)`**_)

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
