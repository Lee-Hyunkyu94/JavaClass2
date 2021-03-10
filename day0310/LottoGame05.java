package day0310;
// 사용자가 입력한 로또 번호와

// 컴퓨터가 만들어낸 로또 번호를 비교하여
// 사용자 숫자: [##, ##, ##, ##, ##]
// 컴퓨터 숫자: [##, ##, ##, ##, ##]
// 총 맞춘 숫자 : #개
// 등수 : #등
// 이 출력되는 프로그램을 작성하시오

import java.util.Random;

// 등수기준
// 6개 - 1등
// 5개 - 2등
// 4개 - 3등
// 3개 - 4등
// 2개 5등

// 12시 10분까지
import java.util.Scanner;

public class LottoGame05 {
    static final int SIZE = 6;
    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 45;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int[] lotto = new int[SIZE]; // userArray
        int[] lottoNumbers = new int[SIZE]; // computerArray
        int idx = 0;

        // 로또 번호 입력

        while (idx < lotto.length) {
            System.out.printf("%d번 숫자\n", idx + 1);
            System.out.println("> ");
            int userInput = sc.nextInt();

            while (!(userInput >= NUMBER_MIN && userInput <= NUMBER_MAX)) {
                System.out.println("잘못 입력하셨습니다");
                System.out.println("다시");
                System.out.println("> ");
                userInput = sc.nextInt();
            }
            boolean NC = true;

            for (int i = 0; i < lotto.length; i++) {
                if (userInput == lotto[i]) {
                    NC = false;

                    break;
                }

            }
            if (NC) {
                lotto[idx] = userInput;
                idx++;

            }
        } // 정렬
        for (int i = 0; i < lotto.length - 1; i++) {
            if (lotto[i] == lotto[i + 1]) {
                int temp = lotto[i];
                lotto[i] = lotto[i + 1];
                lotto[i] = temp;
                i = -1;
            }
        }
        // 컴퓨터 번호
        idx = 0;
        while (idx < SIZE) {
            System.out.printf("%d번 숫자\n", idx + 1);
            int comInput = ran.nextInt(NUMBER_MAX) + 1;
            boolean NC = true;

            for (int i = 0; i < lottoNumbers.length; i++) {
                if (comInput == lottoNumbers[i]) {
                    NC = false;
                    break;
                }
            }
            if (NC) {
                lottoNumbers[idx] = comInput;
                idx++;
            }
        } // 정렬
        for (int i = 0; i < lottoNumbers.length - 1; i++) {
            if (lottoNumbers[i] == lottoNumbers[i + 1]) {
                int temp = lottoNumbers[i];
                lottoNumbers[i] = lottoNumbers[i + 1];
                lottoNumbers[i + 1] = temp;
                i = -1;
            }
        }

        // 몇개 맞았는지 확인 (2중 for문 사용)

        int count = 0;
        for (int i = 0; i < lotto.length; i++) {
            for (int j = 0; j < lottoNumbers.length; j++) {
                if (lotto[i] == lottoNumbers[j]) {

                    count++;
                    break;
                }
            }
        }
        System.out.println("등수: " + (SIZE - count + 1) + "등");

        sc.close();

    }

}
