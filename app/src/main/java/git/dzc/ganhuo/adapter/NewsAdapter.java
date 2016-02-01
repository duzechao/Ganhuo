package git.dzc.ganhuo.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
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
import com.marshalchen.ultimaterecyclerview.UltimateDifferentViewTypeAdapter;
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

public class NewsAdapter extends UltimateDifferentViewTypeAdapter<NewsAdapter.ViewType> {

    private static final String imgType = "福利";
    private Context context;
    private List<NewsResult.NewsModule> data;
    private final OnItemOnclickListener mListener;

    public NewsAdapter( List<NewsResult.NewsModule> data, Context context,OnItemOnclickListener mListener) {
        this.mListener = mListener;
        if(data!=null){
            this.data = data;
        }else{
            this.data = new ArrayList<>();
        }
        this.context = context;

        putBinder(ViewType.ITEM_TEXT,new TextDataBinder(this));
        putBinder(ViewType.ITEM_IMG,new ImgDataBinder(this));
    }

    public NewsAdapter(Context context,OnItemOnclickListener mListener) {
        this(null,context,mListener);
    }

    @Override
    public ViewType getEnumFromPosition(int position) {
        NewsResult.NewsModule module = data.get(position);
        if(imgType.equalsIgnoreCase(module.getType())){
            return ViewType.ITEM_IMG;
        }
        return ViewType.ITEM_TEXT;
    }

    @Override
    public ViewType getEnumFromOrdinal(int ordinal) {
        return ViewType.values()[ordinal];
    }

    @Override
    public UltimateRecyclerviewViewHolder getViewHolder(View view) {
        return new UltimateRecyclerviewViewHolder(view);
    }

    @Override
    public UltimateRecyclerviewViewHolder onCreateViewHolder(ViewGroup parent) {
        return new UltimateRecyclerviewViewHolder(parent);
    }

    @Override
    public int getAdapterItemCount() {
        return 0;
    }

    @Override
    public long generateHeaderId(int position) {
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    @Override
    public void onBindViewHolder(UltimateRecyclerviewViewHolder viewHolder, int position) {
        getDataBinder(viewHolder.getItemViewType()).bindViewHolder(viewHolder, position);
    }


    public interface OnItemOnclickListener {
        void onClick(NewsResult.NewsModule item,View view, int position);
    }


    public void insertAll(List<NewsResult.NewsModule> list){
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }
    public void addAll(List<NewsResult.NewsModule> list){
        data.addAll(list);
        notifyDataSetChanged();
    }



    //设置view的类型
    enum ViewType {
        ITEM_TEXT, ITEM_IMG
    }

    //第一种view的viewHolder
    class TextViewHolder extends UltimateRecyclerviewViewHolder {
        @Bind(R.id.title)
        TextView tvTitle;
        @Bind(R.id.user_name)
        TextView tvUserName;
        @Bind(R.id.time)
        TextView tvTime;
        public TextViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //第二种view的viewHolder
    class ImgViewHolder extends UltimateRecyclerviewViewHolder {
        @Bind(R.id.user_name)
        TextView tvUserName;
        @Bind(R.id.time)
        TextView tvTime;
        @Bind(R.id.img)
        SimpleDraweeView img;

        public ImgViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //第一种view的数据绑定
    class TextDataBinder extends com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder<TextViewHolder>{


        public TextDataBinder(UltimateDifferentViewTypeAdapter dataBindAdapter) {
            super(dataBindAdapter);
        }

        @Override
        public TextViewHolder newViewHolder(ViewGroup parent) {
            //这个方法会在adapter的onCreateViewHolder调用  这里设置view的布局
            View view = LayoutInflater.from(context).inflate(R.layout.fragment_news_item,parent,false);
            return new TextViewHolder(view);
        }

        @Override
        public void bindViewHolder(TextViewHolder holder, int position) {
            //这个方法绑定数据   这个方法会在onBindViewHolder中调用
            NewsResult.NewsModule module = data.get(position);
            String type = module.getType();

            holder.tvTitle.setText(module.getDesc());
            holder.tvUserName.setText(module.getWho());
            holder.tvTime.setText(module.getUpdatedAt().substring(0,10));
            if(mListener!=null){
                holder.itemView.setOnClickListener(view -> mListener.onClick(module,holder.itemView,position));
            }

        }

        @Override
        public int getItemCount() {
            return data==null?0:data.size();
        }
    }

    class ImgDataBinder extends com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder<ImgViewHolder>{

        public ImgDataBinder(UltimateDifferentViewTypeAdapter dataBindAdapter) {
            super(dataBindAdapter);
        }

        @Override
        public ImgViewHolder newViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(context).inflate(R.layout.fragment_news_item_img,parent,false);
            return new ImgViewHolder(view);
        }

        @Override
        public void bindViewHolder(ImgViewHolder holder, int position) {
            NewsResult.NewsModule module = data.get(position);
            ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {

                private boolean isInit = false;

                @Override
                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    if (imageInfo == null) {
                        return;
                    }
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
            holder.tvUserName.setText("图:"+module.getWho());
            holder.tvTime.setText(module.getUpdatedAt().substring(0,10));
            if(mListener!=null){
                holder.itemView.setOnClickListener(view -> mListener.onClick(module,holder.img,position));
            }
        }

        @Override
        public int getItemCount() {
            return data==null?0:data.size();
        }
    }
}
