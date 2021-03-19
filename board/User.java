package board;

public class User {
    // 1. 필드
    // 회원 번호
    private int id;
    
    // 회원 유저네임
    private String userName;
    
    // 회원 비밀번호
    private String passWord;
    
    // 회원 닉네임
    private String Nickname;

    // 2.메소드
    // getters/setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }
    
    // id를 기준으로한 equals() 메소드

    public boolean equals(Object o) {
        
        if (o instanceof User) {
            User u = (User) o;
            if (id == u.id) {
                return true;
            }
        }
        return false;
    }
    
    // 사용자로부터 넘겨받은 userName과 passWord가 일치하면 true가 리턴되는
    // logIn 메소드
    public boolean logIn(User u) {
        if(userName.equals(u.userName) && passWord.equals(u.passWord)) {
            return true;
        }
            
        return false;
        
    }
    
}
