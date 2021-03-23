package day0323;
// 부모클래스가 될 Canis 클래스
// Canis란? 생물학적 분류에서
// 강아지들이 포함된 "개 속"을 뜻한다.
// 개 속에 속하는 동물들은
// 하이애나, 늑대 등이 있다.
// 우리 클래스에서는 간단하게
// makeGroup() 이라는 메소드만 만들어준다.
public class Canis {
    public Canis() {
        System.out.println("캐니스 생성자 호출");
    }
    
    public void makeGroup() {
        System.out.println("무리를 만든다.");
    }
}
