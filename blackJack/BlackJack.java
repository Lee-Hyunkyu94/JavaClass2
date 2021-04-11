package blackJack;
import java.util.Scanner;

public class BlackJack {
    
    Scanner sc = new Scanner(System.in);
    Card card;
    CardDeck cardDeck;
    
    public void play() {
       System.out.println("=============BlackJack============");
       Scanner sc = new Scanner(System.in);
       Gamer gamer = new Gamer();
       Dealer dealer = new Dealer();
       CardDeck cardDeck = new CardDeck();
       PlayingGame(sc,cardDeck,gamer,dealer);
       
    }
    
    private void PlayingGame(Scanner sc, CardDeck cardDeck, Gamer gamer, Dealer dealer) {
        String gamerInput, dealerInput;
        boolean gamerturn = false , dealerturn = false;
        while(true) {
            System.out.println("카드를 더 뽑게요? 그럼 1번 싫으면 0번");
            gamerInput = sc.nextLine();
            
            if("0".equals(gamerInput)) {
               gamerturn = true;
            }else {
                Card card = cardDeck.selectCard();
                gamer.receiveCard(card);
            }
            
            System.out.println("카드를 더 뽑게요? 그럼 1번 싫으면 0번");
            dealerInput = sc.nextLine();
            
            if("0".equals(dealerInput)) {
                dealerturn = true;
            }else {
                Card card = cardDeck.selectCard();
                dealer.receiveCard(card);
            }
            
            if(gamerturn&&dealerturn) {
                break;
            }
            }
    }
    
    private void firstgameinit(CardDeck cardDeck, Gamer gamer, Dealer dealer) {
        System.out.println("처음 2장의 카드를 줄게요.");
        for(int i = 0; i < 2;i++) {
            Card card = cardDeck.selectCard();
            gamer.receiveCard(card);
            
            Card card2 = cardDeck.selectCard();
            dealer.receiveCard(card2);
                    
        }
    }
}
