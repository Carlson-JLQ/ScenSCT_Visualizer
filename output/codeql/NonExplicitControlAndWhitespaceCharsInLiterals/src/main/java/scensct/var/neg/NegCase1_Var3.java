// Printable ASCII and normal whitespace in string/numeric literals should not be flagged as containing non-explicit control characters.
package scensct.var.neg;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring with temporaries
        String result = "";
        String[] parts = {"Hello, World! 123", " \t\n\r\f", "Tab:\tNewline:\nReturn:\rFormfeed:\f"};
        for (String part : parts) {
            result += part;
        }
        int numericSum = 0;
        int[] nums = {42, 0x2A, 0b101010};
        for (int n : nums) {
            numericSum += n; // not used, just to hold literals
        }
        System.out.println(result + 42 + 0x2A + 0b101010);
    }
}