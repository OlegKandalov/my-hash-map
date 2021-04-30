import java.util.Arrays;

public class HashMap {
    private Node[] arrayOfBuckets;
    private static final int length = 16;
    private int nodeCount = 0;
    private int collision = 0;


    public HashMap() {
        arrayOfBuckets = new Node[length];
    }

    public void put(int key, long value) {
        Node node = new Node(key, value, null);
        int indexOfBucket = getIndex(key);
        Node isNull = arrayOfBuckets[indexOfBucket];

        if (isNull == null) {
            arrayOfBuckets[indexOfBucket] = node;
            nodeCount++;
        } else {
            while (isNull.next != null) {
                if (isNull.key == key) {
                    isNull.value = value;
                    return;
                }
                isNull = isNull.next;
            }
            if (isNull.key == key) {
                isNull.value = value;
            } else {
                isNull.next = node;
                collision++;
            }
        }
    }

    public Long get(int key) {
        int indexOfBucket = getIndex(key);
        Node node = arrayOfBuckets[indexOfBucket];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public int size() {
        return nodeCount + collision;
    }

    private int getIndex(int key) {
        String keyString = key + "";
        int hashCode = keyString.hashCode();
        return hashCode & (length - 1);
    }


    private static class Node {
        private int key;
        private long value;
        private Node next;

        public Node(int key, long value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        String[] allNodes = new String[nodeCount];
        int idx = 0;
        for (Node arrayOfBucket : arrayOfBuckets) {
            if (arrayOfBucket != null) {
                allNodes[idx++] = arrayOfBucket.toString();
            }
        }
        return Arrays.toString(allNodes) + " + nodes in collision: " + collision;
    }
}
