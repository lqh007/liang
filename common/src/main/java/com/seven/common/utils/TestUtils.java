package com.seven.common.utils;

import java.io.IOException;
import java.util.Arrays;

public class TestUtils {

    public static void main(String[] args) throws IOException {
        int[] arr = {2, 3, 6, 1, 6, 8, 4};
        int temp;
        for (int i=0;i<arr.length-1;i++) {
            for (int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }


        System.out.println(Arrays.toString(arr));

    }


}
