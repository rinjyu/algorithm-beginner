package com.algorithm.coding;

import java.util.Scanner;

public class Test10 {

    public static void main(String[] args) {
        // write your code here
        factorial1();
        euclidGcd1();
        factorial2();
        euclidGcd2();
        gcdArray();
    }

    public static void factorial1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 입력={}");
        int num = scanner.nextInt();

        System.out.println(num + "!={}" + subFactorial1(num));
    }

    public static int subFactorial1(int num){
        if(num > 0){
            return num * subFactorial1(num - 1);
        }else{
            return 1;
        }
    }

    public static void euclidGcd1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("두 정수의 최대 공약수 구하기");
        System.out.println("정수1 입력={}");
        int num1 = scanner.nextInt();
        System.out.println("정수2 입력={}");
        int num2 = scanner.nextInt();

        System.out.println("최대공약수={}" + subEuclidGcd1(num1, num2));
    }

    public static int subEuclidGcd1(int num1, int num2){
        if(num2 == 0){
            return num1;
        }else{
            return subEuclidGcd1(num2, num1 % num2);
        }
    }

    public static void factorial2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 입력={}");
        int num = scanner.nextInt();

        System.out.println(num + "!={}" + subFactorial2(num));
    }

    public static int subFactorial2(int num){
        int factorial = 1;
        while (num > 1){
            factorial *= num--;
        }
        return factorial;
    }

    public static void euclidGcd2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("두 정수의 최대 공약수 구하기");
        System.out.println("정수1 입력={}");
        int num1 = scanner.nextInt();
        System.out.println("정수2 입력={}");
        int num2 = scanner.nextInt();

        System.out.println("최대공약수={}" + subEuclidGcd2(num1, num2));
    }

    public static int subEuclidGcd2(int num1, int num2){

        while (num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1;
    }

    public static void gcdArray(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("최대공약수를 구할 정수 개수={}");
        int cnt;
        do {
            cnt = scanner.nextInt();
        }while (cnt <= 1);

        System.out.println("값을 개수만큼 입력하세요.");

        int[] arrays = new int[cnt];
        for(int i = 0; i < arrays.length; i++){
            arrays[i] = scanner.nextInt();
        }

        System.out.println("최대공약수={}" + subGcdArray(arrays, 0, cnt));
    }

    public static int subGcdArray(int[] arrays, int start, int cnt){

        if(cnt == 1){
            return arrays[start];
        }else if(cnt == 2){
            return gcd(arrays[start], arrays[start + 1]);
        }else{
            return gcd(arrays[start], subGcdArray(arrays, start + 1, cnt - 1));
        }
    }

    public static int gcd(int num1, int num2){

        while (num2 != 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = num2;
        }

        return num1;
    }
}


