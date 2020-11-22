package com.algorithm.coding;

import java.util.Comparator;
import java.util.Scanner;

public class Test29 {

    public static void main(String[] args){
        // write your code here
        Task task;
        Data data;
        Data ptr;
        Data temp = new Data();

        LinkedList<Data> list = new LinkedList<Data>();

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

        public static final Comparator<Data> NO_ORDER =	 new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data>{
            public int compare(Data d1, Data d2){
                return (d1.memNo > d2.memNo) ? 1 : (d1.memNo < d2.memNo) ? -1 : 0;
            }
        }

        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

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

    public static class LinkedList<E> {

        class Node<E>{
            private E data;
            private Node<E> next;

            Node(E data, Node<E> next){
                this.data = data;
                this.next = next;
            }
        }

        private Node<E> head;
        private Node<E> selNode;

        public LinkedList(){
            head = selNode = null;
        }

        public E search(E object, Comparator<? super E> c){
            Node<E> currentNode = head;

            while (currentNode != null){
                if(c.compare(object, currentNode.data) == 0){
                    selNode = currentNode;
                    return currentNode.data;
                }
                selNode = currentNode.next;
            }
            return null;
        }

        public void addFirst(E object){
            Node<E> currentNode = head;
            head = selNode = new Node<E>(object, currentNode);
        }

        public void addLast(E object){
            if(head == null){
                addFirst(object);
            }else{
                Node<E> currentNode = head;
                while (currentNode.next != null){
                    currentNode = currentNode.next;
                }
                currentNode.next = selNode = new Node<E>(object, null);
            }
        }

        public void removeFirst(){
            if(head != null){
                head = selNode = head.next;
            }
        }

        public void removeLast(){
            if(head != null){
                if(head.next == null) {
                    removeFirst();
                }else{
                    Node<E> currentNode = head;
                    Node<E> prevNode = head;

                    while(currentNode.next != null){
                        prevNode = currentNode;
                        currentNode = currentNode.next;
                    }
                    prevNode.next = null;
                    selNode = prevNode;
                }
            }
        }

        public void remove(LinkedList.Node node){
            if(head != null){
                if(node == head){
                    removeFirst();
                }else{
                    Node<E> currentNode = head;

                    while (currentNode.next != node){
                        currentNode = currentNode.next;
                        if(currentNode == null){
                            return;
                        }
                    }
                    currentNode.next = node.next;
                    selNode = currentNode;
                }
            }
        }

        public void removeCurrentNode(){
            remove(selNode);
        }

        public void clear(){
            while (head != null){
                removeFirst();
            }
            selNode = null;
        }

        public boolean next(){
            if(selNode == null || selNode.next == null){
                return false;
            }
            selNode = selNode.next;
            return true;
        }

        public void printCurrentNode(){
            if(selNode == null){
                System.out.println("선택한 노드가 없음");
            }else{
                System.out.println(selNode.data);
            }
        }

        public void dump(){
            Node<E> currentNode = head;
            while (currentNode != null){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }

        public void purge(Comparator<? super E> c){
            Node<E> node = head;

            while(node != null){
                int count = 0;
                Node<E> nextNode = node;
                Node<E> preNode = node;

                while(preNode.next != null){
                    nextNode = preNode.next;
                    if (c.compare(node.data, nextNode.data) == 0){
                        preNode.next = nextNode.next;
                        count++;
                    }else{
                        preNode = nextNode;
                    }
                }
                if(count == 0){
                    node = node.next;
                }else{
                    Node<E> temp = node;
                    remove(node);
                    node = temp.next;
                }
            }
            selNode = head;
        }

        public E retrieve(int n){
            Node<E> node = head;

            while(n >= 0 && node != null){
                if(n-- == 0){
                    selNode = node;
                    return node.data;
                }
                node = node.next;
            }
            return (null);
        }
    }

    public static class LinkedListT<E> {

        class Node<E> {
            private E data;
            private Node<E> next;

            Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
        }

        private Node<E> head;
        private Node<E> tail;
        private Node<E> selNode;

        public LinkedListT(){
            head = selNode = null;
        }

        public E search(E object, Comparator<? super E> c){
            Node<E> currentNode = head;

            while (currentNode != null){
                if(c.compare(object, currentNode.data) == 0){
                    selNode = currentNode;
                    return currentNode.data;
                }
                selNode = currentNode.next;
            }
            return null;
        }

        public void addFirst(E object){
            Node<E> currentNode = head;
            head = selNode = new Node<E>(object, currentNode);
        }

        public void addLast(E object){
            if(head == null){
                addFirst(object);
            }else{
                tail.next = selNode = new Node<E>(object, null);
                tail = selNode;
            }
        }

        public void removeFirst(){
            if(head != null){
                head = selNode = head.next;
                if(head == null){
                    tail = null;
                }
            }
        }

        public void removeLast(){
            if(head != null){
                if(head.next == null) {
                    removeFirst();
                }else{
                    Node<E> currentNode = head;
                    Node<E> prevNode = head;

                    while(currentNode.next != null){
                        prevNode = currentNode;
                        currentNode = currentNode.next;
                    }
                    prevNode.next = null;
                    tail = selNode = prevNode;
                }
            }
        }

        public void remove(Node<E> node){
            if(head != null){
                if(node == head){
                    removeFirst();
                }else if(node == tail){
                    removeLast();
                }else{
                    Node<E> currentNode = head;

                    while (currentNode.next != node){
                        currentNode = currentNode.next;
                        if(currentNode == null){
                            return;
                        }
                    }
                    currentNode.next = node.next;
                    selNode = currentNode;
                }
            }
        }

        public void removeCurrentNode(){
            remove(selNode);
        }

        public void clear(){
            while (head != null){
                removeFirst();
            }
            selNode = null;
        }

        public boolean next(){
            if(selNode == null || selNode.next == null){
                return false;
            }
            selNode = selNode.next;
            return true;
        }

        public void printCurrentNode(){
            if(selNode == null){
                System.out.println("선택한 노드가 없음");
            }else{
                System.out.println(selNode.data);
            }
        }

        public void dump(){
            Node<E> currentNode = head;
            while (currentNode != null){
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }

        public void purge(Comparator<? super E> c){
            Node<E> node = head;

            while(node != null){
                int count = 0;
                Node<E> nextNode = node;
                Node<E> preNode = node;

                while(preNode.next != null){
                    nextNode = preNode.next;
                    if (c.compare(node.data, nextNode.data) == 0){
                        preNode.next = nextNode.next;
                        count++;
                    }else{
                        preNode = nextNode;
                    }
                }
                if(count == 0){
                    node = node.next;
                }else{
                    Node<E> temp = node;
                    remove(node);
                    node = temp.next;
                }
            }
            selNode = head;
        }

        public E retrieve(int n){
            Node<E> node = head;

            while(n >= 0 && node != null){
                if(n-- == 0){
                    selNode = node;
                    return node.data;
                }
                node = node.next;
            }
            return (null);
        }
    }
}