// Taint path with mutablePendingIntentCreation and additional taint step, and implicit read with FieldContent non-PendingIntent, node part of additional flow step should not be flagged.
package scensct.core.neg;

import android.content.Intent;
import android.app.PendingIntent;

public class NegCase8 {
    private Intent fieldIntent; // FieldContent of type Intent (not PendingIntent)

    public void test() {
        // Implicit Intent source with NoState
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
        // Additional taint step via field assignment
        fieldIntent = implicitIntent;
        // Implicit read of field as sink, not allowed, part of additional flow step, node type not array
        // PendingIntent sink with mutable flag, includes mutablePendingIntentCreation transition
        PendingIntent pendingIntent = PendingIntent.getActivity(null, 0, implicitIntent, PendingIntent.FLAG_MUTABLE);
        sendPendingIntent(pendingIntent);
    }

    private void sendPendingIntent(PendingIntent pi) {
        // Placeholder
    }
}