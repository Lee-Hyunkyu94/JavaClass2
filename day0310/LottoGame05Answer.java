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

public class LottoGame05Answer {
    static final int SIZE = 6;
    static final int NUMBER_MIN = 1;
    static final int NUMBER_MAX = 45;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();

        // 컴퓨터 숫자를 저장할 배열 computerArray
        int[] computerArray = new int[SIZE];
        // 사용자 숫자를 저장할 배열 userArray
        int[] userArray = new int[SIZE];
        // 입력할 index를 저장할 int 변수 idx
        int idx = 0;
        // 1. 컴퓨터 숫자 배열 숫자 넣기
        // A.while() 사용해서 idx 가 6보다 작은동안
        // 랜덤 숫자 생성해서 배열에 없으면 추가
        while (idx < SIZE) {
            // random의 nextInt를 사용하여 랜덤한 숫자를 하나 봅아서 int randomNumber에 저장한다.
            int randomNumber = ran.nextInt(6) + 1;

            // 만약 randomNumber 가 computerArray에 이미 존재하면 false, 그 외에는 true의 값을 갖는 boolean
            // numberChecker
            boolean numberChecker = true;

            // for 문을 사용하여
            // computerArray의 각 element를 체크해서
            // 만약 randomNumber와 값이 같은 element가 있을 경우 numberChecker의 값을 false로 할당한다.

            for (int i = 0; i < computerArray.length; i++) {

                if (randomNumber == computerArray[i]) {
                    numberChecker = false;
                    break;
                }
            }
            // numberChecker의 저장되 값이 true 일 경우에는 해당 숫자가 중복이 아니라는 의미이므로
            // computerArray의 idx index에 randomNumber를 할당해주고
            // idx++해준다
            if (numberChecker) {
                computerArray[idx] = randomNumber;
                idx++;
            }
        }
        // B.for() 사용해서 정렬
        for (int i = 0; i < computerArray.length - 1; i++) {
            if (computerArray[i] > computerArray[i + 1]) {
                int temp = computerArray[i];
                computerArray[i] = computerArray[i + 1];
                computerArray[i + 1] = temp;
                i = -1;
            }
        }
        // 2. 사용자 숫자 배열 숫자 넣기
        idx = 0;
        // A.while() 사용해서 idx 가 6보다 작은동안
        // 사용자한테 숫자 입력받아서 올바른 범위에 속하고
        // 배열에 없으면 추가
        while (idx < SIZE) {
            // 1. 사용자한테 숫자를 입력받는다.
            System.out.println((idx + 1) + "번째 숫자");
            System.out.println("> ");
            int userNumber = sc.nextInt();

            // 사용자의 숫자가 중복인지 아닌지를 확인하여 중복이면 false, 아니면 true를 할당받는 boolean 변수 inputChecker
            boolean inputChecker = true;
            // 2. 사용자의 숫자를 검증하고, 올바르지 않으면 다시 입력 받는다.
            while (!(userNumber >= NUMBER_MIN && userNumber <= NUMBER_MAX)) {
                System.out.println("잘못된 숫자입니다.");
                System.out.println((idx + 1) + "번째 숫자");
                System.out.println("> ");
                userNumber = sc.nextInt();
            }
            // 3. 사용자의 숫자가 중복인지 체크한다.

            for (int i = 0; i < userArray.length; i++) {
                if (userNumber == userArray[i]) {
                    inputChecker = false;
                    break;
                }
            }
            // 4. 중복이 아니면 idx 칸에 할당하고 idx ++, 중복이면 경고메시지만 출력
            if (inputChecker) {
                userArray[idx] = userNumber;
                idx++;
            } else {
                System.out.println("이미 입력하신 숫자입니다.");
            }

        }
        // B.for() 사용해서 정렬
        for (int i = 0; i < userArray.length - 1; i++) {
            if (userArray[i] == userArray[i + 1]) {
                int temp = userArray[i];
                userArray[i] = userArray[i + 1];
                userArray[i + 1] = temp;
                i = -1;

            }
        }

        // 3. 몇개가 맞았는지 확인

        // 맞은 갯수를 저장할 int count
        int count = 0;
        for (int i = 0; i < userArray.length; i++) {
            for (int j = 0; j < computerArray.length; j++) {
                if (userArray[i] == computerArray[j]) {
                    // 사용자 배열의 i번째 숫자가
                    // computerArray j번째 숫자와 같다라는 의미이므로
                    // count를 1 증가 시킨다
                    count++;
                    break;
                }

            }
        }

        // 4. 결과출력
        System.out.printf("사용자의 숫자: [%2d, %2d, %2d, %2d, %2d %2d]\n", userArray[0], userArray[1], userArray[2],
                userArray[3], userArray[4], userArray[5]);

        System.out.printf("컴퓨터의 숫자: [%2d, %2d, %2d, %2d, %2d %2d]\n", computerArray[0], computerArray[1],
                computerArray[2], computerArray[3], computerArray[4], computerArray[5]);

        System.out.println("맞은 갯수: " + count + "개");
        System.out.println("등수: " + (SIZE - count + 1) + "등");

        sc.close();
    }
}
