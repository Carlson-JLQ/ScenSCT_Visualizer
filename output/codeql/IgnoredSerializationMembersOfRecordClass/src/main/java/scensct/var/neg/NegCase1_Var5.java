// A record class with a direct member named "normalField" should not be flagged as having a special serialization-related name.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Add a nested static class and override toString without special names
    record MyRecord(String normalField) {
        static class Logger {
            static void log(String msg) {
                System.out.println("Log: " + msg);
            }
        }
        
        @Override
        public String toString() {
            Logger.log("toString called");
            return "MyRecord[" + normalField + "]";
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("test");
        System.out.println(r);
    }
}