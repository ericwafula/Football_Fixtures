package tech.ericwathome.footballfixtures.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tech.ericwathome.footballfixtures.models.Player;

public interface FootballApi {
//    @GET("trophies?player=276")
    @GET("trophies")
    Call<Player> playerTrophy(@Query("player") String id);
//    Call<Player> playerTrophy();
}
