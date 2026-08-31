class Solution {
    public boolean hasDuplicate(int[] nums) {
        //define my hash Set 
     HashSet<Integer> set = new HashSet<>();
     for(int x : nums)
     {
        if(set.contains(x)){
            return true;
        }

        set.add(x);
     }
        return false;
    }
}