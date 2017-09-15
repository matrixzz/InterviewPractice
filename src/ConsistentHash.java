import java.util.*;

public class ConsistentHash<T> {

        private final int numberOfReplicas;
        private final SortedMap<Integer, T> circle =
                new TreeMap<Integer, T>();

        public ConsistentHash(int numberOfReplicas, Collection<T> nodes) {

            this.numberOfReplicas = numberOfReplicas;

            for (T node : nodes) {
                add(node);
            }
        }

        public void add(T node) {
            for (int i = 0; i < numberOfReplicas; i++) {
                circle.put((node.toString() + i).hashCode(),
                        node);
            }
        }

        public void remove(T node) {
            for (int i = 0; i < numberOfReplicas; i++) {
                circle.remove((node.toString() + i).hashCode());
            }
        }

        public T get(Object key) {
            if (circle.isEmpty()) {
                return null;
            }
            int hash = key.hashCode();
            if (!circle.containsKey(hash)) {
                SortedMap<Integer, T> tailMap =
                        circle.tailMap(hash);
                hash = tailMap.isEmpty() ?
                        circle.firstKey() : tailMap.firstKey();
            }
            return circle.get(hash);
        }

        public static void main(String[] args) {
            Collection<String> nodes = new HashSet<>(10);
            ConsistentHash<String> consistentHash = new ConsistentHash<>(3, nodes);
            consistentHash.get("123");
        }
}
