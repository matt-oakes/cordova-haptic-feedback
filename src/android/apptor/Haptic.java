package apptor;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;


import android.os.Vibrator;
import android.content.Context;


/**
 * This class echoes a string called from JavaScript.
 */
public class Haptic extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        if(action.equals("vibro")){
                String type = args.getString(0);
                Vibrator v = (Vibrator) this.cordova.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    if (v == null) return false;
                    long durations[] = {0, 20};

                    switch (type) {
                    case "impactLight":
                        durations = new long[]{0, 20};
                        break;
                    case "impactMedium":
                        durations = new long[]{0, 40};
                        break;
                    case "impactHeavy":
                    durations = new long[]{0, 60};
                        break;
                    case "notificationSuccess":
                        durations = new long[]{0, 40 ,60, 20};
                        break;
                    case "notificationWarning":
                        durations = new long[]{0, 20, 60, 40};
                        break;
                    case "notificationError":
                        durations = new long[]{0, 20, 40, 30, 40, 40};
                        break;
                    }

                    v.vibrate(durations, -1);
        }
        return true;
    }    
}
