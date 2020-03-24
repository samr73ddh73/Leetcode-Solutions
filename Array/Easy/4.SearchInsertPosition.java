//Remember this binarySearch funchtion :
class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int i=Arrays.binarySearch(nums,target);
        if(i>=0)
            return i;
        return -(i)-1;
    }
}

// Binary Search Approach: 
//In here, we have to consider alot of edge cases:
// 1)target element< arr[0]
// 2)target element> arr[n-1]

class Solution {
    public int bs(int[] nums,int start,int end,int target)
    {
        if(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target && mid-1>=start && nums[mid-1]<target )
                return mid;
            if(nums[mid]<target && mid+1<=end &&nums[mid+1]>target )
                return mid+1;
            if(mid==start && nums[mid]>target)// eq: [1,2,4,6] target:0 bcz here there is no mid-1
                return start;
            if(mid==end && nums[mid]<target)// eg: [1,2,4,6] target:7 
                return mid+1;
            if(nums[mid]>target)
                return bs(nums,start,mid-1,target);
            return bs(nums,mid+1,end,target);
            
        }
        return -1;
    }
    public int searchInsert(int[] nums, int target) {
        
       return bs(nums,0,nums.length-1,target);
    }
}

//better binary search:
class Solution {
   
    public int searchInsert(int[] nums, int target) {
     
        if(target>nums[nums.length-1])
            return nums.length;
        int l=0,r=nums.length-1,ans=-1;
        while(l<=r)
        {
            int mid=l+(r-l)/2;
            if(nums[mid]<target)
                l=mid+1;
            else
            {
                ans=mid;
                r=mid-1;
            }
        }
        return ans;
        
    }
}