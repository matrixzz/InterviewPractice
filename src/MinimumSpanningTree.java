import java.util.*;

public class MinimumSpanningTree {
    static public class Connection {
        public String city1, city2;
        public int cost;
        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    public List<Connection> lowestCost(List<Connection> connections) {
        List<Connection> result = new ArrayList<>();
        // Empty case
        if(connections == null || connections.isEmpty()) {
            return result;
        }

        // Preparing work
        PriorityQueue<Connection> heap = new PriorityQueue<Connection>(connections.size(), new ConnectionComparator());
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> rank = new HashMap<>();
        for(Connection c : connections) {
            heap.offer(c);
            parent.put(c.city1, c.city1);
            parent.put(c.city2, c.city2);
            rank.put(c.city1, 0);
            rank.put(c.city2, 0);
        }

        while(result.size() < rank.size() - 1) {
            Connection c = heap.poll();
            if (c == null) {
                return new ArrayList<Connection>();
            }
            String root1 = find(c.city1, parent);
            String root2 = find(c.city2, parent);
            if (!root1.equals(root2)) {
                result.add(c);
                if (rank.get(root1) > rank.get(root2)) {
                    parent.put(root2, root1);
                    rank.put(root1, rank.get(root1) + 1);
                } else {
                    parent.put(root1, root2);
                    rank.put(root2, rank.get(root2) + 1);
                }
            }
        }

        result.sort(new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                if (o1.cost > o2.cost) {
                    return 1;
                } else if (o1.cost < o2.cost) {
                    return -1;
                } else {
                    if (o1.city1.compareTo(o2.city1) > 0) {
                        return 1;
                    } else if (o1.city1.compareTo(o2.city1) < 0) {
                        return -1;
                    } else {
                        return o1.city2.compareTo(o2.city2);
                    }
                }
            }
        });

        return result;
    }

    private String find(String city, Map<String, String> parent) {
        if (parent.get(city).equals(city)) {
            return city;
        } else {
            return find(parent.get(city), parent);
        }
    }

    private class ConnectionComparator implements Comparator<Connection> {
        @Override
        public int compare(Connection a, Connection b) {
            return a.cost - b.cost;
        }
    }

    public static void main(String[] args){
        MinimumSpanningTree problem = new MinimumSpanningTree();
        List<Connection> connections = new ArrayList<>();
        Connection a = new Connection("Acity", "Bcity", 1);
        Connection b = new Connection("Acity", "Ccity", 2);
        Connection c = new Connection("Bcity", "Ccity", 3);
        connections.add(a);
        connections.add(b);
        connections.add(c);

        problem.lowestCost(connections);
    }
}
