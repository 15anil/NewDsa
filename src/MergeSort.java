//import java.lang.reflect.AnnotatedArrayType;
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int arr[]){
        if (arr == null || arr.length<=1){
            return;
        }
        int mid = arr.length/2;
        int left[] = new int[mid];
        int right[] = new int[arr.length-mid];

        for (int i = 0;i<mid;i++){
            left[i] = arr[i];
        }
        for (int i = mid; i< arr.length;i++){
            right[i-mid] = arr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,arr);
    }
    private static void merge(int left[],int right[],int arr[]){
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<left.length && j<right.length){
            if (left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else {
                arr[k++] = right[j++];
            }
        }
        while (i< left.length){
            arr[k++] = left[i++];
        }
        while (j<right.length){
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int arr[] = {9,5,1,3,8,4,2,7,6};
        System.out.println("before sorting " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("after sorting " + Arrays.toString(arr));
    }
}
