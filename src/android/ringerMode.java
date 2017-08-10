package com.cordova.plugins.ringermode;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.media.AudioManager;

/**
 * This class echoes a string called from JavaScript.
 */

public class ringerMode extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getRingerMode")) {
            this.getRingerMode(callbackContext);
            return true;
        }
        return false;
    }

    private void getRingerMode(CallbackContext callbackContext) {
        Context context = this.cordova.getActivity().getApplicationContext();
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        int normal;
        normal = 0; 

        switch (audioManager.getRingerMode()) {
            case AudioManager.RINGER_MODE_SILENT:
                callbackContext.success("RINGER_MODE_SILENT");
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                callbackContext.success("RINGER_MODE_VIBRATE");
                break;
            case AudioManager.RINGER_MODE_NORMAL:
                normal = 1; 
                break;
        }
        if(number == 1){
                callbackContext.success(audioManager.getStreamVolume(AudioManager.STREAM_NOTIFICATION));
        }
    }
}
