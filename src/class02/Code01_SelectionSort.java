package class02;

import utils.Utils;

import java.util.Arrays;

public class Code01_SelectionSort {
    // 从小到大排序
    public static void selectionSort(int[] arr) {
        // 数组为空或者元素只有一个，不需要排序
        if (arr == null || arr.length <= 1) {
            return;
        }
        // 数组下标0 ~ N-1范围找到最小值，放到0位置
        // 数组下标1 ~ N-1范围找到最小值，放到1位置
        // 数组下标2 ~ N-1范围找到最小值，放到2位置
        // ...
        // 数组下标N-1 ~ N-1范围找到最小值，放到N-1位置
        for (int i = 0; i <= arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j <= arr.length - 1; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    // swap 交换arr的序号i和序号j位置的值
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试
    public static void main(String[] args) {
        // 测试次数
        int N = 10000;
        // 随机数组最小值
        int minValue = -100;
        // 随机数组最大值
        int maxValue = 100;
        // 随机数组最小值
        int minCapacity = 0;
        // 随机数组最大值
        int maxCapacity = 100;
        for (int i = 0; i < N; i++) {
            int[] arr1 = Utils.generateRandomIntArray(minValue, maxValue, minCapacity, maxCapacity);
            int[] arr2 = Utils.copyArray(arr1);
            selectionSort(arr1);
            Arrays.sort(arr2);
            if (!Utils.isArrayEqual(arr1, arr2)) {
                System.out.println("测试失败");
                Utils.printArray(arr1);
                Utils.printArray(arr2);
                return;
            }
        }
        System.out.println("测试成功");
    }
}
