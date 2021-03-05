package day0305;
//사용자로부터 키와 몸무게를 입력 받아서

//사용자의 bmi 수치를 소숫점 2번째 자리까지 출력하고
//사용자의 체형이 어디에 속하는지도 출력하세요
//bmi 공식: 몸무게(kg) / 키 (m) / 키 (m)
//체형 기준
//~18.5 미만: 저체중
//~23미만:정상체중
//~25미만: 과체중
//그외: 비만

// 기네스북에 따르면 세상에서 가장 키가 컸던 사람의 키는 2.82m였습니다.
// 기네스북에 따르면 세상에서 가장 몸무게가 많이 나갔던 사람의 무게는 635kg이었습니다.

// 키를 잘못 입력하면 추가적인 입력 없이 경고 메시지만 출력하시오
// 몸무게를 잘못 입력하면 결과 출력 대신 경고 메시지만 출력하시오.(쉬는시간 포함 45분까지)
import java.util.Scanner;

public class BmiChecker02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 키 입력
        System.out.println("키를 입력하시오. (m)");
        System.out.println("> ");
        double h = sc.nextDouble();

        if (h > 0 && h <= 2.82) {
            // 2. 몸무게 입력
            System.out.println("몸무게를 입력하시오.(kg)");
            System.out.println("> ");
            double w = sc.nextDouble();
            if (w > 0 && w <= 635) {
                // bmi 체크
                double bmi = w / h / h;
                System.out.printf("당신의 bmi: " + "[%.2f]\n", bmi);
                if (bmi > 0) {

                    if (bmi < 18.5) {
                        System.out.println("당신은 저체중입니다.");
                    } else if (bmi < 23) {
                        System.out.println("당신은 정상체중입니다.");
                    } else if (bmi < 25) {
                        System.out.println("당신은 과체중입니다.");
                    } else {
                        System.out.println("당신은 비만입니다.");
                    }
                }
            } else {
                System.out.println("몸무게를 잘못 입력하셨습니다.");
            }
        } else {
            System.out.println("키를 잘못 입력하셨습니다.");
        }
        sc.close();

    }

}
