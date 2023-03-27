package com.example.firstlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.os.Bundle;
import android.widget.TextView;
import static android.content.ContentValues.TAG;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.fido.Fido;
import com.google.android.gms.fido.fido2.Fido2ApiClient;
import com.google.android.gms.fido.fido2.Fido2PendingIntent;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //Call API
//    CronetEngine.Builder myBuilder = new CronetEngine.Builder(context);
//    CronetEngine cronetEngine = myBuilder.build();

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String url = "http://192.168.1.4:8000/requestGetMakeCredentialOptions";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
    }

    private void getData() {
        // RequestQueue initialized
        mRequestQueue = Volley.newRequestQueue(this);

        // String Request initialized
        mStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
            public void onResponse(String response) {

                Log.d("Response :", response.toString());
                try{
                    Fido2ApiClient fido2ApiClient = Fido.getFido2ApiClient(getApplicationContext());
                    byte[] responseBytes = response.getBytes();

                    Task<PendingIntent> result = fido2ApiClient.getRegisterPendingIntent(new PublicKeyCredentialCreationOptions(response));
//                    Task<PendingIntent> result = fido2ApiClient.getRegisterPendingIntent(response);
                    Log.d("Cred options: ", result.toString());
//                    var task = client.getRegisterPendingIntent(apiResult.data);
//                    Log.d("Public key credentials: ", task.await());


        } catch (Exception e) {
            Log.e(TAG, "Cannot call registerRequest", e);
        }
                }


        }, new Response.ErrorListener() {
//            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "Error :" + error.toString());
            }
        });

        mRequestQueue.add(mStringRequest);
    }

    //UI creation
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView username = (TextView) findViewById(R.id.username);
//        TextView password = (TextView) findViewById(R.id.password);
//
//        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.button);
//    }
}