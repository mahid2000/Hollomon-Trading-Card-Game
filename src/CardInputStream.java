import java.io.*;

// CardInputStream class that implements the InputStream class
public class CardInputStream extends InputStream {
    
    BufferedReader read;
    String temp;
    Card newCard;
    Long id = (long) 0;
    String name = null;
    Rank rank = null;
    //long price;
    int argCount = 0;

    // COnstructor that creates instance of Buffered reader which wraps wround inputstream
    public CardInputStream(InputStream input) {
        read = new BufferedReader(new InputStreamReader(input));
    }

    //Overiden close method to close reader
    @Override
    public void close() {
        try {
            read.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Method that reads details of card object and creates then returns a corresponding card object 
    Card readCard() {
        

        try {
            //System.out.println("Is this your Card?");
            while ((temp = this.read.readLine()).contains("OK") == false){
                //System.out.println(temp);
                //System.out.println(argCount);
                
                //System.out.println(argCount);

                //I used a counter to count the the values after each CARD object and then assign them to their corresponding variable names
                // every time CARD shows up the counter resets indicating a new card object and iterating through that objects details
                if (temp.contains("CARD") == true){
                    argCount = 0;  
                    System.out.println("Reset"); 
                }
                System.out.println(argCount);

                //Assign details to the card variables
                if (argCount == 1){
                    id = Long.parseLong(temp);
                    //System.out.println(id);
                }
                if (argCount == 2){
                    name = temp;
                    //System.out.println(name);
                }
                if (argCount == 3){
                    rank = Rank.valueOf(temp);
                    //System.out.println(rank);
                }
                argCount += 1;

            }
            // generate new card object with the colected details and return it
            newCard = new Card(id, name, rank);
            System.out.println("Added card " + newCard);
            return newCard;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    // method to read line response from server using reader and return any non card messages
    String readResponse() {
        String response = null;
        String temp = null;

        try {
            //System.out.println(this.read.readLine());
            while ((temp = this.read.readLine()) != null){
                //System.out.println("The temp is" + temp);
                //response = response + temp;
                //System.out.println("the response is" + response);
                return response = temp;
            }
            //return response;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        if (response == null) {
            response = "OK";
        }
        //System.out.println("the response is" + response);
        //System.out.println("the temp is" + temp);
        return response;
        
        
    }
    
    @Override
    public int read() throws IOException {
        // TODO Auto-generated method stub
        return 0;
    }

}
