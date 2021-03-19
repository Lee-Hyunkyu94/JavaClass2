package gradeBook;

import board.User;

public class Student {
    // 필드
    private int studentId;

    private String LogId;
    private String LogPw;
    private String studentName;
    private int studentClassRoom;
    private boolean studentInputChecker;
    private int korean;
    private int english;
    private int math;

    // 메서드
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getLogId() {
        return LogId;
    }
    
    public void setLogId(String logId) {
        LogId = logId;
    }
    
    public String getLogPw() {
        return LogPw;
    }
    
    public void setLogPw(String logPw) {
        LogPw = logPw;
    }
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentClassRoom() {
        return studentClassRoom;
    }

    public void setStudentClassRoom(int studentClassRoom) {
        this.studentClassRoom = studentClassRoom;
    }

    public boolean isStudentInputChecker() {
        return studentInputChecker;
    }

    public void setStudentInputChecker(boolean studentInputChecker) {
        this.studentInputChecker = studentInputChecker;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    // id 값으로 equals() 메서드 만들기
    public boolean equals(Object o) {

        if (o instanceof Student) {
            Student s = (Student) o;
            if (studentId == s.studentId) {
                return true;
            }
        }
        return false;
    }
    
    public boolean logIn(Student s) {
        if(LogId.equals(s.LogId) && LogPw.equals(s.LogPw)) {
            return true;
        }
            
        return false;
        
    }

}
