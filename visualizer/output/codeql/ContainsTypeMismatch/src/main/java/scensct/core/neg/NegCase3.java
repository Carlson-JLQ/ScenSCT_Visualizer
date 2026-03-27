// Calling a method named contains on a non-collection type should not be flagged.
package scensct.core.neg;

public class NegCase3 {
    // Custom class with a contains method, not a Java collection subtype.
    static class CustomContainer {
        public boolean contains(Object obj) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        CustomContainer container = new CustomContainer();
        // Calling contains on CustomContainer, which is not a subtype of java.util.Collection.
        boolean result = container.contains("test");
        System.out.println(result);
    }
}