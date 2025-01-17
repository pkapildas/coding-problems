package array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ArrayProblems{

/**
 * Find Element in infinite Array
 *  arry = [1,3,5,8, 12, 58, 73 .......]
 * target = 58
 * 
 *  here the approach is to go  Binary Search   with calculated range  
 * and returns -1 if not found
 */


private  int  SearchInfinite( int[] arr, int target){

    int low = 0;
    int high = 1;
    // Intention to find which range the target element will be found 
    while(arr[high]< target){
         low = high;
         high = 2* high;
    }

    return binarySearch( arr, low, high, target);
}
/**
 * for I index we need to do log(i) times 
 */
int binarySearch(int[] arr, int low, int high, int target){
  int mid =  (low+ high)/2;
  while( low<=high){
  if(arr[mid] == target){
    return mid;    
  } else if (target> arr[mid]){
    low= mid+1;    
  } else{
    high = mid -1;
  }
  }
  return -1;
}


/** 
 * Search in  a Rotated Array

 */

int binarySearchRotatedArray(int[] arr, int target){
     int low =0;
     int high = arr.length -1;
  
  while(low <= high){
    int mid =  (low+ high)/2;
     if(arr[mid] <= target){
    return mid;    
  } 

  if(arr[low] <= arr[mid]){
    // left side is sorted asc
    if (target>= arr[low]  && target <arr[mid] ){
        high = mid-1;    
    } else{
        low  = mid +1;
    }

  } else {
    if (target> arr[mid] && target<= arr[high]){
     low= mid+1;    
    } else{
        high = mid -1;
    }
  }
  
  }
 
  return -1;
}

/**
 * t = O(nlog(k))
 * s = o(K)
 */
private int findKthLargestElement(int[] arr, int k){
  PriorityQueue<Integer> pq  = new PriorityQueue<>(k);
  for(int num : arr){
    pq.offer(num);
    if(pq.size() > k ){
      pq.poll();
    }
  }
  return pq.peek();

}
    ArrayProblems arrayProblems;
    @BeforeEach
    public void setUp(){
        arrayProblems = new ArrayProblems();
    }


    /**
     Pair with target sum

     Assume  if the elements are sorted
     first element and last element is less  than the sum then the number are
     in the range of start to end of array
     T =O(N)
     S = O(1)
     */
    private int[]  searchPairWithTargetSum(int[] arr, int target){
        int start =0;
        int end = arr.length -1;

        while(start<end){
            int currentSum = arr[start]+arr[end];
            if(currentSum == target){
                return  new int[]{start, end};
            }
            if(target> currentSum){
                start++;
            }else {
                end--;
            }
        }
        return new int[]{-1, -1};
    }

    private int[]  searchPairWithTargetSumDuplicates(int[] arr, int target){
        Map<Integer, Integer> locationMap = new HashMap<>();
        for(int i =0 ;i < arr.length; ++i){
            int key = arr[i];
            if(locationMap.containsKey(key)){
                return new int[]{locationMap.get(key), i};
            }else {
                int cmpl = target - key;
                locationMap.put(cmpl, i);
            }
        }
        return new int[]{-1, -1};

    }
    @Test
    public void test_pairwithTarget(){
        int[] a = {1,2,3,4,5,6};
        int[] ints = arrayProblems.searchPairWithTargetSum(a, 3);
        System.out.println(ints [0] + " "+ ints[1]);
        Assertions.assertArrayEquals(ints, new  int[]{0,1});
        ints = arrayProblems.searchPairWithTargetSumDuplicates(a, 6);
        System.out.println(ints [0] + " "+ ints[1]);
        Assertions.assertArrayEquals(ints, new  int[]{1,3});
        a = new int[]{1, 4, 3, 8, 5, 6};
        ints = arrayProblems.searchPairWithTargetSumDuplicates(a, 4);
        Assertions.assertArrayEquals(ints, new  int[]{0,2});
    }

    
 boolean isTripletExist(int[] nums, int n, int target, int count)
    {
        if (count == 3 && target == 0) {
            return true;
        }
        if (count == 3 || n == 0 || target < 0) {
            //Not reached Possible triplet
            return false;
        }

        // recursively call num -  current  or skipping current number and check whether there's as triplet available
        return isTripletExist(nums, n - 1, target - nums[n - 1], count + 1) ||
                isTripletExist(nums, n - 1, target, count);
    }

    @Test
    public void test_isTripletExist(){
        int[] nums = { 2, 7, 4, 0, 9, 5, 1, 3 };
        int target = 6;

        if (isTripletExist(nums, nums.length, target, 0)) {
            System.out.println("Triplet exists");
        }
        else {
            System.out.println("Triplet doesn't exist");
        }
    }

    class Bank{
        Map<String, Integer> accounts = new HashMap<>();

        int withdraw(String account ,int amount){
                int balance = accounts.getOrDefault(account, 0);
                if(balance> 0){
                    balance -=  amount;
                }
            accounts.put(account, balance);
                return amount;

        }
    }


    public static void main(String[] args) {
        int  [] a = {33,44,55};
        int b =9;
        arra_operations(a, b);
        System.out.println("after update");
        System.out.println(Arrays.toString(a));
        System.out.println(" b "+b);
    }
    static void arra_operations(int [] a, int b){
        b =10;
        int[] array = {1,2,3,4,5};
        String arrayAsString = Arrays.toString(array);
        System.out.println("Array "+array);
        System.out.println("Array "+arrayAsString);
        System.out.println(Arrays.binarySearch(array ,3));
        int a1[] = new int[5];
        Arrays.fill(a1, 54);
        a[0]= 99;
    }

    List<Integer> sortBasedOnFrequency(List<Integer> list  ){
        int size = list.size();
        Map<Integer, Integer> mapCount = new HashMap<>();
        Map<Integer, Integer> mapIndex = new HashMap<>();
        for( int i = 0 ; i< size ; ++i){
            int element = list.get(i);
            if(mapCount.containsKey(element)){
                mapCount.put(element, mapCount.getOrDefault(element, 0)+1);
            }else {
                mapCount.put(element, 1);
                mapIndex.put(element, i);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int fr1 = mapCount.get(o1);
                int fr2 = mapCount.get(o2);
                if(fr1!= fr2){
                    return fr1-fr2;
                }else {
                    return mapIndex.get(o1) -
                            mapIndex.get(o2);
                }
            }

        });

        return list;

    }

    private  int searchSortedRotatedArray(int[] array , int key ) {
        // case 1 a[0] is < a[mid] then  the left side is sorted
        //case 2. a[0] is > a[mid ] right side part is sorted
        //
        int low = 0, high = array.length -1;
        while(low<= high){
            int mid = (low+high)/2;
            if( array[mid] == key){
                return  mid;
            }
            if(array[low] <= array[mid]){
                if(key >= array[low] && key < array[mid]){
                    high = mid-1;
                }else {
                    low= mid+1;
                }
            }else {
                if( key > array[mid] && key<=array[high]){
                    low = mid+1;
                }else  {
                    high = mid-1;
                }
            }
        }
        return  -1;
    }
}

