package com.algorithm.coding;

import java.util.Scanner;

public class Test18 {

    public static void main(String[] args) {
        // write your code here
        quickSort1();
        quickSort2();
        quickSort3();
        quickSort4();
        quickSort5();
        quickSort6();
        quickSort7();
    }

    public static void quickSort1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort1(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort1(int[] arrays, int first, int last){

        IntStack firstStack = new IntStack(last - first + 1);
        IntStack lastStack = new IntStack(last - first + 1);
        
        firstStack.push(first);
        lastStack.push(last);
        
        while (!firstStack.isEmpty()){
            int pointFirst = first = firstStack.pop();
            int pointLast = last = lastStack.pop();
            int pivot = arrays[(first + last) / 2];
            
            do{
                while (arrays[pointFirst] < pivot){
                    pointFirst++;
                }
                while (arrays[pointLast] > pivot){
                    pointLast--;
                }
                if(pointFirst <= pointLast){
                    swap(arrays, pointFirst++, pointLast--);
                }
            }while (pointFirst <= pointLast);

            if(first < pointLast){
                firstStack.push(first);
                lastStack.push(pointLast);
            }

            if(pointFirst < last){
                firstStack.push(pointFirst);
                lastStack.push(last);
            }
        }
    }

    public static void quickSort2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort2(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort2(int[] arrays, int first, int last){

        int pointFirst = first;
        int pointLast = last;
        int middle = arrays[(pointFirst + pointLast) / 2];

        do{
            while (arrays[pointFirst] < middle){
                pointFirst++;
            }
            while (arrays[pointLast] > middle){
                pointLast--;
            }

            if(pointFirst <= pointLast){
                swap(arrays, pointFirst++, pointLast--);
            }
        }while (pointFirst <= pointLast);

        if(pointLast - first < last - pointFirst){
            int temp;
            temp = first;
            first = pointFirst;
            pointFirst = temp;
            temp = last;
            last = pointLast;
            pointLast = temp;
        }

        if(first < pointLast){
            subQuickSort2(arrays, first, pointLast);
        }
        if(pointFirst < last){
            subQuickSort2(arrays, pointFirst, last);
        }

    }

    public static void quickSort3(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort3(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort3(int[] arrays, int first, int last){

        if(last - first < 9){
            insertionSort(arrays, first, last);
        }else{
            int pointFirst = first;
            int pointLast = last;
            int middle = arrays[(pointFirst + pointLast) / 2];

            do{
                while (arrays[pointFirst] < middle){
                    pointFirst++;
                }
                while (arrays[pointLast] > middle){
                    pointLast--;
                }

                if(pointFirst <= pointLast){
                    swap(arrays, pointFirst++, pointLast--);
                }
            }while (pointFirst <= pointLast);

            if(pointLast - first < last - pointFirst){
                int temp;
                temp = first;
                first = pointFirst;
                pointFirst = temp;
                temp = last;
                last = pointLast;
                pointLast = temp;
            }

            if(first < pointLast){
                subQuickSort3(arrays, first, pointLast);
            }
            if(pointFirst < last){
                subQuickSort3(arrays, pointFirst, last);
            }
        }

    }

    public static void quickSort4(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort4(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort4(int[] arrays, int first, int last){

        IntStack firstStack = new IntStack(last - first + 1);
        IntStack lastStack = new IntStack(last - first + 1);

        firstStack.push(first);
        lastStack.push(last);

        while (!firstStack.isEmpty()){
            int pointFirst = first = firstStack.pop();
            int pointLast = last = lastStack.pop();

            if(last - first < 9){
                insertionSort(arrays, first, last);
            }else{
                int pivot = arrays[(first + last) / 2];

                do{
                    while (arrays[pointFirst] < pivot){
                        pointFirst++;
                    }
                    while (arrays[pointLast] > pivot){
                        pointLast--;
                    }
                    if(pointFirst <= pointLast){
                        swap(arrays, pointFirst++, pointLast--);
                    }
                }while (pointFirst <= pointLast);

                if(pointLast - first < last - pointFirst){
                    int temp;
                    temp = first;
                    first = pointFirst;
                    pointFirst = temp;
                    temp = last;
                    last = pointLast;
                    pointLast = temp;
                }

                if(first < pointLast){
                    firstStack.push(first);
                    lastStack.push(pointLast);
                }

                if(pointFirst < last){
                    firstStack.push(pointFirst);
                    lastStack.push(last);
                }

            }
        }

    }

    public static void quickSort5(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort5(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort5(int[] arrays, int first, int last){

        if(last - first < 9){
            insertionSort(arrays, first, last);
        }else{
            int pointFirst = first;
            int pointLast = last;
            int middle = getMiddle(arrays[pointFirst], arrays[(pointFirst + pointLast) / 2], arrays[pointLast]);

            do{
                while (arrays[pointFirst] < middle){
                    pointFirst++;
                }
                while (arrays[pointLast] > middle){
                    pointLast--;
                }

                if(pointFirst <= pointLast){
                    swap(arrays, pointFirst++, pointLast--);
                }
            }while (pointFirst <= pointLast);

            if(pointLast - first < last - pointFirst){
                int temp;
                temp = first;
                first = pointFirst;
                pointFirst = temp;
                temp = last;
                last = pointLast;
                pointLast = temp;
            }

            if(first < pointLast){
                subQuickSort5(arrays, first, pointLast);
            }
            if(pointFirst < last){
                subQuickSort5(arrays, pointFirst, last);
            }
        }

    }

    public static void quickSort6(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort6(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort6(int[] arrays, int first, int last){

        if(last - first < 9){
            insertionSort(arrays, first, last);
        }else{
            int pointFirst = first;
            int pointLast = last;
            int pivot = 0;
            int middle = sort(arrays, pointFirst, (pointFirst + pointLast) / 2, pointLast);
            pivot = arrays[middle];
            swap(arrays, middle, last - 1);
            pointFirst++;
            pointLast--;

            do{
                while (arrays[pointFirst] < pivot){
                    pointFirst++;
                }
                while (arrays[pointLast] > pivot){
                    pointLast--;
                }

                if(pointFirst <= pointLast){
                    swap(arrays, pointFirst++, pointLast--);
                }
            }while (pointFirst <= pointLast);

            if(pointLast - first < last - pointFirst){
                int temp;
                temp = first;
                first = pointFirst;
                pointFirst = temp;
                temp = last;
                last = pointLast;
                pointLast = temp;
            }

            if(first < pointLast){
                subQuickSort6(arrays, first, pointLast);
            }
            if(pointFirst < last){
                subQuickSort6(arrays, pointFirst, last);
            }
        }

    }

    public static void quickSort7(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        subQuickSort7(arrays, 0, cnt - 1);
        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void subQuickSort7(int[] arrays, int first, int last){

        IntStack firstStack = new IntStack(last - first + 1);
        IntStack lastStack = new IntStack(last - first + 1);

        firstStack.push(first);
        lastStack.push(last);

        while (!firstStack.isEmpty()){
            int pointFirst = first = firstStack.pop();
            int pointLast = last = lastStack.pop();

            if(last - first < 9){
                insertionSort(arrays, first, last);
            }else{
                int pivot = 0;
                int middle = sort(arrays, pointFirst, (pointFirst + pointLast) / 2, pointLast);
                pivot = arrays[middle];
                swap(arrays, middle, last - 1);
                pointFirst++;
                pointLast--;

                do{
                    while (arrays[pointFirst] < pivot){
                        pointFirst++;
                    }
                    while (arrays[pointLast] > pivot){
                        pointLast--;
                    }
                    if(pointFirst <= pointLast){
                        swap(arrays, pointFirst++, pointLast--);
                    }
                }while (pointFirst <= pointLast);

                if(pointLast - first < last - pointFirst){
                    int temp;
                    temp = first;
                    first = pointFirst;
                    pointFirst = temp;
                    temp = last;
                    last = pointLast;
                    pointLast = temp;
                }

                if(first < pointLast){
                    firstStack.push(first);
                    lastStack.push(pointLast);
                }

                if(pointFirst < last){
                    firstStack.push(pointFirst);
                    lastStack.push(last);
                }

            }
        }

    }

    static int sort(int[] arrays, int index1, int index2, int index3) {
        if (arrays[index2] < arrays[index1]) {
            swap(arrays, index2, index1);
        }
        if (arrays[index3] < arrays[index2]) {
            swap(arrays, index3, index2);
        }
        if (arrays[index2] < arrays[index1]) {
            swap(arrays, index2, index1);
        }
        return index2;
    }

    private static int getMiddle(int index1, int index2, int index3) {
        if (index1 >= index2) {
            if (index2 >= index3) {
                return index2;
            }else if (index1 <= index3) {
                return index1;
            }else {
                return index3;
            }
        }else if (index1 > index3) {
            return index1;
        }else if (index2 > index3) {
            return index3;
        }else {
            return index2;
        }
    }

    static void insertionSort(int[] arrays, int first, int last) {
        for (int i = first + 1; i <= last; i++) {
            int temp = arrays[i];
            int j;
            for (j = i; j > 0 && arrays[j - 1] > temp; j--){
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = temp;
        }
    }

    static class IntStack {
        private int max;
        private int pointer;
        private int[] stack;

        public class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException(){ }
        }

        public class OverflowIntStackException extends RuntimeException {
            public OverflowIntStackException(){ }
        }

        public IntStack(int capacity) {
            pointer = 0;
            max = capacity;
            try{
                stack = new int[max];
            }catch(OutOfMemoryError e){
                max = 0;
            }
        }

        public int push(int x) throws IntStack.OverflowIntStackException {
            if(pointer >= max){
                throw new IntStack.OverflowIntStackException();
            }
            return stack[pointer++] = x;
        }

        public int pop() throws IntStack.EmptyIntStackException {
            if(pointer <= 0) {
                throw new IntStack.EmptyIntStackException();
            }
            return stack[--pointer];
        }

        public int peek() throws IntStack.EmptyIntStackException {
            if(pointer <= 0){
                throw new IntStack.EmptyIntStackException();
            }
            return stack[pointer - 1];
        }

        public int indexOf(int x) {
            for(int i = pointer - 1; i >= 0; i--){
                if(stack[i] == x){
                    return i;
                }
            }
            return -1;
        }

        public void clear() {
            pointer = 0;
        }

        public int capacity() {
            return max;
        }

        public int size() {
            return pointer;
        }

        public boolean isEmpty() {
            return pointer <= 0;
        }

        public boolean isFull() {
            return pointer >= max;
        }

        public void dump() {
            if(pointer <= 0){
                System.out.println("스택이 비어 있습니다.");
            }else{
                for(int i = 0; i < pointer; i++){
                    System.out.print(stack[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void swap(int[] arrays, int first, int last){

        int temp = arrays[first];
        arrays[first] = arrays[last];
        arrays[last] = temp;
    }
}
