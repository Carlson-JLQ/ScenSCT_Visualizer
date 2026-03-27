// A record class with a direct member named "normalField" should not be flagged as having a special serialization-related name.
package scensct.var.neg;

public class NegCase1_Var1 {
    // Variant 1: Rename component and add a static field with a non-special name
    record MyRecord(String dataValue) {
        private static final int DEFAULT_COUNT = 1;
        
        public String retrieve() {
            return dataValue;
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("test");
        System.out.println(r.retrieve());
    }
}