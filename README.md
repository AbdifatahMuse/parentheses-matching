#Count paired parentheses
Given a String with numerous parentheses, it has valid syntax if 
- left parentheses accord to right parentheses 
- it begin with left parentheses

Write a piece of code, traverse through the whole string
* judge if the parentheses are in pairs and calculate how many pairs in the giving string ; 
* justify if the string are valid syntax

Sample Test Case 01:
```
Input:       x = fes(int) (print xxxxx)
Output:      2
Explanation: the number of () is 2, the whole string are valid syntax
```
Sample Test Case 02:
```
Input:       ()aaa (bbb(sss))ss))
Output:      3
Explanation: the number of () is 3 , the syntax is invalid, there are two consecutive right(left) parenthesis
```