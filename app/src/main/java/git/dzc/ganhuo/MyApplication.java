package git.dzc.ganhuo;

import android.app.Application;

import git.dzc.ganhuo.http.ApiManager;

/**
 * Created by dzc on 16/1/29.
 */
public class MyApplication extends Application {
    private ApiManager apiManager;
    private static MyApplication instance;
    public static MyApplication getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        apiManager = new ApiManager();
    }

    public ApiManager getApiManager() {
        return apiManager;
    }
}
