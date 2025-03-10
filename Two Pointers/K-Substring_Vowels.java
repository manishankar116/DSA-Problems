/* 
Given a string s and a number k, find the number of vowels in every substring of size k.

Vowels: ['a', 'e', 'i', 'o', 'u']

Example
String: "technology"
k: 3

Here, the substrings of size k and their vowel counts are:
tec => 1
ech => 1
chn => 0
hno => 1
nol => 1
olo => 2
log => 0
ogy => 0
Answer: [1, 1, 0, 1, 1, 2, 0, 0]

Approach:

Imagine you have a "window" of fixed size that slides over the array or string.
As the window moves, you update the information about the elements within the window. 
This technique is particularly useful for problems where you need to examine all possible subarrays or substrings of a given size.

Steps:
Initialize the Window: Start by defining the initial window, usually the first k elements of the array or string.

Process the Initial Window: Calculate the desired property (e.g., sum, count of vowels) for the initial window.

Slide the Window: Move the window one element at a time from left to right. 

For each new position:
Add the new element entering the window.
Remove the element that is leaving the window.
Update the desired property based on the changes.

*/

class Solution {
	int[] kSubstringVowels (String s, int k) {
		
		
		int n = s.length();
		int[] result = new int[n-k+1];
		
		int count = 0;
		
		for(int i = 0; i < k; i++){
			if(isVowel(s.charAt(i))){
				count++;
			}
		}
		result[0] = count;
			   
		for(int i = k; i < n; i++){
			if(isVowel(s.charAt(i))){
				count++;
			}
			if(isVowel(s.charAt(i-k))){
				count--;
			}
			
			result[i-k+1]=  count;
		}
			   
		return result;
		
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
		
}
