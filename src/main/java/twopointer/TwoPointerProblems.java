package twopointer;

public class TwoPointerProblems {
    /**


     Example 1:

     Input: s = "A man, a plan, a canal: Panama"
     Output: true
     Explanation: "amanaplanacanalpanama" is a palindrome.
     Example 2:

     Input: s = "race a car"
     Output: false
     Explanation: "raceacar" is not a palindrome.

     */
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;

        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
    /**

     There are a few ways we can use the Two Pointer approach.
     First, if the input is an array or string, we should keep Two Pointers (along with hash tables) on our tool belt.

     Stronger signals for Two Pointers are….

     If we want to reduce nested loops to a single pass.
     If the input is sequenced or sorted.
     If we need to compare a value at one index with value at another index.
     If we need to make swaps between indices.
     If we partition the array.





     **/
}
