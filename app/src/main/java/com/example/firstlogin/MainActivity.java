package com.example.firstlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import static android.content.ContentValues.TAG;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
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
    private String url = "https://run.mocky.io/v3/85cf9aaf-aa4f-41bf-b10c-308f032f7ccc";

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
        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
            public void onResponse(String response) {

                Toast.makeText(getApplicationContext(), "Response :" + response.toString(), Toast.LENGTH_LONG).show();//display the response on screen
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