package com.algorithm.coding;

import java.util.Comparator;
import java.util.Scanner;

public class Test32 {

    public static void main(String[] args){
        // write your code here
        Task task;
        Data data;
        Data pointer;
        Data temp = new Data();

        class IntegerDecComparator implements Comparator<Integer> {
            public int compare(Integer n1, Integer n2) {
                return (n1 > n2) ? 1 : (n1 < n2) ? -1 : 0;
            }
        }

        final IntegerDecComparator INT_DEC_COMP = new IntegerDecComparator();

        BinTree<Integer, Data> tree = new BinTree<Integer, Data>();


        do {
            switch (task = SelectTask()) {

                case ADD :
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    tree.add(data.keyCode(), data);
                    break;

                case REMOVE :
                    temp.scanData("삭제", Data.NO);
                    tree.remove(temp.keyCode());
                    break;

                case SEARCH :
                    temp.scanData("검색", Data.NO);
                    pointer = tree.search(temp.keyCode());
                    if (pointer != null) {
                        System.out.println("그 번호의 이름은 " + pointer + "입니다.");
                    } else {
                        System.out.println("해당 데이터가 없습니다.");
                    }
                    break;

                case PRINT :
                    tree.print();
                    break;
            }
        } while (task != Task.TERMINATE);
    }

    public static class BinTree<K,V> {

        static class Node<K, V> {
            private K key;
            private V data;
            private Node<K, V> left;
            private Node<K, V> right;

            Node(K key, V data, Node<K, V> left, Node<K, V> right) {
                this.key = key;
                this.data = data;
                this.left = left;
                this.right = right;
            }

            K getKey() {
                return key;
            }

            V getValue() {
                return data;
            }

            void print() {
                System.out.println(data);
            }
        }

        private Node<K, V> root;
        private Comparator<? super K> comparator = null;

        public BinTree() {
            root = null;
        }

        public BinTree(Comparator<? super K> c) {
            this();
            comparator = c;
        }

        private int compare(K key1, K key2) {
            return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
        }

        public V search(K key) {
            Node<K, V> p = root;

            while (true) {
                if (p == null) {
                    return null;
                }
                int cond = compare(key, p.getKey());
                if (cond == 0) {
                    return p.getValue();
                } else if (cond < 0) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
        }

        private void addNode(Node<K, V> node, K key, V data) {
            int cond = compare(key, node.getKey());
            if (cond == 0) {
                return;
            } else if (cond < 0) {
                if (node.left == null){
                    node.left = new Node<K, V>(key, data, null, null);
                } else{
                    addNode(node.left, key, data);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node<K, V>(key, data, null, null);
                } else {
                    addNode(node.right, key, data);
                }
            }
        }

        public void add(K key, V data) {
            if (root == null) {
                root = new Node<K, V>(key, data, null, null);
            } else {
                addNode(root, key, data);
            }
        }

        public boolean remove(K key) {
            Node<K, V> p = root;
            Node<K, V> parent = null;
            boolean isLeftChild = true;

            while (true) {
                if (p == null) {
                    return false;
                }
                int cond = compare(key, p.getKey());
                if (cond == 0) {
                    break;
                } else {
                    parent = p;
                    if (cond < 0) {
                        isLeftChild = true;
                        p = p.left;
                    } else {
                        isLeftChild = false;
                        p = p.right;
                    }
                }
            }

            if (p.left == null) {
                if (p == root) {
                    root = p.right;
                }else if (isLeftChild) {
                    parent.left = p.right;
                }else {
                    parent.right = p.right;
                }
            } else if (p.right == null) {
                if (p == root) {
                    root = p.left;
                } else if (isLeftChild) {
                    parent.left = p.left;
                } else {
                    parent.right = p.left;
                }
            } else {
                parent = p;
                Node<K, V> left = p.left;
                isLeftChild = true;
                while (left.right != null) {
                    parent = left;
                    left = left.right;
                    isLeftChild = false;
                }
                p.key = left.key;
                p.data = left.data;
                if (isLeftChild) {
                    parent.left = left.left;
                } else {
                    parent.right = left.left;
                }
            }
            return true;
        }

        private void printSubTree(Node node) {
            if (node != null) {
                printSubTree(node.left);
                System.out.println(node.key + " " + node.data);
                printSubTree(node.right);
            }
        }

        public void print() {
            printSubTree(root);
        }

        private void printSubTreeR(Node node) {
            if (node != null) {
                printSubTreeR(node.right);
                System.out.println(node.key.toString() + " " + node.data.toString());
                printSubTreeR(node.left);
            }
        }

        public void printRerverse() {
            printSubTreeR(root);
        }

        private Node<K, V> getMinNode() {
            if (root == null) {
                return null;
            } else {
                Node<K, V> p = root;

                while (p.left != null) {
                    p = p.left;
                }
                return p;
            }
        }

        private Node<K, V> getMaxNode() {
            if (root == null) {
                return null;
            } else {
                Node<K, V> p = root;

                while (p.right != null) {
                    p = p.right;
                }
                return p;
            }
        }

        public K getMinKey() {
            Node<K, V> minNode = getMinNode();
            return (minNode == null ? null : minNode.getKey());
        }

        public V getDataWithMinKey() {
            Node<K, V> minNode = getMinNode();
            return (minNode == null ? null : minNode.getValue());
        }

        public K getMaxKey() {
            Node<K, V> maxNode = getMaxNode();
            return (maxNode == null ? null : maxNode.getKey());
        }

        public V getDataWithMaxKey() {
            Node<K, V> maxNode = getMinNode();
            return (maxNode == null ? null : maxNode.getValue());
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
        PRINT("출력"),
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