package git.dzc.ganhuo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.kogitune.activity_transition.ActivityTransition;
import com.kogitune.activity_transition.ExitActivityTransition;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import git.dzc.ganhuo.R;

public class ImageInfoActivity extends BaseActivity {

    private ExitActivityTransition exitTransition;

    @Bind(R.id.img)
    SimpleDraweeView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_info);

        ButterKnife.bind(this);

        exitTransition = ActivityTransition.with(getIntent()).to(findViewById(R.id.img)).start(savedInstanceState);
        String url = getIntent().getStringExtra("url");
        FLog.d(this.getClass(), "url=" + url);
        img.setImageURI(Uri.parse(url));
    }


    @Override
    public void onBackPressed() {
        exitTransition.exit(this);
    }
}
