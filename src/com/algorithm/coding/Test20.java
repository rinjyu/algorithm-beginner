package com.algorithm.coding;

import java.util.Scanner;

public class Test20 {

    private static int[] buffer;

    public static void main(String[] args) {
        // write your code here
        mergeArray();
        mergeSort();
    }

    public static void mergeArray(){

        int[] a = {2, 4, 6, 8, 11, 13};
        int[] b = {1, 2, 3, 4, 9, 16, 21};
        int[] c = new int[13];

        System.out.println("두 배열의 병합");

        subMergeArray(a, a.length, b, b.length, c);

        System.out.println("첫번째 배열={}");
        for(int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }
        System.out.println("두번째 배열={}");
        for(int i = 0; i < b.length; i++){
            System.out.println(b[i]);
        }
        System.out.println("세번째 배열={}");
        for(int i = 0; i < c.length; i++){
            System.out.println(c[i]);
        }
    }

    public static void subMergeArray(int[] a, int aLength, int[] b, int bLength, int[] c) {

        int pa = 0;
        int pb = 0;
        int pc = 0;

        while (pa < aLength && pb < bLength){
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];
        }
        while (pa < aLength){
            c[pc++] = a[pa++];
        }
        while (pb < bLength){
            c[pc++] = b[pb++];
        }
    }

    public static void mergeSort(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subMergeSort(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subMergeSort(int[] arrays, int cnt){

        buffer = new int[cnt];

        subMergeSort(arrays, 0, cnt - 1);

        buffer = null;
    }

    public static void subMergeSort(int[] arrays, int first, int last){

        if(first < last){
            int i;
            int center = (first + last) / 2;
            int p = 0;
            int j = 0;
            int k = first;

            subMergeSort(arrays, first, center);
            subMergeSort(arrays, center + 1, last);

            for(i = first; i <= center; i++){
                buffer[p++] = arrays[i];
            }
            while (i <= last && j < p){
                arrays[k++] = (buffer[j] <= arrays[i]) ? buffer[j++] : arrays[i++];
            }
            while (j < p){
                arrays[k++] = buffer[j++];
            }
        }

    }
}
