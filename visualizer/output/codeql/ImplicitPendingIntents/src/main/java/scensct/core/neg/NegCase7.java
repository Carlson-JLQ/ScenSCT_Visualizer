// Taint path with mutablePendingIntentCreation and additional taint step, and implicit read with array of Intent elements not ArrayContent should not be flagged.
package scensct.core.neg;

import android.content.Intent;
import android.app.PendingIntent;

public class NegCase7 {
    public void test() {
        // Implicit Intent source with NoState
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
        // Additional taint step via array of Intent elements
        Intent[] arr = new Intent[1];
        arr[0] = implicitIntent;
        // Implicit read of array element (Intent) as sink, not allowed, not part of additional flow step
        // PendingIntent sink with mutable flag, includes mutablePendingIntentCreation transition
        PendingIntent pendingIntent = PendingIntent.getActivity(null, 0, implicitIntent, PendingIntent.FLAG_MUTABLE);
        sendPendingIntent(pendingIntent);
    }

    private void sendPendingIntent(PendingIntent pi) {
        // Placeholder
    }
}