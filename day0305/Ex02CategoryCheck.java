package day0305;
// 사용자로부터 성별, 나이, 신체등급순으로 입력 받아서

// 남성이고 19세 이상일시
// 1~3: 현역
// 4: 공익
// 그외: 면제가 출력되는 프로그램을 작성하시오
// 단, 성별을 입력받을 때에는 숫자값으로 입력 받아서 1이면 남자 2면 여자로 판정하도록 하겠습니다.

// 단, 여성일 시에는 추가적인 정보 입력없이
// "여성에게는 국방의 의무가 부여되지 않습니다" 라는 메시지만 출력되게 하세요

// 남자이지만 미성년자일 경우
// "아직 신체등급이 부여되지 안항ㅆ습니다." 라는 메시지만 출력되게 하세요(20분)

import java.util.Scanner;

public class Ex02CategoryCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 성별입력
        /*String man = new String();
        man = new String("1");
        String woman = new String();
        woman = new String("2"); // 알아서 숫자가 입력되게 하려면?
        */
        System.out.println("남성은 1, 여성은 2 성별을 입력해주십시오.");
        System.out.println("> ");
        int number = sc.nextInt();
        if (number == 1) {
            // 2. 나이입력
            System.out.println("나이를 입력해 주십시오");
            System.out.println("> ");
            int age = sc.nextInt();
            if (age >= 19) {
                // 3. 신체등급
                System.out.println("신체등급을 입력해 주십시오");
                System.out.println("> ");

                int grade = sc.nextInt();

                if (grade < 3) {
                    System.out.println("저런 현역이군요");
                } else if (grade == 4) {
                    System.out.println("공익입니다");
                } else {
                    System.out.println("축하합니다. 면제대상입니다.");
                }
            } else {
                System.out.println("아직 신체등급이 부여되지 않았습니다.");
            }

        } else {

            System.out.println("여성에게는 국방의 의무가 부여되지 않습니다.");
        }
        System.out.println("프로그램 종료");
        sc.close();
    }

}
