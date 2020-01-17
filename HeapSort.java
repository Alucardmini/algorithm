import java.util.Arrays;

public class HeapSort {

    public static void sort(int[] arr) {

        //1.构建大根堆 从最后一个非叶子节点开始保证大根堆
        for (int i = arr.length / 2 - 1; i >= 0; i --)
            adjustHeap(arr, i, arr.length);

        // 2.排序 从堆顶取数
        for (int j = arr.length - 1; j > 0; j --) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j - 1);
        }
    }

    private static void adjustHeap(int[] arr, int i, int length) {

        int temp = arr[i];
        for (int k = 2*i + 1; k < length; k = 2*k + 1) {
            if (k + 1 < length && arr[k + 1] > arr[k])
                k += 1;
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else
                break;
        }
        arr[i] = temp;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String [] args) {

        int[] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        
        int[] arr1 = {5,4,3,2,1, 4, 5, 1, 5, 90};
        sort(arr1);
        System.out.println(Arrays.toString(arr1));

    }
}
