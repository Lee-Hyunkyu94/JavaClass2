package day0305;
// Bmi Checker를

// 입력과 출력을 나눈 메뉴 버젼으로 고치시오.

import java.util.Scanner;

public class HomeWork01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double h = 0;
        double w = 0;
        double bmi = 0;

        boolean inputChecker = false;

        while (true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.println("> ");
            int userChoice = sc.nextInt();

            if (userChoice == 1) {
                System.out.println("키를 입력해 주십시오. (m)");
                System.out.println("> ");
                double userInput = 0;
                userInput = sc.nextDouble();

                while (userInput < 0 || userInput > 2.82) {
                    System.out.println("잘못된 정보입니다.");
                    System.out.println("키를 입력해 주십시오. (m)");
                    System.out.println("> ");
                    userInput = sc.nextDouble();
                }
                System.out.println("입력되었습니다.");
                h = userInput;

                System.out.println("몸무게를 입력해 주십시오. (kg)");
                System.out.println("> ");
                userInput = sc.nextDouble();

                while (userInput < 0 || userInput > 635) {
                    System.out.println("잘못된 정보입니다.");
                    System.out.println("몸무게를 입력해주십시오 (kg)");
                    System.out.println("> ");
                    userInput = sc.nextDouble();
                }
                System.out.println("입력되었습니다.");
                w = userInput;

                inputChecker = true;

            } else if (userChoice == 2) {
                if (inputChecker) {

                    bmi = w / h / h;
                    System.out.printf("bmi: " + "%.2f\n", bmi);

                    if (bmi < 18.5) {
                        System.out.println("저체중");
                    } else if (bmi < 23) {
                        System.out.println("정상체중");
                    } else if (bmi < 25) {
                        System.out.println("과체중");
                    } else {
                        System.out.println("비만");

                    }
                } else {
                    System.out.println("입력된 정보가 없습니다.");
                }
            } else if (userChoice == 3) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
        }
        sc.close();

    }

}
