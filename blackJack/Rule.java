package blackJack;

import java.util.List;

public class Rule {
    // 변수 생성
    Card card;
    private List<Card> cards;
    private int score;
    private static final int BLACKJACK = 21;

    Gamer gm = new Gamer();

    Dealer dr = new Dealer();

    // 점수측정
    void accountscore() {
        System.out.println("your score: " + score + "point");
    }

    // 승패판단
    void winorlose() {
        int lastgmsum = BLACKJACK - gm.getSum();
        int lastdrsum = BLACKJACK - dr.getSum();

        while (lastgmsum >= 0 && lastdrsum >= 00) {
            if (lastgmsum < lastdrsum) {
                score++;
                System.out.println("you are winner!");
            } else if (lastgmsum == lastdrsum) {
                System.out.println("draw!");
            } else if (lastgmsum > lastdrsum) {
                score--;
                System.out.println("you are loser!");
            }
            
            break;
        }
    }

    // 카드 받기
    void getCard(Card card) {

    }

    // 뽑은 카드 소유
    void receiveCard(Card card) {
        this.cards.add(card);
    }

    // 카드 오픈
    void printCards() {

    }

    // 합계
    int getSum() {
        return 0;
    }
}

class Gamer extends Rule {
    Card card;

    private List<Card> deck;

    private int sum;

    @Override
    void receiveCard(Card card) {
        this.deck.add(card);
    }

    @Override
    void printCards() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gamer's Card: ");

        for (Card card : deck) {
            sb.append(card.toString());
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    @Override
    int getSum() {
        sum = 0;
        for (Card card : deck) {
            sum += Integer.parseInt(card.getNumber());
        }

        return sum;
    }
}

class Dealer extends Rule {
    Card card;

    private List<Card> deck;

    private int sum;

    @Override
    void receiveCard(Card card) {
        if(this.checkSum()) {
            this.deck.add(card);
            this.printCards();
        } else {
            System.out.println("카드의 합이 17 이상입니다. 더이상 카드를 받을 수 없습니당.");
        }
    }

    @Override
    void printCards() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dealer's Card: ");

        for (Card card : deck) {
            sb.append(card.toString());
            sb.append("");
        }

        System.out.println(sb.toString());
    }

    @Override
    public int getSum() {
        sum = 0;
        for (Card card : deck) {
            sum += Integer.parseInt(card.getNumber());
        }

        return sum;
    }

    public boolean checkSum() {

        if (sum <= 16) {
                return true;
            

        } else {
            return false;
        }

    }

}
