package day0304;
// 사용자로부터 나이를 입력 받아서
// ~5 이하: 영아
// ~13 이하: 어린이
// ~18 이하: 청소년
// 그외: 성인
// 이 출력되는 프로그램을 작성해보세요

import java.util.Scanner;

public class AgeChecker01Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("나이");
        System.out.println("> ");
        int age = sc.nextInt();
        
        if(age <= 5) {
            System.out.println("영아입니다.");
        }else if (age <=13 && age > 5) {
            System.out.println("어린이입니다.");
        }else if (age <= 18 && age > 13) {
            System.out.println("청소년입니다.");
        }else {
            System.out.println("성인입니다.");
        }
        
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

}
