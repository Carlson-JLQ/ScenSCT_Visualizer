// Implicit Intent with mutable PendingIntent sent to third party, including implicit read of Intent array, should be flagged as unsafe.
package scensct.ref.pos;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class PosCase3_FN1 {
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
        // Send to unspecified third party (using retrievedIntent as part of flow)
        Intent thirdPartyIntent = new Intent(retrievedIntent);
        thirdPartyIntent.putExtra("pending", pending);
        context.startActivity(thirdPartyIntent);
    }
}