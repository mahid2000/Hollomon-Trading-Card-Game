
// Create Card class implementing comaprable interface
public class Card implements Comparable<Card> {

    private Long id;
    private String name;
    private Rank rank;
    public long price;

    //Constructor to construct Card object
    public Card(long id, String name, Rank rank) {
        this.id = id;
        this.name = name;
        this. rank = rank;
        this.price = (long) 0;
    }

    //Overriden toString()  method to print card values as a string
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.id + " " + this.name + " " + this.rank + " " + this.price;
    }

    // Overriden hashcode() method to make sure id is 32 bit
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return (int) ((id >> 32) ^ id);
    }

    //Overidden equals()  method to check if all 3 values of two Card objects are equlivant. Cards can oly be equal if they have the same name rank and id
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        if (!(obj instanceof Card)) {
            //System.out.println("False");
            return false;
        }
        Card other = (Card) obj;
        //System.out.println("True");
        //System.out.println(this.id.equals(other.id));
        //System.out.println(this.name.equals(other.name));
        //System.out.println(this.rank == other.rank);
        return (this.id.equals(other.id) && this.name.equals(other.name) && this.rank == other.rank);
    }

    //Ovveriden compareTo() method to compare the Cards. returns int 0 if all 3 CArd values are equal, else returns int representing how far off one value is from the other (i.e >0 or <0)
    @Override
    public int compareTo(Card o) {
        // TODO Auto-generated method stub
        int conferRank = this.rank.compareTo(o.rank);
        int conferName = this.name.compareTo(o.name);
        int conferId = this.id.compareTo(o.id);
        if (conferRank == 0) {
            if (conferName == 0) {
                if (conferId == 0) {
                    return conferId;
                }
                return conferId;
            }
            return conferName;
        }
        //System.out.println(conferRank);
        //System.out.println(this.rank);
        //System.out.println(o.rank);
        //System.out.println(conferName);
        return conferRank;
    }

}
