/** Design a data structure that supports all following operations in average O(1) time.

    insert(val): Inserts an item val to the set if not already present.
    remove(val): Removes an item val from the set if present.
    getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.*/



import java.util.Random;
import java.util.Collections;

class RandomizedSet {

    /** Initialize your data structure here.
     * Two Data Structures used Map for quick access of the indexes where an element is stored in the list.
     * Arraylist to fetch values fast with the random Function.*/
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element.
     * Values are inserted int the map as well as the Arraylist*/
    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element.
     * For removing use the property of Arraylist where if the element is removed from the end of the list the complexity is of O(1).
     * For using this we swap the index to be removed with the last index in the Arraylist. And make the changes to the HashMap accordingly with the index mapping*/
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int index = map.get(val);
            int lastIndex = list.size() - 1;
            int lastVal = list.get(lastIndex);
            Collections.swap(list, index, lastIndex);
            list.remove(lastIndex);
            map.put(lastVal, index);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set.
     * Simply use the random function to give an integer in the range of the size of the Arraylist.*/
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */