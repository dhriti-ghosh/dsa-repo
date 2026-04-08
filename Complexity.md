# Time and Space Complexity

Time Complexity: how fast your code runs as input grows
Space Complexity: how much extra memory your code uses

We express both using Big O notation.

O(1) Constant - Access array index
O(log n) Logarithmic
O(n) Linear
O(n log n) Efficient sorting
O(n²) Nested loops


## How to Calculate Time Complexity

### Ignore constants

```java
for (int i = 0; i < 2*n; i++)
{}
```
O(n) 

### Nested loops
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++)
```
O(n*n) = O(n^2)

### Dependent loops
```java
for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++)
```
Not n^2 fully, still simplifies to O(n^2)

### Logarithmic patterns
```java
while (n > 1) {
    n = n / 2;
}
```
Each step is divided into half = O(log n)
/2, /3, etc going to be O(log n) - In Big O notation, we ignore the base

### Multiple independent parts
```java
for (int i = 0; i < n; i++) {}   // O(n)
for (int j = 0; j < n; j++) {}   // O(n)
```
O(n + n) = O(n)

### Nested different sizes
```java
for (int i = 0; i < n; i++) {
    for (int j = 0; j < k; j++)
```
O(n * k)

## How to Calculate Space Complexity

```java
int sum = 0;
```
Only one variable O(1)

```java
int[] arr = new int[n];
```
Storing n elements O(n)

```java
int f(int n) {
    if (n == 0) return 0;
    return f(n - 1);
}
```
Recursion - stack depth n O(n)

1. Always take the worst case
2. Drop constants (2n = n) and lower terms ( n + n^2 = n^2)