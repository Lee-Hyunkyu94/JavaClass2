package viewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import controller.EvaluationController;
import controller.StudentController;
import model.EvaluationDTO;
import model.TeacherDTO;
import util.ScannerUtil;

public class EvaluationViewer {
    private EvaluationController controller;
    private Scanner sc;
    private final String FORMAT_STRING = new String("y.M.d.");
    private StudentViewer studentViewer;  
    public EvaluationViewer(StudentViewer studentViewer) {
        controller = new EvaluationController();
        sc = new Scanner(System.in);
        // 의존성 주입(Dependency Injection)을 하는 코드 -> 클래스 선언을 해도 private 필드나 메소드는 public이 붙지 않는이상 사용할 수 없다.
        this.studentViewer = studentViewer; // EvaluationViewer 는 어쩔수 없이 studentViewer를 가져올수 밖에 없다.
        // 그냥 studentController 에서 값을 뽑아낼순 있다.(studentViewer가 했던 것처럼, 하지만 우리가 필요한게 studentviewer에 있는 리스트가 필요해서 의존성 주입을 한것)
    }
    
    // 해당 교사의 평가를 모두 다 보여주는 printList() 메소드
    // 단, 파라미터로 TeacherDTO 객체를 받아온다.
    public void printList(TeacherDTO t) {
        while(true) {

        // 해당 선생의 id 값을 통해서, 그 선생에 연관된 평가 목록을 불러온다.
        ArrayList<EvaluationDTO> list = controller.selectById(t.getId());
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_STRING);
        for(EvaluationDTO e : list) {
            // 작성한 학생의 이름을 출력하기 위해
            // e.getStudentId()로 해당 학생 객체를 불러온다.
            // 하지만 우리가 해당 학생의 정보를 갖고오려면
            // studentController가 필요한데 그건 우리한테 없다.
            // 데이터베이스가 있으면 좀더 쉽게 처리가 가능하지만
            // 우리는 데이터베이스가 없으므로,
            // studentViewer에 어쩔 수 없이 controller에서 이름을 갖고오는
            // 메소드를 만들어서 대신 써야 한다!
            System.out.printf("%d. %s - %s(%s)\n", 
                    e.getId(), 
                    e.getContent(), 
                    studentViewer.selectNameById(e.getStudentId()).getName(),
                    sdf.format(e.getWrittenDate().getTime()));
        }
        if(studentViewer.isLogInNull()) {
            String message = new String("1. 뒤로가기");
            ScannerUtil.nextInt(sc, message, 1, 1);
            break;
        } // teacherMenu 에서도 볼수 있어야 해서 teacher 로그인일 경우 수정을 막는다.
        
        String message = new String("1. 새 평가 등록 2. 삭제 3. 뒤로가기");
        int userChoice = ScannerUtil.nextInt(sc, message, 1, 3);
            if(userChoice == 1) {
                insert(t);
            }else if(userChoice == 2) {
                message = new String("삭제할 평가의 번호를 입력해주세요.");
                userChoice = ScannerUtil.nextInt(sc, message);
                
                EvaluationDTO e = controller.selectOne(userChoice);
                while(e == null) {
                    System.out.println("잘못 입력하셨습니다.");
                    userChoice = ScannerUtil.nextInt(sc, message);
                    e = controller.selectOne(userChoice);
                }
                
                delete(userChoice);
                    
                
            }else if(userChoice == 3) {
                break;
            }
        }
    }
    // 입력 메소드
    public void insert(TeacherDTO t) {
        int stduentId = studentViewer.selectLogInId();
        if(controller.validateStudentId(stduentId)) {
            System.out.println("한번에 한개의 평가만 등록하실 수 있습니다.");
        }else {
        // 정보를 추가할 Evaluation객체를 만든다.
        EvaluationDTO e = new EvaluationDTO();
        
        String message;
        message = new String("교사의 평을 입력해 주세요.");
        e.setContent(ScannerUtil.nextLine(sc, message));
        e.setTeacherId(t.getId());
        e.setStudentId(studentViewer.selectLogInId());
        controller.add(e);
        }
    }
    // 삭제 메소드
    public void delete(int id) {
        EvaluationDTO e = controller.selectOne(id);
        if(e.getStudentId() == studentViewer.selectLogInId()) {
            String message = new String("정말로 삭제하시겠습니까? y/n");
            String yesno = ScannerUtil.nextLine(sc, message);
            if(yesno.equalsIgnoreCase("y")) {
                controller.delete(e);
            }
        } else {
            System.out.println("자기자신이 작성한 평가만 삭제 가능합니다.");
        }
    }
}
