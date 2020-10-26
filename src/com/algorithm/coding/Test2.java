package com.algorithm.coding;

import java.util.Random;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        // write your code here
        cloneArrays();
        maxRandom();
        arraysReverse();
        arraysAdd();
        arraysEquals();
        arraysCopy();
        arraysReverseCopy();
    }

    public static void cloneArrays(){
        int[]a = {1, 2, 3, 4, 5};
        int[]b = a.clone();
    }

    public static int maxRandom(){
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] arraysHeight = new int[num];
        for(int i = 0; i < arraysHeight.length; i++){
            arraysHeight[i] = 100 + random.nextInt(90);
        }

        return maxHeight(arraysHeight);
    }

    private static int maxHeight(int[] num){

        int max = num[0];
        for(int i = 0; i < num.length; i++){
            if(max < num[i]){
                max = num[i];
            }
        }

        return max;
    }

    public static void arraysReverse(){

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arrays = new int[num];
        for(int i = 0; i < num; i++){
            arrays[i] = scanner.nextInt();
        }

        reverse(arrays);

        for(int i = 0; i < num; i++){
            System.out.println(arrays[i]);
        }
    }

    private static void reverse(int[] n){
        for(int i = 0; i < n.length / 2; i++){
            swap(n, i, n.length - i - 1);
        }
    }

    private static void swap(int[] n, int i, int j){
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }

    public static void arraysAdd(){

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] arrays = new int[num];
        for(int i = 0; i < num; i++){
            arrays[i] = scanner.nextInt();
        }

        int total = 0;
        for(int i = 0; i < num; i++){
            System.out.println(arrays[i]);
            total += arrays[i];
        }

        System.out.println(total);

    }

    public static boolean arraysEquals(){

        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int[] arrays1 = new int[num1];
        for(int i = 0; i < num1; i++){
            arrays1[i] = scanner.nextInt();
        }

        int num2 = scanner.nextInt();
        int[] arrays2 = new int[num2];
        for(int i = 0; i < num2; i++){
            arrays2[i] = scanner.nextInt();
        }

        if(arrays1.length != arrays2.length){
            return false;
        }

        for(int i = 0; i < arrays1.length; i++){
            if(arrays1[i] != arrays2[i]){
                return false;
            }
        }

        return true;
    }

    public static void arraysCopy(){

        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int[] arrays1 = new int[num1];
        for(int i = 0; i < arrays1.length; i++){
            arrays1[i] = scanner.nextInt();
        }

        int num2 = scanner.nextInt();
        int[] arrays2 = new int[num2];
        for(int i = 0; i < arrays2.length; i++){
            arrays2[i] = scanner.nextInt();
        }

        int len = (arrays1.length <= arrays2.length) ? arrays1.length : arrays2.length;
        for(int i = 0; i < len; i++){
            arrays1[i] = arrays2[i];
        }
    }

    public static void arraysReverseCopy(){

        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int[] arrays1 = new int[num1];
        for(int i = 0; i < arrays1.length; i++){
            arrays1[i] = scanner.nextInt();
        }

        int num2 = scanner.nextInt();
        int[] arrays2 = new int[num2];
        for(int i = 0; i < arrays2.length; i++){
            arrays2[i] = scanner.nextInt();
        }

        int len = (arrays1.length <= arrays2.length) ? arrays1.length : arrays2.length;
        for(int i = 0; i < len; i++){
            arrays1[i] = arrays2[arrays2.length - i - 1];
        }
    }

}
