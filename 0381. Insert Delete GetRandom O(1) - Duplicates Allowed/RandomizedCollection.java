import java.util.Random;

class RandomizedCollection {

    /** Initialize your data structure here.
     * Using the DataStructure is the key.
     * One HashMap would store the value and corresponding to that a hashSet that would store the occurence of indices.
     * Second HashMap would store the indices as the key and element as the value. */
    private HashMap<Integer, HashSet<Integer>> map1;
    private HashMap<Integer, Integer> map2;
    private Random rand;

    public RandomizedCollection() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        rand = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     * Simply add the key value pair of indices and element in the second hashMap.
     * Check if the value is already in the First HashMap, if yes Add the index to the HashSet, otherwise create a new HashSet and make an entry in the HashMap.*/
    public boolean insert(int val) {
        int sizeMap2 = map2.size();
        map2.put(sizeMap2 + 1, val);

        if(map1.containsKey(val)){
            map1.get(val).add(sizeMap2 + 1);
            return false;
        }
        else{
            HashSet<Integer> temp = new HashSet<>();
            temp.add(sizeMap2 + 1);
            map1.put(val, temp);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element.
     * Deletion is comparitively complex as the Data entry is to be maintained in both the HashMap.
     * Removal from HashMap1 is easy as the index is to be removed from the HashSet.
     * Removal from HAshMap2 is the critical part as the index is to be swapped with the last index,
     * becasue we do not want null sequence of index in the hashMap because it would create a problem while fetching random numbers*/
    public boolean remove(int val) {
        if(map1.containsKey(val)){
            HashSet<Integer> temp = map1.get(val);
            int toRemove = temp.iterator().next();

            temp.remove(toRemove);

            if(temp.size() == 0){
                map1.remove(val);
            }

            if(toRemove == map2.size()){
                map2.remove(toRemove);
                return true;
            }

            int sizeMap2 = map2.size();
            int lastValue = map2.get(sizeMap2);

            temp = map1.get(lastValue);

            temp.remove(sizeMap2);
            temp.add(toRemove);

            map2.remove(toRemove);
            map2.remove(sizeMap2);
            map2.put(toRemove, lastValue);

            return true;
        }
        return false;
    }

    /** Get a random element from the collection.
     * Generate a Random Index and return the element from the HashMap2. */
    public int getRandom() {
        if(map2.size() == 0){
            return -1;
        }
        if(map2.size() == 1){
            return map2.get(1);
        }
        return map2.get( rand.nextInt(map2.size()) + 1 );
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */