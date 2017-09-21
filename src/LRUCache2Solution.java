import java.util.HashMap;
import java.util.Map;

public class LRUCache2Solution {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int capacity;

    LRUCache2Solution(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            // remove from list
            node.prev.next = node.next;
            node.next.prev = node.prev;

            moveToTail(node);

            return node.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if(this.get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if(map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node node = new Node(key, value);
        moveToTail(node);
        map.put(key, node);
    }

    private void moveToTail(Node node) {
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        node.next = tail;
    }

    public static void main(String[] args) {
        LRUCache2Solution cache = new LRUCache2Solution(2);
        cache.set(2,1);
        cache.set(1,1);
        System.out.println(cache.get(2));
        cache.set(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

        System.out.println("new test case:");
        cache = new LRUCache2Solution(1);
        cache.set(2,1);
        System.out.println(cache.get(2));
        cache.set(3,2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));

        System.out.println("new test case:");
        cache = new LRUCache2Solution(2);
        System.out.println(cache.get(2));
        cache.set(2,6);
        System.out.println(cache.get(2));
        cache.set(1,5);
        System.out.println(cache.get(1));

        System.out.println("new test case:");
        cache = new LRUCache2Solution(2);
        cache.set(2,1);
        cache.set(2,2);
        System.out.println(cache.get(2));
        cache.set(1,1);
        cache.set(4,1);
        System.out.println(cache.get(2));

    }
}
