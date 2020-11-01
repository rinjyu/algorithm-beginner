package com.algorithm.coding;

import java.util.Scanner;

public class Test8 {

    public static void main(String[] args) {
        // write your code here
        stack();
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

        public int push(int x) throws OverflowIntStackException {
            if(pointer >= max){
                throw new OverflowIntStackException();
            }
            return stack[pointer++] = x;
        }

        public int pop() throws EmptyIntStackException {
            if(pointer <= 0) {
                throw new EmptyIntStackException();
            }
            return stack[--pointer];
        }
        
        public int peek() throws EmptyIntStackException {
            if(pointer <= 0){
                throw new EmptyIntStackException();
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

    public static void stack(){

        Scanner scanner = new Scanner(System.in);
        IntStack stack = new IntStack(64);

        while (true){
            System.out.println("현재 데이터 수：" + stack.size() + " / " + stack.capacity());
            System.out.print("(1)푸시　(2)팝　(3)피크　(4)덤프　(5)검색　(6)비움　(7)정보표시　(0)종료={}");

            int type = scanner.nextInt();
            if(type == 0){
                break;
            }

            int data;
            switch (type){
                case 1:
                    System.out.println("데이터={}");
                    data = scanner.nextInt();
                    try{
                        stack.push(data);
                    }catch (IntStack.OverflowIntStackException e){
                        System.out.println("스택이 가득 찼습니다.");
                    }

                    break;
                case 2:
                    try{
                        data = stack.pop();
                        System.out.println("pop 데이터={}" + data);
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }

                    break;
                case 3:
                    try{
                        data = stack.peek();
                        System.out.println("peek 데이터={}" + data);
                    }catch (IntStack.EmptyIntStackException e){
                        System.out.println("스택이 비어 있습니다.");
                    }

                    break;

                case 4:
                    stack.dump();

                    break;

                case 5:
                    System.out.println("데이터={}");
                    data = scanner.nextInt();
                    int index = stack.indexOf(data);
                    if(index > -1){
                        System.out.println("데이터가 없습니다.");
                    }else{
                        System.out.println("꼭대기부터 " + (stack.size() - index) + "번째에 있습니다.");
                    }

                    break;
                case 6:
                    stack.clear();

                    break;
                case  7:
                    System.out.println("용량={}" + stack.capacity());
                    System.out.println("데이터 수={}" + stack.size());
                    System.out.println("비어 " + (stack.isEmpty() ? "있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (stack.isFull() ? "찼습니다." : "차지 않았습니다."));

                    break;
            }
        }
    }

    static class GStack<E>{
        private int max;
        private int pointer;
        private E[] stack;

        public static class EmptyGStackException extends RuntimeException{
            public EmptyGStackException(){};
        }

        public static class OverflowGStackException extends RuntimeException{
            public OverflowGStackException(){};
        }

        public GStack(int capacity){
            pointer = 0;
            max = capacity;
            try{
                stack = (E[]) new Object[max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public E push(E e) throws OverflowGStackException {
            if(pointer >= max){
                throw new OverflowGStackException();
            }
            return stack[pointer++];
        }
    }

    static class Stacks{

        private int max;
        private int pointer1;
        private int pointer2;
        private int[] stack;

        public enum StackType{
            StackA, StackB
        };

        public class EmptyIntStackException extends RuntimeException{
            public EmptyIntStackException(){

            }
        }

        public class OverflowIntStackException extends RuntimeException{
            public OverflowIntStackException(){

            }
        }

        public Stacks(int capacity){
            pointer1 = 0;
            pointer2 = capacity = 1;
            max = capacity;
            try{
                stack = new int[max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public int push(StackType stacks, int index) throws OutOfMemoryError{

            if(pointer1 >= pointer2 + 1){
                throw new OverflowIntStackException();
            }

            switch (stacks){
                case StackA:
                    stack[pointer1++] = index;

                    break;

                case StackB:
                    stack[pointer2++] = index;

                    break;
            }

            return index;
        }

        public int pop(StackType stacks) throws EmptyIntStackException{
            int index = 0;
            switch (stacks){
                case StackA:
                    if(pointer1 <= 0){
                        throw new EmptyIntStackException();
                    }

                    index = stack[--pointer1];
                    break;

                case StackB:
                    if(pointer2 >= max - 1){
                        throw new EmptyIntStackException();
                    }

                    index = stack[--pointer2];
                    break;
            }

            return index;
        }

        public int peek(StackType stacks) throws EmptyIntStackException{
            int index = 0;
            switch (stacks){
                case StackA:
                    if(pointer1 <= 0){
                        throw new EmptyIntStackException();
                    }

                    index = stack[pointer1 - 1];

                    break;

                case StackB:
                    if(pointer2 >= max - 1){
                        throw new EmptyIntStackException();
                    }

                    index = stack[pointer2 + 1];

                    break;
            }

            return index;
        }

        public int indexOf(StackType stacks, int index){
            switch (stacks){
                case StackA:
                    for(int i = pointer1 - 1; i >= 0; i--){
                        if(stack[i] == index){
                            return i;
                        }
                    }

                    break;

                case StackB:
                    for(int i = pointer2 + 1; i <max; i++){
                        if(stack[i] == index){
                            return i;
                        }
                    }

                    break;
            }

            return -1;
        }

        public void clear(StackType stacks){
            switch (stacks){
                case StackA:
                    pointer1 = 0;

                    break;

                case StackB:
                    pointer2 = max - 1;

                    break;
            }

        }

        public int capacity(){
            return max;
        }

        public int size(StackType stacks){
            switch (stacks){
                case StackA:
                    return pointer1;

                case StackB:
                    return max - pointer2 - 1;
            }

            return 0;
        }

        public boolean isEmpty(StackType stacks){
            switch (stacks){
                case StackA:
                    return pointer1 <= 0;

                case StackB:
                    return pointer2 >= max - 1;
            }

            return true;
        }

        public boolean isFull(){
            return  pointer1 >= pointer2 + 1;
        }

        public void dump(StackType stacks){
            switch (stacks){
                case StackA:
                    if(pointer1 <= 0){
                        System.out.println("스택이 비어 있습니다.");
                    }else{
                        for(int i = 0; i < pointer1; i++){
                            System.out.print(stack[i] + " ");
                        }
                        System.out.println();
                    }

                    break;
                case StackB:
                    if(pointer2 >= max - 1){
                        System.out.println("스택이 비어 있습니다.");
                    }else{
                        for(int i = 0; i < pointer2; i++){
                            System.out.print(stack[i] + " ");
                        }
                        System.out.println();
                    }

                    break;
            }
        }
    }
}

