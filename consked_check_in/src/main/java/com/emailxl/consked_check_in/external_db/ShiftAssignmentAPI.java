package com.emailxl.consked_check_in.external_db;

import android.util.Log;

import com.emailxl.consked_check_in.utils.AppConstants;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.emailxl.consked_check_in.utils.Utils.readStream;

/**
 * @author ECG
 */

class ShiftAssignmentAPI {
    private static final String SERVER_URL = AppConstants.SERVER_DIR + "ShiftAssignment/Search/";
    private static final String TAG = "ShiftAssignmentAPI";
    private static final boolean LOG = AppConstants.LOG_EXT;

    static ShiftAssignmentExt[] searchShiftAssignment(int expoIdExt, int workerIdExt) {

        if (LOG) Log.i(TAG, "ShiftAssignmentExt called");

        String stringUrl = SERVER_URL;

        if (expoIdExt != 0) {
            stringUrl += expoIdExt;

            if (workerIdExt != 0) {
                stringUrl += "/" + workerIdExt;
            }
        }

        InputStream is = null;
        ShiftAssignmentExt[] output = null;

        try {
            URL url = new URL(stringUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("x-li-format", "json");

            if (conn.getResponseCode() == 200) {

                is = conn.getInputStream();
                String result = readStream(is);
                output = loadShiftAssignment(result);
            }
        } catch (Exception e) {
            if (LOG) Log.e(TAG, e.getMessage());
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    if (LOG) Log.e(TAG, e.getMessage());
                }
            }
        }

        return output;
    }

    private static ShiftAssignmentExt[] loadShiftAssignment(String result) throws Exception {

        JSONArray jArray = new JSONArray(result);

        int len = jArray.length();
        ShiftAssignmentExt[] output = new ShiftAssignmentExt[len];

        for (int i = 0; i < len; i++) {
            JSONObject json = jArray.getJSONObject(i);

            int workerIdExt = json.optInt("workerid");
            int jobIdExt = json.optInt("jobid");
            int stationIdExt = json.optInt("stationid");
            int expoIdExt = json.optInt("expoid");

            ShiftAssignmentExt shiftassignment = new ShiftAssignmentExt();
            shiftassignment.setWorkerIdExt(workerIdExt);
            shiftassignment.setStationIdExt(stationIdExt);
            shiftassignment.setJobIdExt(jobIdExt);
            shiftassignment.setExpoIdExt(expoIdExt);

            output[i] = shiftassignment;
        }

        return output;
    }
}
