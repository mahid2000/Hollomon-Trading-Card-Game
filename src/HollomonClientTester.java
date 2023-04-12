import java.util.List;

public class HollomonClientTester {
    public static void main(String[] args) {
        HollomonClient hc0 = new HollomonClient("netsrv.cim.rhul.ac.uk", 1812);
        List al0 = hc0.login("bottest", "testpass");
        hc0.close();
        HollomonClient hc1 = new HollomonClient("netsrv.cim.rhul.ac.uk", 1812);
        List al1 = hc1.login("iamnotauser", "maybethisisapassword");
        hc1.close();
        HollomonClient hc2 = new HollomonClient("netsrv.cim.rhul.ac.uk", 1812);
        List al2 = hc2.login("which", "oncefieldthe");
        hc2.close();
    }
}
