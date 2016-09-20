package com.xyh.yuan7.okhttpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;




public class MainActivity extends AppCompatActivity {
    private String URL="http://capi.douyucdn.cn/api/v1/live?limit=20&offset=0";
    private String url="http://www.tngou.net/api/hospital/list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormEncodingBuilder()
                .add("id", "1")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                       Log.i("TAG",response.body().string());
            }
        });

    }

//    private void get() {
//        OkHttpManager.getAsync(URL, new OkHttpManager.DataCallBack() {
//            @Override
//            public void requestFailure(Request request, IOException e) {
//
//            }
//
//            @Override
//            public void requestSuccess(String result) throws Exception {
//                TextView textView= (TextView) findViewById(R.id.textview);
//                textView.setText(result);
//                Log.i("TAG",result);
//            }
//        });
//    }
}
