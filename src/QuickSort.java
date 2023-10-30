import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int arr[]){
        if (arr == null || arr.length<=1){
            return;//base case
        }
        quickSortRecursive(arr,0, arr.length-1);
    }
    private static void quickSortRecursive(int arr[],int low,int high){
        if (low < high){
            int pivotindex = partition(arr,low,high);

            quickSortRecursive(arr,low,pivotindex-1);//lefgt array sorting
            quickSortRecursive(arr,pivotindex+1,high);//right array sorting
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];//in this case i'am taking the pivot element as high that is last element
        int i = low-1;
        for (int j=low; j<high;j++){
            if (arr[j] <=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);//place the pivot element in its position
        return i+1;//index of pivot element
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 1, 3, 8, 4, 2, 7, 6};
        System.out.println("Original array: " + Arrays.toString(arr));

        quickSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}