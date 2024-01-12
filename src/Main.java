public class Main {
    public static void main(String[] args) {

        int [] arr = {1,2,3,4,5};
        System.out.println(BST.binarySearch(arr, 4));

        int [] values = {5,1,3,4,2,7};
        BST bst = new BST();
        for (int i=0; i<values.length; i++){
            bst.root = bst.insert(bst.root, values[i]);
        }
        bst.inorder(bst.root);
        System.out.println(bst.search(bst.root, 6));

        int[] arr2 = {64,34,25,12,22,11,90};
        Sorting.mergeSort(arr2);
        Sorting.printArray(arr2);



    }
}