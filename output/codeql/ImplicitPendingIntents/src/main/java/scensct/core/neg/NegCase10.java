// Taint path with mutablePendingIntentCreation and additional taint step, and implicit read with FieldContent non-PendingIntent, node part of additional flow step, array of Intent elements not ArrayContent should not be flagged.
package scensct.core.neg;

import android.content.Intent;
import android.app.PendingIntent;

public class NegCase10 {
    private Intent[] fieldIntentArray; // FieldContent of type Intent[] (not PendingIntent), array of Intent elements

    public void test() {
        // Implicit Intent source with NoState
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
        // Additional taint step via field assignment
        fieldIntentArray = new Intent[]{implicitIntent};
        // Implicit read of field as not sink, part of additional flow step, node type array of Intent, content not ArrayContent
        // PendingIntent sink with mutable flag, includes mutablePendingIntentCreation transition
        PendingIntent pendingIntent = PendingIntent.getActivity(null, 0, implicitIntent, PendingIntent.FLAG_MUTABLE);
        sendPendingIntent(pendingIntent);
    }

    private void sendPendingIntent(PendingIntent pi) {
        // Placeholder
    }
}