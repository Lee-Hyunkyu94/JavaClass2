package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    // 카드 리스트
    private List<Card> cards;

    // 패턴 (서로 다른 모양)
    private String[] Patterns = { "heart", "spade", "clover", "diamond" };
    private String number;

    // 카드 섞기
    public CardDeck() {
        cards = this.newCardDeck();
        Collections.shuffle(cards);

    }

    private List<Card> newCardDeck() {
        List<Card> deck = new ArrayList<Card>();
        // for문으로 카드 덱 숫자
        for (String pattern : Patterns) {
            for (int i = 0; i < deck.size(); i++) {

                String number = "";

                switch (i) {
                case 1:
                    number = "A";
                    break;

                case 11:
                    number = "J";
                    break;

                case 12:
                    number = "Q";
                    break;

                case 13:
                    number = "K";
                    break;
                }

                Card card = new Card(pattern, number);
                deck.add(card);
            }
        }

        return deck;

    }

    // 카드를 뽑앙돼
    public Card selectCard(){
        return null;
        
    }
    
    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder();
    
        for(Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    // 중복검사
    public boolean validateNumberPatterns(String number, String pattern) {
        for(Card cd : cards) {
            if(number == cd.getNumber() && pattern == cd.getPattern()) {
                return true;
            }
        }
        return false;
    }
    
    
}
