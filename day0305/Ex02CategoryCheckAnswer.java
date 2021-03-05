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
// "아직 신체등급이 부여되지 않았습니다." 라는 메시지만 출력되게 하세요(20분)

import java.util.Scanner;

public class Ex02CategoryCheckAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 성별입력
        System.out.println("남성은 1, 여성은 2 성별을 입력해주십시오.");
        System.out.println("< ");
        int gender = sc.nextInt();

        // 성별을 통해 남자인지 여자인지 확인하여
        // 각각의 코드를 만들어준다.

        if (gender == 1) {
            // 남자이므로 나이를 입력받는다
            System.out.println("나이를 입력해주세요");
            System.out.println("< ");
            int age = sc.nextInt();

            // 나이를 통해 성인인지 미성년자인지 확인하여
            // 각각의 코드를 만들어준다

            if (age >= 19) {
                // 성인이므로 신체등급을 입력받는다
                System.out.println("신체등급을 입력해주세요");
                System.out.println("< ");
                int category = sc.nextInt();
                // 신체등급에 따른 코드구현을 한다.
                if (category <= 3) {
                    System.out.println("현역입니다");
                } else if (category == 4) {
                    System.out.println("공익입니다");
                } else {
                    System.out.println("면제입니다");
                }

            } else {
                // 미성년자이므로 경고메시지만 출력
                System.out.println("미성년자에게는 아직 신체등급이 부여되지 않았습니다");
            }

        } else if (gender == 2) {
            // 여자이므로 경고메시지만 출력
            System.out.println("여성에게는 국방의 의무가 부여되지 않습니다.");
        }

        sc.close();
    }

}
