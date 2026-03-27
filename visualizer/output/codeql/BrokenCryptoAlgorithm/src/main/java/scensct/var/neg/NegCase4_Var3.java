// A string literal matching the insecure pattern flows along a path but does not reach the algorithm parameter of a cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase4_Var3 {
    private static String getPrefix() {
        String s = "DES/ECB/PKCS5Padding";
        return s.toUpperCase().substring(0, 3);
    }
    
    public static void main(String[] args) throws Exception {
        String prefix = getPrefix();
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("AES");
        System.out.println("Got prefix: " + prefix);
    }
}