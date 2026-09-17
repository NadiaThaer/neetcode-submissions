
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        // Create a HashMap.
        // Key   = the word after sorting its characters.
        // Value = a List of words that have the same sorted characters.
        //
        // Example:
        // "eat" -> "aet"
        // "tea" -> "aet"
        //
        // So the Map will contain:
        // "aet" -> ["eat", "tea"]
        Map<String, List<String>> map = new HashMap<>();


        // Loop through every word in the input array.
        //
        // If strs = ["eat", "tea", "tan"]
        // word will be:
        // "eat" first
        // "tea" second
        // "tan" third
        for (String word : strs) {


            // Call our own method sortStr().
            // It sorts the characters of the word
            // and returns the sorted word as a String.
            //
            // Example:
            // "eat" -> "aet"
            // "tea" -> "aet"
            // "tan" -> "ant"
            String sort = sortStr(word);


            // putIfAbsent() checks if the key already exists.
            //
            // If "aet" does NOT exist:
            // create a new empty ArrayList.
            //
            // Example:
            // "aet" -> []
            //
            // If "aet" already exists:
            // do nothing.
            map.putIfAbsent(sort, new ArrayList<>());


            // Get the List associated with the sorted key
            // and add the original word to that List.
            //
            // Example:
            // map.get("aet") -> ["eat"]
            //
            // Then add "tea":
            // map.get("aet") -> ["eat", "tea"]
            map.get(sort).add(word);
        }


        // Convert the values of the HashMap
        // into the final List<List<String>>.
        //
        // Example:
        // Map:
        // "aet" -> ["eat", "tea", "ate"]
        // "ant" -> ["tan", "nat"]
        //
        // Result:
        // [["eat", "tea", "ate"], ["tan", "nat"]]
        return convertToList(map);
    }


    // This method converts the HashMap values
    // into a List of Lists.
    private List<List<String>> convertToList(
            Map<String, List<String>> map) {

        // Create an empty result.
        //
        // The final answer will be stored here.
        List<List<String>> result = new ArrayList<>();


        // map.values() gives us all the Lists inside the Map.
        //
        // Example:
        // Map:
        // "aet" -> ["eat", "tea"]
        // "ant" -> ["tan", "nat"]
        //
        // map.values() gives:
        // ["eat", "tea"]
        // ["tan", "nat"]
        for (List<String> anagrams : map.values()) {

            // Add each group of Anagrams to the result.
            result.add(anagrams);
        }


        // Return the final answer.
        return result;
    }


    // This is our own method.
    // It takes a String and returns the same characters sorted.
    //
    // Example:
    // "eat" -> "aet"
    // "tea" -> "aet"
    private String sortStr(String word) {


        // Convert the String into a character array.
        //
        // Example:
        // "eat"
        // becomes:
        // ['e', 'a', 't']
        char[] chars = word.toCharArray();


        // Arrays.sort() is a built-in Java method.
        // It sorts the elements of the array in ascending order.
        //
        // ['e', 'a', 't']
        // becomes:
        // ['a', 'e', 't']
        Arrays.sort(chars);


        // Convert the sorted char array back into a String.
        //
        // ['a', 'e', 't']
        // becomes:
        // "aet"
        return new String(chars);
    }
}