package day0315;

import java.util.Scanner;

import util.ArrayUtil;
import util.ScannerUtil;

// 성적관리프로그램을
// 인원제한이 없는 프로그램으로 ArrayUtil을 사용하여 만들어보세요
// (12시 20분까지)
public class GradeBook01 {
    static final int SUBJECT = 3;
    static final int MAX = 100;
    static final int MIN = 0;
    static final int KOREAN = 0;
    static final int ENGLISH = 1;
    static final int MATH = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userChoice = ScannerUtil.nextInt(sc, "1. 입력 2. 출력 3. 종료");
        int[] student = new int[0];
        for (int i = 0; i < student.length; i++) {
            int[] id = new int[student[i]];
            String[] name = new String[student[i]];
            int[][] score = new int[student[i]][SUBJECT];
            int index = 0;

            if (userChoice == 1) {
                student = addNumber(student);
                id[student[i]] = ScannerUtil.nextInt(sc, "번호를 입력하세요");
                name[student[i]] = ScannerUtil.nextLine(sc, "이름을 입력하세요");
                score[student[i]][KOREAN] = ScannerUtil.nextInt(sc, "국어 점수를 입력해주세요", MIN, MAX);
                score[student[i]][ENGLISH] = ScannerUtil.nextInt(sc, "영어 점수를 입력해주세요", MIN, MAX);
                score[student[i]][MATH] = ScannerUtil.nextInt(sc, "수학 점수를 입력해주세요", MIN, MAX);

            } else if (userChoice == 2) {
                print(student);

            } else if (userChoice == 3) {
                System.out.println("이용해주셔서 감사합니다.");
            }

        }
        sc.close();
    }

    // addNumber 로 인원제한 없는 ArrayUtil
    public static int[] addNumber(int[] members) {
        Scanner sc = new Scanner(System.in);
        int member = sc.nextInt();
        int[] temp = members;
        members = new int[ArrayUtil.size(members) + 1];
        for (int i = 0; i < ArrayUtil.size(temp); i++) {
            members[i] = temp[i];
        }
        members[ArrayUtil.size(members) - 1] = member;
        return members;

    }
    public static void print(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d", array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
