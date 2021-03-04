package day0304;
// Scanner
// Scanner 클래스는 자바에서 다양한 입력을 처리해주는 클래스이다.
// 우리가 사용자로부터 ㅋ키보드 입력을 받기 위해서는 이 스캐너 클래스의 객체를 만들어서
// 그 객체의 메소드를 실행하여 입력을 받아야 한다.

// 단, Scanner는 자바에서 기본으로 포함해주는 클래스가 아닌 추가적인 클래스이므로
// 우리가 "수입(import)" 해와야한다
import java.util.Scanner;

public class Ex02Scanner {
    public static void main(String[] args) {
     // Scanner 객체를 선언과 초기화해보자
        // 단 초기화 시에는 반드시 어디서 입력을 읽어올지를 지정해와야 하기 때문에
        // 키보드 입력을 할 때에는 () 안에 System.in 이라고 적어주어야 한다. // console 창에 키보드로 입력
        Scanner scanner = new Scanner(System.in);
        // 실행 했을경우 강제종료 해줘야함(Terminate)
        
        
        // 1. 사용자로부터 int를 입력 받을 때에는
        //    스캐너 객체의 nextInt() 메소드를 실행하면 된다.
        System.out.print("숫자: ");
        int userNumber = scanner.nextInt();
        // userNum -> Buffer 에 입력 "12 엔터" 면 12만 가져옴
        // "12" 가 userNum 에 입력
        System.out.println("사용자가 입력한 숫자: "+userNumber);
        // "엔터" 남아있음
        
        // 2. 사용자로부터 double을 입력 받을 때에는
        //    스캐너 객체의 nextDouble() 메소드를 실행하면 된다.
        System.out.print("실수: ");
        double userDouble = scanner.nextDouble();
        // userD -> Buffer 에 "2.3 엔터" 입력 시 전에 있던 엔터 + 2.3을 가져옴
        // "\n 2.3" 이 userD에 입력 -> 앞의 공백문자는 자체적으로 제거.
        System.out.println("사용자가 입력한 실수: "+userDouble);
        // "엔터" 남아있음
        
        // 3. 사용자로부터 String을 입력 받을 때에는
        //    스캐너 객체의 nextLine() 메소드를 실행하면 된다.
        System.out.print("이름: ");
        
        // 스캐너 객체를 키보드 입력을 위해 사용할 때에는 한가지 주의할 점이 있는데
        // 만약 nextInt(), nextDouble() 등의 숫자, 실수를 입력하는 메소드를 실행하고 나서
        // nextLine() 메소드를 실행하게 된다면
        // nextInt(), nextDouble()에서 사용자가 입력을 종료하기 위해 눌렀던 엔터키(공백문자\n)이
        // 버퍼메모리에 남아있고
        // 그 엔터키를 보고 nextLine() 메소드는 "사용자가 아무런 글자 입력을 하지 않고 입력을 끝냈다"고 착각하는
        // 버그가 존재한다.
        
        // 해당 버그를 해결하기 위해서는 
        // nextInt(), nextDouble() 등의 숫자, 실수를 입력하는 메소드 "이후에는" 반드시
        // nextLine() 메소드를 한번 실행해서 버퍼메모리를 비워두고
        // 그 다음 String 입력을 nextLine()으로 받아주어야 한다.
        
        // 단, 프로그램을 시작하자마자 String 입려을 위해
        // nextLine()을 쓰는 경우,
        // 버퍼메모리가 깨끗한 상태이기 때문에
        // nextLine()을 두번 적어줄 필요가 없다. // String name = scanner.nextLine(); 으로 시작
        
        scanner.nextLine(); // -> 버그 해결 (공백제거) => 버퍼메모리를 비워주는 용도
        // nextLine() 하나를 더 넣어서 "엔터"를 읽게한다. 
        String name = new String(scanner.nextLine());
        // nextLine 은 모든 문자열을 가져옴
        // scanner.nextLine(); 으로 "엔터" 값 먼저 읽게한다.
        System.out.println("사용자의 이름: "+name);
  
        
        // Scanner와 같이 외부에서 무언가 값을 "읽어" 오는 클래스 객체는 프로그램의 가장 마지마 줄에
        // close() 메소드를 호출해주는 것이 좋다. 
        scanner.close();
     
    }

}
