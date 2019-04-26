class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("I", 1);
        myMap.put("V", 5);
        myMap.put("X", 10);
        myMap.put("L", 50);
        myMap.put("C", 100);
        myMap.put("D", 500);
        myMap.put("M", 1000);

        int currentN, nextN;
        int acc = 0;

        for(int i = 0; i < s.length() - 1; i++) {
            currentN = myMap.get(""+s.charAt(i));
            nextN = myMap.get(""+s.charAt(i+1));
            if(currentN < nextN) {
                // if current is less than next eg: IX this results to 10 - 1 = 9
                acc -= currentN;
            } else {
                // otherwise add eg: II this results to 2
                // eg: XI this results to 11
                acc += currentN;
            }
        }
        return acc + myMap.get(""+s.charAt(s.length() - 1));
    }
}
