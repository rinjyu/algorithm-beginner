package com.algorithm.coding;

import java.util.Scanner;

public class Test26 {

    public static void main(String[] args) {
        // write your code here
        kmpMatch1();
        kmpMatch2();
    }

    public static void kmpMatch1(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("텍스트 입력={}");
        String text = scanner.next();

        System.out.println("패턴 입력={}");
        String pattern = scanner.next();

        int index = subKmpMatch1(text, pattern);
        if(index > -1){
            int len = 0;
            for(int i = 0; i < i; i++){
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

    public static int subKmpMatch1(String text, String pattern){

        int txtPointer = 1;
        int patternPointer = 0;
        int[] skip = new int[pattern.length() + 1];

        skip[txtPointer] = 0;
        while (txtPointer != pattern.length()){

            if(pattern.charAt(txtPointer) == pattern.charAt(patternPointer)){
                skip[++txtPointer] = ++patternPointer;
            }else if(patternPointer == 0){
                skip[++txtPointer] = patternPointer;
            }else{
                patternPointer = skip[patternPointer];
            }
        }

        txtPointer = patternPointer = 0;
        while (txtPointer != text.length() && patternPointer != pattern.length()){

            if(text.charAt(txtPointer) == pattern.charAt(patternPointer)){
                txtPointer++;
                patternPointer++;
            }else if(patternPointer == 0){
                txtPointer++;
            }else{
                patternPointer = skip[patternPointer];
            }
        }

        if(patternPointer == pattern.length()){
            return txtPointer - patternPointer;
        }

        return -1;
    }

    public static void kmpMatch2(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("텍스트 입력={}");
        String text = scanner.next();

        System.out.println("패턴 입력={}");
        String pattern = scanner.next();

        int index = subKmpMatch2(text, pattern);
        if(index > -1){
            int len = 0;
            for(int i = 0; i < i; i++){
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

    public static int subKmpMatch2(String text, String pattern){

        int txtPointer = 1;
        int patternPointer = 0;
        int[] skip = new int[pattern.length() + 1];
        int cnt = 0;
        int i = -1;

        System.out.println("skip 테이블 만들기");
        skip[txtPointer] = 0;
        while (txtPointer != pattern.length()){

            if(i == txtPointer - patternPointer){
                System.out.print("      ");
            }else{
                System.out.printf("%2d  ", txtPointer - patternPointer);
                i = txtPointer - patternPointer;
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

            if(pattern.charAt(txtPointer) == pattern.charAt(patternPointer)){
                skip[++txtPointer] = ++patternPointer;
            }else if(patternPointer == 0){
                skip[++txtPointer] = patternPointer;
            }else{
                patternPointer = skip[patternPointer];
            }
        }

        System.out.println("검색");
        txtPointer = patternPointer = 0;
        while (txtPointer != text.length() && patternPointer != pattern.length()){
            if(i == txtPointer - patternPointer){
                System.out.print("    ");
            }else{
                System.out.printf("%2d  ", txtPointer - patternPointer);
                i = txtPointer - patternPointer;
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
            }else if(patternPointer == 0){
                txtPointer++;
            }else{
                patternPointer = skip[patternPointer];
            }
        }

        System.out.printf("%d회 비교\n", cnt);
        if(patternPointer == pattern.length()){
            return txtPointer - patternPointer;
        }

        return -1;
    }
}
