package com.algorithm.coding;

import java.util.Scanner;

public class Test25 {

    public static void main(String[] args) {
        // write your code here
        bfMatch1();
        bfMatch2();
        bfMatchLast();
        indexOf();
    }

    public static void bfMatch1(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("텍스트 입력={}");
        String text = scanner.next();

        System.out.println("패턴 입력={}");
        String pattern = scanner.next();

        int index = subBfMatch1(text, pattern);
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

    public static int subBfMatch1(String text, String pattern) {

        int txtPointer = 0;
        int patternPointer = 0;

        while (txtPointer != text.length() && patternPointer != pattern.length()){

            if(text.charAt(txtPointer) == pattern.charAt(patternPointer)){
                txtPointer++;
                patternPointer++;
            }else{
                txtPointer = txtPointer - patternPointer + 1;
                patternPointer = 0;
            }
        }
        if(patternPointer == pattern.length()){
            return txtPointer - patternPointer;
        }

        return -1;
    }

    public static void bfMatch2(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("텍스트 입력={}");
        String text = scanner.next();

        System.out.println("패턴 입력={}");
        String pattern = scanner.next();

        int index = subBfMatch2(text, pattern);
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

    private static int subBfMatch2(String text, String pattern) {

        int txtPointer = 0;
        int patternPointer = 0;
        int cnt = 0;
        int i = -1;

        while (txtPointer != text.length() && patternPointer != pattern.length()){

            if(i == txtPointer - patternPointer){
                System.out.print("      ");
            }else{
                System.out.printf("%2d  ", txtPointer - patternPointer);
            }
            for(int j = 0; j < text.length(); j++){
                System.out.print(text.charAt(j) + " ");
            }
            System.out.println();

            for(int j = 0; j < txtPointer * 2 + 4; j++){
                System.out.print(" ");
            }
            System.out.print(text.charAt(txtPointer) == pattern.charAt(patternPointer) ? '+' : '|');
            System.out.println();

            for(int j = 0; j < (txtPointer - patternPointer) * 2 + 4; j++){
                System.out.print(" ");
            }

            for(int j = 0; j < pattern.length(); j++){
                System.out.print(pattern.charAt(j) + " ");
            }
            System.out.println();
            System.out.println();
            cnt++;

            if(text.charAt(txtPointer) == pattern.charAt(patternPointer)){
                txtPointer++;
                patternPointer++;
            }else{
                txtPointer = txtPointer - patternPointer + 1;
                patternPointer = 0;
            }
        }
        System.out.printf("%d회 비교\n", cnt);
        if(patternPointer == pattern.length()){
            return txtPointer - patternPointer;
        }

        return -1;
    }

    public static void bfMatchLast() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("텍스트 입력={}");
        String text = scanner.next();

        System.out.println("패턴 입력={}");
        String pattern = scanner.next();

        int index = subBfMatchLast(text, pattern);
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

    public static int subBfMatchLast(String text, String pattern) {

        int txtPointer = text.length() - 1;
        int patternPointer = pattern.length() - 1;

        while (txtPointer >= 0 && patternPointer >= 0){

            if(text.charAt(txtPointer) == pattern.charAt(patternPointer)){
                txtPointer--;
                patternPointer--;
            }else{
                txtPointer = txtPointer + (pattern.length() - patternPointer) - 2;
                patternPointer = pattern.length() - 1;
            }
        }
        if(patternPointer < 0){
            return txtPointer + 1;
        }

        return -1;
    }

    public static void indexOf(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("텍스트 입력={}");
        String text = scanner.next();

        System.out.println("패턴 입력={}");
        String pattern = scanner.next();

        int index1 = text.indexOf(pattern);
        int index2 = text.lastIndexOf(pattern);

        if(index1 > -1){
            int len1 = 0;
            for(int i = 0; i < index1; i++){
                len1 = text.substring(i, i + 1).getBytes().length;
            }
            len1 += pattern.length();

            int len2 = 0;
            for(int i = 0; i < index2; i++){
                len2 = text.substring(i, i + 1).getBytes().length;
            }
            len2 += pattern.length();

            System.out.println("텍스트={}" + text);
            System.out.printf(String.format("패턴 : %%%ds\n", len1), pattern);
            System.out.println("텍스트={}" + text);
            System.out.printf(String.format("패턴 : %%%ds\n", len2), pattern);
        }else{
            System.out.println("일치하는 패턴이 없습니다.");
        }
    }
}
