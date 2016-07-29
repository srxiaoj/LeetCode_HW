/**
 * Created by thanksgiving on 7/28/16.
 */
public class MapBST {
    class TreeNode {
        int key;
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
        public String toString() {
            return "[" + key + "->" + val + "]";
        }
    }

    private TreeNode root;
    int count;
    public MapBST() {
        root = null;
        this.count = 0;
    }


    public void put(int key, int val) {
        count++;
        if (root == null) {
            root = new TreeNode(key, val);
            return;
        }
        TreeNode cur = root;
        while (cur.left != null || cur.right != null) {
            if (cur.key < key) {
                if (cur.right == null) {
                    cur.right = new TreeNode(key, val);
                    return;
                }
                cur = cur.right;
            } else if (cur.key > key) {
                if (cur.left == null) {
                    cur.left = new TreeNode(key, val);
                    return;
                }
                cur = cur.left;
            } else {
                cur.val = val;
                count--;
                return;
            }
        }
        if (cur.key < key) {
            cur.right = new TreeNode(key, val);
        } else {
            cur.left = new TreeNode(key, val);
        }
    }

    public int get(int key) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            } else if (cur.key < key) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return -1;
    }

    public int size() {
        return count;
    }

    public static void main(String[] args) {
        MapBST myMap = new MapBST();
        myMap.put(8, 0);
        myMap.put(3, 2);
        myMap.put(15, 1);
        myMap.put(5, 100);
        myMap.put(20, 11);
        myMap.put(11, 8);
        System.out.println(myMap.get(8));
        System.out.println(myMap.get(3));
        System.out.println(myMap.get(15));
        System.out.println(myMap.get(5));
        System.out.println(myMap.get(20));
        System.out.println(myMap.get(11));
    }
}
