// Implicit Intent with mutable PendingIntent sent to third party, including implicit read of Intent array, should be flagged as unsafe.
package scensct.core.pos;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class PosCase3 {
    public void sendPendingIntentToThirdParty(Context context, Intent[] intentArray, int index) {
        // Implicit Intent creation
        Intent implicitIntent = new Intent("com.example.ACTION_TRIGGER");
        // Create mutable PendingIntent from implicit Intent
        PendingIntent pending = PendingIntent.getActivity(
            context,
            0,
            implicitIntent,
            PendingIntent.FLAG_MUTABLE
        );
        // Implicit read of Intent array (accessing intentArray[index])
        Intent retrievedIntent = intentArray[index];
        // Send to unspecified third party via PendingIntent.send()
        try {
            pending.send();
        } catch (PendingIntent.CanceledException e) {
            // Handle exception
        }
    }
}