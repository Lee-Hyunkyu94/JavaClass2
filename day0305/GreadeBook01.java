package day0305;
// 사용자로부터 번호, 이름, 국어, 영어, 수학 을 입력받아

// 다음과 같은 양식으로 출력해주는 프로그램

// 번호: 0##번 이름: ###
// 국어: 0##점 영어: 0##점 수학: 0##점
// 총점: 0##점 평균: 0##.##점

// 단, 입력 기능과 출력 기능을 분리하여
// 사용자가 입력을 선택했을 때에만 입력을 하게되고
// 사용자가 출력을 선언했을 때에만 출력을 하게 하는 프로그램으로 만드시오.
// 또한 사용자가 잘못된 점수를 입력했을 경우, 올바른 점수를 입력할 때 까지 다시 입력을 받도록 하세요.

// 생각해볼것: 변수의 선언위치
// 심화문제: 만약 사용자가 아무런 정보를 입력 없이 출력을 누르면
//         "아직 아무런 입력이 되지 않았습니다"
//         라는 메시지만 출력되게 프로그램을 작성하시오.

import java.util.Scanner;

public class GreadeBook01 {
    static final int SUBJECT_SIZE = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력기능

        int id = 0;
        String name = new String();
        int korean = 0;
        int english = 0;
        int math = 0;
        
        // 사용자가 한번이라도 입력을 했느지를 저장할 boolean 변수
        boolean inputChecker = false;
        
        while (true) {
            System.out.println("1번. 입력 2번. 출력 3번. 종료");
            System.out.println("> ");
            int userChoice = sc.nextInt();
            // 입력
            // 1. 번호입력
            if (userChoice == 1) {
                System.out.println("번호를 입력하시오");
                System.out.println("> ");
                id = sc.nextInt();
                // 2. 이름입력
                sc.nextLine();
                System.out.println("이름을 입력하시오");
                System.out.println("> ");
                name = sc.nextLine();
                // 3. 점수입력

                System.out.println("점수를 입력하시오");
                System.out.println("국어");
                System.out.println("> ");
                korean = sc.nextInt();
                if (korean >= 0 && korean <= 100) {
                    System.out.println("입력 성공");
                } else {
                    System.out.println("점수를 다시 입력해 주십시오.");
                    korean = sc.nextInt();
                }
                System.out.println("영어 점수를 입력하십시오");
                System.out.println("> ");
                english = sc.nextInt();
                if (english >= 0 && english <= 100) {
                    System.out.println("입력성공");
                } else {
                    System.out.println("점수를 다시 입력해 주십시오.");
                    english = sc.nextInt();
                }
                System.out.println("수학 점수를 입력하십시오");
                System.out.println("> ");
                math = sc.nextInt();
                if (math >= 0 && math <= 100) {
                    System.out.println("입력성공");
                } else {
                    System.out.println("점수를 다시 입력해 주십시오.");
                    math = sc.nextInt();
                    
                    inputChecker = true;

                }

            } else if (userChoice == 2){
                double sum = korean + english + math;
                double average = sum / (double)SUBJECT_SIZE;
                
                System.out.printf("번호: %03d번 이름 %s\n", id, name);
                System.out.printf("국어: %03d점 영어: %03d점 수학: %03d\n", korean, english, math);
                System.out.printf("총점: %03f점 평균: %06.2f점\n", sum, average);

            }else if(userChoice == 3) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }

        }

        sc.close();
    }

}
