// Tainted source and XSLT sink are independent statements with no propagation.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class NegCase5 {
    public void independentOperations(HttpServletRequest request) throws Exception {
        // Scenario 5: Tainted source present.
        String userData = request.getParameter("info");
        // Independent XSLT sink using constant, no data flow from userData.
        TransformerFactory factory = TransformerFactory.newInstance();
        String constantXsl = "<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'><xsl:template match='/'><ok/></xsl:template></xsl:stylesheet>";
        factory.newTransformer(new StreamSource(new StringReader(constantXsl)));
    }
}