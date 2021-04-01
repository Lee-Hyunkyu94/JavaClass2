package exercise;

class MyTv2 {
    private boolean isPowerOn;
    private int channel;
    private int volume;
    private int Prevchannel;
    
    final int MAX_VOLUME = 100;
    final int MIN_VOLUME = 0;
    final int MAX_CHANNEL = 100;
    final int MIN_CHANNEL = 0;

    public void setVolume(int volume) {
        if (volume > MAX_VOLUME || volume < MIN_VOLUME) {
            return;
        }

        this.volume = volume;
    }

    public int getVolume() {
        return volume;

    }

    public void setChannel(int channel) {
        if (channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
            return;
        }
        
        Prevchannel = this.channel;
        this.channel = channel;
    }

    public int getChannel() {
        return channel;
    }

    public void gotoPrevChannel() {
        setChannel(Prevchannel);
        
    }

}

public class Exercise7_10 {
    public static void main(String[] args) {
        MyTv2 t = new MyTv2();

        t.setChannel(10);
        System.out.println("CH: " + t.getChannel());
        t.setChannel(20);
        System.out.println("CH: " + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH: " + t.getChannel());
        t.gotoPrevChannel();
        System.out.println("CH: " + t.getChannel());
        
        t.setVolume(20);
        System.out.println("VOL: " + t.getVolume());
    }
}
// 7-12
// b. (default)의 경우에는 상속받는 자식 클래스가 접근 가능하다. x
// 틀림
// c. 접근 제어자는 - 클래스, 메서드, 멤버변수, 생성자
//                이렇게만 접근 가능

// 7-13
// Math 클래스의 생성자는 private 이지만 멤버변수가 없고 메소드는 전부 static이기 때문에 생성자를 private 로 해도 
// 상관이 없다.