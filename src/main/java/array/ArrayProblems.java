
public class ArrayProblems{

/**
 * Find Element in infinite Array
 *  arry = [1,3,5,8, 12, 58, 73 .......]
 * target = 58
 * 
 *  here the approach is to go  Binary Search   with calculated range  
 * and returns -1 if not found
 */


private  int  SearchInfinite(( int[] arr, int target)){

    itn low = 0;
    int high = 1;
    // Intention to find which range the target element will be found 
    while(arr[high]< target){
         low = high;
         hight = 2* high;
    }

    return binarySearch( arr, low, high, target);
}
/**
 * for I index we need to do log(i) times 
 */
int binarySearch(int[] arr, int low, int hight, int target){
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
     int hight = arr.length -1;
  
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
      pq.poll()
    }
  }
  return pq.peek();

}

}