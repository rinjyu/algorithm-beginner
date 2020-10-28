package com.algorithm.coding;

import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        // write your code here
        dayOfYear1();
        dayOfYear2();
        leftDayOfYear();
    }

    public static void dayOfYear1(){

        Scanner scanner = new Scanner(System.in);
        int retry;

        System.out.println("해의 경과일수={}");
        do{
           int year = scanner.nextInt();
           int month = scanner.nextInt();
           int day = scanner.nextInt();

            System.out.println("년={}" + year + " 월={}" + month + " 일={}" + day);
            System.out.printf("해의 %d일째={}", dayOfYearCal1(year, month, day));

            System.out.println("재시작?(1 : YES, O : NO)={}");
            retry = scanner.nextInt();
        }while (retry == 1);
    }

    private static int dayOfYearCal1(int y, int m, int d){

        int dd = d;
        for(int i = 1; i < m; i++){
            dd += mday[isLeap(y)][i - 1];
        }

        return dd;
    }

    private static int[][] mday = {
        {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},	// 평년
        {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}	// 윤년
    };

    private static int isLeap(int y){

        return (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) ? 1 : 0;
    }

    public static void dayOfYear2(){

        Scanner scanner = new Scanner(System.in);
        int retry;

        System.out.println("해의 경과일수={}");
        do{
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();

            System.out.println("년={}" + year + " 월={}" + month + " 일={}" + day);
            System.out.printf("해의 %d일째={}", dayOfYearCal2(year, month, day));

            System.out.println("재시작?(1 : YES, O : NO)={}");
            retry = scanner.nextInt();
        }while (retry == 1);
    }

    private static int dayOfYearCal2(int y, int m, int d){

        while (--m != 0){
            d += mday[isLeap(y)][m - 1];
        }

        return d;
    }

    public static void leftDayOfYear(){

        Scanner scanner = new Scanner(System.in);
        int retry;

        System.out.println("해의 남은 일수={}");
        do{
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();

            System.out.println("년={}" + year + " 월={}" + month + " 일={}" + day);
            System.out.printf("해의 남은 일수={] %d", dayOfLeftYearCal(year, month, day));

            System.out.println("재시작?(1 : YES, O : NO)={}");
            retry = scanner.nextInt();
        }while (retry == 1);
    }

    private static int dayOfLeftYearCal(int y, int m, int d){

        int days = d;
        for(int i = 1; i < m; i++){
            days += mday[isLeap(y)][i - 1];
        }

        return 365 + isLeap(y) - days;
    }


}
