/*
Problem:
Given a sorted array, check if there exist two numbers whose sum is zero.

Example
A: [-3, 1, 3, 4]
Answer: true
A: [-2, 1, 3, 4]
Answer: false

Approach:

Start with Two Pointers:

    One pointer (left) at the beginning of the array.
    Another pointer (right) at the end of the array.
Check the Sum:

    Calculate the sum of the numbers at the left and right pointers.
Adjust Pointers Based on Sum:

    If the sum is greater than zero, move the right pointer one step to the left.
    If the sum is less than zero, move the left pointer one step to the right.
    If the sum is zero, you've found two numbers that sum to zero, so return true.
Repeat:

Continue adjusting the pointers and checking the sum until the left pointer is greater than the right pointer.
Return false:

    If you finish the loop without finding two numbers that sum to zero, return false.

*/


class Solution {
	boolean hasTwoSumZero (int[] A) {
		
		int left = 0;
		int right = A.length-1;
		
		while(left <= right){
			
			if((A[left] + A[right]) > 0){
				right--;
			}
			
			else if(A[left] + A[right] < 0){
				left++;
			}
			
			else{
				return true;
			}
		}
		return false;
	}
}