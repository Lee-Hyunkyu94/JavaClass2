package blackJack;

import java.util.Scanner;

import util.ScannerUtil;

public class BlackJack {
    
    Scanner sc = new Scanner(System.in);
    
    public void play() {
        Dealer dealer = new Dealer();
        Gamer gamer = new Gamer();
        Rule rule = new Rule();
        CardDeck cardDeck = new CardDeck();
        
        
    }
    
    public void PlayingGame(CardDeck cardDeck, Gamer gamer, Dealer dealer, Rule rule) {
        while(true) {
            System.out.println("----------------------");
            String message = new String("1. 게임시작 2. 종료");
            int userChoice = ScannerUtil.nextInt(sc, message, 1, 2);
            
            if(userChoice == 1) {
                Card card = cardDeck.selectCard();
                gamer.getCard(card);
                dealer.printCards();
                gamer.printCards();
                rule.winorlose();
                rule.accountscore();
            } else if(userChoice == 2) {
                break;
            }
        }
    }
}
