package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CardDeck{
    Card card;
    // 카드 리스트
    private List<Card> cards;

    // 패턴 (서로 다른 모양)
    private String[] Patterns = { "heart", "spade", "clover", "diamond" };
    private String number;
    private int point;
    private final int CARD_COUNT = 13;

    // 생성자
    public CardDeck() {
        cards = this.newCardDeck();
        Collections.shuffle(cards);
    }
 
    // 덱 만드는 메소드
    private List<Card> newCardDeck() {
        List<Card> deck = new ArrayList<>();
        // for문으로 카드 덱 숫자
        for (String pattern : Patterns) {
            for (int i = 1; i <= CARD_COUNT; i++) {
                Card card = new Card();
                number = this.inttoString(i);

                card = new Card(pattern, number, point);
                deck.add(card);
            }
        }

        return deck;

    }

    // 숫자를 A J Q K 로 변환하는 메소드.
    public String inttoString(int number) {
        if (number == 1) {
            return "A";
        } else if (number == 11) {
            return "J";
        } else if (number == 12) {
            return "Q";
        } else if (number == 13) {
            return "K";
        }

        return String.valueOf(number);
    }
    
    private int intopoint(int number) {
        if(number >= 11) {
            return 10;
        }
        return number;
    }

    public Card selectCard(){
        Card selectedCard = getRandomCard();
        cards.remove(selectedCard);
        return selectedCard;
    }

    private Card getRandomCard() {
        for(int i = 0; i < cards.size(); i++) {
            int size = i;
            System.out.println(size);
            return cards.get(size);
            
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Card card : cards) {
            sb.append(card.toString());
            sb.append("\n");
        }

        return sb.toString();
    }

}
