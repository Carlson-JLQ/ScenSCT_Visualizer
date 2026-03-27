// A constructor call that does not instantiate java.text.SimpleDateFormat should not be flagged as suspicious date format pattern.
package scensct.var.neg;

import java.text.DateFormat;

public class NegCase1_Var3 {
    private static DateFormat createDateFormat(String pattern) {
        // Helper method that returns DateFormat but internally uses SimpleDateFormat
        return new java.text.SimpleDateFormat(pattern);
    }
    
    public static void main(String[] args) {
        // Variant 3: Move constructor call to a helper method
        DateFormat df = createDateFormat("yyyy-MM-dd");
        // The call site does not directly invoke SimpleDateFormat constructor
    }
}