package day0312;
// 입력과 출력을 메소드로 분리해서

// 6명의 학생을 관리하는 프로그램을 작성하시오
// (쉬는시간 포함 35분까지)

import util.ScannerUtil;
import java.util.Scanner;

public class GradeBook02 {
    static final int SIZE_STUDENT = 6;
    static final int SIZE_SUBJECT = 3;

    static final int SCORE_MIN = 0;
    static final int SCORE_MAX = 100;

    static final int INDEX_KOREAN = 0;
    static final int INDEX_ENGLISH = 1;
    static final int INDEX_MATH = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int idArray[] = new int[SIZE_STUDENT];

        String nameArray[] = new String[SIZE_STUDENT];

        int[][] scoreArray = new int[SIZE_STUDENT][SIZE_SUBJECT];

        int index = 0;

        while (true) {
            System.out.println();
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.println();
            int userChoice = sc.nextInt();

            if (userChoice == 1) {
                if (index < SIZE_STUDENT) {
                    insert(sc,index,idArray,nameArray,scoreArray);
                    index++;

                } else {
                    System.out.println("입력 학생을 초과하셨습니다.");
                }

            } else if (userChoice == 2) {
                // 출력 코드 구현
                if (index > 0) {
                    print(index, idArray, nameArray,scoreArray);
                } else {
                    System.out.println("입력이나 하고 오십쇼");
                }
            } else if (userChoice == 3) {
                // 종료
                System.out.println("이용해주셔서 감사합니다.");
                break;
            }

        }
        sc.close();
    }

    public static void insert(Scanner sc, int index, int idArray[], String nameArray[], int[][] scoreArray) {
        idArray[index] = ScannerUtil.nextInt(sc, "번호를 입력하세요");
        nameArray[index] = ScannerUtil.nextLine(sc, "이름을 입력하세요");
        scoreArray[index][INDEX_KOREAN] = ScannerUtil.nextInt(sc, "국어 점수를 입력해주세요", SCORE_MIN, SCORE_MAX);
        scoreArray[index][INDEX_ENGLISH] = ScannerUtil.nextInt(sc, "영어 점수를 입력해주세요", SCORE_MIN, SCORE_MAX);
        scoreArray[index][INDEX_MATH] = ScannerUtil.nextInt(sc, "수학 점수를 입력해주세요", SCORE_MIN, SCORE_MAX);

    } // 파라미터에 다 넣어도 상관없음. 메소드 많이 만들필요 x
    public static void print(int index, int[] idArray, String[] nameArray, int[][] scoreArray) {
        for (int i = 0; i < index; i++) {
            System.out.printf("번호: %03d번 이름: %s\n", idArray[i], nameArray[i]);
            System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점", scoreArray[i][INDEX_KOREAN],
                    scoreArray[i][INDEX_ENGLISH], scoreArray[i][INDEX_MATH]);
            System.out.println();
            int sum = scoreArray[i][INDEX_KOREAN] + scoreArray[i][INDEX_ENGLISH]
                    + scoreArray[i][INDEX_MATH];
            double average = (double) sum / SIZE_SUBJECT;
            System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
        }
        
    }
}
