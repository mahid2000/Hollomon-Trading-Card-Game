import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class CardTest {
    
    public static void main(String[] args) {

        Card c0 = new Card(1, "card1", Rank.COMMON);
        Card c1 = new Card(2, "card2", Rank.COMMON);
        Card c2 = new Card(1, "card1", Rank.COMMON);
        Card c3 = new Card(1, "card3", Rank.RARE);
        Card c4 = new Card(2, "card4", Rank.UNCOMMON);
        Card c5 = new Card(1, "card4", Rank.UNIQUE);

        Set<Card> deck1 = new HashSet<Card>();
        Set<Card> deck2 = new TreeSet<Card>();

        c1.price = (long) 2;

        deck1.add(c0);
        deck1.add(c1);
        deck1.add(c2);
        deck1.add(c3);
        deck1.add(c4);
        deck1.add(c5);


        deck2.add(c0);
        deck2.add(c1);
        deck2.add(c2);
        deck2.add(c3);
        deck2.add(c4);
        deck2.add(c5);


        System.out.println("Hashset contains " + deck1.size() + " elements");
        System.out.println(deck1);

        System.out.println("Treeset contains " + deck2.size() + " elements");
        System.out.println(deck2);





        
    }

}
