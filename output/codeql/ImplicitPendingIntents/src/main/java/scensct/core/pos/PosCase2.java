// Implicit Intent with mutable PendingIntent sent to third party, including implicit read of PendingIntent field, should be flagged as unsafe.
package scensct.core.pos;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class PosCase2 {
    static class Container {
        PendingIntent pendingIntentField;
    }
    
    public void sendPendingIntentToThirdParty(Context context, Container container) {
        // Implicit Intent creation
        Intent implicitIntent = new Intent("com.example.ACTION_TRIGGER");
        // Create mutable PendingIntent from implicit Intent
        PendingIntent pending = PendingIntent.getActivity(
            context,
            0,
            implicitIntent,
            PendingIntent.FLAG_MUTABLE
        );
        // Implicit read of PendingIntent field (reading container.pendingIntentField)
        container.pendingIntentField = pending;
        // Send to unspecified third party via PendingIntent.send()
        try {
            container.pendingIntentField.send();
        } catch (PendingIntent.CanceledException e) {
            // Handle exception
        }
    }
}