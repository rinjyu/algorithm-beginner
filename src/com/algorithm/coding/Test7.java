package com.algorithm.coding;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test7 {

    public static void main(String[] args) {
        // write your code here
        binarySearch1();
        binarySearch2();
        physicalSearch1();
        physicalSearch2();
        generic();
    }

    public static void binarySearch1(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수={}");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("오름차순으로 입력하세요.");
        System.out.println("0 번째값={}");
        array[0] = scanner.nextInt();

        for(int i = 1; i < array.length; i++){
            do{
                System.out.println(i + "번째값={}");
                array[i] = scanner.nextInt();
            }while (array[i] < array[i - 1]);
        }

        System.out.printf("검색할 값={}");
        int search = scanner.nextInt();
        System.out.print(scanner);

        int index = Arrays.binarySearch(array, search);

        if (index < 0) {
            int insPoint = -index - 1;
            System.out.println(search + "는 배열에 포함되어 있지 않습니다.");
            System.out.printf("삽입 포인트는 %d입니다.={}" + insPoint);
            System.out.printf("[%d]의 바로 앞에 %d를 삽입하면 배열의 정렬 상태가 유지됩니다.", insPoint, search);
        }else{
            System.out.println(search + "는 배열 " + index + "번째에 포함되어 있습니다.");
        }
    }

    public static void binarySearch2(){

        Scanner scanner = new Scanner(System.in);
        String[] keywords = {
                "abstract",   "assert",       "boolean",   "break",      "byte",
                "case",       "catch",        "char",      "class",      "const",
                "continue",   "default",      "do",        "double",     "else",
                "enum",       "extends",      "final",     "finally",    "float",
                "for",        "goto",         "if",        "implements", "import",
                "instanceof", "int",          "interface", "long",       "native",
                "new",        "package",      "private",   "protected",  "public",
                "return",     "short",        "static",    "strictfp",   "super",
                "switch",     "synchronized", "this",      "throw",      "throws",
                "transient",  "try",          "void",      "volatile",   "while"
        };

        System.out.print("원하는 키워드 입력={}");
        String keyword = scanner.next();
        System.out.print(keyword);

        int index = Arrays.binarySearch(keywords, keyword);
        if(index < 0){
            System.out.println("해당하는 키워드가 없습니다.");
        }else{
            System.out.println("해당 키워드는 " + index + "에 있습니다.");
        }
    }

    public static void physicalSearch1(){

        Scanner scanner = new Scanner(System.in);
        PhysicalData[] data = {
                new PhysicalData("AAA", 162, 0.3),
                new PhysicalData("BBB", 168, 0.4),
                new PhysicalData("CCC", 169, 0.8),
                new PhysicalData("DDD", 171, 1.5),
                new PhysicalData("EEE", 173, 0.7),
                new PhysicalData("FFF", 174, 1.2),
                new PhysicalData("GGG", 175, 2.0)
        };

        System.out.println("찾고자 하는 키를 입력하세요={}");
        int height = scanner.nextInt();
        int index = Arrays.binarySearch(data, new PhysicalData("", height, 0.0), PhysicalData.HEIGHT_ORDER);
        if(index < 0){
            System.out.println("찾고자 하는 키를 가진 사람이 없습니다.");
        }else{
            System.out.println("찾고자하는 키" + height + "는 " + index + "요소에 있습니다.");
            System.out.println(data[index]);
        }
    }

    static class PhysicalData{

        private String name;
        private int height;
        private double vision;

        PhysicalData(String name, int height, double vision){
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString(){
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhysicalData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysicalData> {

            public int compare(PhysicalData data1, PhysicalData data2) {
                return (data1.height > data2.height) ? 1 : (data1.height < data2.height) ? -1 : 0;
            }
        }

        public static final Comparator<PhysicalData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhysicalData> {
            public int compare(PhysicalData data1, PhysicalData data2){
                return (data1.vision > data2.vision) ? 1 : (data1.vision < data2.vision) ? -1 : 0;
            }
        }
    }

    public static void physicalSearch2(){

        Scanner scanner = new Scanner(System.in);
        PhysicalData[] data = {
                new PhysicalData("AAA", 162, 0.3),
                new PhysicalData("BBB", 168, 0.4),
                new PhysicalData("CCC", 169, 0.8),
                new PhysicalData("DDD", 171, 1.5),
                new PhysicalData("EEE", 173, 0.7),
                new PhysicalData("FFF", 174, 1.2),
                new PhysicalData("GGG", 175, 2.0)
        };

        System.out.println("찾고자 하는 시력을 입력하세요={}");
        double vision = scanner.nextDouble();
        int index = Arrays.binarySearch(data, new PhysicalData("", 0, vision), PhysicalData.VISION_ORDER);
        if(index < 0){
            System.out.println("찾고자 하는 시력을 가진 사람이 없습니다.");
        }else{
            System.out.println("찾고자하는 시력" + vision + "은 " + index + "요소에 있습니다.");
            System.out.println(data[index]);
        }
    }

    public static void generic(){
        GenericClass<String> cls1 = new GenericClass<String>("Saturday");
        GenericClass<Integer> cls2 = new GenericClass<Integer>(1031);

        System.out.println(cls1.getCls());
        System.out.println(cls2.getCls());
    }


    static class GenericClass<T>{

        private T cls;
        GenericClass(T cls){
            this.cls = cls;
        }

        T getCls(){
            return cls;
        }
    }

}

