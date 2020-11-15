package com.algorithm.coding;

import java.util.Scanner;

public class Test23 {

    public static void main(String[] args){
        // write your code here
        sort1();
        sort2();
        sort3();
    }

    public static void sort1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            do{
                System.out.print(i + "값={}");
                arrays[i] = scanner.nextInt();
            }while (arrays[i] < 0);
        }

        int max = arrays[0];
        for(int i = 1; i < cnt; i++){
            if(arrays[i] > max){
                max = arrays[i];
            }
        }

        subSort1(arrays, max, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subSort1(int[] arrays, int max, int cnt){

        int[] accumArrays = new int[max + 1];
        int[] tempArrays = new int[cnt];

        for(int i = 0; i < cnt; i++){
            accumArrays[arrays[i]]++;
        }
        for(int i = 1; i <= max ; i++){
            accumArrays[i] += accumArrays[i - 1];
        }
        for(int i = cnt - 1; i >= 0; i--){
            tempArrays[--accumArrays[arrays[i]]] = arrays[i];
        }
        for(int i = 0; i < cnt; i++){
            arrays[i] = tempArrays[i];
        }
    }

    public static void sort2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            do{
                System.out.print(i + "값={}");
                arrays[i] = scanner.nextInt();
            }while (arrays[i] < 0);
        }

        int max = arrays[0];
        for(int i = 1; i < cnt; i++){
            if(arrays[i] > max){
                max = arrays[i];
            }
        }

        subSort2(arrays, max, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subSort2(int[] arrays, int max, int cnt){

        int[] accumArrays = new int[max + 1];
        int[] tempArrays = new int[cnt];

        System.out.println("1단계 : 도수분포표 만들기");
        for(int i = 0; i < cnt; i++){
            for(int j = 0; j <= max; j++){
                System.out.printf("%3d", accumArrays[j]);
            }
            System.out.println();
            accumArrays[arrays[i]]++;
        }

        for(int i = 0; i <= max; i++){
            System.out.printf("%3d", accumArrays[i]);
        }
        System.out.println();

        System.out.println("2단계 : 누적도수분포표 만들기");
        for(int i = 1; i <= max; i++){
            for(int j = 0; j <= max ; j++){
                System.out.printf("%3d", accumArrays[i]);
            }
            System.out.println();
            accumArrays[i] += accumArrays[i - 1];
        }
        for(int i = 0; i <= max ; i++){
            System.out.printf("%3d", accumArrays[i]);
        }
        System.out.println();

        System.out.println("3단계 : 정렬");
        for(int i = cnt - 1; i >= 0; i--){
            for(int j = 0; j < cnt; j++){
                System.out.printf("%3d", tempArrays[i]);
            }
            System.out.println();
            tempArrays[--accumArrays[arrays[i]]] = arrays[i];
        }
        for(int i = 0; i < cnt; i++){
            System.out.printf("%3d", tempArrays[i]);
        }
        System.out.println();
        for(int i = 0; i < cnt; i++){
            arrays[i] = tempArrays[i];
        }
    }

    public static void sort3(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            do{
                System.out.print(i + "값={}");
                arrays[i] = scanner.nextInt();
            }while (arrays[i] < 0);
        }

        int max = arrays[0];
        for(int i = 1; i < cnt; i++){
            if(arrays[i] > max){
                max = arrays[i];
            }
        }

        int min = arrays[0];
        for(int i = 1; i < cnt; i++){
            if(arrays[i] < min){
                min = arrays[i];
            }
        }

        subSort3(arrays, max, min, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subSort3(int[] arrays, int max, int min, int cnt){

        int[] accumArrays = new int[max - min + 2];
        int[] tempArrays = new int[cnt];

        for(int i = 0; i < cnt; i++){
            accumArrays[arrays[i] - min]++;
        }
        for(int i = 1; i <= max - min + 1 ; i++){
            accumArrays[i] += accumArrays[i - 1];
        }
        for(int i = cnt - 1; i >= 0; i--){
            tempArrays[--accumArrays[arrays[i] - min]] = arrays[i];
        }
        for(int i = 0; i < cnt; i++){
            arrays[i] = tempArrays[i];
        }
    }
}
