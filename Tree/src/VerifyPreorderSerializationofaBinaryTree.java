/**
 * Created by thanksgiving on 5/9/16.
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public static void main(String[] args) {
        VerifyPreorderSerializationofaBinaryTree obj = new VerifyPreorderSerializationofaBinaryTree();
        String s1 = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        String s2 = "9,#,#,1";
        System.out.println(obj.isValidSerialization(s1));
        System.out.println(obj.isValidSerialization(s2));
    }

    /**
     * 每loop一个node，indegree加1
     * 每loop一个非#node,outdegree加2, 若为#则outdegree不变
     * 最后indegree应该等于outdegree，且indegree任何时候都不应大于outdegree
     */
    public boolean isValidSerialization(String preorder) {
        int indegree = -1;
        int outdegree = 0;
        String[] res = preorder.split(",");
        for (String s : res) {
            indegree++;
            if (indegree > outdegree) {
                return false;
            }

            if (!s.equals("#")) {
                outdegree += 2;
            }
        }
        return indegree == outdegree;


        /*String[] strs = preorder.split(",");
        int degree = -1;         // root has no indegree, for compensate init with -1
        for (String str : strs) {
            degree++;             // all nodes have 1 indegree (root compensated)
            if (degree > 0) {     // total degree should never exceeds 0
                return false;
            }
            if (!str.equals("#")) {// only non-leaf node has 2 outdegree
                degree -= 2;
            }
        }
        return degree == 0;*/
    }
}
