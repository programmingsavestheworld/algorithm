package utils;

public class Utils {
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isArrayEqual(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("数组为空");
            return;
        }
        System.out.print("打印数组，元素为: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // FunName: generateRandomIntArray
    // Description: 生成随机容量随机值的整形数组
    // @param minValue: 随机数组最小值
    // @param maxValue: 随机数组最大值
    // @param minCapacity: 随机数组最小值
    // @param maxCapacity: 随机数组最大值
    // @return: 返回生成的随机容量随机值的整形数组
    public static int[] generateRandomIntArray(int minValue, int maxValue, int minCapacity, int maxCapacity) {
        if (minValue > maxValue || minCapacity > maxCapacity) {
            System.out.println("generateRandomArray 入参有误");
        }
        // Math.random() -> [0,1) 所有的小数，等概率返回一个
        // Math.random() * (M - N + 1) -> [0,M-N+1) 所有小数，等概率返回一个
        // Math.random() * (M - N + 1) + N -> [N,M+1) 所有小数，等概率返回一个
        // (int)(Math.random() * (M - N) + N) -> [N,M] 所有的整数，等概率返回一个
        int randomCapacity = (int) (Math.random() * (minCapacity - maxCapacity) + maxCapacity);
        int[] arr = new int[randomCapacity]; // 长度随机
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (minValue - maxValue) + maxValue);
        }
        return arr;
    }
}
