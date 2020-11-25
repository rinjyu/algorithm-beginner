package com.algorithm.coding;

import java.util.Scanner;

public class Test33 {

    public static void main(String[] args){
        // write your code here
        Task task;
        Data data;
        Data temp = new Data();

        ChainHash<Integer, Data> hash = new ChainHash<Integer, Data>(13);

        do {
            switch (task = SelectTask()) {

                case ADD :
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    hash.add(data.keyCode(), data);
                    break;

                case REMOVE :
                    temp.scanData("삭제", Data.NO);
                    hash.remove(temp.keyCode());
                    break;

                case SEARCH :
                    temp.scanData("검색", Data.NO);
                    Data tempData = hash.search(temp.keyCode());
                    if (tempData != null) {
                        System.out.println("그 번호의 이름은 " + tempData + "입니다.");
                    } else {
                        System.out.println("해당 데이터가 없습니다.");
                    }
                    break;

                case DUMP :
                    hash.dump();
                    break;
            }
        } while (task != Task.TERMINATE);
    }

    public static class ChainHash<K,V> {

        static class Node<K, V> {
            private K key;
            private V data;
            private Node<K, V> next;

            Node(K key, V data, Node<K, V> next) {
                this.key = key;
                this.data = data;
                this.next = next;
            }

            K getKey() {
                return key;
            }

            V getValue() {
                return data;
            }

            public int hashCode() {
                return key.hashCode();
            }
        }

        private int	size;
        private Node<K,V>[] table;

        public ChainHash(int capacity) {
            try {
                table = new Node[capacity];
                this.size = capacity;
            } catch (OutOfMemoryError e) {
                this.size = 0;
            }
        }

        public int hashValue(Object key) {
            return key.hashCode() % size;
        }

        public V search(K key) {
            int hash = hashValue(key);
            Node<K, V> node = table[hash];;

            while (node != null) {
                if (node.getKey().equals(key)) {
                    return node.getValue();
                }
                node = node.next;
            }

            return null;
        }

        public int add(K key, V data) {
            int hash = hashValue(key);
            Node<K,V> node = table[hash];
            while (node != null) {
                if (node.getKey().equals(key)) {
                    return 1;
                }
                node = node.next;
            }
            Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
            table[hash] = temp;
            return 0;
        }

        public int remove(K key) {
            int hash = hashValue(key);
            Node<K, V> selNode = table[hash];
            Node<K,V> prevNode = null;

            while (selNode != null) {
                if (selNode.getKey().equals(key)) {
                    if(prevNode == null) {
                        table[hash] = selNode.next;
                    }else{
                        prevNode.next = selNode.next;
                    }
                }
                prevNode = selNode.next;
                selNode = selNode.next;
            }

            return 1;
        }

        public void dump() {
            for (int i = 0; i < size; i++) {
                Node<K,V> node = table[i];
                System.out.printf("%02d  ", i);
                while (node != null) {
                    System.out.printf("→ %s (%s)  ", node.getKey(), node.getValue());
                    node = node.next;
                }
                System.out.println();
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer memNo;
        private String memName;

        Integer keyCode() {
            return memNo;
        }

        public String toString(){
            return memName;
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
    }

    enum Task{
        ADD("삽입"),
        REMOVE("삭제"),
        SEARCH("검색"),
        DUMP("출력"),
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
        }while(key < Task.ADD.ordinal() || key > Task.TERMINATE.ordinal());
        return Task.TaskAt(key);
    }
}