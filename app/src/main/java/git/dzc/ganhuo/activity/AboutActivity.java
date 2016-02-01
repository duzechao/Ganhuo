package git.dzc.ganhuo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import git.dzc.ganhuo.R;

public class AboutActivity extends AppCompatActivity {

    @Bind(R.id.img_close)
    ImageView imgClose;
    @Bind(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        tvContent.setText("作者github：https://github.com/duzechao  \n\n\n感谢干货集中营的API：http://gank.io");
    }

    @OnClick(R.id.img_close)
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
