package com.algorithm.coding;

import java.util.Scanner;

public class Test5 {

    private final static int MAX = 21;

    static int[][] mdays = {
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
    };

    public static void main(String[] args) {
        // write your code here
        Physical1();
        Physical2();
        calculateDates();
        search1();
        search2();
        search3();
    }

    public static void Physical1(){

        Scanner scanner = new Scanner(System.in);

        PhysicalData[] x = {
                new PhysicalData("이나령", 162, 0.3),
                new PhysicalData("전서현", 173, 0.7),
                new PhysicalData("이수민", 175, 2.0),
                new PhysicalData("홍준기", 171, 1.5),
                new PhysicalData("유지훈", 168, 1.2),
                new PhysicalData("이호연", 174, 1.2),
                new PhysicalData("김한결", 169, 0.8),
        };
        int[] vdist = new int[MAX]; // 시력의 분포

        System.out.println("신체검사 리스트");
        System.out.println(" 이름      키      시력");
        System.out.println("-----------------------");
        for (int i = 0; i < x.length; i++){
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }
        System.out.printf("\n평균키：%5.1fcm\n", avgHeight(x));

        distVision(x, vdist);

        System.out.println("\n시력의 분포");
        for (int i = 0; i < MAX; i++) {
            System.out.printf("%3.1f~：%2d명", i / 10.0, vdist[i]);
            System.out.println();
        }
    }

    public static class PhysicalData{
        String name;
        int height;
        double vision;

        PhysicalData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    public static double avgHeight(PhysicalData[] data){
        double sum = 0;
        for(int i = 0; i < data.length; i++){
            sum += data[i].height;
        }

        return sum / data.length;
    }

    public static void distVision(PhysicalData[] data, int[] dist){

        int i = 0;
        dist[i] = 0;
        for(i = 0; i < data.length; i++){
            if(data[i].vision >= 0.0 && data[i].vision <= MAX / 10.0){
                dist[(int)(data[i].vision * 10)]++;
            }
        }
    }

    public static void Physical2(){

        Scanner scanner = new Scanner(System.in);

        PhysicalData[] x = {
                new PhysicalData("이나령", 162, 0.3),
                new PhysicalData("전서현", 173, 0.7),
                new PhysicalData("이수민", 175, 2.0),
                new PhysicalData("홍준기", 171, 1.5),
                new PhysicalData("유지훈", 168, 1.2),
                new PhysicalData("이호연", 174, 1.2),
                new PhysicalData("김한결", 169, 0.8),
        };
        int[] vdist = new int[MAX]; // 시력의 분포

        System.out.println("신체검사 리스트");
        System.out.println(" 이름      키      시력");
        System.out.println("-----------------------");
        for (int i = 0; i < x.length; i++){
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }
        System.out.printf("\n평균키：%5.1fcm\n", avgHeight(x));

        distVision(x, vdist);

        System.out.println("\n시력의 분포");
        for (int i = 0; i < MAX; i++) {
            System.out.printf("%3.1f~：", i / 10.0);
            for (int j = 0; j < vdist[i]; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void calculateDates(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("날짜를 입력하십시오.");
        System.out.println("year={}");
        int year = scanner.nextInt();
        System.out.println("month={}");
        int month = scanner.nextInt();
        System.out.println("day={}");
        int day = scanner.nextInt();
        System.out.println("간격일수={}");
        int calDay = scanner.nextInt();

        Dates dates = new Dates(year, month, day);

        System.out.println("앞의 일자? 뒤의 일자? (0 : 앞 / 1 : 뒤)");
        int selected = scanner.nextInt();
        if(selected == 0){
            System.out.println("앞의 날짜 구하기");

            Dates before = dates.beforeDay(calDay);
            System.out.printf("%d일 앞의 날짜={} %d년 %d월 %d일", calDay, before.year, before.month, before.day);
        }else{
            System.out.println("뒤의 날짜 구하기");

            Dates after = dates.afterDay(calDay);
            System.out.printf("%d일 뒤의 날짜={} %d년 %d월 %d일", calDay, after.year, after.month, after.day);
        }
    }

    public static class Dates{
        int year;
        int month;
        int day;

        Dates(int year, int month, int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }

        Dates afterDay(int calDay){
            Dates temp = new Dates(this.year, this.month, this.day);
            if(calDay < 0){
                return (beforeDay(-calDay));
            }

            temp.day += calDay;
            while (temp.day > mdays[isLeap(temp.year)][temp.month - 1]){
                temp.day -= mdays[isLeap(temp.year)][temp.month - 1];
                if(++temp.month > 12){
                    temp.year++;
                    temp.month = 1;
                }
            }

            return temp;
        }

        Dates beforeDay(int calDay){
            Dates temp = new Dates(this.year, this.month, this.day);
            if(calDay < 0){
                return (afterDay(-calDay));
            }

            temp.day -= calDay;
            while (temp.day < 1){
                if(--temp.month < 1){
                    temp.year--;
                    temp.month = 12;
                }
                temp.day += mdays[isLeap(temp.year)][temp.month - 1];
            }

            return temp;
        }
    }

    private static int isLeap(int year){

        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            return 1;
        }

        return 0;
    }

    public static void search1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수={}");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < array.length; i++){
            System.out.print(i + "의 값?");
            array[i] = scanner.nextInt();
        }

        System.out.printf("검색할 값={}");
        int search = scanner.nextInt();
        System.out.print(scanner);

        searchVal1(array, search);
    }

    private static void searchVal1(int[] array, int search){

        boolean isFind = false;
        int idx = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == search){
                idx = i;
                break;
            }
        }

        if(idx > -1){
            System.out.printf("찾았음={} %d번째, %값", idx, array[idx]);
        }else{
            System.out.println("못찾음");
        }
    }

    public static void search2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수={}");
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        for(int i = 0; i < n; i++){
            System.out.print(i + "의 값?");
            array[i] = scanner.nextInt();
        }

        System.out.printf("검색할 값={}");
        int search = scanner.nextInt();
        System.out.print(scanner);

        if(array.length > 0){
            array[n] = search;
        }

        searchVal2(array, search);
    }

    private static void searchVal2(int[] array, int search){

        int idx = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == search){
                if(i < (array.length - 1)){
                    idx = i;
                    break;
                }
            }
        }

        if(idx > -1){
            System.out.printf("찾았음={} %d번째, 값%d", idx, array[idx]);
        }else{
            System.out.println("못찾음");
        }
    }

    public static void search3(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수={}");
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        for(int i = 0; i < n; i++){
            System.out.print(i + "의 값?");
            array[i] = scanner.nextInt();
        }

        System.out.printf("검색할 값={}");
        int search = scanner.nextInt();
        System.out.print(scanner);

        if(array.length > 0){
            array[n] = search;
        }

        searchVal3(array, search);
    }

    private static void searchVal3(int[] array, int search){

        int i = 0;
        while (true){
            if(array[i] == search){
                break;
            }
            i++;
        }

        if(i == search){
            System.out.printf("찾았음={} %d번째, 값%d", i, array[i]);
        }else{
            System.out.println("못찾음");
        }
    }
}
