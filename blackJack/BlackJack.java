package blackJack;

import java.util.Scanner;

import util.ScannerUtil;

public class BlackJack {
    
    Scanner sc = new Scanner(System.in);
    Card card;
    
    public void play() {
       System.out.println("=============BlackJack============");
       Scanner sc = new Scanner(System.in);
       
       
       Gamer gamer = new Gamer();
       Dealer dealer = new Dealer();
     
       CardDeck cardDeck = new CardDeck();
       
       PlayingGame(sc,cardDeck,gamer,dealer);
       
    }
    
    private void PlayingGame(Scanner sc, CardDeck cardDeck, Gamer gamer, Dealer dealer) {
        
        while(true) {
            System.out.println("----------------------");
            String message = new String("1. 게임시작 2. 종료");
            int userChoice = ScannerUtil.nextInt(sc, message, 1, 2);
            
            if(userChoice == 1) {
                card = cardDeck.selectCard();
                gamer.receiveCard(card);
                card = cardDeck.selectCard();
                dealer.receiveCard(card);
            } else if(userChoice == 2) {
                break;
            }
        }
    }
}
