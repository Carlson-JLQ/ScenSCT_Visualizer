// Calling non-Object.equals/hashCode methods or equals with incompatible array types should not be flagged.
package scensct.core.neg;

public class NegCase2 {
    // Custom class with its own equals/hashCode to differentiate from Object's methods
    static class Custom {
        public boolean equals(Custom other) { // Not Object.equals(Object)
            return true;
        }
        public int hashCode(String input) {   // Not Object.hashCode()
            return input.length();
        }
        public String toString() {
            return "";
        }
    }
    
    public static void main(String[] args) {
        // Scenario 2.1: Array receiver but method is not Object.equals/hashCode
        int[] arr = new int[5];
        Custom custom = new Custom();
        boolean eqCustom = custom.equals(custom); // Custom.equals, not Object.equals
        int hashCustom = custom.hashCode("test"); // Custom.hashCode, not Object.hashCode
        String str = arr.toString();              // toString method, not equals/hashCode
        
        // Scenario 2.2: Object.equals called with incompatible array type argument
        String[] strArr = new String[2];
        int[] intArr = new int[2];
        // Arrays have no type intersection (String[] vs int[])
        boolean incompatible = strArr.equals(intArr); // Should not trigger
    }
}