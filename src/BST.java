public class BST {
    Node root;
    public class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    public Node insert(Node root, int val){
        if (root == null){
            root = new Node(val);
            return root;
        }
        if (root.data > val){
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public void inorder(Node root){
        if (root == null){
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public boolean search(Node root, int key){
        if (root == null){
            return false;
        }
        if (root.data > key){
            return search(root.left, key);
        } else if (root.data < key){
            return search(root.right, key);
        } else if (root.data == key){
            return true;
        }
        return false;
    }
    public static int binarySearch(int[] arr, int x){
        int l = 0;
        int r = arr.length - 1;
        while (l<=r){
            int m = (l + r) / 2;
            if (arr[m] == x){
                return m;
            }
            if (arr[m] > x){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
