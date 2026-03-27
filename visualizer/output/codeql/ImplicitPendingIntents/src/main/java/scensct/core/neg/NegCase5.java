// Taint path from implicit Intent source to mutable PendingIntent sink without ExplicitIntentSanitizer, and mutablePendingIntentCreation transition starts not from NoState should not be flagged.
package scensct.core.neg;

import android.content.Intent;
import android.app.PendingIntent;

public class NegCase5 {
    public void test() {
        // Implicit Intent source with NoState
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
        // Transition via method that changes state before mutablePendingIntentCreation
        Intent intermediate = modifyIntent(implicitIntent); // Assume this changes taint state away from NoState
        // PendingIntent sink with mutable flag, mutablePendingIntentCreation transition starts from non-NoState
        PendingIntent pendingIntent = PendingIntent.getActivity(null, 0, intermediate, PendingIntent.FLAG_MUTABLE);
        sendPendingIntent(pendingIntent);
    }

    private Intent modifyIntent(Intent intent) {
        // Placeholder that changes taint state (e.g., adds extra)
        intent.putExtra("key", "value");
        return intent;
    }

    private void sendPendingIntent(PendingIntent pi) {
        // Placeholder
    }
}