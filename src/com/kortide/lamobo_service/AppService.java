package com.kortide.lamobo_service;

import android.app.IntentService;
import android.content.Intent;

import com.kortide.service.KortideService;

public class AppService extends IntentService {

    public AppService() {
        super("AppService");
    }

    private void showRemoteMsg(String remoteMsg) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("msg", remoteMsg);
        getApplication().startActivity(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        /** Use KortideService to parse remote message from Client */
        String remoteMsg = KortideService.getRemoteMsg(intent);

        showRemoteMsg(remoteMsg);

        /** return a result for Client */
        KortideService.returnResult(intent, "Good " + remoteMsg); 
    }
}
