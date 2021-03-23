package day0323;
// "Canis" 클래스를 상속받는 하이애나 클래스
// 하이애나 = 비열해보임, 시체를 먹음
// 2가지 메소드가 있다.
public class Hyena extends Canis{
    public Hyena() {
        System.out.println("Hyena 생성자 호출");
    }
    
    public void nasty() {
        System.out.println("비열해보인다.");
    }
    
    public void eat() {
        System.out.println("시체를 먹는다.");
    }
    
}
