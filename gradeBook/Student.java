package gradeBook;

// 학생 클래스(학생 번호, 이름, 소속 반, 점수 입력 여부, 국어 점수, 영어 점수, 수학 점수)

public class Student {
    // 필드
    // 학생 번호
    private int id;
    // 학생 로그인시 사용할 아이디
    private String username;
    // 학생 로그인시 사용할 비밀번호
    private String password;
    // 학생이름
    private String name;
    // 소속 반
    private int group;
    // 점수 입력 여부
    private boolean scoreInputSwitch;
    // 국어 점수
    private int korean;
    // 영어 점수
    private int english;
    // 수학 점수
    private int math;

    // 과목 숫자를 저장한 상수
    private final int SUBJECT_SIZE = 3;

    // 필드에 대한 getter/setter 메서드
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public boolean isScoreInputSwitch() {
        return scoreInputSwitch;
    }

    public void setScoreInputSwitch(boolean scoreInputSwitch) {
        this.scoreInputSwitch = scoreInputSwitch;
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
            if (id == s.id) {
                return true;
            }
        }
        return false;
    }

    // 학생의 정보를 출력한 print()
    // 단 민감한 정보들인 아이디와 비밀번호는 출력하지 않는다.
    public void print() {
        System.out.println("+++++++++++++++++++++++++++++++++++");
        System.out.printf("소속 반: %d반 번호: %2d번", group, id);
        System.out.printf("이름: %s\n", name);
        // 점수 입력 여부는 따로 추력을 해주는 것이 아니라
        // 점수 출력 자체를 결정 지어주는데 사용된다.
        System.out.println("-----------------------------------");
        if (scoreInputSwitch) {
            int sum = korean + english + math;
            double average = sum / (double) SUBJECT_SIZE;
            System.out.printf("국어 점수: %03d점 영어 점수: %03d점 수학 점수: %03d점\n", korean, english, math);
            System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
        } else {
            System.out.println();
            System.out.println("아직 입력된 정보가 없습니다.");
            System.out.println();
        }
        System.out.println("+++++++++++++++++++++++++++++++++++");
    }

    public boolean auth(Student s) {
        if (username.equals(s.username) && password.equals(s.password)) {
            return true;
        }

        return false;

    }

}
