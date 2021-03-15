package day0315;

public class StudentEx01 {
    public static void main(String[] args) {
        Student s = null;
        System.out.println(s); // 객체가 만들어지긴 했지만 실체화가 되어있지않아 사용할 수 없음.
        s = new Student();
        
        s.showInfo();
        s.id = 1;
        s.name = new String("조재영");
        s.korean = 80;
        s.english = 81;
        s.math = 74;

        s.showInfo();

        Student s2 = new Student();
        s2.id = 1;
        s2.name = new String("조재영");
        s2.korean = 80;
        s2.english = 81;
        s2.math = 74;
        s2.showInfo();

        System.out.println("s.equals(s2): " + s.equals(s2));
        String str = new String("안녕하세요");
        System.out.println("s.equals(str): "+s.equals(str));
    }
}
