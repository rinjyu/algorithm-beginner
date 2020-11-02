package com.algorithm.coding;

import java.util.Scanner;

public class Test9 {

    public static void main(String[] args) {
        // write your code here
        intDataQueue();
        lastElements();
    }

    static class IntQueue{
        private int max;
        private int num;
        private int front;
        private int rear;
        private int[] que;

        public static class EmptyIntQueueException extends RuntimeException{
            public EmptyIntQueueException(){

            }
        }

        public static class OverflowIntQueueException extends RuntimeException{
            public OverflowIntQueueException(){

            }
        }

        public IntQueue(int capacity){
            num = front = rear = 0;
            max = capacity;
            try{
                que = new int[max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public int enqueue(int data) throws OverflowIntQueueException{
            if(num >= max){
                throw new OverflowIntQueueException();
            }
            que[rear++] = data;
            num++;
            if(rear == max){
                rear = 0;
            }

            return data;
        }

        public int dequeue() throws EmptyIntQueueException{
            if(num <= 0){
                throw new EmptyIntQueueException();
            }
            int data = que[front++];
            num--;
            if(front == max){
                front = 0;
            }

            return data;
        }

        public int peek() throws EmptyIntQueueException{
            if(num <= 0){
                throw new EmptyIntQueueException();
            }
            return que[front];
        }

        public int indexOf(int data){
            for(int i = 0; i < num; i++){
                int index = (i + front) % max;
                if(que[index] == data){
                    return index;
                }
            }

            return  -1;
        }

        public void clear(){
            num = front = rear = 0;
        }

        public int capacity(){
            return max;
        }

        public int size(){
            return num;
        }

        public boolean isEmpty(){
            return num <= 0;
        }

        public boolean isFull(){
            return num >= max;
        }

        public void dump(){
            if(num <= 0){
                System.out.println("큐가 비어있습니다.");
            }else{
                for(int i = 0; i < num; i++){
                    System.out.print(que[(i + front) % max] + " ");
                }
                System.out.println();
            }
        }
    }

    static class IntDequeue{
        private int max;
        private int num;
        private int front;
        private int rear;
        private int[] que;

        public static class EmptyIntDequeueException extends RuntimeException{
            public EmptyIntDequeueException(){

            }
        }

        public static class OverflowIntDequeueException extends RuntimeException{
            public OverflowIntDequeueException(){

            }
        }

        public IntDequeue(int capacity){
            num = front = rear = 0;
            max = capacity;
            try{
                que = new int[max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public int enqueueFront(int data) throws OverflowIntDequeueException{
            if(num >= max){
                throw new OverflowIntDequeueException();
            }
            num++;
            if(--front < 0){
                front = max - 1;
            }
            que[front] = data;

            return data;
        }

        public int enqueueRear(int data) throws OverflowIntDequeueException{
            if(num >= max){
                throw new OverflowIntDequeueException();
            }
            que[rear++] = data;
            num++;
            if(rear == max){
                rear = 0;
            }

            return data;
        }

        public int dequeueFront() throws EmptyIntDequeueException{
            if(num <= 0){
                throw new EmptyIntDequeueException();
            }
            int data = que[front++];
            num--;
            if(front == max){
                front = 0;
            }
            return data;
        }

        public int dequeueRear() throws EmptyIntDequeueException{
            if(num <= 0){
                throw new EmptyIntDequeueException();
            }
            num--;
            if(--rear < 0){
                rear = max - 1;
            }
            return que[rear];
        }

        public int peekFront() throws EmptyIntDequeueException{
            if(num <= 0){
                throw new EmptyIntDequeueException();
            }
            return que[front];
        }

        public int peekRear() throws EmptyIntDequeueException{
            if(num <= 0){
                throw new EmptyIntDequeueException();
            }
            int size = rear == 0 ? max - 1 : rear - 1;
            return que[size];
        }

        public int indexOf(int data){
            for(int i = 0; i < num; i++){
                if(que[(i + front) % max] == data){
                    return i + front;
                }
            }

            return  -1;
        }

        public int search(int data){
            for(int i = 0; i < num; i++){
                if(que[(i + front) % max] == data){
                    return i + 1;
                }
            }

            return  0;
        }

        public void clear(){
            num = front = rear = 0;
        }

        public int capacity(){
            return max;
        }

        public int size(){
            return num;
        }

        public boolean isEmpty(){
            return num <= 0;
        }

        public boolean isFull(){
            return num >= max;
        }

        public void dump(){
            if(num <= 0){
                System.out.println("덱이 비어있습니다.");
            }else{
                for(int i = 0; i < num; i++){
                    System.out.print(que[(i + front) % max] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void intDataQueue(){

        Scanner scanner = new Scanner(System.in);
        IntQueue intQueue = new IntQueue(64);

        while (true){
            System.out.println("현재 데이터수 ={}" + intQueue.size() + "/" + intQueue.capacity());
            System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료={}");
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
                       intQueue.enqueue(data);
                    }catch (IntQueue.OverflowIntQueueException e){
                        System.out.println("큐가 가득찼습니다.");
                    }

                    break;

                case 2:
                    try {
                        data = intQueue.dequeue();
                        System.out.println("디큐한 데이터={}" + data);
                    }catch (IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어있습니다.");
                    }

                    break;

                case 3:
                    try {
                        data = intQueue.peek();
                        System.out.println("피크한 데이터={}" + data);
                    }catch (IntQueue.EmptyIntQueueException e){
                        System.out.println("큐가 비어있습니다.");
                    }

                    break;

                case 4:
                    intQueue.dump();

                    break;
            }

        }


    }

    static class IntDataQueue{
        private int max;
        private int num;
        private int front;
        private int rear;
        private int[] que;

        public static class EmptyIntQueueException extends RuntimeException{
            public EmptyIntQueueException(){

            }
        }

        public static class OverflowIntQueueException extends RuntimeException{
            public OverflowIntQueueException(){

            }
        }

        public IntDataQueue(int capacity){
            num = front = rear = 0;
            max = capacity;
            try{
                que = new int[max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public int enqueue(int data) throws OverflowIntQueueException{
            if(num >= max){
                throw new OverflowIntQueueException();
            }
            que[rear++] = data;
            num++;
            if(rear == max){
                rear = 0;
            }

            return data;
        }

        public int dequeue() throws EmptyIntQueueException{
            if(num <= 0){
                throw new EmptyIntQueueException();
            }
            int data = que[front++];
            num--;
            if(front == max){
                front = 0;
            }

            return data;
        }

        public int peek() throws EmptyIntQueueException{
            if(num <= 0){
                throw new EmptyIntQueueException();
            }
            return que[front];
        }

        public int indexOf(int data){
            for(int i = 0; i < num; i++){
                int index = (i + front) % max;
                if(que[index] == data){
                    return index;
                }
            }

            return  -1;
        }

        public void clear(){
            num = front = rear = 0;
        }

        public int capacity(){
            return max;
        }

        public int size(){
            return num;
        }

        public boolean isEmpty(){
            return num <= 0;
        }

        public boolean isFull(){
            return num >= max;
        }

        public void dump(){
            if(num <= 0){
                System.out.println("큐가 비어있습니다.");
            }else{
                for(int i = 0; i < num; i++){
                    System.out.print(que[(i + front) % max] + " ");
                }
                System.out.println();
            }
        }
    }

    static class Gqueue<E>{

        private int max;
        private int num;
        private int front;
        private int rear;
        private E[] que;

        public static class EmptyIntGqueueException extends RuntimeException{
            public EmptyIntGqueueException(){

            }
        }

        public static class OverflowIntGqueueException extends RuntimeException{
            public OverflowIntGqueueException(){

            }
        }

        public Gqueue(int capacity){
            num = front = rear = 0;
            max = capacity;
            try{
                que = (E[]) new Object[max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public E enqueue(E data) throws Gqueue.OverflowIntGqueueException {
            if(num >= max){
                throw new Gqueue.OverflowIntGqueueException();
            }
            que[rear++] = data;
            num++;
            if(rear == max){
                rear = 0;
            }

            return data;
        }

        public E dequeue() throws Gqueue.EmptyIntGqueueException {
            if(num <= 0){
                throw new Gqueue.EmptyIntGqueueException();
            }
            E data = que[front++];
            num--;
            if(front == max){
                front = 0;
            }

            return data;
        }

        public E peek() throws Gqueue.EmptyIntGqueueException {
            if(num <= 0){
                throw new Gqueue.EmptyIntGqueueException();
            }
            return que[front];
        }

        public int indexOf(E data){
            for(int i = 0; i < num; i++){
                int index = (i + front) % max;
                if(que[index] == data){
                    return index;
                }
            }

            return  -1;
        }

        public void clear(){
            num = front = rear = 0;
        }

        public int capacity(){
            return max;
        }

        public int size(){
            return num;
        }

        public boolean isEmpty(){
            return num <= 0;
        }

        public boolean isFull(){
            return num >= max;
        }

        public void dump(){
            if(num <= 0){
                System.out.println("큐가 비어있습니다.");
            }else{
                for(int i = 0; i < num; i++){
                    System.out.print(que[(i + front) % max].toString() + " ");
                }
                System.out.println();
            }
        }
    }

    public static void lastElements(){

        Scanner scanner = new Scanner(System.in);
        final int num = 10;
        int[] arrays = new int[num];
        int cnt = 0;
        int retry;

        System.out.println("입력 정수={}");

        do{
            System.out.printf("%d번째 정수={}", cnt + 1);
            arrays[cnt++ % num] = scanner.nextInt();

            System.out.println("계속 진행?(1 : 예, 0 : 아니오)={}");
            retry = scanner.nextInt();
        }while (retry == 1);

        int i = cnt - num;
        if(i < 0){
            i = 0;
        }

        for(; i < cnt; i++){
            System.out.printf("%2d번째의 정수={}%d\n", i + 1, arrays[i % num]);
        }
    }
}


