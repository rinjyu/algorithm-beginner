package com.algorithm.coding;

import java.util.Scanner;

public class Test14 {

    public static void main(String[] args) {
        // write your code here
        bubbleSort1();
        bubbleSort2();
        bubbleSort3();
        bubbleSort4();
        bubbleSort5();
        bubbleSort6();
        bubbleSort7();
        bubbleSort8();
    }

    public static void bubbleSort1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subBubbleSort1(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subBubbleSort1(int[] arrays, int cnt){

        for(int i = 0; i < cnt; i++){
            for(int j = cnt - 1; j > i; j--){
                if(arrays[j - 1] > arrays[j]){
                    swap(arrays, j - 1, j);
                }
            }
        }
    }

    public static void swap(int[] arrays, int index1, int index2){
        int temp = arrays[index1];
        arrays[index1] = arrays[index2];
        arrays[index2] = temp;
    }

    public static void bubbleSort2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subBubbleSort2(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subBubbleSort2(int[] arrays, int cnt){

        for(int i = cnt - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arrays[j] > arrays[j + 1]){
                    swap(arrays, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort3(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subBubbleSort3(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subBubbleSort3(int[] arrays, int cnt){

        int compareCnt = 0;
        int swapCnt = 0;

        for(int i = 0; i < cnt - 1; i++){
            System.out.printf("패스%d={}", i + 1);
            for(int j = cnt - 1; j > i; j--){
                for(int k = 0; k < cnt - 1; k++){
                    System.out.printf("%3d %c", arrays[k], (k != j - 1) ? ' ' : (arrays[j - 1] > arrays[j]) ? '+' : '-');
                }
                System.out.printf("%3d\n", arrays[cnt - 1]);
                compareCnt++;
                if(arrays[j - 1] > arrays[j]){
                    swapCnt++;
                    swap(arrays, j - 1, j);
                }
            }
            for(int k = 0; k < cnt; k++){
                System.out.printf("%3d ", arrays[k]);
            }
            System.out.println();
        }
        System.out.println("비교={}" + compareCnt + "회");
        System.out.println("교환={}" + swapCnt + "회");
    }

    public static void bubbleSort4(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subBubbleSort4(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subBubbleSort4(int[] arrays, int cnt){

        for(int i = 0; i < cnt - 1; i++){
            int exchange = 0;
            for(int j = cnt - 1; j > i; j--){
                if(arrays[j - 1] > arrays[j]){
                    swap(arrays, j - 1, j);
                    exchange++;
                }
            }
            if(exchange == 0){
                break;
            }
        }
    }

    public static void bubbleSort5(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subBubbleSort5(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subBubbleSort5(int[] arrays, int cnt){

        int compareCnt = 0;
        int swapCnt = 0;

        for(int i = 0; i < cnt - 1; i++){
            int exchange = 0;
            System.out.printf("패스%d={}", i + 1);
            for(int j = cnt - 1; j > i; j--){
                for(int k = 0; k < cnt - 1; k++){
                    System.out.printf("%3d %c", arrays[k], (k != j - 1) ? ' ' : (arrays[j - 1] > arrays[j]) ? '+' : '-');
                }
                System.out.printf("%3d\n", arrays[cnt - 1]);
                compareCnt++;
                if(arrays[j - 1] > arrays[j]){
                    swap(arrays, j - 1, j);
                    exchange++;
                    swapCnt++;
                }
            }
            for(int k = 0; k < cnt; k++){
                System.out.printf("%3d ", arrays[k]);
            }
            System.out.println();
            if(exchange == 0){
                break;
            }
        }
        System.out.println("비교={}" + compareCnt + "회");
        System.out.println("교환={}" + swapCnt + "회");
    }

    public static void bubbleSort6(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subBubbleSort6(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subBubbleSort6(int[] arrays, int cnt){

        int i = 0;
        while (i < cnt - 1){
            int last = cnt - 1;
            for(int j = cnt - 1; j > i; j--){
                if(arrays[j - 1] > arrays[j]){
                    swap(arrays, j - 1, j);
                    last = j;
                }
            }
            i = last;
        }
    }

    public static void bubbleSort7(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subBubbleSort7(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subBubbleSort7(int[] arrays, int cnt){

        int compareCnt = 0;
        int swapCnt = 0;

        int i = 0;
        int j = 0;

        while (j < cnt - 1){
            System.out.printf("패스%d：\n", i++);
            int last = cnt - 1;
            for(int k = cnt - 1; k > j; k--){
                for(int m = 0; m < cnt - 1; m++)
                    System.out.printf("%3d %c", arrays[m], (m != j - 1) ? ' ' : (arrays[j - 1] > arrays[j]) ? '+' : '-');
                System.out.printf("%3d\n", arrays[cnt - 1]);
                compareCnt++;
                if (arrays[k - 1] > arrays[k]) {
                    swap(arrays, k - 1, k);
                    last = k;
                    swapCnt++;
                }
            }
            j = last;
        }
        System.out.println("비교={}" + compareCnt + "회");
        System.out.println("교환={}" + swapCnt + "회");
    }

    public static void bubbleSort8(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subBubbleSort8(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subBubbleSort8(int[] arrays, int cnt){

        int left = 0;
        int right = cnt - 1;
        int last = right;

        while (left < right){
            for(int i = right; i > left; i--){
                if(arrays[i - 1] > arrays[i]){
                    swap(arrays, i - 1, i);
                    last = i;
                }
            }
            left = last;

            for (int j = left; j < right; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    swap(arrays, j, j + 1);
                    last = j;
                }
            }
            right = last;
        }
    }
}
