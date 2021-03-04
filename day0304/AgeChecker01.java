package day0304;
// 사용자로부터 나이를 입력 받아서
// ~5 이하: 영아
// ~13 이하: 어린이
// ~18 이하: 청소년
// 그외: 성인
// 이 출력되는 프로그램을 작성해보세요

import java.util.Scanner;

public class AgeChecker01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("나이를 입력하시오");
        System.out.println("> ");
        int age = sc.nextInt();
        
        if(age <= 5) {
            System.out.println("영아");
        } else if(age > 5 && age <= 13) {
            System.out.println("어린이");
        } else if(age > 13 && age <= 18) {
            System.out.println("청소년");
        } else {
            System.out.println("성인");
        }
        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

}
