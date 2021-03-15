package day0315;

import java.util.Scanner;
import util.ArrayUtil;
import util.ScannerUtil;

// 성적관리프로그램을
// 인원제한이 없는 프로그램으로 ArrayUtil을 사용하여 만들어보세요
// (12시 20분까지)
public class GradeBook03UsingStudentArray {
    static final int SUBJECT = 3;
    static final int MAX = 100;
    static final int MIN = 0;
    int id;
    String name;
    int korean;
    int english;
    int math;
    Student s = new Student(id, name, korean, english, math);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] idArray = new int[0];
        String[] nameArray = new String[0];
        int[][] scoreArray = new int[SUBJECT][0];

        while (true) {
            int userChoice = ScannerUtil.nextInt(sc, "1. 입력 2. 출력 3. 종료");
            if (userChoice == 1) {
                // 입력 코드 구현

                // 번호 입력
                int id = ScannerUtil.nextInt(sc, "번호를 입력해주세요");

                // 이름 입력
                String name = new String(ScannerUtil.nextLine(sc, "이름을 입력해주세요"));

                // 국어 점수 입력
                int korean = ScannerUtil.nextInt(sc, "국어 점수를 입력해주세요", MIN, MAX);

                // 영어 점수 입력
                int english = ScannerUtil.nextInt(sc, "영어 점수를 입력해주세요", MIN, MAX);

                // 수학 점수 입력
                int math = ScannerUtil.nextInt(sc, "수학 점수를 입력해주세요", MIN, MAX);

                idArray = ArrayUtil.add(idArray, id);
                nameArray = ArrayUtil.add(nameArray, name);
                scoreArray[0] = ArrayUtil.add(scoreArray[0], korean);
                scoreArray[1] = ArrayUtil.add(scoreArray[1], english);
                scoreArray[2] = ArrayUtil.add(scoreArray[2], math);

            } else if (userChoice == 2) {
                // 출력 코드 구현
                if (ArrayUtil.size(idArray) == 0) {
                    System.out.println("아직 입력된 정보가 없습니다.");
                }else {
                    
                }
                
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다");
                break;
            }
        }

        sc.close();
    }

    // 출력에서 사용할 메소드
   
    public int calculateSum() {
        return korean + english + math;
    }
    public double calculateAverage() {
        return calculateSum() / 3.0;
    }
    public void showInfo() {
        System.out.printf("번호: %02d 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점 %03d점 평균 : %06.2f점\n", calculateSum(), calculateAverage());
    }
    
    

}
