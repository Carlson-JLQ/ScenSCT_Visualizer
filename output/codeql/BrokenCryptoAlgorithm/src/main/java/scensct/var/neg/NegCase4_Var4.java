// A string literal matching the insecure pattern flows along a path but does not reach the algorithm parameter of a cryptographic operation should not be flagged as insecure crypto usage.
package scensct.var.neg;

public class NegCase4_Var4 {
    public static void main(String[] args) throws Exception {
        char[] chars = {'D', 'E', 'S', '/', 'E', 'C', 'B', '/', 'P', 'K', 'C', 'S', '5', 'P', 'a', 'd', 'd', 'i', 'n', 'g'};
        String alg = new String(chars);
        String upper = alg.toUpperCase();
        String firstThree = new String(new char[]{upper.charAt(0), upper.charAt(1), upper.charAt(2)});
        String secureAlg = "AES";
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(secureAlg);
        System.out.println("First three chars: " + firstThree);
    }
}