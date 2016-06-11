/**
 * Created by thanksgiving on 6/10/16.
 */
public class SerialAndDeserial {
    public static void main(String[] args) {
        SerialAndDeserial obj = new SerialAndDeserial();
        TreeNode root = TreeNode.deserializeLevelorder("1, 2, null, 3, null");
        TreeNode.printNode(root);
        String afterSeri = obj.serialize(root);
        TreeNode afterDesi = obj.deserialize(afterSeri);
        TreeNode.printNode(afterDesi);

    }

    private int index = 0;
    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        serializeHelper(root, sb);
        String s = sb.toString();
        String sub = s.substring(0, s.length() - 1);
        sub += "}";
        //System.out.println(sub);
        return sub;
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val);
        sb.append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // public TreeNode deserialize(String data) {

    //     if (data == null || data.length() == 0) {

    //         return null;

    //     }

    //     String sub = data.substring(1, data.length() - 1);

    //     if (sub == null || sub.length() == 0) {

    //         return null;

    //     }

    //     String[] chars = sub.split(",");

    //     //System.out.println(Arrays.toString(chars));

    //     int[] index = new int[1];

    //     return deserializeHelper(chars, index);

    // }

    // private TreeNode deserializeHelper(String[] chars, int[] index) {

    //     if (chars == null || chars.length == 0) {

    //         return null;

    //     }

    //     if (chars[index[0]].equals("#")) {

    //         index[0]++;

    //         return null;

    //     }

    //     TreeNode root = new TreeNode(Integer.parseInt(chars[index[0]]));

    //     index[0]++;

    //     //System.out.println(index[0]);

    //     root.left = deserializeHelper(chars, index);

    //     root.right = deserializeHelper(chars, index);

    //     return root;

    // }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String sub = data.substring(1, data.length() - 1);
        if (sub == null || sub.length() == 0) {
            return null;
        }
        String[] chars = sub.split(",");
        //System.out.println(Arrays.toString(chars));
        return deserializeHelper(chars);

    }
    private TreeNode deserializeHelper(String[] chars) {
        if (chars == null || chars.length == 0) {
            return null;
        }
        if (chars[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(chars[index]));
        index++;
        System.out.println(index);
        root.left = deserializeHelper(chars);
//        index++;
        System.out.println(index);
        root.right = deserializeHelper(chars);
        return root;

    }
}
