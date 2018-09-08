import algorithm.queue.*;

import java.util.*;

/**
 * Created by hoducust on 2018/3/31 10H 26m .
 */
public class Main {

    List<String>[] str = new List[12];

    public static void main(String[] args) {

       String[] path =  "/home/.././a//x/..".substring(1).split("/");

       Iterator iter = Arrays.asList(path).iterator();

       while (iter.hasNext()){
           iter.next();
           iter.next();
           iter.next();
           iter.next();
           iter.next();
           iter.next();
           iter.next();
           iter.next();iter.next();

       }

       String CC = new Main().simplifyPath("/home/.././a//x/..");

//        System.out.println(new Main().addStrings("2211", "2779"));

    }
    public String simplifyPath(String path) {
        String[] arrPath = path.substring(1).split("/");
        Deque<String> stk = new ArrayDeque();
        for(String dir:arrPath){
            if(dir=="..") {
                stk.pop();
            }else if(dir!="."&& dir!="") stk.push(dir);
        }
        StringBuilder strb = new StringBuilder("/");
        while(!stk.isEmpty()) strb.insert(1,stk.pop());
        return strb.toString();
    }

    public String addStrings(String num1, String num2) {
        // 不考虑负数
        if (num1 == null || num2 == null) throw new IllegalArgumentException("Illegal Argument : has null！");
        int adding = 0;
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        StringBuffer strBuff = new StringBuffer();

        while (len1 > -1 || len2 > -1) {
            int sumValue = (len1 > -1 ? num1.charAt(len1--) - '0' : 0) + (len2 > -1 ? num2.charAt(len2--) - '0' : 0) + adding;
            adding = sumValue < 10 ? 0 : 1;

            strBuff.insert(0, sumValue % 10);
        }
        return strBuff.toString();
    }


    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

    }

    public TreeNode invertNode(TreeNode root) {
        if (root == null)
            return null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue != null) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        return root;
    }


}
