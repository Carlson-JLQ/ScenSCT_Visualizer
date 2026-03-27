// User-controlled data flows into JexlEngine.createScript with unsafe engine and script is evaluated, should be flagged as JEXL expression injection.
package scensct.ref.pos;

import org.apache.commons.jexl3.*;

public class PosCase1_FN1 {
    public static void main(String[] args) {
        String userInput = args[0]; // tainted source
        JexlEngine engine = new JexlEngine(); // unsafe engine, no sandbox/uberspect
        JexlScript script = engine.createScript(userInput); // tainted data flows into createScript
        script.execute(null); // evaluation leads to injection
    }
}