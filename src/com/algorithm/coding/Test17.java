package com.algorithm.coding;

import java.util.Scanner;

public class Test17 {

    public static void main(String[] args) {
        // write your code here
        pivotSort();
        quickSort1();
        quickSort2();
        quickSort3();
    }

    public static void pivotSort(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subPivotSort(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subPivotSort(int[] arrays, int cnt){

        int first = 0;
        int last = cnt - 1;
        int middle = arrays[cnt / 2];

        do{
            while (arrays[first] < middle){
                first++;
            }
            while (arrays[last] > middle){
                last--;
            }
            if(first <= last){
                swap(arrays, first++, last--);
            }
        }while (first <= last);

        System.out.println("피벗={}" + middle);
        System.out.println("피벗 이하의 그룹");
        for(int i = 0; i <= first - 1; i++){
            System.out.print(arrays[i] + " ");
        }
        System.out.println();

        if(first > last + 1){
            System.out.println("피벗과 일치하는 그룹");
            for(int i = last + 1; i < last - 1; i++){
                System.out.print(arrays[i] + " ");
            }
            System.out.println();
        }

        System.out.println("피벗 이상의 그룹");
        for(int i = last + 1; i < cnt; i++){
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort1(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort1(int[] arrays, int first, int last){

        int pointFirst = first;
        int pointLast = last;
        int middle = arrays[(pointFirst + pointLast) / 2];

        do{
            while (arrays[pointFirst] < middle){
                pointFirst++;
            }
            while (arrays[pointLast] > middle){
                pointLast--;
            }

            if(pointFirst <= pointLast){
                swap(arrays, pointFirst++, pointLast--);
            }
        }while (pointFirst <= pointLast);

        if(first < pointLast){
            subQuickSort1(arrays, first, pointLast);
        }
        if(pointFirst < last){
            subQuickSort1(arrays, pointFirst, last);
        }
    }

    public static void quickSort2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort2(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort2(int[] arrays, int cnt){
        subQuickSort2(arrays, 0, cnt - 1);
    }


    public static void subQuickSort2(int[] arrays, int first, int last){

        int pointFirst = first;
        int pointLast = last;
        int middle = arrays[(pointFirst + pointLast) / 2];

        do{
            while (arrays[pointFirst] < middle){
                pointFirst++;
            }
            while (arrays[pointLast] > middle){
                pointLast--;
            }

            if(pointFirst <= pointLast){
                swap(arrays, pointFirst++, pointLast--);
            }
        }while (pointFirst <= pointLast);

        if(first < pointLast){
            subQuickSort2(arrays, first, pointLast);
        }
        if(pointFirst < last){
            subQuickSort2(arrays, pointFirst, last);
        }
    }

    public static void quickSort3(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort3(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort3(int[] arrays, int first, int last){

        int pointFirst = first;
        int pointLast = last;
        int middle = arrays[(pointFirst + pointLast) / 2];

        System.out.printf("a[%d]~a[%d]：{", first, last);
        for (int i = first; i < last; i++)
            System.out.printf("%d, ", arrays[i]);
        System.out.printf("%d}\n", arrays[last]);

        do{
            while (arrays[pointFirst] < middle){
                pointFirst++;
            }
            while (arrays[pointLast] > middle){
                pointLast--;
            }

            if(pointFirst <= pointLast){
                swap(arrays, pointFirst++, pointLast--);
            }
        }while (pointFirst <= pointLast);

        if(first < pointLast){
            subQuickSort3(arrays, first, pointLast);
        }
        if(pointFirst < last){
            subQuickSort3(arrays, pointFirst, last);
        }
    }

    public static void swap(int[] arrays, int first, int last){

        int temp = arrays[first];
        arrays[first] = arrays[last];
        arrays[last] = temp;
    }
}
