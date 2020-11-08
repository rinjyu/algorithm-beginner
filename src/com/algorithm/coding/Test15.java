package com.algorithm.coding;

import java.util.Scanner;

public class Test15 {

    public static void main(String[] args) {
        // write your code here
        selectionSort1();
        insertSort1();
        selectionSort2();
        insertSort2();
        insertSort3();
    }

    public static void selectionSort1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subSelectionSort1(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subSelectionSort1(int[] arrays, int cnt){

        for(int i = 0; i < cnt - 1; i++){
            int min = i;
            for(int j = i + 1; j < cnt; j++){
                if(arrays[j] < arrays[min]){
                    min = j;
                }
                swap(arrays, i, min);
            }
        }
    }

    public static void swap(int[] arrays, int i, int j){

        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void insertSort1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subInsertSort1(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subInsertSort1(int[] arrays, int cnt){

        for(int i = 1; i < cnt; i++){
            int j;
            int temp = arrays[i];
            for(j = i; j > 0 && arrays[j - 1] > temp; j--){
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = temp;
        }
    }

    public static void selectionSort2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subSelectionSort2(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subSelectionSort2(int[] arrays, int cnt){

        for(int i = 0; i < cnt - 1; i++){
            int min = i;
            for(int j = i + 1; j < cnt; j++){
                if(arrays[j] < arrays[min]){
                    min = j;
                }
            }
            for(int k = 0; k < cnt; k++){
                System.out.print((k == i) ? "  * " : (k == min) ? "  + " : "    ");
            }
            System.out.println();
            for(int k = 0; k < cnt; k++){
                System.out.printf("%3d ", arrays[k]);
            }
            System.out.println("\n");
            swap(arrays, i, min);
        }
    }

    public static void insertSort2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt + 1];
        for(int i = 1; i <= cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subInsertSort2(arrays, cnt + 1);
        System.out.println("오름차순 정렬");
        for(int i = 1; i <= cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subInsertSort2(int[] arrays, int cnt){

        for(int i = 2; i < cnt; i++){
            int temp = arrays[0] = arrays[i];
            int j = i;
            for(; arrays[j - 1] > temp; j--){
                arrays[j] = arrays[j - 1];
            }
            if(j > 0){
                arrays[j] = temp;
            }
        }
    }

    public static void insertSort3(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subInsertSort3(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subInsertSort3(int[] arrays, int cnt){
        
        for(int i = 1; i < cnt; i++){
            int key = arrays[i];
            int first = 0;
            int last = i - 1;
            int center;
            int index = 0;
            do{
                center = (first + last) / 2;
                if(arrays[center] == key){
                    break;
                }else if(arrays[center] < key){
                    first = center + 1;
                }else{
                    last = center - 1;
                }
            }while (first <= last);
            index = (first <= last) ? (center + 1) : (last + 1);
            for(int j = i; j > index; j--){
                arrays[j] = arrays[j - 1];
            }
            arrays[index] = key;
        }
    }
}
