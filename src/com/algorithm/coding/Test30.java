package com.algorithm.coding;

import java.util.Comparator;
import java.util.Scanner;

public class Test30 {

    public static void main(String[] args){
        // write your code here
        Task task;
        Data data;
        Data ptr;
        Data temp = new Data();

        LinkedList<Data> list = new LinkedList<Data>(100);

        do {
            switch (task = SelectTask()) {

                case ADD_FIRST :
                    data = new Data();
                    data.scanData("머리에 삽입", Data.NO | Data.NAME);
                    list.addFirst(data);
                    break;

                case ADD_LAST :
                    data = new Data();
                    data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
                    list.addLast(data);
                    break;

                case RMV_FIRST :
                    list.removeFirst();
                    break;

                case RMV_LAST :
                    list.removeLast();
                    break;

                case RMV_CRNT :
                    list.removeCurrentNode();
                    break;

                case SEARCH_NO :
                    temp.scanData("검색", Data.NO);
                    ptr = list.search(temp, Data.NO_ORDER);
                    if(ptr == null){
                        System.out.println("그 번호의 데이터가 없습니다.");
                    }else{
                        System.out.println("검색 성공：" + ptr);
                    }
                    break;

                case SEARCH_NAME :
                    temp.scanData("검색", Data.NAME);
                    ptr = list.search(temp, Data.NAME_ORDER);
                    if(ptr == null){
                        System.out.println("그 이름의 데이터가 없습니다.");
                    }else{
                        System.out.println("검색 성공：" + ptr);
                    }
                    break;

                case NEXT :
                    list.next();
                    break;

                case PRINT_CRNT :
                    list.printCurrentNode();
                    break;

                case DUMP :
                    list.dump();
                    break;

                case CLEAR :
                    list.clear();
                    break;
            }
        } while (task != Task.TERMINATE);
    }

    public static class LinkedList<E>{

        class Node<E>{
            private E data;
            private int next;
            private int dNext;

            void set(E data, int next){
                this.data = data;
                this.next = next;
            }
        }

        private Node<E>[] n;
        private int size;
        private int max;
        private int head;
        private int selNode;
        private int deleted;
        private static final int NULL = -1;

        public LinkedList(int capacity){
            head = selNode = max = deleted = NULL;
            try{
                n = new Node[capacity];
                for(int i = 0; i < capacity; i++){
                    n[i] = new Node<E>();
                }
                size = capacity;
            }catch(OutOfMemoryError e){
                size = 0;
            }
        }

        private int getInsertIndex(){
            if(deleted == NULL){
                if(max < size){
                    return ++max;
                }else{
                    return NULL;
                }
            }else{
                int rec = deleted;
                deleted = n[rec].dNext;
                return rec;
            }
        }

        private void deleteIndex(int index){
            if(deleted == NULL){
                deleted = index;
                n[index].dNext = NULL;
            }else{
                int rec = deleted;
                deleted = index;
                n[index].dNext = rec;
            }
        }

        public E search(E object, Comparator<? super E> c){
            int pointer = head;
            while(pointer != NULL){
                if(c.compare(object, n[pointer].data) == 0){
                    selNode = pointer;
                    return n[pointer].data;
                }
                pointer = n[pointer].next;
            }
            return null;
        }

        public void addFirst(E object){
            int pointer = head;
            int rec = getInsertIndex();
            if(rec != NULL){
                head = selNode = rec;
                n[head].set(object, pointer);
            }
        }

        public void addLast(E object){
            if(head == NULL){
                addFirst(object);
            }else{
                int pointer = head;
                while(n[pointer].next != NULL){
                    pointer = n[pointer].next;
                }
                int rec = getInsertIndex();
                if(rec != NULL){
                    n[pointer].next = selNode = rec;
                    n[rec].set(object, NULL);
                }
            }
        }

        public void removeFirst(){
            if(head != NULL){
                int pointer = n[head].next;
                deleteIndex(head);
                head = selNode = pointer;
            }
        }

        public void removeLast(){
            if(head != NULL){
                if(n[head].next == NULL){
                    removeFirst();
                }else{
                    int pointer = head;
                    int pre = head;

                    while(n[pointer].next != NULL){
                        pre = pointer;
                        pointer = n[pointer].next;
                    }
                    n[pre].next = NULL;
                    deleteIndex(pointer);
                    selNode = pre;
                }
            }
        }

        public void remove(int p){
            if(head != NULL){
                if(p == head){
                    removeFirst();
                }else{
                    int pointer = head;

                    while(n[pointer].next != p){
                        pointer = n[pointer].next;
                        if(pointer == NULL){
                            return;
                        }
                    }
                    n[pointer].next = NULL;
                    deleteIndex(p);
                    n[pointer].next = n[p].next;
                    selNode = pointer;
                }
            }
        }

        public void removeCurrentNode(){
            remove(selNode);
        }

        public void clear(){
            while(head != NULL){
                removeFirst();
            }
            selNode = NULL;
        }
        
        public boolean next(){
            if(selNode == NULL || n[selNode].next == NULL){
                return false;
            }
            selNode = n[selNode].next;
            return true;
        }

        public void printCurrentNode(){
            if(selNode == NULL){
                System.out.println("선택 노드가 없습니다.");
            }else{
                System.out.println(n[selNode].data);
            }
        }
        
        public void dump(){
            int pointer = head;

            while(pointer != NULL){
                System.out.println(n[pointer].data);
                pointer = n[pointer].next;
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    static class Data{

        static final int NO = 1;
        static final int NAME = 2;

        private Integer memNo;
        private String memName;

        public String toString(){
            return  "(" + memNo + ")" + memName;
        }

        void scanData(String guide, int type){
            System.out.println(guide + "할 데이터를 입력해주세요");

            if ((type & NO) == NO) {
                System.out.print("번호={}");
                memNo = scanner.nextInt();
            }

            if ((type & NAME) == NAME) {
                System.out.print("이름={}");
                memName = scanner.next();
            }
        }

        public static final Comparator<Data> NO_ORDER =	 new Data.NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data>{
            public int compare(Data d1, Data d2){
                return (d1.memNo > d2.memNo) ? 1 : (d1.memNo < d2.memNo) ? -1 : 0;
            }
        }

        public static final Comparator<Data> NAME_ORDER = new Data.NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data>{
            public int compare(Data d1, Data d2){
                return d1.memName.compareTo(d2.memName);
            }
        }
    }

    enum Task{
        ADD_FIRST("머리에 노드를 삽입"),
        ADD_LAST("꼬리에 노드를 삽입"),
        RMV_FIRST("머리 노드를 삭제"),
        RMV_LAST("꼬리 노드를 삭제"),
        RMV_CRNT("선택 노드를 삭제"),
        CLEAR("모든 노드를 삭제"),
        SEARCH_NO("번호로 검색"),
        SEARCH_NAME("이름으로 검색"),
        NEXT("선택 노드를 하나 뒤쪽으로 이동"),
        PRINT_CRNT("선택 노드를 출력"),
        DUMP("모든 노드를 출력"),
        TERMINATE("종료");

        private final String message;


        static Task TaskAt(int index){
            for(Task m : Task.values()){
                if(m.ordinal() == index){
                    return m;
                }
            }
            return null;
        }

        Task(String msg) {
            message = msg;
        }

        String getMessage() {
            return message;
        }
    }

    static Task SelectTask(){
        int key;
        do{
            for(Task m : Task.values()){
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if((m.ordinal() % 3) == 2 && m.ordinal() != Task.TERMINATE.ordinal()){
                    System.out.println();
                }
            }
            System.out.print("：");
            key = scanner.nextInt();
        }while(key < Task.ADD_FIRST.ordinal() || key > Task.TERMINATE.ordinal());
        return Task.TaskAt(key);
    }

    public static class LinkedListT<E>{

        class Node<E>{
            private E data;
            private int next;
            private int dNext;

            void set(E data, int next){
                this.data = data;
                this.next = next;
            }
        }

        private Node<E>[] n;
        private int size;
        private int max;
        private int head;
        private int tail;
        private int selNode;
        private int deleted;
        private static final int NULL = -1;

        public LinkedListT(int capacity){
            head = tail = selNode = max = deleted = NULL;
            try{
                n = new Node[capacity];
                for(int i = 0; i < capacity; i++){
                    n[i] = new Node<E>();
                }
                size = capacity;
            }catch(OutOfMemoryError e){
                size = 0;
            }
        }

        private int getInsertIndex(){
            if(deleted == NULL){
                if(max < size){
                    return ++max;
                }else{
                    return NULL;
                }
            }else{
                int rec = deleted;
                deleted = n[rec].dNext;
                return rec;
            }
        }

        private void deleteIndex(int index){
            if(deleted == NULL){
                deleted = index;
                n[index].dNext = NULL;
            }else{
                int rec = deleted;
                deleted = index;
                n[index].dNext = rec;
            }
        }

        public E search(E object, Comparator<? super E> c){
            int pointer = head;
            while(pointer != NULL){
                if(c.compare(object, n[pointer].data) == 0){
                    selNode = pointer;
                    return n[pointer].data;
                }
                pointer = n[pointer].next;
            }
            return null;
        }

        public void addFirst(E object){
            boolean empty = (tail == NULL);
            int pointer = head;
            int rec = getInsertIndex();
            if(rec != NULL){
                head = selNode = rec;
                n[head].set(object, pointer);
                if(empty){
                    tail = selNode;
                }
            }
        }

        public void addLast(E object){
            if(head == NULL){
                addFirst(object);
            }else{
                int rec = getInsertIndex();
                if(rec != NULL){
                    n[tail].next = selNode = rec;
                    n[rec].set(object, NULL);
                    tail = rec;
                }
            }
        }

        public void removeFirst(){
            if(head != NULL){
                int pointer = n[head].next;
                deleteIndex(head);
                head = selNode = pointer;
                if(head == NULL){
                    tail = NULL;
                }
            }
        }

        public void removeLast(){
            if(head != NULL){
                if(n[head].next == NULL){
                    removeFirst();
                }else{
                    int pointer = head;
                    int pre = head;

                    while(n[pointer].next != NULL){
                        pre = pointer;
                        pointer = n[pointer].next;
                    }
                    n[pre].next = NULL;
                    deleteIndex(pointer);
                    tail = selNode = pre;
                }
            }
        }

        public void remove(int p){
            if(head != NULL){
                if(p == head){
                    removeFirst();
                }else if(p == tail){
                    removeLast();
                }else{
                    int pointer = head;

                    while(n[pointer].next != p){
                        pointer = n[pointer].next;
                        if(pointer == NULL){
                            return;
                        }
                    }
                    n[pointer].next = NULL;
                    deleteIndex(p);
                    n[pointer].next = n[p].next;
                    selNode = pointer;
                }
            }
        }

        public void removeCurrentNode(){
            remove(selNode);
        }

        public void clear(){
            while(head != NULL){
                removeFirst();
            }
            selNode = NULL;
        }

        public boolean next(){
            if(selNode == NULL || n[selNode].next == NULL){
                return false;
            }
            selNode = n[selNode].next;
            return true;
        }

        public void printCurrentNode(){
            if(selNode == NULL){
                System.out.println("선택 노드가 없습니다.");
            }else{
                System.out.println(n[selNode].data);
            }
        }

        public void dump(){
            int pointer = head;

            while(pointer != NULL){
                System.out.println(n[pointer].data);
                pointer = n[pointer].next;
            }
        }

        public void purge(Comparator<? super E> c){
            int pointer = head;

            while(pointer != NULL){
                int count = 0;
                int ptr = pointer;
                int pre = pointer;

                while(n[pre].next != NULL){
                    ptr = n[pre].next;
                    if(c.compare(n[pointer].data, n[ptr].data) == 0){
                        remove(ptr);
                        count++;
                    }else{
                        pre = ptr;
                    }
                }
                if(count == 0){
                    pointer = n[ptr].next;
                }else{
                    int temp = n[ptr].next;
                    remove(ptr);
                    ptr = temp;
                }
            }
            selNode = head;
        }

        public E retrieve(int n){
            int pointer = head;

            while(n >= 0 && pointer != NULL){
                if(n-- == 0){
                    selNode = pointer;
                    return this.n[pointer].data;
                }
                pointer = this.n[pointer].next;
            }
            return (null);
        }
    }
}