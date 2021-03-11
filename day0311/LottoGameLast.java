package day0311;
// 로또게임 최종판

// 사용자로부터 몇 번을 할건지 입력을 받고
// 그리고 각 게임을 수동으로 할지 자동으로 할지 입력받아서
// 최종적으로 컴퓨터의 숫자와 대조하여 각 게임의 맞춘 갯수 등수를 출력하게 만드시오

// 예시
// 몇번 플레이하시겠습니까? 5번
// 1번 게임을 수동/자동 중 어떤걸로 하시겠습니까?(1: 수동 2: 자동)
// 2
// 2번 게임을 수동/자동 중 어떤걸로 하시겠습니까?(1: 수동 2: 자동)
// 1
// 첫번째 숫자를 입력해주세요: 33
//            ...
// 5번 게임을 수동/자동 중 어떤걸로 하시겠습니까?(1: 수동 2: 자동)
// 2
// 컴퓨터의 숫자 : [##, ##, ##, ##, ##, ##]
// 사용자의 숫자
// 1번 게임: [##, ##, ##, ##, ##, ##] - 4개 3등
// 1번 게임: [##, ##, ##, ##, ##, ##] - 5개 2등
// 1번 게임: [##, ##, ##, ##, ##, ##] - 6개 1등
// 1번 게임: [##, ##, ##, ##, ##, ##] = 3개 4등
// 1번 게임: [##, ##, ##, ##, ##, ##] - 0개 등수없음

import java.util.Scanner;
import java.util.Random;

public class LottoGameLast {
    static final int MAX = 45;
    static final int MIN = 1;
    static final int SIZE = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int[] computerArray = new int[SIZE];
        int[] userArray = new int[SIZE];
        int index = 0;

        while (true) {
            System.out.println("1. 게임시작 2. 결과확인 3. 종료");
            System.out.print("> ");
            int userChoice = sc.nextInt();
            System.out.println();

            
                if (index < SIZE) {
                    // 입력
                    System.out.println("몇번 플레이하시겠습니까?");
                    System.out.print("> "); // 예시 5번
                    int userGameSize = sc.nextInt();
                    int[][] UA = new int[userGameSize][SIZE];
                    
                    for (int i = 0; i < UA.length; i++) {
                        System.out.println("1. 수동 2. 자동");
                        System.out.print("> ");
                        int UC = sc.nextInt();

                        index = 0;

                        if (UC == 1) {
                            while (index < UA[i].length) {
                                System.out.println((index + 1) + "번 숫자를 입력하시오");
                                int userNumber = sc.nextInt();

                                boolean inputSwitch = userNumber >= MIN && userNumber <= MAX;

                                for (int j = 0; j < UA.length; j++) {
                                    if (userNumber == userArray[j]) {
                                        inputSwitch = false;
                                        break;
                                    }
                                }
                                if (inputSwitch) {
                                    UA[i][index] = userNumber;
                                    index++;

                                } else {
                                    System.out.println("~~~~~");
                                }
                            }
                        } else {
                            while (index < SIZE) {
                                int randomNumber = ran.nextInt(MAX) + 1;

                                boolean inputSwitch = true;

                                for (int j = 0; j < UA[i].length; j++) {
                                    if (randomNumber == UA[i][j]) {
                                        inputSwitch = false;
                                        break;
                                    }
                                }
                                if (inputSwitch) {
                                    UA[i][index] = randomNumber;
                                    index++;
                                }
                            }
                        }

                    }
                }

                else {
                    System.out.println("더이상 이용하실수 없습니다.");
                }
                while (index < SIZE) {
                    int randomNumber = ran.nextInt(MAX) + 1;

                    boolean inputSwitch = true;

                    for (int i = 0; i < computerArray.length; i++) {
                        if (randomNumber == computerArray[i]) {
                            inputSwitch = false;
                            break;
                        }
                    }if(inputSwitch) {
                        computerArray[index] = randomNumber;
                        index++;
                    }
                }

            for(int i = 0; i < computerArray.length -1;i++) {
                if(computerArray[i] >computerArray[i+1]) {
                    int temp = computerArray[i];
                            computerArray[i] = computerArray[i+1];
                    computerArray[i+1]=temp;
                    i =-1;
                }
            }for(int i =0;i<UA.length;i++) {
                
            }
            

        sc.close();

    }

}}
