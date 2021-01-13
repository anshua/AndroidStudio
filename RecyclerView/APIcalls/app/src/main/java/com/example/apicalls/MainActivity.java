package com.example.apicalls;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button mBtnCallAPI;
    private ArrayList<ResponseClass> responseClassArrayList = new ArrayList<>();
    private PostAdapter postAdapter;
    private RecyclerView recyclerView;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            URL url = null;

            Log.d("Anshu", "runnable: data build");

            try {
                url = new URL("https://jsonplaceholder.typicode.com/posts");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();

                StringBuffer buffer = new StringBuffer();

                while (data != -1){
                    char ch = (char) data;
                    buffer.append(ch);
                    data = reader.read();
                }

                Log.d("Anshu", "buffer read");

                buildResponseData(buffer);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("Anshu", "exception: data build");
            }
        }
    };

    private void buildResponseData(StringBuffer stringBuffer) throws JSONException {

        Log.d("Anshu", "build response: data build");
        String json = stringBuffer.toString();
        try {
            JSONArray jsonObject = new JSONArray(json);

            for (int i = 0; i < jsonObject.length(); i++) {
                JSONObject object = jsonObject.getJSONObject(i);
                int id = object.getInt("id");
                int userId = object.getInt("userId");
                String title = object.getString("title");
                String body = object.getString("body");

                ResponseClass responseClass = new ResponseClass(id, userId, title, body);
                responseClassArrayList.add(responseClass);
            }
            updateAdapter();

            Log.d("Anshu", "response data build");
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void updateAdapter(){

        Log.d("Anshu", "update adapter: data build");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                postAdapter.updateRecyclerViewList(responseClassArrayList);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsAndListeners();
        setRecyclerAdapter();
    }

    private void initViewsAndListeners() {
        mBtnCallAPI = findViewById(R.id.btnAPI);
        recyclerView = findViewById(R.id.recyclerView);
        mBtnCallAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startBackgroundThread();
                Log.d("Anshu", "initialise: data build");
            }
        });
    }

    private void setRecyclerAdapter(){
        postAdapter = new PostAdapter(responseClassArrayList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
    }

    private void startBackgroundThread() {
        Thread thread = new Thread(runnable);
        thread.start();
        Log.d("Anshu", "start background: data build");
    }
}