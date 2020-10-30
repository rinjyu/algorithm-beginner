package com.algorithm.coding;

import java.util.Arrays;
import java.util.Scanner;

public class Test6 {

    public static void main(String[] args) {
        // write your code here
        search1();
        search2();
        search3();
        search4();
        search5();
    }

    public static void search1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수={}");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("오름차순으로 입력하세요.");
        for(int i = 0; i < array.length; i++){
            array[i] = scanner.nextInt();
        }

        System.out.printf("검색할 값={}");
        int search = scanner.nextInt();
        System.out.print(scanner);

        //오름차순 정렬
        Arrays.sort(array);

        System.out.println(Arrays.asList(array).toString());

        int index = searchVal1(array, search);

        if(index > -1){
            System.out.println(search + "는 배열에 포함되어 있습니다.");
        }else{
            System.out.println(search + "는 배열에 포함되어 있지 않습니다.");
        }
    }

    public static int searchVal1(int[] array, int search){

        int index = -1;
        int startIdx = 0;
        int endIdx = array.length - 1;
        int middleIdx = (startIdx + (endIdx)) / 2;
        if(search == array[middleIdx]){
            return middleIdx;
        }else if(search > array[middleIdx]){
            startIdx = middleIdx + 1;
        }else{
            endIdx = middleIdx - 1;
        }

        for(int i = startIdx; i <= endIdx; i++){
            if(search == array[i]){
                index = i;
                break;
            }
        }

        return index;
    }

    public static void search2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수={}");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("오름차순으로 입력하세요.");
        System.out.println("0 번째값={}");
        array[0] = scanner.nextInt();

        for(int i = 1; i < array.length; i++){
            do{
                System.out.println(i + "번째값={}");
                array[i] = scanner.nextInt();
            }while (array[i] < array[i - 1]);
        }

        System.out.printf("검색할 값={}");
        int search = scanner.nextInt();
        System.out.print(scanner);

        System.out.println(Arrays.asList(array).toString());

        int index = searchVal2(array, search);

        if(index > -1){
            System.out.println(search + "는 배열 " + index + "번째에 포함되어 있습니다.");
        }else{
            System.out.println(search + "는 배열에 포함되어 있지 않습니다.");
        }
    }

    public static int searchVal2(int[] array, int search){

        int startIdx = 0;
        int endIdx = array.length - 1;

        do{
            int middleIdx = (startIdx + (endIdx)) / 2;
            if(array[middleIdx] == search){
                return middleIdx;
            }else if(array[middleIdx] < search){
                startIdx = middleIdx + 1;
            }else{
                startIdx = middleIdx - 1;
            }
        }while (startIdx < endIdx);

        return -1;
    }
    
    public static void search3(){
        
        int[] array = {1, 9, 2, 9, 4, 6, 7, 9};
        int key = 9;
        int[] result = new int[array.length];
        int cnt = searchVal3(array, key, result);
        if(cnt > 0){
            for(int i = 0; i < cnt; i++){
                System.out.println("요소값은={}" + result[i] + "에 있습니다");
            }
        }else{
            System.out.println(key + "는 배열에 포함되어 있지 않습니다.");
        }

        System.out.println(Arrays.toString(result));
    }

    private static int searchVal3(int[] array, int key, int[] result){

        int cnt = 0;
        for(int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                result[cnt++] = i;
            }
        }

        return cnt;
    }

    public static void search4(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수={}");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("오름차순으로 입력하세요.");
        System.out.println("0 번째값={}");
        array[0] = scanner.nextInt();

        for(int i = 1; i < array.length; i++){
            do{
                System.out.println(i + "번째값={}");
                array[i] = scanner.nextInt();
            }while (array[i] < array[i - 1]);
        }

        System.out.printf("검색할 값={}");
        int search = scanner.nextInt();
        System.out.print(scanner);

        System.out.println(Arrays.asList(array).toString());

        int index = searchVal4(array, search);

        if(index > -1){
            System.out.println(search + "는 배열 " + index + "번째에 포함되어 있습니다.");
        }else{
            System.out.println(search + "는 배열에 포함되어 있지 않습니다.");
        }
    }

    public static int searchVal4(int[] array, int search){

        System.out.println("   |");
        for(int i = 0; i < array.length; i++){
            System.out.printf("%4d", i);
        }
        System.out.println();
        System.out.print("---+");
        for(int i = 0; i < 4 * array.length + 2; i++){
            System.out.print("-");
        }
        System.out.println();

        int startIdx = 0;
        int endIdx = array.length - 1;

        do{
            int middleIdx = endIdx / 2;
            System.out.print("   |");
            if(startIdx != middleIdx){
                System.out.printf(String.format("%%%ds<-%%%ds+", (startIdx * 4) + 1, (middleIdx - startIdx) * 4), "", "");
            }else{
                System.out.printf(String.format("%%%ds<-+", middleIdx * 4 + 1), "");
            }

            if(middleIdx != endIdx){
                System.out.printf(String.format("%%%ds->\n", (endIdx - middleIdx) * 4 - 2), "");
            }else{
                System.out.println("->");
            }

            System.out.printf("%3d|", middleIdx);

            for(int i = 0; i < array.length; i++){
                System.out.printf("%4d", array[i]);
            }
            System.out.println("\n   |");

            if(array[middleIdx] == search){
                return middleIdx;
            }else if(array[middleIdx] > search){
                startIdx = middleIdx + 1;
            }else{
                endIdx = middleIdx - 1;
            }
        }while (startIdx <= endIdx);

        return -1;
    }

    public static void search5(){

        int[] array = {1, 3, 5, 7, 7, 7, 7, 8, 8, 9, 9};
        int search = 7;
        int index = searchVal5(array, search);
        if(index > 0){
            System.out.println(search + "는 배열 " + index + "번째에 포함되어 있습니다.");
        }else{
            System.out.println(search + "는 배열에 포함되어 있지 않습니다.");
        }
    }

    public static int searchVal5(int[] array, int search){

        int startIdx = 0;
        int endIdx = array.length - 1;

        do{
            int middleIdx = (startIdx + endIdx) / 2;
            if(array[middleIdx] == search){
                for(; middleIdx > startIdx; middleIdx--){
                    if(array[middleIdx - 1] < search){
                        break;
                    }
                }
                return middleIdx;
            }else if(array[middleIdx] < search){
                startIdx = middleIdx + 1;
            }else{
                endIdx = middleIdx - 1;
            }
        }while (startIdx <= endIdx);

        return -1;
    }
}

