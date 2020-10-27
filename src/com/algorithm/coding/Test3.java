package com.algorithm.coding;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        // write your code here
        cardConv1();
        cardConv2();
        primeNum1();
        primeNum2();
        primeNum3();
    }

    public static void cardConv1(){

        Scanner scanner = new Scanner(System.in);

        int n, cd, dno, retry;
        char[] cno = new char[32];

        System.out.println("10진수를 기수로 변환");
        do{
            do{
                System.out.println("변환하는 음이 아닌 정수={}");
                n = scanner.nextInt();
            }while (n < 0);

            do{
                System.out.println("변환할 진수 입력(2~36)={}");
                cd = scanner.nextInt();
            }while (cd < 2 || cd > 36);

            dno = subCardConv1(n, cd, cno);

            System.out.println(cd + "의 진수={}");
            for(int i = 0; i < dno; i++){
                System.out.println(cno[i]);
            }

            System.out.println("재시작?(1 : YES, O : NO)={}");
            retry = scanner.nextInt();
        }while (retry == 1);
    }

    private static int subCardConv1(int x, int r, char[] d){
        int digit = 0;
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        do{
            d[digit++] = chars.charAt(x % r);
            x /= r;
        }while (x != 0);

        for(int i = 0; i < digit / 2; i ++){
            char t = d[i];
            d[i] = d[digit - i - 1];
            d[digit - i - 1] = t;
        }

        return digit;
    }

    public static void cardConv2(){

        Scanner scanner = new Scanner(System.in);

        int n, cd, dno, retry;
        char[] cno = new char[32];

        System.out.println("10진수를 기수로 변환");
        do{
            do{
                System.out.println("변환하는 음이 아닌 정수={}");
                n = scanner.nextInt();
            }while (n < 0);

            do{
                System.out.println("변환할 진수 입력(2~36)={}");
                cd = scanner.nextByte();
            }while (cd < 2 || cd > 36);

            dno = subCardConv2(n, cd, cno);

            System.out.println(cd + "의 진수={}");
            for(int i = 0; i < dno; i++){
                System.out.println(cno[i]);
            }

            System.out.println("재시작?(1 : YES, O : NO)={}");
            retry = scanner.nextInt();
        }while (retry == 1);
    }

    private static int subCardConv2(int x, int r, char[] d){
        int n = ((Integer) x).toString().length();
        int digit = 0;
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf(String.format("%%2d | %%%dd\n", n), r, x);
        do{
            System.out.printf("---- + ");
            for(int i = 0; i < n + 2; i++){
                System.out.printf("-");
            }
            System.out.println();

            if(x / r != 0){
                System.out.printf(String.format("%%2d | %%%dd %%d\n", n), r, x / r, x % r);
            }else{
                System.out.printf(String.format("%%%dd %%d\n", n), x / r, x % r);
            }
            d[digit++] = chars.charAt(x % r);
            x /= r;
        }while (x != 0);

        for(int i = 0; i < digit / 2; i ++){
            char t = d[i];
            d[i] = d[digit - i - 1];
            d[digit - i - 1] = t;
        }

        return digit;
    }

    private static void primeNum1(){
        int counter = 0;
        for(int n = 2; n <= 1000; n++){
            int i;
            for(i = 2; i < n; i++){
                counter++;
                if(n % 2 == 0){
                    break;
                }
            }
            if(n == i){
                System.out.println(n);
            }
        }

        System.out.println("실행횟수={}" + counter);
    }

    private static void primeNum2(){
        int counter = 0;
        int cnt = 0;
        int[] prime = new int[500];

        prime[cnt++] = 2;
        for(int n = 3; n <= 1000; n += 2){
            int i;
            for(i = 1; i < cnt; i++){
                counter++;
                if(n % prime[i] == 0){
                    break;
                }
            }
            if(cnt == i){
                prime[cnt++] = n;
            }
        }

        for(int k = 0; k < cnt; k++){
            System.out.println(prime[k]);
        }

        System.out.println("실행횟수={}" + counter);
    }

    private static void primeNum3(){
        int counter = 0;
        int cnt = 0;
        int[] prime = new int[500];

        prime[cnt++] = 2;
        prime[cnt++] = 3;

        for(int n = 5; n <= 1000; n += 2){
            boolean chk = false;
            for(int i = 1; prime[i] * prime[i] <= n; i++){
                counter += 2;
                if(n % prime[i] == 0){
                    chk = true;
                    break;
                }
            }
            if(!chk){
                prime[cnt++] = n;
                counter++;
            }
        }

        for(int k = 0; k < cnt; k++){
            System.out.println(prime[k]);
        }

        System.out.println("실행횟수={}" + counter);
    }
}
