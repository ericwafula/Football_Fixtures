package tech.ericwathome.footballfixtures.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.ericwathome.footballfixtures.R;
import tech.ericwathome.footballfixtures.adapters.TrophyListAdapter;
import tech.ericwathome.footballfixtures.models.Player;
import tech.ericwathome.footballfixtures.models.Trophy;
import tech.ericwathome.footballfixtures.network.FootballApi;
import tech.ericwathome.footballfixtures.network.RetrofitClient;

public class TrophiesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private static final String TAG = "TAG";
    RetrofitClient retrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trophies);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        String id =  intent.getStringExtra("id");

        retrofitClient = new RetrofitClient();
        FootballApi footballApi = retrofitClient.getRetrofitInstance().create(FootballApi.class);

        Call<Player> call = footballApi.playerTrophy(id);

        call.enqueue(new Callback<Player>() {
            @Override
            public void onResponse(Call<Player> call, Response<Player> response) {
                if (response.isSuccessful()) {
                    Player player = response.body();
                    List<Trophy> trophies = player.getTrophies();
                    Log.d(TAG, "onResponse: " + Arrays.toString(trophies.toArray()));
//                    System.out.println(Arrays.toString(trophies.toArray()));
                    inializeAdapter(trophies);
                } else {
                    Log.d(TAG, "onResponseNotSuccessful: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Player> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    private void inializeAdapter(List<Trophy> trophies) {
        TrophyListAdapter adapter =  new TrophyListAdapter(TrophiesActivity.this, trophies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}