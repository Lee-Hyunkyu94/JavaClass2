package day0323;

import java.util.Scanner;

import util.ScannerUtil;

public class CarMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CarImpl carImpl = new CarImpl();
        Car c = null;
        Ferrari f = new Ferrari();
        BMW b = new BMW();
        HyunDae h = new HyunDae();
        
        
        while(true) {
            String message = new String("1. 페라리 2. BMW 3. 현다이 4. 종료");
            int userChoice = ScannerUtil.nextInt(sc, message, 1, 4);
            if(userChoice == 1) {
                message = new String("차 번호를 입력해주세요.");
                f.setCarNumber(ScannerUtil.nextLine(sc, message));
                
                message = new String("모델명을 입력해주세요.");
                f.setModel(ScannerUtil.nextLine(sc, message));
                
                message = new String("가격을 입력해주세요.");
                f.setPrice(ScannerUtil.nextInt(sc, message));
                
                message = new String("색상을 입력해주세요.");
                f.setColor(ScannerUtil.nextLine(sc, message));
                
                c = new Ferrari();
            }else if(userChoice == 2) {
                message = new String("차 번호를 입력해주세요.");
                b.setCarNumber(ScannerUtil.nextLine(sc, message));
                
                message = new String("모델명을 입력해주세요.");
                b.setModel(ScannerUtil.nextLine(sc, message));
                
                message = new String("가격을 입력해주세요.");
                b.setPrice(ScannerUtil.nextInt(sc, message));
                
                message = new String("색상을 입력해주세요.");
                b.setColor(ScannerUtil.nextLine(sc, message));
                
                c = new BMW();
            }else if(userChoice == 3) {
                message = new String("차 번호를 입력해주세요.");
                h.setCarNumber(ScannerUtil.nextLine(sc, message));
                
                message = new String("모델명을 입력해주세요.");
                h.setModel(ScannerUtil.nextLine(sc, message));
                
                message = new String("가격을 입력해주세요.");
                h.setPrice(ScannerUtil.nextInt(sc, message));
                
                message = new String("색상을 입력해주세요.");
                h.setColor(ScannerUtil.nextLine(sc, message));
                
                c = new HyunDae();
                
            }else if(userChoice == 4) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
                    carImpl.showCar(c);
        }
    }
}
