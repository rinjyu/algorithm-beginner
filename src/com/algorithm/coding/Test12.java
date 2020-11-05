package com.algorithm.coding;

import java.util.Scanner;

public class Test12 {

    private static String[] pillars = {"A기둥", "B기둥", "C기둥"};

    public static void main(String[] args) {
        // write your code here
        hanoi1();
        recurs();
        hanoi2();
        hanoi3();
    }

    public static void hanoi1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("하노이의 탑");

        System.out.println("원반 개수={}");
        int no = scanner.nextInt();
        System.out.println(no);

        move1(no, 1, 3);
    }

    public static void move1(int no, int start, int end){

        if(no > 1){
            move1(no - 1, start, 6 - start - end);
            System.out.println(no + "을 " + start + "기둥 -> " + end + "기둥");
        }

        if(no > 1){
            move1(no - 1, 6 - start - end, end);
        }
    }

    public static void recurs(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 입력={}");
        int num = scanner.nextInt();

        subRecurs(num);
    }

    public static void subRecurs(int num){

        int[] stack1 = new int[100];
        int[] stack2 = new int[100];
        int pointer = -1;
        int temp = 0;

        while (true){
            if(num > 0){
                pointer++;
                stack1[pointer] = num;
                stack2[pointer] = temp;

                if(temp == 0){
                    num = num - 1;
                }else if(temp == 1){
                    num = num - 2;
                    temp = 0;
                }
                continue;
            }

            do {
                num = stack1[pointer];
                temp = stack2[pointer--] + 1;
                if(temp == 2){
                    System.out.println(num);
                    if(pointer < 0){
                        return;
                    }
                }
            }while (temp == 2);
        }
    }

    public static void hanoi2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("하노이의 탑");

        System.out.println("원반 개수={}");
        int no = scanner.nextInt();
        System.out.println(no);

        move2(no, 1, 3);
    }

    public static void move2(int no, int start, int end){

        if(no > 1){
            move2(no - 1, start, 6 - start - end);
            System.out.println(no + "을 " + pillars[start - 1] + " -> " + pillars[end - 1] + "");
        }

        if(no > 1){
            move2(no - 1, 6 - start - end, end);
        }
    }

    public static void hanoi3(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("하노이의 탑");

        System.out.println("원반 개수={}");
        int no = scanner.nextInt();
        System.out.println(no);

        move3(no, 1, 3);
    }

    public static void move3(int no, int start, int end){

        int[] stack1 = new int[100];
        int[] stack2 = new int[100];
        int[] stack3 = new int[100];
        int pointer = 0;
        int temp = 0;

        while (true){
            if(temp == 0 && no > 1){
                stack1[pointer] = start;
                stack2[pointer] = end;
                stack3[pointer] = temp;

                pointer++;
                no = no - 1;
                end = 6 - start - end;
                continue;
            }

            System.out.printf("%d를 %d -> %d", no, start, end);
            System.out.println();

            if (temp == 1 && no > 1){
                stack1[pointer] = start;
                stack2[pointer] = end;
                stack3[pointer] = temp;

                pointer++;
                no = no - 1;
                start = 6 - start - end;
                if(++temp == 2){
                    temp = 0;
                }
                continue;
            }

            do {
                if(pointer-- == 0){
                    return;
                }
                start = stack1[pointer];
                end = stack2[pointer];
                temp = stack3[pointer] + 1;

                no++;
            }while (temp == 2);
        }
    }
}
