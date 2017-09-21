import java.util.*;

public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    Map<Integer, Node> dataMap;
    Node head;
    Node tail;
    int size;
    int capacity;

    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.dataMap = new HashMap<>(capacity);
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }

    // @return an integer
    public int get(int key) {
        if (this.dataMap.containsKey(key)) {
            Node dataNode = this.dataMap.get(key);

            // Not head
            if (dataNode.prev != null) {
                dataNode.prev.next = dataNode.next;
            } else {
                return dataNode.value;
            }

            // Not tail
            if (dataNode.next != null) {
                dataNode.next.prev = dataNode.prev;
            } else {
                // Set new tail
                this.tail = dataNode.prev;
                this.tail.next = null;
            }

            // Move to head
            this.head.prev = dataNode;
            dataNode.next = this.head;
            dataNode.prev = null;
            this.head = dataNode;

            return dataNode.value;
        } else {
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (this.get(key) != -1) {
            this.dataMap.get(key).value = value;
            return;
        }
        Node dataNode = new Node(key, value);
        if (this.size == 0) {
            this.head = dataNode;
            this.tail = dataNode;
        } else {
            if(this.size == this.capacity) {
                // remove tail
                this.dataMap.remove(this.tail.key);
                this.tail = this.tail.prev;
                if (--this.size != 0) {
                    this.tail.next = null;
                }
            }
            if (this.size != 0) {
                this.head.prev = dataNode;
                dataNode.next = this.head;
                this.head = dataNode;
            } else {
                this.head = dataNode;
                this.tail = dataNode;
            }
        }
        this.dataMap.put(key, dataNode);
        this.size++;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2,1);
        cache.set(1,1);
        System.out.println(cache.get(2));
        cache.set(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        System.out.println("new test case:");
        cache = new LRUCache(1);
        cache.set(2,1);
        System.out.println(cache.get(2));
        cache.set(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

        System.out.println("new test case:");
        cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.set(2,6);
        System.out.println(cache.get(2));
        cache.set(1,5);
        System.out.println(cache.get(1));

        System.out.println("new test case:");
        cache = new LRUCache(2);
        cache.set(2,1);
        cache.set(2,2);
        System.out.println(cache.get(2));
        cache.set(1,1);
        cache.set(4,1);
        System.out.println(cache.get(2));

    }
}
