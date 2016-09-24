import java.io.*;
import java.util.*;

public class QuoraOntology {
    class TrieNode {
        private int count;
        private TrieNode[] children;

        public TrieNode() {
            this.count = 0;
            this.children = new TrieNode[256];
        }
    }

    class Trie {
        private TrieNode head;

        public Trie() {
            this.head = new TrieNode();
        }

        public void insert(String sentence) {
            TrieNode current = head;
            for (char c : sentence.toCharArray()) {
                current = upsert(current, c, 1);
            }
        }

        public TrieNode upsert(TrieNode d, char key, int value) {
            if (d.children[key] != null) {
                d.children[key].count += value;
            } else {
                d.children[key] = new TrieNode();
                d.children[key].count = value;
            }
            return d.children[key];
        }

        public int query(String q) {
            TrieNode current = head;
            for (char c : q.toCharArray()) {
                if (current.children[c] != null) {
                    current = current.children[c];
                } else {
                    return 0;
                }
            }
            return current.count;
        }
    }

    class TreeNode {
        Trie trie;
        List<String> children;

        public TreeNode() {
            this.trie = new Trie();
            this.children = new ArrayList<>();
        }
    }

    class Tree {
        Map<String, TreeNode> treeMap = new HashMap<>();

        public void addNode(String parent, List<String> children) {
            TreeNode node;
            if (!treeMap.containsKey(parent)) {
                node = new TreeNode();
            } else {
                node = treeMap.get(parent);
            }
            node.children.addAll(children);
            treeMap.put(parent, node);
        }

        public void insertSentence(String nodename, String sentence) {
            treeMap.get(nodename).trie.insert(sentence);
        }

        public int query(String nodename, String q) {
            return treeMap.get(nodename).trie.query(q);
        }
    }

    private Tree t;

    public QuoraOntology() {
        this.t = new Tree();
    }

    public void parseFlatTreeIterative(String flatTree) {
        String[] lists = flatTree.split(" ");
        Stack<String> stack = new Stack<>();
        String prev = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i].equals("(")) {
                stack.push(prev);
            } else if (lists[i].equals(")")) {
                stack.pop();
            } else {
                if (!stack.isEmpty()) {
                    t.treeMap.get(stack.peek()).children.add(lists[i]);
                }
                t.addNode(lists[i], new ArrayList<String>());
                prev = lists[i];
            }
        }
    }

    public void parseFlatTree(String flatTree) {
        String s = new String(flatTree);
        Deque<String> words = new LinkedList<>(Arrays.asList(s.split(" ")));
        String root = words.pollFirst();
        t.addNode(root, new ArrayList<String>());
        if (!words.isEmpty() && words.pollFirst().equals("(")) {
            parseFlatTreeHelper(root, words);
        }
    }

    public void parseFlatTreeHelper(String parent, Deque<String> words) {
        String previousWord = null;
        List<String> children = new ArrayList<>();
        while (!words.isEmpty()) {
            String currentWord = words.pollFirst();
            if (currentWord.equals("(")) {
                parseFlatTreeHelper(previousWord, words);
            } else if (currentWord.equals(")")) {
                if (children.size() > 0) {
                    t.addNode(parent, children);
                }
                break;
            } else {
                children.add(currentWord);
                t.addNode(currentWord, new ArrayList<String>());
                previousWord = currentWord;
            }
        }
    }

    public void saveQuery(String query) {
        String[] q = query.split(":");
        t.insertSentence(q[0].trim(), q[1].trim());
    }

    public int findQueryCount(String matchingTo) {
        int index = matchingTo.indexOf(' ');
        String node = matchingTo.substring(0, index).trim();
        String query = matchingTo.substring(index + 1).trim();

        Deque<String> q = new LinkedList<>();
        q.add(node);
        int count = 0;
        while (!q.isEmpty()) {
            String c = q.pollFirst();
            q.addAll(t.treeMap.get(c).children);
            count += t.query(c, query);
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        QuoraOntology o = new QuoraOntology();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(
//                new FileInputStream("/home/thanksgiving/leetCodeWorkSpace/OtherCompany/Quora/src/input56.txt")));
//        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/thanksgiving/leetCodeWorkSpace/OtherCompany/Quora/src/test56.txt"));
        // line 1			int N
        int N = Integer.parseInt(reader.readLine());
        // line 2			flat tree of N topics
        o.parseFlatTreeIterative(reader.readLine());
        // line 3			int M
        int M = Integer.parseInt(reader.readLine());
        // line 4..M+3		topic (colon): question text

        while (M > 0) {
            String query = reader.readLine();
            o.saveQuery(query);
            M--;
        }
        // line M+4			int K
        int K = Integer.parseInt(reader.readLine());
        int temp = K;
        // line M+5..M+K+4	topic name (space) query text
        while (K > 0) {
            String query = reader.readLine();
//            if ((temp - K) % 1000 == 0)
//                System.out.println("read query " + (temp - K));
//            bw.write(String.valueOf(o.findQueryCount(query)));
//            bw.newLine();
            System.out.println(o.findQueryCount(query));
            K--;
        }
//        bw.close();
    }

}
