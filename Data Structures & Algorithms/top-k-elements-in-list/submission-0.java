class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        // 1. Count frequency
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // 2. Put keys in ArrayList
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());

        // 3. Sort keys according to frequency (descending)
        Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));

        // 4. Take first k keys
        for (int i = 0; i < k; i++) {
            result[i] = keys.get(i);
        }

        return result;
    }
}