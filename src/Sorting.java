import java.util.Arrays;

public class Sorting {
    public static void bubbleSort(int[] arr){
        for (int i=0; i< arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void selectionSort(int[] arr){
        for (int i=0; i< arr.length; i++){
            int min = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[j]<arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void insertionSort(int[] arr){
        for (int i=1; i< arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while (j>=0 && key < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void quickSort(int[] arr){
        int n = arr.length;
        qsort(arr, 0, n-1);
    }
    public static void qsort(int[] arr, int low, int high){
        if (low<high){
            int pi = partition(arr, low, high);
            qsort(arr, low, pi-1);
            qsort(arr, pi+1, high);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j<high; j++){
            if (arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int i=1; i<arr.length; i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        for (int exp = 1; max/exp>0; exp*=10){
            countSort(arr, exp);
        }
    }
    public static void countSort(int[] arr, int exp){
        int[] output = new int[arr.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i=0; i<arr.length; i++){
            count[(arr[i]/exp)%10]++;
        }
        for (int i = 1; i<10; i++){
            count[i] += count[i-1];
        }
        for (int i=arr.length-1; i>=0;i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        for (int i=0; i<arr.length; i++){
            arr[i]=output[i];
        }
    }
    public static void mergeSort(int[] arr){
        int l = 0;
        int r = arr.length-1;
        msort(arr, l, r);
    }
    public static void msort(int[] arr, int l, int r){
        if (l<r){
            int m = (l+(r-1))/2;
            msort(arr, l, m);
            msort(arr, m+1, r);

            merge(arr, l, m, r);
        }
    }
    public static void merge(int[] arr, int l, int m, int r){
        int[] L = new int[m-l+1];
        int[] R = new int[r-m];
        for (int i=0; i<L.length; ++i){
            L[i] = arr[l+i];
        }
        for (int i=0; i<R.length; ++i){
            R[i] = arr[m+1+i];
        }
        int i=0,j=0,k=l;
        while (i<L.length && j<R.length){
            if (L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < L.length) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < R.length) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void printArray(int[] arr){
        for (int i=0; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
