package com.algorithm.coding;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        // write your code here

        max3();
        max4();
        min3();
        min4();
        middle3();
        sum1();
        sum2();
        sum3();
        sum4();
        minus();
        len();
        twoLen();
        gugudan();
        multiply();
        add();
        rectangle();
        triangleLB();
        triangleLU();
        triangleRU();
        triangleRB();
        pyramidStar();
        pyramidNum();

    }

    public static int max3(){

        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

        int max = num1;
        if(max < num2){
            max = num2;
        }
        if(max < num3){
            max = num3;
        }

        return max;
    }

    public static int max4(){

        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3, num4;
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();
        num4 = scanner.nextInt();

        int max = num1;
        if(max < num2){
            max = num2;
        }
        if(max < num3){
            max = num3;
        }
        if(max < num4){
            max = num4;
        }

        return max;
    }

    public static int min3(){

        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

        int min = num1;
        if(min > num2){
            min = num2;
        }
        if(min > num3){
            min = num3;
        }

        return min;
    }

    public static int min4(){

        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3, num4;
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();
        num4 = scanner.nextInt();

        int min = num1;
        if(min > num2){
            min = num2;
        }
        if(min > num3){
            min = num3;
        }
        if(min > num4){
            min = num4;
        }

        return min;
    }

    public static int middle3(){

        Scanner scanner = new Scanner(System.in);
        int num1, num2, num3;
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        num3 = scanner.nextInt();

        if((num2 >= num1 && num2 < num3) || (num2 >= num3 && num2 < num1)){
            return num2;
        }else if((num3 >= num1 && num3 < num2) || (num3 >= num2 && num3 < num1)){
            return num3;
        }else{
            return num1;
        }
    }

    public static int sum1(){

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        int i = 1;

        while(i <= num){
            sum += i;
            i++;
        }

        return sum;
    }

    public static int sum2(){

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        for(int i = 1; i <= num; i++){
            sum += i;
        }

        return sum;
    }

    public static int sum3(){

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = (num + 1) * (num / 2) + (num % 2 == 1 ? (num + 1) / 2 : 0);

        return sum;
    }

    public static int sum4(){

        Scanner scanner = new Scanner(System.in);
        int num1, num2;
        num1 = scanner.nextInt();
        num2 = scanner.nextInt();
        int min = num1;
        int max = num2;
        if(num1 > num2){
            min = num2;
            max = num1;
        }

        int sum = 0;
        for(int i = min; i <= max; i++){
            sum += i;
        }

        return sum;
    }

    public static void minus(){

        Scanner scanner = new Scanner(System.in);
        int num1, num2;
        num1 = scanner.nextInt();
        while (true) {
            num2 = scanner.nextInt();
            if (num2 > num1){
                break;
            }
            System.out.println("첫번째 수보다 큰 값으로 다시 입력");
        }
    }

    public static int len(){

        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            num = scanner.nextInt();
        } while (num <= 0);

        int len = 0;
        while (num > 0) {
            num /= 10;
            len++;
        }

        return len;
    }

    public static int twoLen(){

        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            num = scanner.nextInt();
        } while (!(num > 9 && num < 100));

        return num;
    }

    public static void gugudan(){

        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }

    public static void multiply(){

        System.out.print("   |");
        for(int i = 1; i <= 9; i++){
            System.out.printf("%3d", i);
        }
        System.out.println("\n---+---------------------------");
        for(int i = 1; i <= 9; i++){
            System.out.printf("%2d |", i);
            for(int j = 1; j <= 9; j++){
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }

    public static void add(){

        System.out.print("   |");
        for(int i = 1; i <= 9; i++){
            System.out.printf("%3d", i);
        }
        System.out.println("\n---+---------------------------");
        for(int i = 1; i <= 9; i++){
            System.out.printf("%2d |", i);
            for(int j = 1; j <= 9; j++){
                System.out.printf("%3d", i + j);
            }
            System.out.println();
        }
    }

    public static void rectangle(){

        for(int i = 1; i <= 5; i++){
            for(int j = 1; j <= 5; j++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }

    public static void triangleLB(){

        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            num = scanner.nextInt();
        }while (num <= 0);

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= i; j ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void triangleLU(){

        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            num = scanner.nextInt();
        }while (num <= 0);

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= num - i + 1; j ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void triangleRU(){

        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            num = scanner.nextInt();
        }while (num <= 0);

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= i - 1; j ++){
                System.out.print(" ");
            }
            for(int j = 1; j <= num - i + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void triangleRB(){

        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            num = scanner.nextInt();
        }while (num <= 0);

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= num - i; j ++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pyramidStar(){

        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            num = scanner.nextInt();
        }while (num <= 0);

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= num - i + 1; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= (i - 1) * 2 + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void pyramidNum(){

        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            num = scanner.nextInt();
        }while (num <= 0);

        for(int i = 1; i <= num; i++){
            for(int j = 1; j <= num - i + 1; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= (i - 1) * 2 + 1; j++){
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }

}
