class ValidateBST{
    Node root;
    class Node{
        int val;
        int left;
        int right;

        Node(int value){
            this.val = value;
        }
    }
    public boolean isValidBST(Node root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    public boolean isValidBST(Node root, long minVal, long maxVal){
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        else{
            return isValidBST(root.left, minVal, root.val) && 
            isValidBST(root.right, root.val, maxVal);
        }
    }

    
}
