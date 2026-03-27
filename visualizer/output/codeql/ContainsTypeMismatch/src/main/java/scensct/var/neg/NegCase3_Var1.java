// Calling a method named contains on a non-collection type should not be flagged.
package scensct.var.neg;

public class NegCase3_Var1 {
    static class CustomContainer {
        public boolean contains(Object obj) {
            return false;
        }
    }
    
    static boolean checkContains(CustomContainer c, Object o) {
        return c.contains(o);
    }
    
    public static void main(String[] args) {
        CustomContainer container = new CustomContainer();
        boolean result = checkContains(container, "test");
        System.out.println(result);
    }
}