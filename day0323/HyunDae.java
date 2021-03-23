package day0323;

public class HyunDae implements Car{
    // 필드
    private String carNumber;
    private String model;
    private int price;
    private String color;
    
  
    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void turnOn() {
        System.out.println("시동 on");
    }

    @Override
    public void speedUp() {
        System.out.println("속도 up");
    }

    @Override
    public void speedDown() {
        System.out.println("속도 down");
    }

    @Override
    public void goLeft() {
        System.out.println("왼쫙");
    }

    @Override
    public void goRight() {
        System.out.println("오른쫙");
        
    }

    @Override
    public void park() {
        System.out.println("주차 시작");
    }

    @Override
    public void turnOff() {
        System.out.println("시동 off");
    }

}
