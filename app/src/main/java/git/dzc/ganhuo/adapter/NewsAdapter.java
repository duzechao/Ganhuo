package git.dzc.ganhuo.adapter;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.common.logging.FLog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import git.dzc.ganhuo.MyApplication;
import git.dzc.ganhuo.R;
import git.dzc.ganhuo.module.NewsResult;
import git.dzc.ganhuo.utils.ScreenUtils;

public class NewsAdapter extends UltimateViewAdapter<NewsAdapter.NewsViewHolder> {

    private List<NewsResult.NewsModule> data;
    private final OnItemOnclickListener mListener;

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        if (position < getItemCount() && position < data.size() && (customHeaderView != null ? position > 0 : true)) {
            NewsResult.NewsModule module = data.get(position);
            if("福利".equalsIgnoreCase(module.getType())){
                holder.img.setVisibility(View.VISIBLE);
                ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {

                    private boolean isInit = false;

                    @Override
                    public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                        if (imageInfo == null) {
                            return;
                        }
                        QualityInfo qualityInfo = imageInfo.getQualityInfo();
                        FLog.d("Final image received! " +
                                        "Size %d x %d",
                                "Quality level %d, good enough: %s, full quality: %s",
                                imageInfo.getWidth(),
                                imageInfo.getHeight(),
                                qualityInfo.getQuality(),
                                qualityInfo.isOfGoodEnoughQuality(),
                                qualityInfo.isOfFullQuality());
                        if(!isInit){
                            holder.img.setAspectRatio((float) imageInfo.getWidth()/(float) imageInfo.getHeight());
                            isInit = true;
                        }

                    }

                    @Override
                    public void onFailure(String id, Throwable throwable) {
                        FLog.e(getClass(), throwable, "Error loading %s", id);
                    }
                };

                DraweeController controller = Fresco.newDraweeControllerBuilder().setControllerListener(controllerListener)
                .setUri(Uri.parse(module.getUrl())).build();

                holder.img.setMaxWidth(ScreenUtils.getScreenW(MyApplication.getInstance()));
                holder.img.setAdjustViewBounds(true);
                holder.img.setController(controller);
                holder.tvTitle.setVisibility(View.GONE);
                holder.tvUserName.setText("图:"+module.getWho());
            }else{
                holder.tvTitle.setText(module.getDesc());
                holder.tvUserName.setText(module.getWho());
            }
            holder.tvTime.setText(module.getUpdatedAt().substring(0,10));

        }
    }
    public interface OnItemOnclickListener {
        void onClick(NewsResult item, int position);
    }

    public NewsAdapter(List<NewsResult.NewsModule> items, OnItemOnclickListener listener) {
        data = items;
        mListener = listener;
    }

    public NewsAdapter(OnItemOnclickListener mListener) {
        this.mListener = mListener;
        data = new ArrayList<>();
    }

    @Override
    public NewsViewHolder getViewHolder(View view) {
        return new NewsViewHolder(view,false);
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_news_item, parent, false);
        return new NewsViewHolder(view,true);
    }



    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getAdapterItemCount() {
        return data==null?0:data.size();
    }

    @Override
    public long generateHeaderId(int position) {
        return 0;
    }


    public class NewsViewHolder extends UltimateRecyclerviewViewHolder {
        @Bind(R.id.title)
        TextView tvTitle;
        @Bind(R.id.user_name)
        TextView tvUserName;
        @Bind(R.id.time)
        TextView tvTime;
        @Bind(R.id.img)
        SimpleDraweeView img;
        public NewsViewHolder(View view, boolean isItem) {
            super(view);
            if(isItem)ButterKnife.bind(this, view);
        }
    }

    public void insertAll(List<NewsResult.NewsModule> list){
        data.addAll(list);
        notifyDataSetChanged();
    }
}
