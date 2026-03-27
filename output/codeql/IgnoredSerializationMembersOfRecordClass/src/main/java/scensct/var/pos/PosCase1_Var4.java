// A record class declares a direct member with a name exactly matching one of the special serialization-related names should be flagged as a violation.
package scensct.var.pos;

import java.io.*;

public final class PosCase1_Var4 {
    // Variant 4: Idiomatic variation - use a different special serialization method name (readObject) with matching signature
    public record MyRecord(String data) {
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException { // changed to readObject // [REPORTED LINE]
            in.defaultReadObject();
        }
    }

    public static void main(String[] args) {
        MyRecord r = new MyRecord("sample");
        System.out.println(r.data());
    }
}