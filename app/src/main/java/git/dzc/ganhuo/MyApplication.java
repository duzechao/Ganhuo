package git.dzc.ganhuo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;

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
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
                .build();
        Fresco.initialize(this,config);
    }

    public ApiManager getApiManager() {
        return apiManager;
    }
}
