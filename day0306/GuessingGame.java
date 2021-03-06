package day0306;
// 숫자 맞추기 게임

// 1. 플레이 기능
//    플레이 기능에서는 컴퓨터가 1~100 사이의 랜덤한 숫자를 하나 뽑고
//    사용자가 그 숫자를 맞추는 기능이 구현되어있다.
//    사용자가 컴퓨터가 뽑은 숫자를 맞출 때 까지 계속 입력을 하되
//    사용자의 숫자가 더 클 경우에는 DOWN 이라는 메시지가 출력이 되고
//    사용자의 숫자가 더 작을 경우에는 UP 이라는 메시지가 출력이 된다.
//    사용자가 입력하는 숫자는 1 ~ 100 을 벗어날 수 없다.
//    또한, 사용자가 입력 할 때마다 점수가 1씩 추가 되서
//    결국 몇 번만에 맞췄는지 점수가 나오고
//    해당 점수가 최고기록보다 작으면, 그 점수가 새로운 최고 기족이 된다.

// 2. 최고기록 보기 기능
//    현재까지 플레이한 기록 중 가장 최고 기록을 보여준다.
//    단, 사용자가 플레이 했던 기록이 없을 경우, "아직 플레이 기록이 없습니다"라는 간단한 메시지만 출력해 준다.

// 3. 종료기능
//    프로그램을 종료시킨다.

import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        // 최고 점수를 저장할 변수
        int bestScore = 0;

        while (true) {
            System.out.println();
            System.out.println("1. 플레이, 2. 최고기록, 3. 종료");
            System.out.println("> ");
            int userChoice = sc.nextInt();
            if (userChoice == 1) {
                // 플레이 코드 구현

                // 현재 점수 변수 선언
                int currentScore = 0;

                // 1. 컴퓨터 숫자 결정
                int computerNumber = random.nextInt(NUMBER_MAX) + 1;

                // 2. 사용자의 입력
                // A. 숫자 입력
                System.out.println("1부터 100사이의 숫자를 입력해 주세요");
                System.out.println("> ");
                int userNumber = sc.nextInt();

                while (!(userNumber >= NUMBER_MIN && userNumber <= NUMBER_MAX)) {
                    System.out.println("잘못 입력하셨습니다.");
                    System.out.println("1부터 100사이의 숫자를 입력해주세요");
                    System.out.println("> ");
                    userNumber = sc.nextInt();

                }
                currentScore++;

                // B. 컴퓨터 숫자와 같을 때까지 입력
                while (computerNumber != userNumber) {
                    // 컴퓨터 숫자와 사용자의 숫자를 비교해서
                    // UP 혹은 DOWN 둘 중 하나를 출력해준다.
                    if (computerNumber > userNumber) {
                        System.out.println("UP");
                    } else {
                        System.out.println("down");
                    }
                    System.out.println("1부터 100사이의 숫자를 입력해주세요");
                    System.out.println("> ");
                    userNumber = sc.nextInt();

                    while (!(userNumber >= NUMBER_MIN && userNumber <= NUMBER_MAX)) {
                        System.out.println("잘못 입력하셨습니다.");
                        System.out.println("1부터 100사이의 숫자를 입력해주세요");
                        System.out.println("> ");
                        userNumber = sc.nextInt();

                    }
                    currentScore++;
                }
                    
                // 3. 이번 판 결과 출력
                // A. 축하 메시지
                System.out.println("짝짝짝 정답입니다!!! 짝짝짝");
                // B. 현재 점수 출력
                System.out.printf("사용자의 이번 라운드 기록: %3d회\n", currentScore);
                // C. 최고 기록 출력
                System.out.printf("현재 최고 기록: %3d회\n", bestScore);
                // D. 최고 기록 결정
                if(currentScore < bestScore) {
                    System.out.println("축하해요 님 1등이에요");
                    bestScore = currentScore;
                }
                
            } else if(userChoice == 2) {
                // 최고 기록 보기 코드 구현
                if(bestScore > 0 ) {
                    System.out.println();
                    System.out.printf("사용자의 최고 기록: %3d회\n", bestScore);
                    System.out.println();
                }else {
                    System.out.println();
                    System.out.println("아직 플레이 기록이 존재하지 않습니다.");
                    System.out.println();
                }
            }else if(userChoice == 3) {
                System.out.println("플레이해주셔서 감사합니다");
                System.out.println("게임 종료");
                break;
            }
        }
        
        sc.close();
    }

}
