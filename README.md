# Special Quartic Generator

***This project uses the Apache Commons Math library for Java! Things won't compile unless the user adds that library to the project.***

## Objective: 

Generate a polynomial
```
(Ax^2 + Bx + C)(Ax^2 + Bx + D) + F
```

which can be factorized to ```(x+a)(x+b)(x+c)(x+d)```,
where a, b, c & d are real.

**Use the Apache Commons Math library as needed!**
## Steps:

1) We find that the given polynomial expands into:
```
(A^2)x^4 + (2AB)X^3 + (B^2 + AC + AD)X^2 + (BC + BD)X + (CD + F)
```

2) Now, plug in random values for A,B,C,D,E,F and create a quartic equation of the form:
```
ax^4 + bx^3 + cx^2 + dx + e
```

where, a = A^2,
b = 2AB,
c = (B^2 + AC + AD), and so on...

3) Find roots for the quartic equation using LaguerreSolver from the Apache Commons Math library, and check if all are real.
4) Finally, back-calculate the values of A,B,C,D & F from a,b,c,d.
5) Here, we find that we cannot find individual values of C or D, and we only get solutions for C+D
6) Try all combinations of C+D in a given interval (I used 1 ~ C+D/2), where if one is I, the other is (C+D)-I.
7) Display all combinations.

## Sample Output
```
Function = 36 + 84 x + 73 x^2 + 28 x^3 + 4 x^4
Roots = [-2.0, -2.0, -1.5, -1.5]

(7 x + 2 x^2)(12 + 7 x + 2 x^2) + 36.0
(1 + 7 x + 2 x^2)(11 + 7 x + 2 x^2) + 25.0
(2 + 7 x + 2 x^2)(10 + 7 x + 2 x^2) + 16.0
(3 + 7 x + 2 x^2)(9 + 7 x + 2 x^2) + 9.0
(4 + 7 x + 2 x^2)(8 + 7 x + 2 x^2) + 4.0
(5 + 7 x + 2 x^2)(7 + 7 x + 2 x^2) + 1.0
```
