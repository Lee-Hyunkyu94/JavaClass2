package day0305;
// 사용자로부터 숫자를 입력받아서

// 출력하는 프로그램.
// 단 사용자가 자연수가 아닌 숫자를 입력한다면
// 자연수를 입력할때까지 다시 입력을 받는다

import java.util.Scanner;

public class Ex06While02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("자연수를 입력해주세요");
        System.out.println("> ");
        int number = sc.nextInt();

        while (!(number >= 0)) {
            System.out.println("잘못입력하셨습니다");
            System.out.println("자연수를 다시 입력해 주세요");
            System.out.println("> ");
            number = sc.nextInt();
        }

        System.out.println("사용자가 입력한 자연수: " + number);
        
        sc.close();
    }

}
