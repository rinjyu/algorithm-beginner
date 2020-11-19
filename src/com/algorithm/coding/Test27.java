package com.algorithm.coding;

import java.util.Scanner;

public class Test27 {

    public static void main(String[] args) {
        // write your code here
        bmMatch1();
        bmMatch2();
    }

    public static void bmMatch1(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("텍스트 입력={}");
        String text = scanner.next();

        System.out.println("패턴 입력={}");
        String pattern = scanner.next();

        int index = subBmMatch1(text, pattern);
        if(index > -1){
            int len = 0;
            for(int i = 0; i < index; i++){
                len = text.substring(i, i + 1).getBytes().length;
            }
            len += pattern.length();

            System.out.println((index + 1) + "번째 문자부터 일치");
            System.out.println("텍스트={}" + text);
            System.out.printf(String.format("패턴 : %%%ds\n", len), pattern);
        }else{
            System.out.println("일치하는 패턴이 없습니다.");
        }
    }

    public static int subBmMatch1(String text, String pattern){

        int txtPointer;
        int patternPointer;
        int textLen = text.length();
        int patternLen = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        for(txtPointer = 0; txtPointer <= Character.MAX_VALUE; txtPointer++){
            skip[txtPointer] = patternLen;
        }
        for(txtPointer = 0; txtPointer < patternLen - 1; txtPointer++){
            skip[pattern.charAt(txtPointer)] = patternLen - txtPointer - 1;
        }

        while (txtPointer < textLen){
            patternPointer = patternLen - 1;

            while (text.charAt(txtPointer) == pattern.charAt(patternPointer)){
                if(patternPointer == 0){
                    return txtPointer;
                }
                patternPointer--;
                txtPointer--;
            }
            txtPointer += (skip[text.charAt(txtPointer)] > patternLen - patternPointer) ? skip[text.charAt(txtPointer)] : patternLen - patternPointer;
        }

        return  - 1;
    }

    public static void bmMatch2(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("텍스트 입력={}");
        String text = scanner.next();

        System.out.println("패턴 입력={}");
        String pattern = scanner.next();

        int index = subBmMatch2(text, pattern);
        if(index > -1){
            int len = 0;
            for(int i = 0; i < index; i++){
                len = text.substring(i, i + 1).getBytes().length;
            }
            len += pattern.length();

            System.out.println((index + 1) + "번째 문자부터 일치");
            System.out.println("텍스트={}" + text);
            System.out.printf(String.format("패턴 : %%%ds\n", len), pattern);
        }else{
            System.out.println("일치하는 패턴이 없습니다.");
        }
    }

    public static int subBmMatch2(String text, String pattern){

        int txtPointer;
        int patternPointer;
        int textLen = text.length();
        int patternLen = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1];
        int cnt = 0;
        int i = -1;

        for(txtPointer = 0; txtPointer <= Character.MAX_VALUE; txtPointer++){
            skip[txtPointer] = patternLen;
        }
        for(txtPointer = 0; txtPointer < patternLen - 1; txtPointer++){
            skip[pattern.charAt(txtPointer)] = patternLen - txtPointer - 1;
        }

        while (txtPointer < textLen){
            patternPointer = patternLen - 1;

            if(i == txtPointer - patternPointer){
                System.out.print("      ");
            }else{
                System.out.printf("%2d  ", txtPointer - patternPointer);
                i = txtPointer - patternPointer;
            }

            for (int j = 0; j < text.length(); j++) {
                System.out.println(text.charAt(j) + " ");
            }
            System.out.println();

            for (int j = 0; j < txtPointer * 2 + 4; j++) {
                System.out.println(" ");
            }
            System.out.print(text.charAt(txtPointer) == pattern.charAt(patternPointer) ? '+' : '|');
            System.out.println();

            for (int j = 0; j < (txtPointer - patternPointer) * 2 + 4; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < pattern.length(); j++) {
                System.out.println(pattern.charAt(j) + " ");
            }
            System.out.println();
            System.out.println();
            cnt++;

            while (text.charAt(txtPointer) == pattern.charAt(patternPointer)){
                if(patternPointer == 0){
                    return txtPointer;
                }
                patternPointer--;
                txtPointer--;
                if(i == txtPointer - patternPointer){
                    System.out.print("    ");
                }else{
                    System.out.printf("%2d  ", txtPointer - patternPointer);
                    i = txtPointer - patternPointer;
                }

                for (int j = 0; j < text.length(); j++) {
                    System.out.print(text.charAt(j) + " ");
                }
                System.out.println();

                for (int j = 0; j < txtPointer * 2 + 4; j++) {
                    System.out.print(" ");
                }
                System.out.print(text.charAt(txtPointer) == pattern.charAt(patternPointer) ? '+' : '|');
                System.out.println();

                for (int j = 0; j < (txtPointer - patternPointer) * 2 + 4; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < pattern.length(); j++) {
                    System.out.print(pattern.charAt(i) + " ");
                }
                System.out.println();
                System.out.println();
                cnt++;
            }
            txtPointer += skip[text.charAt(txtPointer)];
        }

        return  - 1;
    }
}
