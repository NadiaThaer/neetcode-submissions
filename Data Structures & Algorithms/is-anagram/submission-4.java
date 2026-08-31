class Solution {
    public boolean isAnagram(String s, String t) {
        //Main Func in The HashMap 
        /*
        1-put(Key,Value)
        2-get(Key)
        3-containKey(Key)
        */
        /*
          Soluetion : 
          1-check the length for both string if is same Start To Creat The Hash Map 
          2-to creat the Hash Map for Both i need the Key And Value 
                     Key ->>>>> the char
                     value->>>> Frequancy
          
        */
    //check the length 
    if(s.length() != t.length()){
        return false;
    }
    //creat the HashMap 1 
    HashMap <Character,Integer> Map1 = new HashMap<>();
    //creat the HashMap 2
    HashMap <Character,Integer> Map2 = new HashMap<>();
    for(char x : s.toCharArray()){
        if(Map1.containsKey(x))
         {
            Map1.put(x,Map1.get(x)+1);
         }
         else{
                Map1.put(x,1);
         } 
    }
    
    for(char x : t.toCharArray()){
        if(Map2.containsKey(x))
         {
            Map2.put(x,Map2.get(x)+1);
         }
         else{
                Map2.put(x,1);
         }

    }

/*
Important difference with Integer
If you directly compare Integer objects using == or !=, Java can sometimes compare their object references instead of their values:
*/
    for (char x : Map1.keySet()) {
        if (!Map2.containsKey(x) || !Map1.get(x).equals(Map2.get(x))) {
            return false;
        }
    }

    return true;
    }
}
