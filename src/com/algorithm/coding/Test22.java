package com.algorithm.coding;

import java.util.*;

public class Test22 {

    public static void main(String[] args){
        // write your code here
        heapSort();
    }

    public static void heapSort(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        heapSort(arrays, cnt);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void heapSort(int[] arrays, int cnt){

        for(int i = (cnt - 1) / 2; i >= 0; i--){
            displayHeap(arrays, cnt);
            downHeap(arrays, i, cnt - 1);
        }

        for(int i = cnt - 1; i > 0; i--){
            swap(arrays, 0, i);
            displayHeap(arrays, cnt);
            downHeap(arrays, 0, i - 1);
        }
    }

    public static void displayHeap(int[] arrays, int cnt){
        int i = cnt;
        int height = 1;
        while ((i >>= 1) > 0){
            height++;
        }

        i = 0;
        int w = 1;
        Loop: {
            for(int level = 0; level < height; level++){
                displaySpace(square(height - level) - 3);
                for(int k = 0; k < w; k++){
                    System.out.printf("%02d", arrays[i++]);
                    if(i >= cnt){
                        break Loop;
                    }
                    if(k < w - 1){
                        displaySpace(square(height - level + 1) - 2);
                    }
                }
                System.out.println();

                displaySpace(square(height - level) - 4);
                for(int k = 0; k < w; k++){
                    if(2 * k + i < cnt){
                        System.out.print(" ／ ");
                    }
                    if(2 * k + i + 1 < cnt){
                        System.out.print(" ＼ ");
                    }
                    if(k < w - 1){
                        displaySpace(square(height - level + 1) - 4);
                    }
                }
                System.out.println();
                w *= 2;
            }
        }
        System.out.println();
        System.out.println();
    }


    public static void downHeap(int[] arrays, int first, int last) {

        int temp = arrays[first];
        int child;
        int parent;

        for (parent = first; parent < (last + 1) / 2; parent = child){
            int firstPoint = parent * 2 + 1;
            int lastPoint = firstPoint + 1;
            child = (lastPoint <= last && arrays[lastPoint] > arrays[firstPoint]) ? lastPoint : firstPoint;
            if(temp >= arrays[child]){
                break;
            }
            arrays[parent] = arrays[child];
        }
        arrays[parent] = temp;
    }
    
    public static void displaySpace(int cnt){
        for(int i = 0; i < cnt; i++){
            System.out.print(" ");
        }
    }

    public static int square(int cnt){
        int k = 1;

        while (cnt-- > 0){
            k *= 2;
        }

        return (k);
    }

    public static void swap(int[] arrays, int first, int last){

        int temp = arrays[first];
        arrays[first] = arrays[last];
        arrays[last] = temp;
    }
}
