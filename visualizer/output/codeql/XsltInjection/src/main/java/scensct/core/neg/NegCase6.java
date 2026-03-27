// Tainted data reaches XSLT sink but lacks standard taint flow edges to the call.
package scensct.core.neg;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class NegCase6 {
    public void transformWithInterruption(HttpServletRequest request) throws Exception {
        // Scenario 6: Tainted source.
        String rawInput = request.getParameter("sheet");
        // Flow interruption: assign to a new variable without propagation to sink.
        String intermediate = rawInput;
        // Sink uses a constant, breaking the flow path.
        TransformerFactory factory = TransformerFactory.newInstance();
        String safeXsl = "<?xml version='1.0'?><xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'><xsl:template match='/'></xsl:template></xsl:stylesheet>";
        factory.newTransformer(new StreamSource(new StringReader(safeXsl)));
    }
}