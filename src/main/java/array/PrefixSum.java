package array;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum {
    public int[] calculatePrefixSume(int[] arr) {
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        return prefixSum;
    }

    public int[] calculatePrefixSumeOptimized(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i];
        }
        return arr;
    }


    public int rangeSumQueriesBruteForce(int[] arr, int i, int j) {
        int sum = 0;
        for (int k = i; k < j; ++k) {
            sum += arr[k];
        }
        return sum;
    }

    public int rangeSumQueries(int[] arr, int left, int right) {

        /*for(int i =1; i<arr.length; ++i){
            arr[i ] = arr[i-1]+arr[i];
        }*/
        //build prefix sum array in the construction
        if (left == 0) {
            return arr[0];
        }
        return arr[right] - arr[left - 1];
    }

    int subArraySumProblem(int[] arr, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer, Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0, 1);
        for (int num : arr) {
            prefixSum += num;
            if (prefixSumFrequency.containsKey(prefixSum - k)) {
                count += prefixSumFrequency.get(prefixSum - 1);
            }
            prefixSumFrequency.put(prefixSum, prefixSumFrequency.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
