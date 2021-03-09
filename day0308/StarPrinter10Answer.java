package day0308;

// 별찍기 10번

import java.util.Scanner;

public class StarPrinter10Answer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("출력할 줄 수를 입력하세요");
        System.out.print("> ");
        int userNumber = sc.nextInt();

        int maxLength = 2 * userNumber - 1;

        for (int i = 1; i <= maxLength; i++) {
            String stars = new String();

            if (i == 1 || i == maxLength) {
                // 첫번째 줄 혹은 마지막 줄이므로
                // 별을 9개만 넣어준다

                // 별을 담당하는 j for 문
                for (int j = 1; j <= maxLength; j++) {
                    stars += "*";
                }

            } else {
                // 그 외의 경우
                // 윗부분이건 아랫부분이건
                // 별 - 공백 - 별 이라는 형태이므로
                // if-else 구조를 통해 별의 갯수와 공백의 갯수를 정하고
                // j for문 3개를 만들어 각각의 갯수만큼의 별과 공백을
                // stars에 추가해준다

                // 해방 줄의 별의 갯수를 저장할 int starWidth
                int starWidth = 0;
                // 해당 줄의 공백의 갯수를 저장할 int spaceWidth
                int spaceWidth = 0;

                // starWidth 와 spaceWidth의 값을 정하는 if - else
                if (i < userNumber) {
                    // 윗부분

                    // 윗부분일 때 사용될 int upperI
                    int upperI = i - 1; // i = 2, 3, 4 //upperI = 1, 2, 3
                    starWidth = userNumber - upperI;
                    
                    
                } else {
                    // 아랫부분

                    // 아랫부분일 때 사용될 int lowerI
                    int lowerI = i - userNumber + 1; // i = 5, 6, 7, 8
                    starWidth = lowerI;

                }
                // 공백의 갯수는 윗부분이건 아랫부분이건
                // 총 너비 - 왼쪽 별의 갯수 - 오른쪽 별의 갯수이고
                // 왼쪽 별의 갯수와 오른쪽 별의 갯수는 둘다 starWidth 이다.
                // 따라서 아래와 같이
                // 공백의 갯수 = 총 너비 - 2 * 별의 갯수 로 적어줄 수 있다
                spaceWidth = maxLength - 2 * starWidth;

                // 왼쪽 별을 담당하는 j for 문
                for (int j = 1; j <= starWidth; j++) {
                    stars += "*";
                }

                // 가운데 별을 담당하는 j for 문
                for (int j = 1; j <= spaceWidth; j++) {
                    stars += " ";
                }
                // 오른쪽 별을 담당하는 j for 문
                for (int j = 1; j <= starWidth; j++) {
                    stars += "*";
                }
            }
            System.out.println(stars);
            sc.close();
        }
    }
}