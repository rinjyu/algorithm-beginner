package com.algorithm.coding;

import java.util.Scanner;

public class Test34 {

    public static void main(String[] args){
        // write your code here
        Task task;
        Data data;
        Data temp = new Data();

        OpenHash<String, Data> hash = new OpenHash<String, Data>(13);

        do {
            switch (task = SelectTask()) {

                case ADD :
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    int type = hash.add(data.keyCode(), data);
                    switch (type) {
                        case 1:
                            System.out.println("그 키값은 이미 등록되어 있습니다.");
                            break;
                        case 2:
                            System.out.println("해시 테이블이 가득 찼습니다.");
                            break;
                    }
                    break;

                case REMOVE :
                    temp.scanData("삭제", Data.NAME);
                    hash.remove(temp.keyCode());
                    break;

                case SEARCH :
                    temp.scanData("검색", Data.NAME);
                    Data tempData = hash.search(temp.keyCode());
                    if (tempData != null) {
                        System.out.println("그 키를 갖는 데이터는 " + tempData + "입니다.");
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

    public static class OpenHash<K,V> {
        enum Status {OCCUPIED, EMPTY, DELETED};

        static class Bucket<K,V> {
            private K key;
            private V data;
            private Status status;

            Bucket() {
                status = Status.EMPTY;
            }

            void set(K key, V data, Status status) {
                this.key = key;
                this.data = data;
                this.status = status;
            }

            void setStatus(Status status) {
                this.status = status;
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

        private int size;
        private Bucket<K,V>[] table;

        public OpenHash(int size) {
            try {
                table = new Bucket[size];
                for (int i = 0; i < size; i++) {
                    table[i] = new Bucket<K, V>();
                }
                this.size = size;
            } catch (OutOfMemoryError e) {
                this.size = 0;
            }
        }

        public int hashValue(Object key) {
            return key.hashCode() % size;
        }

        public int rehashValue(int hash) {
            return (hash + 1) % size;
        }

        private Bucket<K,V> searchNode(K key) {
            int hash = hashValue(key);
            Bucket<K,V> p = table[hash];

            for (int i = 0; p.status != Status.EMPTY && i < size; i++) {
                if (p.status == Status.OCCUPIED && p.getKey().equals(key)) {
                    return p;
                }
                hash = rehashValue(hash);
                p = table[hash];
            }
            return null;
        }

        public V search(K key) {
            Bucket<K,V> p = searchNode(key);
            if (p != null) {
                return p.getValue();
            } else {
                return null;
            }
        }

        public int add(K key, V data) {
            if (search(key) != null) {
                return 1;
            }

            int hash = hashValue(key);
            Bucket<K,V> p = table[hash];
            for (int i = 0; i < size; i++) {
                if (p.status == Status.EMPTY || p.status == Status.DELETED) {
                    p.set(key, data, Status.OCCUPIED);
                    return 0;
                }
                hash = rehashValue(hash);
                p = table[hash];
            }
            return 2;
        }

        public int remove(K key) {
            Bucket<K,V> p = searchNode(key);
            if (p == null) {
                return 1;
            }
            p.setStatus(Status.DELETED);

            return 0;
        }

        public void dump() {
            for (int i = 0; i < size; i++) {
                System.out.printf("%02d ", i);
                switch (table[i].status) {
                    case OCCUPIED :
                        System.out.printf("%s (%s)\n", table[i].getKey(), table[i].getValue());
                        break;

                    case EMPTY :
                        System.out.println("-- 미등록 --");
                        break;

                    case DELETED :
                        System.out.println("-- 삭제 마침 --");
                        break;
                }
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer memNo;
        private String memName;

        String keyCode() {
            return memName;
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
        ADD("데이터 삽입"),
        REMOVE("데이터 삭제"),
        SEARCH("데이터 검색"),
        DUMP("모든 데이터 출력"),
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