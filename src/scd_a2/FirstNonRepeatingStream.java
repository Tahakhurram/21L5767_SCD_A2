import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {
    char data;
    Node prev;
    Node next;

    public Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class FirstNonRepeatingStream {
    private Map<Character, Node> charMap;
    private Queue<Node> nonRepeatingQueue;

    public FirstNonRepeatingStream() {
        charMap = new HashMap<>();
        nonRepeatingQueue = new LinkedList<>();
    }

    public void add(char c) {
        if (charMap.containsKey(c)) {
            Node node = charMap.get(c);
            if (node != null) {
                nonRepeatingQueue.remove(node);
                charMap.put(c, null);
            }
        } else {
            Node newNode = new Node(c);
            charMap.put(c, newNode);
            nonRepeatingQueue.offer(newNode);
        }
    }

    public char getFirstNonRepeating() {
        while (!nonRepeatingQueue.isEmpty() && charMap.get(nonRepeatingQueue.peek().data) == null) {
            nonRepeatingQueue.poll();
        }
        if (!nonRepeatingQueue.isEmpty()) {
            return nonRepeatingQueue.peek().data;
        } else {
            return '-';
        }
    }

    public static void main(String[] args) {
        FirstNonRepeatingStream stream = new FirstNonRepeatingStream();
        char[] input1 = {'a', 'b', 'a'};
        for (char c : input1) {
            stream.add(c);
        }
        System.out.println("First non-repeating character: " + stream.getFirstNonRepeating()); 

        stream = new FirstNonRepeatingStream();
        char[] input2 = {'a', 'b', 'a', 'b'};
        for (char c : input2) {
            stream.add(c);
        }
        System.out.println("First non-repeating character: " + stream.getFirstNonRepeating()); 

        stream = new FirstNonRepeatingStream();
        char[] input3 = {'a', 'b', 'b'};
        for (char c : input3) {
            stream.add(c);
        }
        System.out.println("First non-repeating character: " + stream.getFirstNonRepeating()); 
    }
}
