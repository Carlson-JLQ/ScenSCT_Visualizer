// A record class with a direct member named "normalField" should not be flagged as having a special serialization-related name.
package scensct.var.neg;

public class NegCase1_Var3 {
    // Variant 3: Add a non-special static final field and a helper static method
    record MyRecord(String normalField) {
        static final String PREFIX = "val: ";
        
        public String getData() {
            return PREFIX + normalField;
        }
        
        static String format(String s) {
            return PREFIX + s;
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("test");
        System.out.println(r.getData());
        System.out.println(MyRecord.format("demo"));
    }
}