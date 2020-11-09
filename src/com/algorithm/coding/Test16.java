package com.algorithm.coding;

import java.util.Scanner;

public class Test16 {

    public static void main(String[] args) {
        // write your code here
        shellSort1();
        shellSort2();
        shellSort3();
        shellSort4();
    }

    public static void shellSort1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subShellSort1(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subShellSort1(int[] arrays, int cnt){

        for(int i = cnt / 2; i > 0; i /= 2){
            for(int j = i; j < cnt; j++){
                int k;
                int temp = arrays[j];
                for(k = j - i; k >= 0 && arrays[k] > temp; k -= i){
                    arrays[j + i] = arrays[k];
                }
                arrays[k + i] = temp;
            }
        }
    }

    public static void shellSort2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subShellSort2(arrays, cnt);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subShellSort2(int[] arrays, int cnt){

        int h;
        for(h = 1; h < cnt / 9;h = h * 3 + 1){

        }

        for(; h > 0; h /= 3){
            for(int i = h; i < cnt; i++){
                int j;
                int temp = arrays[i];
                for(j = i - h; j >= 0 && arrays[j] > temp; j -= h){
                    arrays[j + h] = arrays[j];
                }
                arrays[j + h] = temp;
            }
        }
    }

    public static void shellSort3(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        int sortCnt = subShellSort3(arrays, cnt);
        System.out.println("이동횟수={}" + sortCnt);
    }

    public static int subShellSort3(int[] arrays, int cnt){

        int sortCnt = 0;
        for(int i = cnt / 2; i > 0; i /= 2){
            for(int j = i; j < cnt; j++){
                int k;
                int temp = arrays[j];
                for(k = j - i; k >= 0 && arrays[k] > temp; k -= i){
                    arrays[j + i] = arrays[k];
                    sortCnt++;
                }
                arrays[k + i] = temp;
                sortCnt++;
            }
        }

        return sortCnt;
    }

    public static void shellSort4(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        int sortCnt = subShellSort4(arrays, cnt);
        System.out.println("이동횟수={}" + sortCnt);
    }

    public static int subShellSort4(int[] arrays, int cnt){

        int sortCnt = 0;
        int h;
        for(h = 1; h < cnt / 9;h = h * 3 + 1){

        }

        for(; h > 0; h /= 3){
            for(int i = h; i < cnt; i++){
                int j;
                int temp = arrays[i];
                for(j = i - h; j >= 0 && arrays[j] > temp; j -= h){
                    arrays[j + h] = arrays[j];
                    sortCnt++;
                }
                arrays[j + h] = temp;
                sortCnt++;
            }
        }

        return sortCnt;
    }
}
