package day0305;
//사용자로부터 점수를 입력받아서

//A, B, C, D, F 가 출력되는 프로그램을 작성하세요

//90점이상: A
//80점대: B
//70점대: C
//60점대: D
//그외: F

// 단, 사용자가 잘못된 점수를 입력할 경우,
// 올바른 점수를 입력할 때 까지 다시 입력을 받으세요(32분까지)
import java.util.Scanner;

public class GradeChecker03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("점수를 입력하세요");
        System.out.println("> ");
        double score = sc.nextDouble();

        while (score < 0 || score >= 100) {
            System.out.println("점수를 다시 입력하세요.");
            System.out.println("> ");
            score = sc.nextDouble();
        }
        if (score <= 100 && score >= 90) {
            System.out.println("A");
        } else if (score <= 90 && score >= 80) {
            System.out.println("B");
        } else if (score <= 80 && score >= 70) {
            System.out.println("C");
        } else if (score <= 70 && score >= 60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }

}
