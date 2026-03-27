// A constructor call that does not instantiate java.text.SimpleDateFormat should not be flagged as suspicious date format pattern.
package scensct.core.neg;

import java.text.DateFormat;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario: Constructor is for DateFormat, not SimpleDateFormat
        DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
    }
}