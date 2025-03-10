/*

Given an array and a number k, remove all occurrences of k from the array (in-place). Return the number of elements 'remainingSize' left after removing k. Note that removing the occurences is mandatory and will be checked in the main method. There can be anything beyond the first 'remainingSize' elements. It will be ignored.

Example
Array: [1, 4, 2, 6, 2, 6, 9, 4]
Number: 4
Answer: 6
Explanation:[1, 2, 6, 2, 6, 9]

*/

class Solution {
	int removeOccurences(int[] A, int k) {
		
		int ans = 0;
		for(int num : A){
			if(num != k){
				ans++;
			}
		}
		
		return ans;
	}
}