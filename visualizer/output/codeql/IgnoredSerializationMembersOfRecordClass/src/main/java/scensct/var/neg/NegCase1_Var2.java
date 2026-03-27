// A record class with a direct member named "normalField" should not be flagged as having a special serialization-related name.
package scensct.var.neg;

public class NegCase1_Var2 {
    // Variant 2: Use compact constructor and add an instance method with a generic name
    record MyRecord(String normalField) {
        public MyRecord {
            if (normalField == null) throw new IllegalArgumentException();
        }
        
        public String fetch() {
            return normalField.toUpperCase();
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("test");
        System.out.println(r.fetch());
    }
}