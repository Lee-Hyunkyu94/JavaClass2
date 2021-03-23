package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.TeacherController;
import model.TeacherDTO;
import util.ScannerUtil;

public class TeacherViewer {
    Scanner sc;
    TeacherController controller;
    TeacherDTO logIn;

    // 1. 생성자
    public TeacherViewer() {
        sc = new Scanner(System.in);
        controller = new TeacherController();
    }

    // 2. 로그인
    public int logIn() {
        // 출력할 메시지를 담는 String 객체 message
        String message;

        // 사용자가 입력할 정보를 담은 TeacherDTO 객체 t
        TeacherDTO t = new TeacherDTO();

        // 아이디 입력
        message = new String("아이디를 입력해주세요");
        t.setUsername(ScannerUtil.nextLine(sc, message));

        // 비밀번호 입력
        message = new String("비밀번호를 입력하세요.");
        t.setPassword(ScannerUtil.nextLine(sc, message));

        // 결과값을 TeacherDTO 객체 result에 넣는다.
        TeacherDTO result = controller.auth(t);

        // result가 null인지 확인하여
        // null 일 경우 다시 묻는다.
        while (result == null) {
            System.out.println("잘못 입력하셨습니다.");
            message = new String("종료하시겠습니까? y/n");
            String agree = ScannerUtil.nextLine(sc, message);
            if (!agree.equalsIgnoreCase("y")) {
                return -1;
            }
            message = new String("아이디를 입력해주세요");
            t.setUsername(ScannerUtil.nextLine(sc, message));

            message = new String("비밀번호를 입력하세요.");
            t.setPassword(ScannerUtil.nextLine(sc, message));

            result = controller.auth(t);

        }
        // result가 null이 아닐 경우
        // result.getGroup()를 return 한다.
        
        return result.getGroup();

    }

    // logOut 담당
    public void logOut() {
        System.out.println("로그아웃 되었습니다.");
        logIn = null;
    }

    // 3. 교사 회원가입
    public void register() {
        // 출력할 내용을 담은 String 객체 message
        String message;
        
        // 사용자가 입력한 정보를 담을 TeacherDTO 객체 t
        TeacherDTO t = new TeacherDTO();

        // 아이디 입력
        message = new String("사용하실 아이디를 입력해 주세요.");
        t.setUsername(ScannerUtil.nextLine(sc, message));

        // 아이디가 유효한 아이디인지 체크
        while (controller.validateUsername(t)) {
            System.out.println("사용하실수 없는 아이디입니다.");
            t.setUsername(ScannerUtil.nextLine(sc, message));
        }

        // 비밀번호 입력
        message = new String("사용하실 비밀번호를 입력해주세요.");
        t.setPassword(ScannerUtil.nextLine(sc, message));

        // 이름 입력
        message = new String("이름을 입력해주세요.");
        t.setName(ScannerUtil.nextLine(sc, message));

        // 반 입력
        message = new String("소속 반을 입력해주세요.");
        t.setGroup(ScannerUtil.nextInt(sc, message));

        // 유효한 반인지 체크
        while(controller.validateGroup(t)) {
            System.out.println("이미 담당 교사가 존재하는 반입니다.");
            t.setGroup(ScannerUtil.nextInt(sc, message));
        }
            
        // 컨트롤러의 add() 메소드 호출
        controller.add(t);
    }

    
    // 파라미터와 group의 값이 같은 TeacherDTO 객체를 리턴해주는 메소드
    public TeacherDTO selectOneByGroup(int group) {
        return controller.selectOneByGroup(group);
    }
}
