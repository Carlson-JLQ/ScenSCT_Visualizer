// A record class declares a direct member with a name exactly matching one of the special serialization-related names should be flagged as a violation.
package scensct.var.pos;

import java.io.*;

public final class PosCase1_Var5 {
    // Variant 5: Structural refactoring - move record to a static nested class, add an unrelated default method
    public static final class Container {
        public record MyRecord(String data) {
            private void writeObject(ObjectOutputStream out) throws IOException { // [REPORTED LINE]
                out.defaultWriteObject();
            }

            public String getDataUpperCase() { // unrelated default method
                return data.toUpperCase();
            }
        }
    }

    public static void main(String[] args) {
        Container.MyRecord r = new Container.MyRecord("nested");
        System.out.println(r.data());
    }
}