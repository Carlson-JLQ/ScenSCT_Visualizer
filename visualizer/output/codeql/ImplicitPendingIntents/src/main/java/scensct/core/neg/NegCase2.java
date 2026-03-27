// An implicit Intent source exists, but all PendingIntent sinks are not mutable should not be flagged as implicit Intent to PendingIntent flow.
package scensct.core.neg;

import android.content.Intent;
import android.app.PendingIntent;

public class NegCase2 {
    public void test() {
        // Implicit Intent source with NoState
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
        // PendingIntent sink with FLAG_IMMUTABLE (not mutable), taint state other than MutablePendingIntent
        PendingIntent pendingIntent = PendingIntent.getActivity(null, 0, implicitIntent, PendingIntent.FLAG_IMMUTABLE);
        sendPendingIntent(pendingIntent);
    }

    private void sendPendingIntent(PendingIntent pi) {
        // Placeholder
    }
}