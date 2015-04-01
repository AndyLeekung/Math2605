Readme for Part 1 of the Math 2605 Project
The Hilbert Matrix

This will follow the rubric and explain how to run each part of the rubric

All of part 1 is run from the program "ProblemOne.java"

Compile all of the java files in the folder in the terminal then run "ProblemOne.java"

Place all test files into the same folder as the program

1) LU-decomposition
    To test the LU decomposition you will navigate the menu:
    a) Enter 1 to Enter a Matrix file
    b) Enter the name of the file (e.g. a.dat)
    c) Answer 1 if it is augmented 2 if it is not (it should be not augmented)
    d) Enter 1 in the menu to get the LU decomposition
    e) You can exit this menu and input another matrix by entering -1
    Alternatively you can use a Hilbert Matrix:
    a) Enter 2 to use a Hilbert Matrix
    b) Enter the size of the Hilbert Matrix
    c) Enter 1 in the menu to get the LU decomposition
    d) You can exit this menu and input another matrix by entering -1

2) QR-factorization
    To test the QR decomposition you will navigate the menu:
    a) Enter 1 to Enter a Matrix file
    b) Enter the name of the file (e.g. a.dat)
    c) Answer 1 if it is augmented 2 if it is not (it should be not augmented)
    d) Enter 2 in the menu to get the QR decomposition using householder or 3 for Givens
    e) You can exit this menu and input another matrix by entering -1
    Alternatively you can use a Hilbert Matrix:
    a) Enter 2 to use a Hilbert Matrix
    b) Enter the size of the Hilbert Matrix
    c) Enter 2 in the menu to get the QR decomposition using householder or 3 for Givens
    d) You can exit this menu and input another matrix by entering -1

3) Solve linear Systems
    a) Enter 1 to Enter a Matrix file
    b) Enter the name of the file (e.g. a.dat)
    c) Answer 1 if it is augmented 2 if it is not
    d) If the matrix was not augmented then enter 4 to input a b
        e) Input the elements of b
    f) Enter the corresponding number for the method to solve
    g) Data should be outputed
    h) You can exit this menu and input another matrix by entering -1
    Alternatively you can use a Hilbert Matrix
    a) Enter 2 to use a Hilbert Matrix
    b) Enter the size of the Hilbert Matrix
    c) Enter the corresponding number for the method to solve
    d) Data should be outputed
    e) You can exit this menu and input another matrix by entering -1

4) Solution of Hilbert Matrices
    a) Enter 3 to display the information for all the Hilbert Matrices
    b) Enter the corresponding number for the method to display
    c) Displays the corresponding information such as the error, solution, and solution error
    Alternatively you can individuall view each Hilbert Matrix decomposition following previous steps in #3

5) Plots and discussion
    Plot and discussion are found in the "The Hilbert Matrix.docx"