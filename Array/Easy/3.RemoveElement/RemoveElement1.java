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
