// No insecure randomness source should not be flagged as insecure randomness usage.
package scensct.var.neg;

public class NegCase1_Var5 {
    public static void main(String[] args) {
        // Simulating a scenario with a pseudo-random source that is not from java.util.Random.
        // Using a simple linear congruential generator (LCG) for demonstration, but it's custom and not a standard insecure source.
        // The checker should not flag custom deterministic sequences as insecure randomness unless they match the rule.
        int seed = 12345;
        int x = customLCG(seed);
        System.out.println(x);
    }
    
    private static int customLCG(int seed) {
        // Custom LCG: not a standard insecure random API, so it should not trigger the rule.
        int a = 1664525;
        int c = 1013904223;
        int m = (int) Math.pow(2, 32);
        return (a * seed + c) % m;
    }
}