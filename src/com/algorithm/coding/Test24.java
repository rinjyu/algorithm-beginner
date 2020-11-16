package com.algorithm.coding;

public class Test24 {

    public static void main(String[] args){
        // write your code here
        toStringTest();
        IntSetTest();
    }

    public static class IntSet1{

        private int max;
        private int num;
        private int[] set;

        public IntSet1(int capacity){
            num = 0;
            max = capacity;
            try{
                set = new int[max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public int capacity(){
            return max;
        }

        public int size(){
            return num;
        }

        public int indexOf(int n){
            for(int i = 0; i < num; i++){
                if(set[i] == n){
                    return i;
                }
            }
            return -1;
        }

        public boolean contains(int n){
            return (indexOf(n) != -1) ? true : false;
        }

        public boolean add(int n){
            if (num >= max || contains(n)){
                return false;
            }else{
                set[num++] = n;
                return true;
            }
        }

        public boolean add(IntSet1 s){
            boolean chk = false;
            for(int i = 0; i < num; i++){
                if(add(set[i])){
                    chk = true;
                }
            }
            return chk;
        }

        public boolean remove(int n){
            int index;
            if(num <= 0 || (index = indexOf(n)) == -1){
                return false;
            }else{
                set[index] = set[--num];
                return true;
            }
        }

        public void copyTo(IntSet1 s){
            int n = (s.max < num) ? s.max : num;
            for(int i = 0; i < n; i++){
                s.set[i] = set[i];
            }
            s.num = n;
        }

        public void copyFrom(IntSet1 s){
            int n = (max < s.num) ? max : s.num;
            for(int i = 0; i < n; i++){
                set[i] = s.set[i];
            }
            num = n;
        }

        public boolean equals(IntSet1 s){
            if(num != s.num){
                return false;
            }

            for(int i = 0; i < num; i++){
                if(set[i] == s.set[i]){
                    return false;
                }
            }

            return true;
        }

        public boolean equalTo(IntSet1 s){
            if(num != s.num){
                return false;
            }

            for(int i = 0; i < num; i++){
                int j = 0;
                for( ; j < s.num; j++){
                    if(set[i] == s.set[j]){
                        break;
                    }
                }
                if(j == s.num){
                    return false;
                }
            }
            return true;
        }

        public void unionOf(IntSet1 s1, IntSet1 s2) {
            copyFrom(s1);
            for(int i = 0; i < s2.num; i++){
                add(s2.set[i]);
            }
        }

        public String toString(){
            StringBuffer temp = new StringBuffer("{ ");
            for(int i = 0; i < num; i++){
                temp.append(set[i] + " ");
            }
            temp.append("}");
            return temp.toString();
        }

        public boolean isEmpty(){
            return num == 0;
        }

        public boolean isFull(){
            return num >= max;
        }

        public void clear(){
            num = 0;
        }

        public boolean retain(IntSet1 s){
            boolean chk = false;
            for(int i = 0; i < num; i++){
                if(!s.contains(set[i])){
                    remove(set[i]);
                    chk = true;
                }
            }
            return chk;
        }

        public boolean remove(IntSet1 s){
            boolean chk = false;
            for(int i = 0; i < num; i++){
                if(s.contains(set[i])){
                    remove(set[i]);
                    chk = true;
                }
            }
            return chk;
        }

        public boolean isSubsetOf(IntSet1 s){
            for(int i = 0; i < num; i++){
                int j = 0;
                for(; j < s.num; j++){
                    if(set[i] == s.set[j]){
                        break;
                    }
                }
                if(j == s.num){
                    return false;
                }
            }
            return true;
        }

        public boolean isProperSubsetOf(IntSet1 s){
            if(num >= s.num){
                return false;
            }
            return s.isSubsetOf(s);
        }

        public void intersectionOf(IntSet1 s1, IntSet1 s2){
            clear();
            for(int i = 0; i < s1.num; i++){
                if(s2.contains(s1.set[i])){
                    add(s1.set[i]);
                }
            }
        }

        public void differenceOf(IntSet1 s1, IntSet1 s2){
            clear();
            for(int i = 0; i < s1.num; i++){
                if(!s2.contains(s1.set[i])){
                    add(s1.set[i]);
                }
            }
        }
    }

    public static void toStringTest(){
        A a1 = new A();
        A a2 = new A();
        B b1 = new B(18);
        B b2 = new B(55);

        System.out.println("a1={}" + a1.toString());
        System.out.println("a2={}" + a2);
        System.out.println("b1={}" + b1.toString());
        System.out.println("b2={}" + b2);
    }

    public static void IntSetTest(){

        IntSet1 s1 = new IntSet1(20);
        IntSet1 s2 = new IntSet1(20);
        IntSet1 s3 = new IntSet1(20);

        s1.add(10);
        s1.add(15);
        s1.add(20);
        s1.add(25);

        s1.copyTo(s2);
        s2.add(12);
        s2.remove(25);

        s3.copyFrom(s2);

        System.out.println("s1={}" + s1);
        System.out.println("s2={}" + s2);
        System.out.println("s3={}" + s3);

        System.out.println("집합 s1에 15는 " + (s1.contains(15) ? "포함됩니다." : "포함되지 않습니다"));
        System.out.println("집합 s2에 25는 " + (s2.contains(25) ? "포함됩니다." : "포함되지 않습니다"));
        System.out.println("집합 s1과 s2는 " + (s1.equalTo(s2) ? "같습니다" : "같지 않습니다"));
        System.out.println("집합 s2와 s3은 " + (s2.equalTo(s3) ? "같습니다" : "같지 않습니다"));
        s3.unionOf(s1, s2);
        System.out.println("집합 s1과 s2의 합집합은 " + s3 + "입니다.");
    }

    public static class IntSet2{

        private int max;
        private int num;
        private int[] set;

        public IntSet2(int capacity){
            num = 0;
            max = capacity;
            try{
                set = new int[max];
            }catch (OutOfMemoryError e){
                max = 0;
            }
        }

        public int capacity(){
            return max;
        }

        public int size(){
            return num;
        }

        public int indexOf(int n){
            for(int i = 0; i < num; i++){
                if(set[i] == n){
                    return i;
                }
            }
            return -1;
        }

        public boolean contains(int n){
            return (indexOf(n) != -1) ? true : false;
        }

        public boolean add(int n){
            int index;
            if (num >= max || (index = indexOf(n)) >= 0){
                return false;
            }else{
                index = -(index + 1);
                num++;
                for(int i = num - 1; i > index; i--){
                    set[i] = set[i - 1];
                }
                set[index] = n;
                return true;
            }
        }

        public boolean add(IntSet2 s){
            boolean chk = false;
            for(int i = 0; i < num; i++){
                if(add(set[i])){
                    chk = true;
                }
            }
            return chk;
        }

        public boolean remove(int n){
            int index;
            if(num <= 0 || (index = indexOf(n)) == -1){
                return false;
            }else{
                num--;
                for(int i = index; i > num; i++){
                    set[i] = set[i + 1];
                }
                return true;
            }
        }

        public void copyTo(IntSet2 s){
            int n = (s.max < num) ? s.max : num;
            for(int i = 0; i < n; i++){
                s.set[i] = set[i];
            }
            s.num = n;
        }

        public void copyFrom(IntSet2 s){
            int n = (max < s.num) ? max : s.num;
            for(int i = 0; i < n; i++){
                set[i] = s.set[i];
            }
            num = n;
        }

        public boolean equals(IntSet2 s){
            if(num != s.num){
                return false;
            }

            for(int i = 0; i < num; i++){
                if(set[i] == s.set[i]){
                    return false;
                }
            }

            return true;
        }

        public boolean equalTo(IntSet2 s){
            if(num != s.num){
                return false;
            }

            for(int i = 0; i < num; i++){
                int j = 0;
                for( ; j < s.num; j++){
                    if(set[i] == s.set[j]){
                        break;
                    }
                }
                if(j == s.num){
                    return false;
                }
            }
            return true;
        }

        public void unionOf(IntSet2 s1, IntSet2 s2) {
            copyFrom(s1);
            for(int i = 0; i < s2.num; i++){
                add(s2.set[i]);
            }
        }

        public String toString(){
            StringBuffer temp = new StringBuffer("{ ");
            for(int i = 0; i < num; i++){
                temp.append(set[i] + " ");
            }
            temp.append("}");
            return temp.toString();
        }

        public boolean isEmpty(){
            return num == 0;
        }

        public boolean isFull(){
            return num >= max;
        }

        public void clear(){
            num = 0;
        }

        public boolean retain(IntSet2 s){
            boolean chk = false;
            for(int i = 0; i < num; i++){
                if(!s.contains(set[i])){
                    remove(set[i]);
                    chk = true;
                }
            }
            return chk;
        }

        public boolean remove(IntSet2 s){
            boolean chk = false;
            for(int i = 0; i < num; i++){
                if(s.contains(set[i])){
                    remove(set[i]);
                    chk = true;
                }
            }
            return chk;
        }

        public boolean isSubsetOf(IntSet2 s){
            for(int i = 0; i < num; i++){
                int j = 0;
                for(; j < s.num; j++){
                    if(set[i] == s.set[j]){
                        break;
                    }
                }
                if(j == s.num){
                    return false;
                }
            }
            return true;
        }

        public boolean isProperSubsetOf(IntSet2 s){
            if(num >= s.num){
                return false;
            }
            return s.isSubsetOf(s);
        }

        public void intersectionOf(IntSet2 s1, IntSet2 s2){
            clear();
            for(int i = 0; i < s1.num; i++){
                if(s2.contains(s1.set[i])){
                    add(s1.set[i]);
                }
            }
        }

        public void differenceOf(IntSet2 s1, IntSet2 s2){
            clear();
            for(int i = 0; i < s1.num; i++){
                if(!s2.contains(s1.set[i])){
                    add(s1.set[i]);
                }
            }
        }
    }
}

class A{

}

class B{
    int x;

    B(int x){
        this.x = x;
    }

    public String toString(){
        return "B[" + x + "]";
    }
}
