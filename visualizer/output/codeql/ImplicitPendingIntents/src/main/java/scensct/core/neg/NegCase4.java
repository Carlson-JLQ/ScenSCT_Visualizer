// Taint path from implicit Intent source to mutable PendingIntent sink without ExplicitIntentSanitizer, but no mutablePendingIntentCreation transition should not be flagged.
package scensct.core.neg;

import android.content.Intent;
import android.app.PendingIntent;

public class NegCase4 {
    public void test() {
        // Implicit Intent source with NoState
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
        // Direct flow to PendingIntent sink with mutable flag, but no mutablePendingIntentCreation transition (e.g., via getActivity directly)
        PendingIntent pendingIntent = PendingIntent.getActivity(null, 0, implicitIntent, PendingIntent.FLAG_MUTABLE);
        sendPendingIntent(pendingIntent);
    }

    private void sendPendingIntent(PendingIntent pi) {
        // Placeholder
    }
}