// A class that does not implement java.lang.Iterable should not be flagged as non-multiple-iteration iterable.
package scensct.var.neg;

public class NegCase1_Var4 {
    // Using a static nested class for configuration
    private final int value;
    private final Config config;
    
    public NegCase1_Var4(int value) {
        this.value = value;
        this.config = new Config();
    }
    
    public int getValue() {
        return value;
    }
    
    // Nested static class unrelated to Iterable
    public static class Config {
        private boolean debug = false;
        public void enableDebug() { debug = true; }
        public boolean isDebug() { return debug; }
    }
    
    // Method that returns the nested class instance
    public Config getConfig() {
        return config;
    }
}