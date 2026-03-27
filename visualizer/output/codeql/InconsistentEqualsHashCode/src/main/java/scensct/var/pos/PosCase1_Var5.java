// A class that overrides hashCode but does not override equals should be flagged as a violation.
package scensct.var.pos;

public class PosCase1_Var5 { // [REPORTED LINE]
    private static class Data {
        int id;
    }
    
    private Data data;
    
    public PosCase1_Var5(int id) {
        data = new Data();
        data.id = id;
    }
    
    @Override
    public int hashCode() {
        // HashCode based on nested object's field
        return data.id;
    }
    
    // Added a finalize method (irrelevant)
    @Override
    protected void finalize() throws Throwable {
        try {
            data = null;
        } finally {
            super.finalize();
        }
    }
    
    // No equals method
}