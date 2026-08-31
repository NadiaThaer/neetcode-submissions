class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> Map = new HashMap<>();
        for(int x =0;x<nums.length;x++){
            int needed=target-nums[x];
            if(Map.containsKey(needed))
               {
                 return new int[]{
                   
                    Map.get(needed), x
                 };
               }
            else{
                Map.put(nums[x],x);
            }
            
        }
         return new int[]{};
         /*
                    Order of Indices: The problem requires the indices to be returned with the smaller index first. Since the Map stores indices of elements encountered previously, Map.get(needed) will always be smaller than the current index x
                    */
    }
}
