package com.algorithm.coding;

public class Test13 {

    private static int[] arrays;
    private static boolean[] isQueenCheck1;
    private static boolean[] isQueenCheck2;
    private static boolean[] isQueenCheck3;

    public static void main(String[] args) {
        // write your code here
        queen1();
        queen2();
        queen3();
        queen4();
        queen5();
    }

    public static void queen1(){
        arrays = new int[8];
        set1(0);
    }

    public static void set1(int i){

        for(int j = 0; j < 8; j++){
            arrays[i] = j;
            if(i == 7){
                output1();
            }else{
                set1(i + 1);
            }
        }
    }

    public static void output1(){

        for(int i = 0; i < 8; i++){
            System.out.printf("%2d", arrays[i]);
        }
        System.out.println();
    }

    public static void queen2(){
        arrays = new int[8];
        isQueenCheck1 = new boolean[8];
        set2(0);
    }

    public static void set2(int i){

        for(int j = 0; j < 8; j++){
            if(!isQueenCheck1[j]){
                arrays[i] = j;
                if(i == 7){
                    output1();
                }else{
                    isQueenCheck1[j] = true;
                    set2(i + 1);
                    isQueenCheck1[j] = false;
                }
            }
        }
    }

    public static void queen3(){
        arrays = new int[8];
        isQueenCheck1 = new boolean[8];
        isQueenCheck2 = new boolean[15];
        isQueenCheck3 = new boolean[15];
        set3(0);
    }
    
    public static void set3(int i){

        for(int j = 0; j < 8; j++){
            if(!isQueenCheck1[j] && !isQueenCheck2[i + j] && !isQueenCheck3[i - j + 7]){
                arrays[i] = j;
                if(i == 7){
                    output1();
                }else{
                    isQueenCheck1[j] = isQueenCheck2[i + j] = isQueenCheck3[i - j + 7] = true;
                    set3(i + 1);
                    isQueenCheck1[j] = isQueenCheck2[i + j] = isQueenCheck3[i - j + 7] = false;
                }
            }
        }
    }

    public static void queen4(){
        arrays = new int[8];
        isQueenCheck1 = new boolean[8];
        isQueenCheck2 = new boolean[15];
        isQueenCheck3 = new boolean[15];
        set4(0);
    }

    public static void set4(int i){

        for(int j = 0; j < 8; j++){
            if(!isQueenCheck1[j] && !isQueenCheck2[i + j] && !isQueenCheck3[i - j + 7]){
                arrays[i] = j;
                if(i == 7){
                    output2();
                }else{
                    isQueenCheck1[j] = isQueenCheck2[i + j] = isQueenCheck3[i - j + 7] = true;
                    set4(i + 1);
                    isQueenCheck1[j] = isQueenCheck2[i + j] = isQueenCheck3[i - j + 7] = false;
                }
            }
        }
    }

    public static void output2(){

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.printf("%s", j == arrays[i] ? "■" : "□");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void queen5(){
        arrays = new int[8];
        isQueenCheck1 = new boolean[8];
        isQueenCheck2 = new boolean[15];
        isQueenCheck3 = new boolean[15];
        set5(0);
    }

    public static void set5(int i){

        int j;
        int[] temp = new int[8];

        Start: while (true){
            j = 0;
            while (true){
                while (j < 8){
                    if(!isQueenCheck1[j] && !isQueenCheck2[i + j] && !isQueenCheck3[i - j + 7]){
                        arrays[i] = j;
                        if(i == 7){
                            output2();
                        }else{
                            isQueenCheck1[j] = isQueenCheck2[i + j] = isQueenCheck3[i - j + 7] = true;
                            temp[i++] = j;
                            continue Start;
                        }
                    }
                    j++;
                }
                if(--i == -1){
                    return;
                }
                j = temp[i];
                isQueenCheck1[j] = isQueenCheck2[i + j] = isQueenCheck3[i - j + 7] = false;
                j++;
            }
        }
    }
}
