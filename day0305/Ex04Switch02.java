package day0305;
// 의도적으로 break를 생략해서 switch문 코드를 좀 간략하게 만들어보자

// 사용자로부터 월을 입력받아서
// 해당 월의 마지마 날이 몇일인지 보여주는 프로그램

import java.util.Scanner;

public class Ex04Switch02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 월 입력
        System.out.println("월을 입력하세요.");
        System.out.println("> ");
        int month = sc.nextInt();

        switch (month) {
        case 2:
            System.out.println("28일까지입니다.");
            break;
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            System.out.println("31일까지입니다.");
            break;
        case 4:
        case 6:
        case 9:
        case 11:
            System.out.println("30일까지입니다.");
            break;
        }
        System.out.println("시스템이 종료됩니다.");
        sc.close();
    }

}
