//BruteForce:
class Solution {
    public int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length-count;)
        {
            if(nums[i]==val)
            {
                count++;
                for(int j=i;j<nums.length-count;j++)
                {
                    nums[j]=nums[j+1];
                }
            }
            else
                i++;
        }
        return nums.length-count;
        
    }
}
//Two Pointer Approach:
Idea: i will point to the element which is equal to the target value.
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
