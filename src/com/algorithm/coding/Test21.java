package com.algorithm.coding;

import java.util.*;

public class Test21 {

    public static void main(String[] args) {
        // write your code here
        arraysSort();
        sortCaleandar();
        physicalAscSort();
        physicalDescSort();
    }

    public static void arraysSort(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("요소수 입력={}");
        int cnt = scanner.nextInt();
        int[] arrays = new int[cnt];
        for(int i = 0; i < cnt; i++){
            System.out.print(i + "값={}");
            arrays[i] = scanner.nextInt();
        }

        Arrays.sort(arrays);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < cnt; i++){
            System.out.println(i + "={}" + arrays[i]);
        }
    }

    public static void sortCaleandar(){

        GregorianCalendar[] calendars = {
          new GregorianCalendar(2019, Calendar.NOVEMBER, 1),
          new GregorianCalendar(1990, Calendar.JANUARY, 4),
          new GregorianCalendar(2005, Calendar.AUGUST, 21),
          new GregorianCalendar(2020, Calendar.NOVEMBER, 13),
        };

        Arrays.sort(calendars);

        for(int i = 0; i < calendars.length; i++){
            System.out.printf("%04d년 %02d월 %02d일", calendars[i].get(Calendar.YEAR), calendars[i].get(Calendar.MONTH) + 1, calendars[i].get(Calendar.DATE));
            System.out.println();
        }
    }

    public static void physicalAscSort(){

        Scanner scanner = new Scanner(System.in);

        Physical[] x = {
                new Physical("이나령", 162, 0.3),
                new Physical("전서현", 173, 0.7),
                new Physical("이수민", 175, 2.0),
                new Physical("홍준기", 171, 1.5),
                new Physical("유지훈", 168, 0.4),
                new Physical("이호연", 174, 1.2),
                new Physical("김한결", 169, 0.8),
        };

        System.out.println("오름차순 정렬할 순서를 입력해주세요(0 : 키, 1 : 시력)");
        int sort = scanner.nextInt();
        if(sort == 0){
            Arrays.sort(x, Physical.HEIGHT_ASC_ORDER);
        }else{
            Arrays.sort(x, Physical.VISION_ASC_ORDER);
        }

        System.out.println("신체 검사");
        System.out.println(" 이름       키        시력");
        System.out.println("--------------");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }
    }

    public static void physicalDescSort(){

        Scanner scanner = new Scanner(System.in);

        Physical[] x = {
                new Physical("이나령", 162, 0.3),
                new Physical("전서현", 173, 0.7),
                new Physical("이수민", 175, 2.0),
                new Physical("홍준기", 171, 1.5),
                new Physical("유지훈", 168, 0.4),
                new Physical("이호연", 174, 1.2),
                new Physical("김한결", 169, 0.8),
        };

        System.out.println("내림차순 정렬할 순서를 입력해주세요(0 : 키, 1 : 시력)");
        int sort = scanner.nextInt();
        if(sort == 0){
            Arrays.sort(x, Physical.HEIGHT_DESC_ORDER);
        }else{
            Arrays.sort(x, Physical.VISION_DESC_ORDER);
        }

        System.out.println("신체 검사");
        System.out.println(" 이름       키        시력");
        System.out.println("--------------");
        for (int i = 0; i < x.length; i++) {
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }
    }

    static class Physical {
        String name;
        int    height;
        double vision;

        Physical(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        static final Comparator<Physical> HEIGHT_ASC_ORDER = new HeightAscOrderComparator();
        static final Comparator<Physical> HEIGHT_DESC_ORDER = new HeightDescOrderComparator();
        static final Comparator<Physical> VISION_ASC_ORDER = new VisionAscOrderComparator();
        static final Comparator<Physical> VISION_DESC_ORDER = new VisionDescOrderComparator();

        private static class HeightAscOrderComparator implements Comparator<Physical> {
            public int compare(Physical d1, Physical d2) {
                return (d1.height > d2.height) ?  1 :
                        (d1.height < d2.height) ? -1 : 0;
            }
        }

        private static class VisionAscOrderComparator implements Comparator<Physical> {
            public int compare(Physical d1, Physical d2) {
                return (d1.vision > d2.vision) ?  1 :
                        (d1.vision < d2.vision) ? -1 : 0;
            }
        }

        private static class HeightDescOrderComparator implements Comparator<Physical> {
            public int compare(Physical d1, Physical d2) {
                return (d1.height < d2.height) ?  1 :
                        (d1.height > d2.height) ? -1 : 0;
            }
        }

        private static class VisionDescOrderComparator implements Comparator<Physical> {
            public int compare(Physical d1, Physical d2) {
                return (d1.vision < d2.vision) ?  1 :
                        (d1.vision > d2.vision) ? -1 : 0;
            }
        }
    }
}
