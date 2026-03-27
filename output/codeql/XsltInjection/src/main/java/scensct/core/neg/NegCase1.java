// Constant string should not be flagged as tainted source for XSLT injection.
package scensct.core.neg;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class NegCase1 {
    public static void main(String[] args) throws Exception {
        // Scenario 1: Source is a constant string, not a recognized tainted source.
        String stylesheet = "<?xml version=\"1.0\"?><xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"><xsl:template match=\"/\"><html></html></xsl:template></xsl:stylesheet>";
        TransformerFactory factory = TransformerFactory.newInstance();
        // Sink uses constant source, no user input involved.
        factory.newTransformer(new StreamSource(new StringReader(stylesheet)));
    }
}