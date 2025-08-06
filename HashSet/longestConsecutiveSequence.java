import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int longestConsecutive(int[] nums) {

        Set<Integer> hs = new HashSet<>();
        int count = 0;
        for(int num : nums){
            hs.add(num);
        }

        for(int num : hs){
            if(!hs.contains(num - 1)){
                int length = 1;
                int curr = num;
                while(hs.contains(curr + 1)){
                    length++;
                    curr++;
                }
                count = Math.max(count, length);
            }
        }


        return count;
    }

    public static void main(String[] args) {
        int arr1[] = {100,4,200,1,3,2}; //output - 4 (1,2,3,4)
        int[] arr2 = {0,3,7,2,5,8,4,6,0,1}; //output - 9 (0,1,2,3,4,5,6,7,8)

        System.out.println(longestConsecutive(arr1));
        System.out.println(longestConsecutive(arr2));

    }
}