// A record class with a direct member named "normalField" should not be flagged as having a special serialization-related name.
package scensct.core.neg;

public class NegCase1 {
    // Record with a normal field name, not a special serialization name
    record MyRecord(String normalField) {
        // Normal method name, not a special serialization name
        public String getData() {
            return normalField;
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("test");
        System.out.println(r.getData());
    }
}