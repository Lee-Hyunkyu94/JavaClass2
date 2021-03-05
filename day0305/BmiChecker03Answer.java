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

// 만약 사용자가 잘못된 키 혹은 몸무게를 입력할 시
// 유효한 키, 몸무게를 입력할 때까지 다시 입력을 받으세요(50분까지)
import java.util.Scanner;

public class BmiChecker03Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 키를 입력 받고, 그 키가 유효한 입력인지 체크해서
        // 유효하지 않으면 유효한 값이 입력 될 때까지 다시 입력받는다.
        System.out.println("키를 입력하십시오.(m)");
        System.out.println("> ");
        double h = sc.nextDouble();

        while (!(h > 0 && h <= 2.82)) { // 좀더 편하게 범위를 잡기 위해서 !을 쓰는거지 || 써도 상관 x
            System.out.println("잘못입력하셨습니다.");
            System.out.println("다시 입력해주십시오.");
            System.out.println("> ");
            h = sc.nextDouble();
        }
        // 몸무게를 입력받고, 그 몸무게가 유효한 입력인지 체크해서
        // 유효하지 않으면 유효한 값이 입력될때까지 다시 입력받는다.
        System.out.println("몸무게를 입력하십시오.(kg)");
        System.out.println("> ");
        double w = sc.nextDouble();

        while (!(w > 0 && w <= 635)) {
            System.out.println("잘못 입력하셨습니다.");
            System.out.println("몸무게를 다시 입력해주십시오");
            w = sc.nextDouble();
        }
        // 입력이 끝났다라는 것은 모두 유효한 값이 있으므로 출력을 한다.

        double bmi = w / h / h;

        System.out.printf("%.2f\n", bmi);

        if (bmi < 18.5) {
            System.out.println("저체중");
        } else if (bmi < 23) {
            System.out.println("정상체중");
        } else if (bmi < 25) {
            System.out.println("과체중");
        } else {
            System.out.println("비만");
        }

        System.out.println("프로그램 종료");
        sc.close();

    }

}
