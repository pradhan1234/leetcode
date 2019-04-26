/***
 * Using HashMap and DoublyLinkedList
 */

import java.util.Map;
import java.util.HashMap;
import java.lang.Integer;

// DoublyLinkedList Node
class Node {
    int key, value;
    Node prev, next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    // constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node cursor = map.get(key);
        if(cursor != null) {
            remove(cursor);
            insertFirst(cursor);
            return cursor.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node cursor = map.get(key);
        if(cursor!=null) {
            remove(cursor);
        }

        cursor = new Node(key, value);
        insertFirst(cursor);
        map.put(key, cursor);

        if(map.size() > capacity) {
            cursor = tail.prev;
            remove(cursor);
            map.remove(cursor.key);
        }
    }

    //helper methods
    public void insertFirst(Node cursor) {
        Node first = head.next;
        cursor.prev = head;
        cursor.next = first;
        first.prev = cursor;
        head.next = cursor;
    }

    public void remove(Node cursor){
        Node prevNode = cursor.prev;
        Node nextNode = cursor.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */