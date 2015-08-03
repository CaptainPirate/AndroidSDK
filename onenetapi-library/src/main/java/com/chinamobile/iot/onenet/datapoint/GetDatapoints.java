package com.chinamobile.iot.onenet.datapoint;

import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.chinamobile.iot.onenet.BaseStringRequest;
import com.chinamobile.iot.onenet.ResponseListener;

public class GetDatapoints extends BaseStringRequest {

    private String mApiKey;

    public GetDatapoints(String apiKey, String deviceId, String params, ResponseListener listener) {
        super(Method.GET, BASE_URL + "/devices/" + deviceId + "/datapoints" + params, listener);
        mApiKey = apiKey;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = new HashMap<String, String>();
        if (mApiKey != null) headers.put("api-key", mApiKey);
        return headers;
    }

}
