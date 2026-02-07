/*
Problem:
    The problem is to find the k-th element in the merged sorted array formed by combining two given sorted arrays, A and B. Here's a step-by-step explanation of the solution:

Input: Two sorted arrays A and B, and an integer k.
Output: The k-th element in the merged sorted array.
Example
    For arrays A = [1, 2, 3, 4, 5, 6] and B = [3, 4, 4, 5, 6, 6], the merged sorted array is [1, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6].
    The 3rd element in this array is 3.
    The 6th element in this array is 4.

Approach:

Initialize Variables:

    a and b store the lengths of firstArr and secondArr.
    merged is an array to store the merged result.
    i and j are pointers for firstArr and secondArr.
    index is a pointer for the merged array.

Merge Arrays:

    Use a while loop to compare elements from firstArr and secondArr and add the smaller element to merged.
    Increment the respective pointers (i or j) and the index pointer.

Add Remaining Elements:

    If there are remaining elements in firstArr, add them to merged.
    If there are remaining elements in secondArr, add them to merged.
    Return k-th Element:

Return the element at index k-1 in the merged array (since array indices are zero-based).

*/

class Kth_Element_in_the_Merged_Sorted_Arr {
    int getKthElement(int[] firstArr, int[] secondArr, int k) {
        int a = firstArr.length;
        int b = secondArr.length;
        
        int[] merged = new int[a + b];
        int i = 0;
        int j = 0;
        int index = 0;
        
        // Merge the two arrays
        while (i < a && j < b) {
            if (firstArr[i] <= secondArr[j]) {
                merged[index] = firstArr[i];
                index++;
                i++;
            } else {
                merged[index] = secondArr[j];
                index++;
                j++;
            }
        }
        
        // Add remaining elements from firstArr
        while (i < a) {
            merged[index] = firstArr[i];
            index++;
            i++;
        }
        
        // Add remaining elements from secondArr
        while (j < b) {
            merged[index++] = secondArr[j++];
        }
        
        // Return the k-th element (1-based index)
        return merged[k - 1];
    }
}

