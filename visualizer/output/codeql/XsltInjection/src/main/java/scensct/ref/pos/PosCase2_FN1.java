// User-controlled input flows into XSLT Source with FEATURE_SECURE_PROCESSING not set to true should be flagged as XSLT injection.
package scensct.ref.pos;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;

public class PosCase2_FN1 {
    public void transform(HttpServletRequest request) throws Exception {
        String userInput = request.getParameter("xsl"); // User-controlled input
        Source xslt = new StreamSource(new StringReader(userInput)); // Flow into Source
        TransformerFactory factory = TransformerFactory.newInstance();
        // FEATURE_SECURE_PROCESSING not set
        factory.newTransformer(xslt); // XSLT injection vulnerability
    }
}