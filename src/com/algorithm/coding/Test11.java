package com.algorithm.coding;

import java.util.Scanner;

public class Test11 {

    public static void main(String[] args) {
        // write your code here
        recur1();
        recur2();
        recurStack();
    }

    public static void recur1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 입력={}");
        int num = scanner.nextInt();
        subRecur1(num);
    }

    public static void subRecur1(int num){

        if(num > 0){
            subRecur1(num - 1);
            System.out.println("숫자={}" + num);
            subRecur1(num - 2);
        }
    }

    public static void recur2(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 입력={}");
        int num = scanner.nextInt();
        subRecur2(num);
    }

    public static void subRecur2(int num){

        if(num > 0){
            subRecur2(num - 2);
            System.out.println("숫자={}" + num);
            subRecur2(num - 1);
        }
    }

    public static void recurStack(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 입력={}");
        int num = scanner.nextInt();
        subRecurStack(num);
    }
    
    public static void subRecurStack(int num){
        
        IntStack stack = new IntStack(num);
        while (true){
            if(num > 0){
                stack.push(num);
                num = num - 1;
                continue;
            }
            if(!stack.isEmpty()){
                num = stack.pop();
                System.out.println("숫자={}" + num);
                num = num - 2;
                continue;
            }
            
            break;
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

}
