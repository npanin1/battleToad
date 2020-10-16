import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HeapSortTest {
    @Test
    public void test0() {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int arrForTest[] = {12, 11, 13, 5, 6, 7};
        int arr1[] = {-1, -5, -64, -1, -23, -2, -3, -1, -7, -77};
        int arrForTest1[] = {-1, -5, -64, -1, -23, -2, -3, -1, -7, -77};
        int arr2[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int arrForTest2[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        HeapSort.sort(arr);
        HeapSort.sort(arr1);
        HeapSort.sort(arr2);
        Arrays.sort(arrForTest);
        Arrays.sort(arrForTest1);
        Arrays.sort(arrForTest2);
        Assert.assertArrayEquals(arr, arrForTest);
        Assert.assertArrayEquals(arr1, arrForTest1);
        Assert.assertArrayEquals(arr2, arrForTest2);
    }
}
