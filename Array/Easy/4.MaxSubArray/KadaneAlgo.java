class Solution {
    public int maxSubArray(int[] arr) {
        int max_global=arr[0],max=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>max+arr[i])
            {
                max=arr[i];
            }
            else
                max=max+arr[i];
            if(max>max_global)
                max_global=max;
        }
        return max>max_global?max:max_global;
    }
}