package com.algorithm.coding;

import java.util.Comparator;
import java.util.Scanner;

public class Test31 {

    public static void main(String[] args){
        // write your code here
        Task task;
        Data data;
        Data pointer;
        Data temp = new Data();

        DblLinkedList<Data> list = new DblLinkedList<Data>();

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
                    pointer = list.search(temp, Data.NO_ORDER);
                    if(pointer == null){
                        System.out.println("그 번호의 데이터가 없습니다.");
                    }else{
                        System.out.println("검색 성공：" + pointer);
                    }
                    break;

                case SEARCH_NAME :
                    temp.scanData("검색", Data.NAME);
                    pointer = list.search(temp, Data.NAME_ORDER);
                    if(pointer == null){
                        System.out.println("그 이름의 데이터가 없습니다.");
                    }else{
                        System.out.println("검색 성공：" + pointer);
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

    public static class CircleLinkedList<E>{

        class Node<E> {
            E data;
            Node<E> next;

            Node(E data) {
                this.data = data;
                this.next = this;
            }

            Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
        }

        private Node<E> head;
        private Node<E> tail;
        private Node<E> selNode;

        public CircleLinkedList(){
            head = tail = selNode = null;
        }

        public E search(E object, Comparator<? super E> c){
            if (head != null) {
                Node<E> pointer = head;

                do {
                    if (c.compare(object, pointer.data) == 0) {
                        selNode = pointer;
                        return pointer.data;
                    }
                    pointer = pointer.next;
                } while (pointer != head);
            }
            return null;
        }

        public void addFirst(E object){
            if (head == null) {
                head = tail = selNode = new Node<E>(object);
            } else {
                Node<E> pointer = head;
                head = selNode = new Node<E>(object, pointer);
                tail.next = head;
            }
        }

        public void addLast(E object){
            if (head == null) {
                addFirst(object);
            } else {
                Node<E> pointer = tail;
                pointer.next = selNode = tail = new Node<E>(object, head);
            }
        }

        public void removeFirst(){
            if (head != null) {
                if (head == tail){
                    head = tail = selNode = null;
                } else {
                    Node<E> pointer = head.next;
                    head = selNode = pointer;
                    tail.next = head;
                }
            }
        }

        public void removeLast(){
            if (head != null) {
                if (head == tail) {
                    removeFirst();
                } else {
                    Node<E> pointer = head;
                    Node<E> pre = head;

                    while (pointer.next != head) {
                        pre = pointer;
                        pointer = pointer.next;
                    }
                    pre.next = head;
                    tail = selNode = pre;
                }
            }
        }

        public void remove(Node<E> p) {
            if (head != null) {
                if (p == head) {
                    removeFirst();
                } else if (p == tail) {
                    removeLast();
                } else {
                    Node<E> pointer = head;

                    while (pointer.next != p) {
                        pointer = pointer.next;
                        if (pointer == head) {
                            return;
                        }
                    }
                    pointer.next = p.next;
                    selNode = pointer;
                }
            }
        }

        public void removeCurrentNode(){
            remove(selNode);
        }

        public void clear(){
            while(head != null){
                removeFirst();
            }
            selNode = null;
        }

        public boolean next(){
            if(selNode == null || selNode.next == head){
                return false;
            }
            selNode = selNode.next;
            return true;
        }

        public void printCurrentNode(){
            if(selNode == null){
                System.out.println("선택 노드가 없습니다.");
            }else{
                System.out.println(selNode.data);
            }
        }

        public void dump(){
            if (head != null) {
                Node<E> pointer = head;

                do {
                    System.out.println(pointer.data.toString());
                    pointer = pointer.next;
                } while (pointer != head);
            }
        }

        public void purge(Comparator<? super E> c) {
            if (head == null)
                return;
            Node<E> pointer = head;

            do {
                int count = 0;
                Node<E> pointer2 = pointer;
                Node<E> pre = pointer;

                while (pre.next != head) {
                    pointer2 = pre.next;
                    if (c.compare(pointer.data, pointer2.data) == 0) {
                        remove(pointer2);
                        count++;
                    } else {
                        pre = pointer2;
                    }
                }
                if (count == 0) {
                    pointer = pointer.next;
                } else {
                    Node<E> temp = pointer;
                    remove(pointer);
                    pointer = temp.next;
                }
            } while (pointer.next != head);
            selNode = head;
        }

        public E retrieve(int n) {
            if (head != null) {
                Node<E> pointer = head;

                while (n >= 0) {
                    if (n-- == 0) {
                        selNode = pointer;
                        return (pointer.data);
                    }
                    pointer = pointer.next;
                    if (pointer == head) {
                        break;
                    }
                }
            }
            return (null);
        }
    }

    public static class ArrayCircleLinkedList<E>{

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

        public ArrayCircleLinkedList(int capacity){
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
            if (head != NULL) {
                int pointer = head;

                do {
                    if (c.compare(object, n[pointer].data) == 0) {
                        selNode = pointer;
                        return n[pointer].data;
                    }
                    pointer = n[pointer].next;
                } while (pointer != head);
            }
            return null;
        }

        public void addFirst(E object){
            if (head == NULL) {
                int rec = getInsertIndex();
                if (rec != NULL) {
                    head = tail = selNode = rec;
                    n[head].set(object, rec);
                }
            } else {
                int pointer = head;
                int rec = getInsertIndex();
                if (rec != NULL) {
                    head = selNode = rec;
                    n[head].set(object, pointer);
                    n[tail].next = head;
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
                    n[rec].set(object, head);
                    tail = rec;
                }
            }
        }

        public void removeFirst(){
            if(head != NULL){
                if (head == tail) {
                    deleteIndex(head);
                    head = tail = selNode = NULL;
                } else {
                    int pointer = n[head].next;
                    deleteIndex(head);
                    head = selNode = pointer;
                    n[tail].next = head;
                }
            }
        }

        public void removeLast(){
            if(head != NULL){
                if (head == tail) {
                    removeFirst();
                } else {
                    int pointer = head;
                    int pre = head;

                    while (n[pointer].next != head) {
                        pre = pointer;
                        pointer = n[pointer].next;
                    }
                    n[pre].next = head;
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
                        if(pointer == head){
                            return;
                        }
                    }
                    n[pointer].next = n[p].next;
                    deleteIndex(p);
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
            if(selNode == NULL || n[selNode].next == head){
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
            if (head != NULL) {
                int pointer = head;

                do {
                    System.out.println(n[pointer].data.toString());
                    pointer = n[pointer].next;
                } while (pointer != head);
            }
        }

        public void purge(Comparator<? super E> c) {
            if (head == NULL) {
                return;
            }
            int pointer = head;

            do {
                int count = 0;
                int pointer2 = pointer;
                int pre = pointer;

                while (n[pre].next != head) {
                    pointer2 = n[pre].next;
                    if (c.compare(n[pointer].data, n[pointer2].data) == 0) {
                        remove(pointer2);
                        count++;
                    } else {
                        pre = pointer2;
                    }
                }
                if (count == 0) {
                    pointer = n[pointer].next;
                } else {
                    int temp = n[pointer].next;
                    remove(pointer);
                    pointer = temp;
                }
            } while (n[pointer].next != head);
            selNode = head;
        }

        public E retrieve(int n) {
            if (head != NULL) {
                int pointer = head;

                while (n >= 0) {
                    if (n-- == 0) {
                        selNode = pointer;
                        return this.n[pointer].data;
                    }
                    pointer = this.n[pointer].next;
                    if (pointer == head) {
                        break;
                    }
                }
            }
            return (null);
        }
    }

    public static class DblLinkedList<E> {
        
        class Node<E> {
            private E data;
            private Node<E> prev;
            private Node<E> next;

            Node() {
                data = null;
                prev = next = this;
            }

            Node(E object, Node<E> prev, Node<E> next) {
                data = object;
                this.prev = prev;
                this.next = next;
            }
        }

        private Node<E> head;
        private Node<E> selNode;
        
        public DblLinkedList() {
            head = selNode = new Node<E>();
        }

        public boolean isEmpty() {
            return head.next == head;
        }
        
        public E search(E object, Comparator<? super E> c) {
            Node<E> pointer = head.next;

            while (pointer != head) {
                if (c.compare(object, pointer.data) == 0) {
                    selNode = pointer;
                    return pointer.data;
                }
                pointer = pointer.next;
            }
            return null;
        }
        
        public void printCurrentNode() {
            if (isEmpty()) {
                System.out.println("선택 노드가 없습니다.");
            } else {
                System.out.println(selNode.data);
            }
        }
        
        public void dump() {
            Node<E> pointer = head.next;

            while (pointer != head) {
                System.out.println(pointer.data);
                pointer = pointer.next;
            }
        }
        
        public void dumpReverse() {
            Node<E> pointer = head.prev;

            while (pointer != head) {
                System.out.println(pointer.data);
                pointer = pointer.prev;
            }
        }
        
        public boolean next() {
            if (isEmpty() || selNode.next == head) {
                return false;
            }
            selNode = selNode.next;
            return true;
        }
        
        public boolean prev() {
            if (isEmpty() || selNode.prev == head) {
                return false;
            }
            selNode = selNode.prev;
            return true;
        }
        
        public void add(E object) {
            Node<E> node = new Node<E>(object, selNode, selNode.next);
            selNode.next = selNode.next.prev = node;
            selNode = node;
        }
        
        public void addFirst(E object) {
            selNode = head;
            add(object);
        }
        
        public void addLast(E object) {
            selNode = head.prev;
            add(object);
        }

        public void removeCurrentNode() {
            if (!isEmpty()) {
                selNode.prev.next = selNode.next;
                selNode.next.prev = selNode.prev;
                selNode = selNode.prev;
                if (selNode == head) {
                    selNode = head.next;
                }
            }
        }

        public void remove(Node p) {
            Node<E> pointer = head.next;

            while (pointer != head) {
                if (pointer == p) {
                    selNode = p;
                    removeCurrentNode();
                    break;
                }
                pointer = pointer.next;
            }
        }

        public void removeFirst() {
            selNode = head.next;
            removeCurrentNode();
        }

        public void removeLast() {
            selNode = head.prev;
            removeCurrentNode();
        }

        public void clear() {
            while (!isEmpty()) {
                removeFirst();
            }
        }

        public void purge(Comparator<? super E> c) {
            Node<E> pointer = head.next;

            while (pointer.next != head) {
                int count = 0;
                Node<E> pointer2 = pointer;
                Node<E> pre = pointer;

                while (pre.next != head) {
                    pointer2 = pre.next;
                    if (c.compare(pointer.data, pointer2.data) == 0) {
                        pre.next = pointer2.next;
                        count++;
                    } else {
                        pre = pointer2;
                    }
                }
                if (count == 0) {
                    pointer = pointer.next;
                } else {
                    Node<E> temp = pointer;
                    remove(pointer);
                    pointer = temp.next;
                }
            }
            selNode = head;
        }

        public E retrieve(int n) {
            Node<E> pointer = head.next;

            while (n >= 0 && pointer.next.next != head) {
                if (n-- == 0) {
                    selNode = pointer;
                    return pointer.data;
                }
                pointer = pointer.next;
            }
            return (null);
        }
    }

    static Scanner scanner = new Scanner(System.in);

    static class Data {
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
}