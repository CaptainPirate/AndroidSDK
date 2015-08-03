package com.chinamobile.iot.onenet.device;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.android.volley.AuthFailureError;
import com.chinamobile.iot.onenet.BaseStringRequest;
import com.chinamobile.iot.onenet.ResponseListener;

public class EditDevice extends BaseStringRequest {

    private static final String URL = BASE_URL + "/devices/";

    private String mApiKey;
    private String mTitle;
    private String mDesc;
    private boolean mIsPrivate;

    public EditDevice(String apiKey, String deviceId, String title, String desc, boolean isPrivate,
            ResponseListener listener) {
        super(Method.PUT, URL + deviceId, listener);

        mApiKey = apiKey;
        mTitle = title;
        mDesc = desc;
        mIsPrivate = isPrivate;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("api-key", mApiKey);
        return headers;
    }

    @Override
    public byte[] getBody() throws AuthFailureError {
        byte[] body = null;
        JSONObject obj = new JSONObject();
        try {
            obj.put("title", mTitle);
            obj.put("desc", mDesc);
            obj.put("private", mIsPrivate);
            body = obj.toString().getBytes("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

}
