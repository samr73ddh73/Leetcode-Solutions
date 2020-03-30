//Two Pointer Approach:
//Idea: i will point to the element which is equal to the target value.
import java.util.*;
class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++)
        {
            if(nums[i]!=nums[j])
            {
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
        
    }
}
