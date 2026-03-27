// An object instantiated and flows to a sink but its type does not implement HostnameVerifier should not be flagged.
package scensct.var.neg;

import javax.net.ssl.HttpsURLConnection;
import java.util.ArrayList;
import java.util.List;

public class NegCase5_Var4 {
    static class MyType {
        // Not a HostnameVerifier
    }

    public static void main(String[] args) throws Exception {
        MyType item = new MyType();
        List<Object> list = new ArrayList<>();
        list.add(item);
        Object fromList = list.get(0);
        // Pass to generic sink
        System.out.println(fromList.toString());
    }
}