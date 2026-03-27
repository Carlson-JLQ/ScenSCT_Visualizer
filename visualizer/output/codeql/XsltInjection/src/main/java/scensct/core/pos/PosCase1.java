// User-controlled input flows directly into XSLT stylesheet source parameter without sanitization should be flagged as XSLT injection.
package scensct.core.pos;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;

public class PosCase1 {
    public void transform(HttpServletRequest request) throws Exception {
        String userInput = request.getParameter("xsl"); // User-controlled input
        Source xslt = new StreamSource(new StringReader(userInput)); // Direct flow into Source
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.newTransformer(xslt); // XSLT injection vulnerability
    }
}