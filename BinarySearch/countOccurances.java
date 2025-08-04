public class countOccurances {
    
    public static int firstOccurance(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int result = -1;
            
        while(left <= right){
            int mid = left + (right - left)/2;
                
            if(arr[mid] == target){
                result = mid;
                right = mid-1;
            }
            else if(arr[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
            
        return result;
    }
        
    public static int lastOccurance(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int result = -1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            
            if(arr[mid] == target){
                result = mid;
                left = mid+1;
            }
            else if(arr[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        
        return result;
    }

    public static int countFreq(int[] arr, int target){
        int first = firstOccurance(arr, target);
        if(first == -1) return 0;
        int last = lastOccurance(arr, target);

        return last - first + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2 , 3 , 3 , 3 , 3 , 4};
        int target = 3;
        System.out.println(countFreq(arr, target));
    }

}

