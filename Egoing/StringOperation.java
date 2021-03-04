package Egoing;

public class StringOperation {
    public static void main(String[] args) {
        
        System.out.println("Hello World".length()); // 11
        System.out.println("Hello, [[name]] ...bye. ".replace("[[name]]", "f"));
        
        
        char data[] = {'h','o','t'};
        String str = new String(data);
        
        System.out.println(str);
        System.out.println("Hello, "+str.toUpperCase());
        
    }

}
