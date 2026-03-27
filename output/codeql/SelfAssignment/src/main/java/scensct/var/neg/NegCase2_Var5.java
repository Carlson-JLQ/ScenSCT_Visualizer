// Assignment between different variables should not be flagged as self-assignment.
package scensct.var.neg;

public class NegCase2_Var5 {
    static class Holder {
        int value;
        Holder(int v) { this.value = v; }
    }
    
    public static void main(String[] args) {
        Holder h1 = new Holder(1);
        Holder h2 = new Holder(2);
        h1.value = h2.value; // Assignment through field access, distinct holders
    }
}