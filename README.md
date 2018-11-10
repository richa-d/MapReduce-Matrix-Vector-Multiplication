# MapReduce-Matrix-Vector-Multiplication
This code performs matrix vector multiplication using map reduce, which enables fast computations for large amounts of data. 
There are 2 implementations of the same - using Hadoop (Java) and Spark (Scala).

The input is taken in the form of “a \<row number> \<column number> \<element>” for the matrix, and “b \<row number> \<column number> \<element>” for the vector on each line.
The matrix and the vector are read from the same file.
