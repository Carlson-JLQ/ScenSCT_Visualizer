// Tainted source and XSLT sink present but sink uses different non-tainted input.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class NegCase3 {
    public void transform(HttpServletRequest request) throws Exception {
        // Scenario 3: Tainted source exists.
        String taintedInput = request.getParameter("xsl");
        // Sink uses a constant, different from the tainted input.
        String safeStylesheet = "<?xml version=\"1.0\"?><xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"><xsl:template match=\"/\"><html></html></xsl:template></xsl:stylesheet>";
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.newTransformer(new StreamSource(new StringReader(safeStylesheet)));
    }
}