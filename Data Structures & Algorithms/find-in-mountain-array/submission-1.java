/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    private int getMidIndex(MountainArray m){
        int left = 0;
        int right = m.length()-1;

        while(left <= right){
            int mid = left + (right - left )/2 ;
            boolean isLeftSorted = m.get(mid)>m.get(mid-1);
            boolean isRightSorted = m.get(mid+1)<m.get(mid);
            if( isLeftSorted && isRightSorted )return mid;

            else if(isLeftSorted){
                left = mid;
            }
            else if(isRightSorted){
                right = mid;
            }

        }
        return -1;
    }
    private int binarySearch(MountainArray m , int left , int right , int target){
        while(left <= right){
            int mid = left + ((right-left )/ 2);
            int midElement = m.get(mid);
            
            if(midElement == target){
                return mid;
            }else if(midElement < target){
                left = mid+1;
            }else right = mid-1;
        }

        return -1;
    }

    private int reverseBinarySearch(MountainArray m , int left , int right , int target){
        while(left <= right){
            int mid = left + ((right-left )/ 2);
            int midElement = m.get(mid);
            
            if(midElement == target){
                return mid;
            }else if(midElement < target){
                
                right = mid-1;
            }else left = mid+1;
        }

        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
      int midIndex = getMidIndex(mountainArr);
      System.out.println(midIndex);
      int answer = binarySearch(mountainArr , 0 , midIndex, target);
      if(answer != -1)return answer;
      System.out.println(answer);
      return reverseBinarySearch(mountainArr , midIndex+1 , mountainArr.length()-1 , target);
    
    


        
    }
}