// A constructor call for StringBuffer or StringBuilder where the first argument is not of type char should not be flagged as misinterpreted character capacity.
package scensct.var.neg;

public class NegCase1_Var5 {
    // Variant 5: Mixed constructors with method return as argument
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder(getCapacity());
        StringBuffer sb2 = new StringBuffer(getText());
        StringBuilder sb3 = new StringBuilder();
    }
    
    private static int getCapacity() {
        return 100;
    }
    
    private static String getText() {
        return "initial";
    }
}