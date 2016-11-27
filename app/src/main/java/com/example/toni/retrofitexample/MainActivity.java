package com.example.toni.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Integer laId;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.texto);

        ApiService api = RetroClient.getApiService();
        Call<HackerNews> call = api.getMyJSON();

        call.enqueue(new Callback<HackerNews>() {
            @Override
            public void onResponse(Call<HackerNews> call, Response<HackerNews> response) {
                if(response.isSuccessful()) {
                    laId = response.body().getId();
                    textView.setText(laId.toString());
                }

            }

            @Override
            public void onFailure(Call<HackerNews> call, Throwable t) {

            }
        });
    }
}
