// Creating a non-Writer/OutputStream instance should not be flagged as resource leak.
package scensct.core.neg;

import java.util.ArrayList;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: Instance is ArrayList, not a Writer/OutputStream subtype.
        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        System.out.println(list.size());
    }
}