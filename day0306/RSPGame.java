package day0306;
// 가위바위보게임

// 사용자가 1은 가위, 2는 바위, 3은 보로해서
// 컴퓨터와 가위바위보 게임을 한다.

// 1. 플레이
//    사용자가 1 ~ 3 사이의 숫자를 고르고
//    컴퓨터가 1 ~ 3 사이의 숫자를 고르고 나서
//    결과를 확인해서
//    승리, 무승부, 패배 3가지 중 하나를 정해서
//    기록한다.

// 2. 출력
//    출력은 플레이 기록이 존재할 경우
//    ###전 ###승 ###무 ###패(승률:###%)
//    printf 에서는 %를 "출력"해줄때 즉, % 문자가 아니라 글자 %를 출력할 때에는 %%라고 적어주면 된다!

// 3. 종료

// 이 세가지 기능을 가지고 가위바위보 게임을 만들어보세요(1시 10분까지)

import java.util.Random;
import java.util.Scanner;

public class RSPGame {
    static final int OPTION_SIZE = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        // 승 무 패를 저장할 int 변수
        int win = 0;
        int lose = 0;
        int draw = 0;

        while (true) {
            System.out.println("1. 플레이하기 2. 기록보기 3. 종료");
            System.out.println("> ");
            int userChoice = sc.nextInt();

            if (userChoice == 1) {
                // 플레이 코드 구현

                // 1. 컴푸터 숫자 추첨
                int computerNumber = random.nextInt(OPTION_SIZE) + 1;

                // 2. 사용자 숫자 입력

                System.out.println("1.가위, 2.바위, 3.보");
                System.out.println("> ");
                int userNumber = sc.nextInt();

                while (!(userNumber >= 1 && userNumber <= 3)) {
                    System.out.println("잘못입력하셨습니다");
                    System.out.println("1.가위, 2.바위, 3.보");
                    System.out.println("> ");
                    userNumber = sc.nextInt();

                }

                // 3. 컴퓨터와 사용자의 숫자 비교 후 결과 결정 및 출력

                // 각각 고른 선택지 출력해주기
                if (userNumber == 1) {
                    System.out.printf("사용자의 선택: [%s]\n", "가위");
                } else if (userNumber == 2) {
                    System.out.printf("사용자의 선택: [%s]\n", "바위");
                } else if (userNumber == 3) {
                    System.out.printf("사용자의 선택: [%s]\n", "보");
                }

                if (computerNumber == 1) {
                    System.out.printf("컴퓨터의 선택: [%s]\n", "가위");
                } else if (computerNumber == 2) {
                    System.out.printf("컴퓨터의 선택: [%s]\n", "바위");
                } else if (computerNumber == 3) {
                    System.out.printf("컴퓨터의 선택: [%s]\n", "보");
                }

                if (userNumber == computerNumber) {
                    // 두 숫자가 같다라는것은
                    // 무승부라는 의미가 됩니다.
                    System.out.println("무승부입니다.");
                    draw++;
                } else {
                    // 무승부가 아닐경우
                    // 사용자의 값에 대해 각각의 처리를 해준다.
                    if (userNumber == 1) {
                        // 사용자가 가위를 선택했을 경우

                        if (computerNumber == 2) {
                            System.out.println("졌습니다");
                            lose++;
                        } else if (computerNumber == 3) {
                            System.out.println("이겼습니다");
                            win++;
                        }
                    } else if (userNumber == 2) {
                        // 사용자가 바위를 선택했을 경우
                        if (computerNumber == 1) {
                            System.out.println("이겼습니다");
                            win++;
                        } else if (computerNumber == 3) {
                            System.out.println("졌습니다");
                            lose++;
                        }
                    } else if (userNumber == 3) {
                        // 사용자가 보를 선택했을경우
                        if (computerNumber == 1) {
                            System.out.println("졌습니다");
                            lose++;
                        } else if (computerNumber == 2) {
                            System.out.println("졌습니다");
                            lose++;

                        }

                    }

                }
            } else if (userChoice == 2) {
                // 기록 보기 코드 구현
                int total = win + lose + draw;

                if (total > 0) {
                    // 플레이 기록이 존재하므로 출력
                    double winRate = (double) win / total;
                    System.out.printf("%03d전 %03d승 %03d무 %03d패(승률: %6.2f%%)\n", total, win, draw, lose, winRate * 100);
                } else {
                    System.out.println("아직 플레이 기록이 없습니다.");
                    System.out.println("플레이를 해주십시오.");
                }
            } else if (userChoice == 3) {
                System.out.println("플레이해주셔서 감사합니다");
                System.out.println("프로그램 종료");
                break;
            }
        }
        sc.close();
    }
}