import java.io.*;
import java.net.Socket;
import java.util.*;


public class HollomonClient {

    String server;
    int port;
    BufferedReader read;
    BufferedWriter write;
    InputStream input;
    OutputStream output;
    Socket hollomon;
    CardInputStream CIS;
    List<Card> deck = new ArrayList<Card>();
    Card c;
    String temp;
    Boolean log = false;
    
    //Constructor that makes Client object and initilises the socket, input and output strems and the buffered readers and writers
    public HollomonClient(String server, int port) { 
        
        try {

            hollomon = new Socket(server, port); 
            input = hollomon.getInputStream();
            output = hollomon.getOutputStream();
            
            //The buffered reader and writers have the inputstrem readers and writers encapsualted within them
            read = new BufferedReader(new InputStreamReader(input));
            write = new BufferedWriter(new OutputStreamWriter(output));
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

    

    // Login method that uses buffered writer to sent the login details to the server, and the buffered reader to get the response abck from the sever to the client
    public List<Card> login(String username, String password) {
        
        try {
            write.write(username + "\r\n");
            write.write(password + "\r\n");
            write.flush();

            // while response isnt empty, if the login is succesful brek out of loop, else reyutn null
            while ((temp= read.readLine()) != null/*&& (temp= read.readLine()) != ("User " + username + " logged in successfully.")*/) {
                System.out.println("This is temp " + temp);
                if (temp.contains("successfully") == true) {
                    break;
                } 
                if (temp.contains("No such user") == true) {
                    return null;
                }
            }
            
            //Initialise the CardInputStream for Q4
            CIS = new CardInputStream(input);
            System.out.println("read card is " + CIS.readCard());
            
            //This is my attempt of Q4 but it only added one card and broke the tester for Q3
            /*while ((c = CIS.readCard()) != null) {
                System.out.println("This is read card " + (c = CIS.readCard()));
                deck.add(c); 
            }*/
    
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(deck);
        System.out.println("this is the deck of cards returned to client ");
        return deck;
        

        
        
    }

    // Clsoe method to clsoe all readers, writers, input streams , output streams and sockets
    public void close() {
        
        try {
            read.close();
            write.close();
            input.close();
            hollomon.close();
            output.close();
            //CIS.close();
        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
       

}
