// Calling a method named contains on a non-collection type should not be flagged.
package scensct.var.neg;

public class NegCase3_Var2 {
    interface Holder {
        boolean has(Object item);
    }
    
    static class CustomContainer implements Holder {
        public boolean contains(Object obj) {
            return false;
        }
        
        @Override
        public boolean has(Object item) {
            return contains(item);
        }
    }
    
    public static void main(String[] args) {
        Holder holder = new CustomContainer();
        boolean result = ((CustomContainer) holder).contains("test");
        System.out.println(result);
    }
}