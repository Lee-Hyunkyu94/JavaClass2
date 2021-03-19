package board;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import util.ScannerUtil;

// User, Reply, Board 모두를 활용한
// 로그인 기능, 댓글 기능이 있는 게시판 프로그램

public class BoardEx01 {
    // 댓글을 관리할 ArrayList<> 객체 replyList;
    private final static ArrayList<Reply> replyList = new ArrayList<>(); // final로 선언된 객체의 경우 new 를 사용해서 다시 정의할 수 없다. // 사용자가 새로 선언을 할 수 있기 때문에 막아준거.
    // 회원을 관리할 ArrayList<> 객체 userList;
    private final static ArrayList<User> userList = new ArrayList<>();
    // 게시글을 관리할 ArrayList<> 객체 boardList;
    private final static ArrayList<Board> boardList = new ArrayList<>();
    // 입력을 담당할 Scanner 객체 sc
    private final static Scanner sc = new Scanner(System.in);
    // 현재 게시글 번호를 저장할 int 변수 boardId
    private static int boardId = 1;
    // 현재 댓글 번호를 저장할 int 변수 replyId
    private static int replyId = 1;
    // 현재 회원 번호를 저장할 int 변수 userId
    private static int userId = 1;
    // 현재 로그인한 회원 정보를 저장할 user 객체 logIn
    private static User LogIn = null;

    public static void main(String[] args) {
        index();
    }

    // 1. 맨 처음 로그인 혹은 회원 가입을 안내할
    // index() 메소드
    private static void index() {
        while (true) {
            System.out.println("=================================");
            System.out.println("      비트캠프 게시판 관리 프로그램       ");
            System.out.println("=================================");
            String message = new String("1. 로그인 2. 회원가입 3. 종료");
            int userChoice = ScannerUtil.nextInt(sc, message, 1, 3);

            if (userChoice == 1) {
                // userList.size() 가 0 이 아닐때에만 로그인을 실행하고
                // 그 외에는 "아직 등록된 회원이 없습니다."가 출력되게 만들어준다.

                // ArrayList의 경우, isEmpty() 메소드를 사용하면
                // 해당 리스트에 엘리먼트가 존재하는지 체크가능하다.
                // 만약 리스트가 비어있을 경우 true가 return된다.

                if (userList.isEmpty()) {
                    System.out.println();
                    System.out.println("아직 등록된 회원이 없습니다.");
                    System.out.println();
                } else {
                    // 로그인 메소드 실행
                    logIn();

                    // logIn 메소드 실행 후에
                    // User 객체 logIn의 값이 null이 아니면
                    // 게시판 메뉴를 불러오는 showMenu() 메소드를 실행한다.
                    if (LogIn != null) {
                        showMenu();
                    }
                }

            } else if (userChoice == 2) {
                // 회원가입 메소드 실행
                register();

            } else if (userChoice == 3) {
                // 종료
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }

        }
    }

    // showMenu
    private static void showMenu() {
        while (true) {
            System.out.println("=================================");
            System.out.println("      회원 관리 프로그램       ");
            System.out.println("=================================");
            String message = new String("1. 입력\n2. 보기\n3. 종료");
            int userChoice = ScannerUtil.nextInt(sc, message, 1, 3);

            if (userChoice == 1) {
                // 글 작성 담당 메소드 호출
                writeBoard();
            } else if (userChoice == 2) {
                // 글 목록 보기 담당 메소드 호출
                printAllBoard();
            } else if (userChoice == 3) {
                // 메시지 출력 후 종료
                System.out.println("인덱스 화면으로 돌아갑니다.");
                // 사용자가 인덱스로 돌아갈때
                // logIn 객체를 다시 null로 초기화 해준다.
                // 지금은 콘솔이기 때문에 별 차이가 없는것처럼 보이지만
                // 나중에 웹 프로젝트에서는
                // 로그아웃 혹은 로그인 정보가 만료된 이후에
                // 인터넷 주소(=url)을 강제로 입력하여 글 수정 삭제 등의 페이지에
                // 들어가는 것을 막기 위함이다.
                LogIn = null;
                break;
            }
        }
    }

    private static void printAllBoard() {
        // 게시글을 저장하는 boardList가 비어져 있을 경우
        // 아무글도 없다는 경고 메시지만 출력해준다.
        while (true) {
            if (boardList.isEmpty()) {
                System.out.println();
                System.out.println("아직 등록된 게시글이 존재하지 않습니다.");
                System.out.println();
                break;
            } else {
                // 게시글의 작성일을 형식맞춰줄 SimpleDateFormat 객체 생성
                SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd.a.hh.mm.ss.");

                System.out.println("=====현재 게시판 내용=====");
                for (int i = 0; i < boardList.size(); i++) {
                    Board b = boardList.get(i);
                    System.out.printf("%d번 %s \t\t%s\n", b.getId(), b.getTitle(),
                            sdf.format(b.getWrittenDate().getTime()));
                }
                System.out.println();
                String message = new String("개별 보기할 글의 번호를 입력해주세요. 뒤로 가시려면 0을 입력해주세요.");
                int userChoice = ScannerUtil.nextInt(sc, message);

                // 사용자가 입력한 글의 번호가 유효한지 체크하기 위해서
                // Board 객체를 만들어서
                // 그 객체가 boardList에 존재하는지 체크한다.
                Board b = new Board();
                b.setId(userChoice);

                // 만약 userChoice 가 0이 아니고 boardList의 contains(b) 결과가 false 인 경우
                // 사용자에게 잘못 입력했으므로 다시 입력해달라고 하여
                // 올바른 번호가 입력될 때까지 입력을 받는다.

                while (!(userChoice == 0 || boardList.contains(b))) {

                    System.out.println("잘못 입력하셨습니다.");
                    userChoice = ScannerUtil.nextInt(sc, message);
                    b.setId(userChoice);

                }

                if (userChoice == 0) {
                    break;
                } else {
                    // userChoice 를 파라미터로 하는
                    // printOneBoard 메소드를 실행해준다.
                    printOneBoard(userChoice);
                }
            }
        }
    }

    private static void printOneBoard(int id) {
        // 게시글의 상세보기와 해당 게시글의 댓글을 출력해주는 메소드
        // 파라미터로 받은 id 값을 사용하여
        // 게시판 정보를 불러온다.
        Board b = retrieveBoard(id);

        // b가 null일 경우, id가 잘못되었다라는 의미이므로
        // 경고 메시지만 출력
        if (b == null) {
            System.out.println();
            System.out.println("존재하지 않는 게시글 번호입니다.");
            System.out.println();
        } else {

            // 댓글을 저장하는 replyList 중에
            // boardId의 값이 파라미터 id와 값이 일치하는
            // Reply 객체를 모두 불러온다.
            ArrayList<Reply> list = selectReplyByBoardId(id);

            String writerName = selectNicknameById(b.getWriterId());

            b.print(writerName);

            System.out.println("========================");
            System.out.println("           댓글          ");
            System.out.println("========================");
            // 만약 댓글이 존재하지 않으면
            // "등록된 댓글이 존재하지 않습니다." 라는 메시지만 출력해주고 그 외에는
            // list의 Reply 객체의 print 메소드를 실행시켜주자
            if (list.isEmpty()) {
                System.out.println("등록된 댓글이 존재하지 않습니다.");
            } else {
                for (int i = 0; i < list.size(); i++) {
                    Reply r = list.get(i);

                    r.print(selectNicknameById(r.getWriterId()));
                }
            }
            // 만약 게시글의 작성자와 로그인한 유저가 같을 경우
            // 수정 삭제 뒤로가기를 출력해주고
            // 그 외에는 댓글달기와 뒤로가기 만 출력해준다.
            int userChoice = 0;
            if (LogIn.getId() == b.getWriterId()) {
                // 작성자와 로그인 유저가 같은 사람이므로
                // 수정 삭제 뒤로가기 중 하나를 선택할 수 있게 한다.
                String message = new String("1. 게시글 수정 2. 게시글 삭제 3. 뒤로가기");
                userChoice = ScannerUtil.nextInt(sc, message, 1, 3);
                if (userChoice == 1) {
                    // 게시글 수정 메소드 실행
                    updateBoard(id);
                } else if (userChoice == 2) {
                    // 게시글 삭제 메소드 실행
                    deleteBoard(id);
                }

            } else {
                // 작성자와 로그인 유저가 같은 사람이 아니므로
                // 댓글달기 댓글삭제 뒤로가기 중 하나를 선택할 수 있게 한다.
                String message = new String("1. 댓글 달기 2. 댓글 삭제 3. 뒤로가기");
                userChoice = ScannerUtil.nextInt(sc, message, 1, 3);
                if (userChoice == 1) {
                    // 댓글 달기 메소드 실행
                    addReply(id);
                    printOneBoard(id);
                } else if (userChoice == 2) {
                    // 댓글 삭제 메소드 실행

                    // 만약 댓글이 존재하지 않으면
                    // 아무런 댓글이 없습니다 라는 메시지만 출력하고

                    // 그 외에는 다음과 같은 순서를 가진다.

                    // 삭제 할 댓글을 선택하게한다.
                    // 이때는 댓글 번호와 내용만 보여주고
                    // 사용자가 댓글 번호를 선택하면
                    // 그 번호를 파라미터로 댓글 삭제 메소드에 보내준다.

                    if (list.isEmpty()) {
                        System.out.println();
                        System.out.println("해당 글에는 댓글이 존재하지 않습니다.");
                        System.out.println();
                    } else {
                        for (int i = 0; i < list.size(); i++) {

                            Reply r = list.get(i);
                            System.out.printf("%d. %s \n", r.getId(), r.getContent());
                        }
                        message = new String("삭제할 댓글의 번호를 입력해주세요.삭제를 원하시지 않으면 0을 입력해 주세요.");
                        int userInput = ScannerUtil.nextInt(sc, message);

                        Reply r = new Reply();
                        r.setId(userInput);

                        while (!(userInput == 0 || list.contains(r))) { // while 절은 참일때 계속 돌아간다. 참이 아니게 될 경우 나올수 있으니까 list.contains를 쓸때 반대의 반대 즉 원래대로를 생각해야 머리 안꼬이고 생각 가능.
                            System.out.println("유효하지 않은 입력입니다.");
                            userInput = ScannerUtil.nextInt(sc, message);
                            r.setId(userInput);

                        }

                        if (userInput != 0) {

                            // 만약 로그인 유저가 댓글 작성자와 같으면
                            // 댓글 삭제 메소드를 실행한다.

                            // 먼저 댓글 작성자의 id와 로그인한 유저의 id 비교를 위해
                            // 현재 댓글번호 밖에 저장이 안되 Reply 객체 r에 나머지 정보를 넣어준다.
                            int replyIndex = list.indexOf(r);
                            r = list.get(replyIndex);

                            if (LogIn.getId() == r.getWriterId()) {
                                deleteReply(userInput);
                            } else {
                                System.out.println();
                                System.out.println("해당 댓글의 작성자만 댓글을 삭제하실 수 있습니다");
                                System.out.println();
                            }
                        }
                        printOneBoard(id);
                    }

                }
            }

        }
    }

    // 게시글의 id 값을 파라미터로 받아 해당 게시글의 댓글을 추가하는 메소드
    private static void addReply(int boardId) {
        // 정보를 담을 Reply 객체 생성
        Reply r = new Reply();

        // id를 replyId 값을 주고 replyId++
        r.setId(replyId++);

        // boardId는 파라미터에서
        r.setBoardId(boardId);

        // writerId는 User객체 logIn에서
        r.setWriterId(LogIn.getId());

        // 내용을 입력 받아서 content에
        String message = new String("댓글의 내용을 입력해주세요.");
        r.setContent(ScannerUtil.nextLine(sc, message));

        // 입력 날짜는 Calendar.getInstance()로
        r.setWrittenDate(Calendar.getInstance());

        // 정보가 다 담긴 Reply 객체 r을 리스트에 추가
        replyList.add(r);
    }

    // 게시글의 번호를 파라미터로 받아서
    // 수정하는 updateBoard() 메소드
    private static void updateBoard(int boardId) {
        String message;
        Board b = retrieveBoard(boardId);
        // 새로운 제목을 입력받는다.
        message = new String("새로운 제목을 입력해주세요.");
        b.setTitle(ScannerUtil.nextLine(sc, message));

        // 새로운 내용을 입력받는다.
        message = new String("새로운 내용을 입력해주세요.");
        b.setContent(ScannerUtil.nextLine(sc, message));

        // 수정 날짜를 그 순간의 시간으로 바꾼다.
        b.setUpdatedDate(Calendar.getInstance());

    }

    // 게시글의 번호를 파라미터로 받아서
    // 삭제하는 deleteBoard 메소드
    private static void deleteBoard(int boardId) {
        // 먼저 정말로 게시글을 삭제할 지 물어본다
        String message = new String("게시글을 정말로 삭제할겁니까? 삭제하실거면 y 혹은 Y를 눌러주세요.");
        String yesNo = ScannerUtil.nextLine(sc, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            // 현재 게시글을 게시글 리스트에서 삭제

            // 임시로 객체 b를 만들어서 해당 객체의 id에 boardId 값을 set한다.
            Board b = new Board();
            b.setId(boardId);

            // list의 remove 메소드를 통해서 b를 삭제한다.
            boardList.remove(b);

            // 해당 게시글에 달려있던 댓글들을 댓글 리스트에서 삭제
            ArrayList<Reply> temp = selectReplyByBoardId(boardId);
            for (int i = 0; i < temp.size(); i++) {
                Reply r = temp.get(i);
                deleteReply(r.getId());
            }
        } else {
            printOneBoard(boardId);
        }
    }

    // 파라미터로 들어온 댓글 id값과 일치하는
    // 댓글을 리스트에서 삭제하는 deleteReply
    private static void deleteReply(int replyId) {
        Reply r = new Reply();
        r.setId(replyId);

        replyList.remove(r);
    }

    // 회원번호로 해당 회원의 닉네임을 찾아서 return하는 selectNicknameById() 메소드
    private static String selectNicknameById(int writerId) {
        String temp = new String();

        for (int i = 0; i < userList.size(); i++) {
            User u = userList.get(i);
            if (u.getId() == writerId) {
                return u.getNickname();

            }
        }
        return temp;

    }

    // 사용자가 넘겨준 id 값으로
    // replyList 중에 boardId가 일치하는 Reply 객체들을
    // ArrayList에 담아서 보내주는 selectReplyById() 메소드
    private static ArrayList<Reply> selectReplyByBoardId(int boardId) {
        ArrayList<Reply> temp = new ArrayList<>();

        for (int i = 0; i < replyList.size(); i++) {
            Reply r = replyList.get(i);

            if (boardId == r.getBoardId()) {
                temp.add(r);
            }
        }
        return temp;
    }

    // 사용자가 넘겨준 id 값으로 일치하는 객체를 찾아 리턴해주는
    // retrieveBoard() 메소드
    private static Board retrieveBoard(int id) {
        Board b = new Board();
        b.setId(id);
        if (boardList.contains(b)) {
            int index = boardList.indexOf(b);
            return boardList.get(index);
        }

        return null;
    }

    private static void writeBoard() {
        // Board 객체를 만들어
        // 정보를 넣고
        // boardList에 추가해준다.

        // 정보를 담을 Board 객체 생성
        // BoardList에 추가할 Board의 임시 객체 b
        Board b = new Board();

        // 우리가 미리 준비한 int변수 boardId의 값으로
        // b의 id를 정해주고 ++ 한다.
        b.setId(boardId++);

        // 이 게시글의 작성자 id는 당연히 로그인한 회원의 id가 되어야 한다.
        b.setWriterId(LogIn.getId());

        // 제목을 입력 받는다.
        String mesaage = new String("제목을 입력해주세요.");
        b.setTitle(ScannerUtil.nextLine(sc, mesaage));

        // 내용을 입력 받는다.
        mesaage = new String("내용을 입력해주세요.");
        b.setContent(ScannerUtil.nextLine(sc, mesaage));

        // 작성일과 수정일은 글을 작성하는 현재 시간이 들어가도록 해준다.
        b.setWrittenDate(Calendar.getInstance());
        b.setUpdatedDate(Calendar.getInstance());

        boardList.add(b);
    }

    // 회원가입 메소드
    private static void register() {
        System.out.println();
        System.out.println("회원 가입을 실행합니다.");
        System.out.println();

        User temp = new User();

        temp.setId(userId++);

        String message = new String("사용하실 아이디를 입력해주세요.");
        temp.setUserName(ScannerUtil.nextLine(sc, message));

        while (validateId(temp) || temp.getUserName().equalsIgnoreCase("X")) {
            System.out.println("해당 아이디는 사용하실 수 없습니다.");
            temp.setUserName(ScannerUtil.nextLine(sc, message));
        }

        message = new String("사용하실 비밀번호를 입력해 주세요.");
        temp.setPassWord(ScannerUtil.nextLine(sc, message));

        message = new String("사용하실 닉네임를 입력해 주세요.");
        temp.setNickname(ScannerUtil.nextLine(sc, message));

        userList.add(temp);
    }

    // 회원 리스트 중에서 중복된 아이디가 있는지 체크하는
    // validateId() 메소드
    private static boolean validateId(User u) {
        for (int i = 0; i < userList.size(); i++) {
            if (u.getUserName().equals(userList.get(i).getUserName()))

            {

                return true;
            }
        }
        return false;
    }

    private static void logIn() {
        // 임시로 id 와 비밀번호를 저장할 User 객체 u
        User u = new User();
        // 아이디와 비밀번호를 입력 받아서
        // u에 저장한다.
        String message = new String("아이디를 입력해주세요.");
        u.setUserName(ScannerUtil.nextLine(sc, message));

        message = new String("비밀번호를 입력해주세요.");
        u.setPassWord(ScannerUtil.nextLine(sc, message));

        // 리스트에서 id와 비밀번호가 일치하는 객체를 찾아서
        // 그 객체의 정보를 그대로 logInUser에 할당한다.
        LogIn = auth(u);

        while (LogIn == null) {
            System.out.println();
            System.out.println("해당하는 정보와 일치하는 회원이 없습니다.");
            System.out.println("다시 아이디와 비밀번호를 입력해주세요.");
            System.out.println();

            message = new String("아이디를 입력해주세요. 만약 뒤로 가시려면 x를 입력해주새요.");
            u.setUserName(ScannerUtil.nextLine(sc, message));

            if (u.getUserName().equalsIgnoreCase("X")) {
                break;
            }
            message = new String("비밀번호를 입력해주세요.");
            u.setPassWord(ScannerUtil.nextLine(sc, message));

            LogIn = auth(u);
        }
    }

    private static User auth(User u) {
        for (int i = 0; i < userList.size(); i++) {
            if (u.logIn(userList.get(i))) {
                return userList.get(i);
            }
        }
        return null;
    }
}
