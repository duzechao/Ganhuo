package git.dzc.ganhuo.http;

import android.util.Log;

import git.dzc.ganhuo.module.NewsResult;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import rx.Observable;

/**
 * Created by dzc on 16/1/28.
 */
public class ApiManager {
    String BASE_URL = "http://gank.avosapps.com/api/";

    private static ApiService apiService;
    private Retrofit retrofit;
    private OkHttpClient okHttpClient;

    public ApiManager() {

        okHttpClient = new OkHttpClient.Builder().addInterceptor(chain -> {
            Log.d("url",chain.request().url().toString());
            return chain.proceed(chain.request());
        }).build();
        retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).client(okHttpClient).validateEagerly(true).build();
        apiService = retrofit.create(ApiService.class);
    }

    public Observable<NewsResult> getNewsData(String type, int size, int page){
        return apiService.getData(type,size,page);
    }


}
