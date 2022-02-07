package tech.ericwathome.footballfixtures.network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public RetrofitClient() {
    }

    public Retrofit getRetrofitInstance(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Interceptor.Chain chain) throws IOException {
                        Request newRequest  = chain.request().newBuilder()
                                .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
                                .addHeader("x-rapidapi-key", "55cb87abbfmsh66e5ac5fcfcb39dp14b04fjsn9d507870d1b4")
                                .build();
                        return chain.proceed(newRequest);
                    }
                })
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-football-v1.p.rapidapi.com/v3/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
