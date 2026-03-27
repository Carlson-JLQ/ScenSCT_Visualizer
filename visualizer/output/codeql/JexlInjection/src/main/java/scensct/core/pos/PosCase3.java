// User-controlled data flows into JxltEngine.createTemplate with unsafe engine and template is evaluated, should be flagged as JEXL expression injection.
package scensct.core.pos;

import org.apache.commons.jexl3.*;

public class PosCase3 {
    public static void main(String[] args) {
        String userInput = args[0]; // tainted source
        JexlEngine jexlEngine = new JexlEngineBuilder().sandbox(null).create(); // explicitly unsafe base engine
        JxltEngine engine = jexlEngine.createJxltEngine(); // derived unsafe JxltEngine
        JxltEngine.Template template = engine.createTemplate(userInput); // tainted data flows into createTemplate
        template.evaluate(null, null); // evaluation leads to injection
    }
}