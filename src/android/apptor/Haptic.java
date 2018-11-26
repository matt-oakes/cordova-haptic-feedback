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

                    if (type.equals("impactLight")){
                       durations = new long[]{0, 20};
                       }
                       else if (type.equals("impactMedium")){
                           durations = new long[]{0, 40};
                       }
                       else if (type.equals("impactHeavy")){
                           durations = new long[]{0, 60};
                       }
                       else if (type.equals("notificationSuccess")){
                           durations = new long[]{0, 40 ,60, 20};
                       }
                       else if (type.equals("notificationWarning")){
                           durations = new long[]{0, 20, 60, 40};
                       }
                       else if (type.equals("notificationError")){
                           durations = new long[]{0, 20, 40, 30, 40, 40};
                       }

                    v.vibrate(durations, -1);
        }
        return true;
    }    
}
