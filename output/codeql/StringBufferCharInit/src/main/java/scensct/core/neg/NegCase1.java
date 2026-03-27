// A constructor call for StringBuffer or StringBuilder where the first argument is not of type char should not be flagged as misinterpreted character capacity.
package scensct.core.neg;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: First argument is int (capacity), not char
        StringBuilder sb1 = new StringBuilder(100);
        // First argument is String, not char
        StringBuffer sb2 = new StringBuffer("initial");
        // No argument constructor
        StringBuilder sb3 = new StringBuilder();
    }
}