package gradeBook;

import java.util.ArrayList;
import java.util.Scanner;

import util.ScannerUtil;

public class GradeBookEX01 {
    // 학생 배열
    private final static ArrayList<Student> studentList = new ArrayList<>();
    // 선생 배열
    private final static ArrayList<Teacher> teacherList = new ArrayList<>();
    // 평가 배열
    private final static ArrayList<Evaluation> evalueList = new ArrayList<>();
    // 현재 로그인한 학생 회원
    private static Student SlogIn = null;
    // 현재 로그인한 선생 회원
    private static Teacher TlogIn = null;
    // 학생 회원 번호 저장
    private static int SId = 1;
    // 선생 회원 번호 저장
    private static int TId = 1;

    private final static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    // 맨처음 로그인 회원가입 창
    private static void index() {
        while (true) {
            System.out.println("+++++++++++++++++++++++++");
            System.out.println("     GRADE BOOK EX 01    ");
            System.out.println("+++++++++++++++++++++++++");
            String message = new String("1. 로그인 2. 회원가입 3. 종료");
            int userChoice = ScannerUtil.nextInt(sc, message, 1, 3);

            if (userChoice == 1) {
                userChoice = 0;
                message = new String("1.학생 로그인 2. 선생님 로그인 3. 뒤로가기");
                userChoice = ScannerUtil.nextInt(sc, message, 1, 3);
                if (userChoice == 1) {
                    if (studentList.isEmpty()) {
                        System.out.println();
                        System.out.println("아직 등록된 회원이 없습니다.");
                        System.out.println();
                    } else {
                        // 로그인 메소드 실행
                        studentLogIn();
                        // 로그인 성공하면 메뉴 메소드 실행
                        if (SlogIn != null) {
                            showMenu();
                        }
                    }

                }
                if (userChoice == 2) {
                    if (teacherList.isEmpty()) {
                        System.out.println();
                        System.out.println("아직 등록된 선생님이 없습니다.");
                        System.out.println();
                    } else {
                        // 로그인 메소드 실행
                        teacherLogIn();
                        if (TlogIn != null) {
                            showMenu();
                        }
                    }
                }

            } else if (userChoice == 2) {
                // 회원가입 메소드 실행
                userChoice = 0;
                message = new String("1. 학생 회원가입 2. 선생님 회원가입 3. 뒤로가기");
                userChoice = ScannerUtil.nextInt(sc, message, 1, 3);
                if (userChoice == 1) {
                    // 학생 회원가입 메서드 실행

                } else if (userChoice == 2) {
                    // 선생 회원가입 메서드 실행

                } else if (userChoice == 3) {
                    index();
                }
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // showMenu 메소드
    private static void showMenu() {

    }

    // studentLogIn 메소드
    private static void studentLogIn() {
        Student s = new Student();
        String message = new String("아이디를 입력해 주세요.");
        s.setLogId(ScannerUtil.nextLine(sc, message));

        message = new String("비밀번호를 입력해 주세요");
        s.setLogPw(ScannerUtil.nextLine(sc, message));

        SlogIn = auth(s);

        while (SlogIn == null) {
            System.out.println();
            System.out.println("해당하는 정보와 일치하는 회원이 없습니다.");
            System.out.println("다시 아이디와 비밀번호를 입력해주세요.");
            System.out.println();

            message = new String("아이디를 입력해주세요. 만약 뒤로 가시려면 x를 입력해주세요.");
            s.setLogId(ScannerUtil.nextLine(sc, message));
            if (s.getLogId().equalsIgnoreCase("X")) {
                break;
            }
            message = new String("비밀번호를 입력해 주세요.");
            s.setLogPw(ScannerUtil.nextLine(sc, message));

            SlogIn = auth(s);

        }

    }

    private static Student auth(Student s) {
        for (int i = 0; i < studentList.size(); i++) {
            if (s.logIn(studentList.get(i))) {
                return studentList.get(i);
            }

        }
        return null;
    }

    // teacherLogIn 메소드
    private static void teacherLogIn() {
        Teacher t = new Teacher();
        String message = new String("아이디를 입력해 주세요.");
        t.setLogTId(ScannerUtil.nextLine(sc, message));

        message = new String("비밀번호를 입력해 주세요");
        t.setLogTPw(ScannerUtil.nextLine(sc, message));

        TlogIn = auth(t);

        while (TlogIn == null) {
            System.out.println();
            System.out.println("해당하는 정보와 일치하는 회원이 없습니다.");
            System.out.println("다시 아이디와 비밀번호를 입력해주세요.");
            System.out.println();

            message = new String("아이디를 입력해주세요. 만약 뒤로 가시려면 x를 입력해주세요.");
            t.setLogTId(ScannerUtil.nextLine(sc, message));
            if (t.getLogTId().equalsIgnoreCase("X")) {
                break;
            }
            message = new String("비밀번호를 입력해 주세요.");
            t.setLogTPw(ScannerUtil.nextLine(sc, message));

            TlogIn = auth(t);

        }

    }
    private static Teacher auth(Teacher t) {
        for (int i = 0; i < teacherList.size(); i++) {
            if (t.logIn(teacherList.get(i))) {
                return teacherList.get(i);
            }

        }
        return null;
    }
    
    // student 회원가입
    private static void registerS() {
        System.out.println();
        System.out.println("회원가입을 실행합니다");
        System.out.println();
        
        Student temp = new Student();
        
        temp.setStudentId(SId);
        
        String message = new String("사용하실 아이디를 입력해주세요.");
        temp.setLogId(ScannerUtil.nextLine(sc, message));
        
        
       
    }
    // 중복 확인 메서드
}
