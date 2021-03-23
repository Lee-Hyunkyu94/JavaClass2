package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import model.EvaluationDTO;

public class EvaluationController {

    private ArrayList<EvaluationDTO> list;
    private int id;
    private int studentId;
    private int teacherId;
    private SimpleDateFormat sdf;

    // 객체생성
    public EvaluationController() {
        id = 1;
        list = new ArrayList<>();
        EvaluationDTO e1 = new EvaluationDTO();
        e1.setId(id++);
        e1.setStudentId(1);
        e1.setTeacherId(1);
        e1.setContent("좋아요");
        e1.setWrittenDate(Calendar.getInstance());

        list.add(e1);

        e1 = new EvaluationDTO(); // 새로운 주솟값 선언
        e1.setId(id++);
        e1.setStudentId(2);
        e1.setTeacherId(2);
        e1.setContent("정말 좋아요");
        e1.setWrittenDate(Calendar.getInstance());

        list.add(e1);  // 새로운 주솟값이 리스트 뒤에 add해줌.

    }

    // 1. id 값을 받으면 해당 id 값과 일치하는 EvaluationDTO 객체를 return하는
    // selectOne() 메소드
    public EvaluationDTO selectOne(int id) {
        for (EvaluationDTO e : list) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    // 2. 교사의 id 값을 받으면 해당 id 값과 일치하는 EvaluationDTO 객체들을
    // ArrayList에 담아서 리턴하는 selectById() 메소드
    public ArrayList<EvaluationDTO> selectById(int teacherId) {
        ArrayList<EvaluationDTO> temp = new ArrayList<>();
        for (EvaluationDTO e : list) {
            if (e.getTeacherId() == teacherId) {
                temp.add(e);
            }
        }
        return temp;
    }

    // 3. 사용자가 입력한 값을 EvaluationDTO의 객체형태로 받아서
    // list에 추가하는 add() 메소드
    public void add(EvaluationDTO e) {
        e.setId(id++);
        e.setWrittenDate(Calendar.getInstance());
        list.add(e);
    }

    // 4. 사용자가 입력한 id값 과 일치하는 EvaluationDTO 객체를 삭제하는
    // delete() 메소드
    public void delete(EvaluationDTO e) { // 입력한 id 값이 int 형태가 아니라 EvaluationDTO에 담아서 보내준다.
        list.remove(e);
    }

    // 5. 사용자가 기존의 정보를 입력했는지 안했는 지를 알려주는
    // validateStudentId
    public boolean validateStudentId(int studentId) {
        for (EvaluationDTO e : list) {
            if (studentId == e.getStudentId()) {
                return true;
            }
        }
        return false;
    }
}
