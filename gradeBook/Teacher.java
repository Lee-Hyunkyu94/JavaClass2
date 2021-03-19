package gradeBook;

public class Teacher {
    // 필드
    private int teacherId;
    private String LogTId;
    private String LogTPw;
    private String teacherName;
    private int teacherClassRoom;

    // 메서드
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getLogTId() {
        return LogTId;
    }

    public void setLogTId(String logTId) {
        LogTId = logTId;
    }

    public String getLogTPw() {
        return LogTPw;
    }

    public void setLogTPw(String logTPw) {
        LogTPw = logTPw;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getTeacherClassRoom() {
        return teacherClassRoom;
    }

    public void setTeacherClassRoom(int teacherClassRoom) {
        this.teacherClassRoom = teacherClassRoom;
    }

    // id 값으로 equals() 메서드 만들기
    public boolean equals(Object o) {

        if (o instanceof Teacher) {
            Teacher t = (Teacher) o;
            if (teacherId == t.teacherId) {
                return true;
            }
        }
        return false;
    }
    public boolean logIn(Teacher t) {
        if(LogTId.equals(t.LogTId) && LogTPw.equals(t.LogTPw)) {
            return true;
        }
            
        return false;
        
    }


}
