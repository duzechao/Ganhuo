package git.dzc.ganhuo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import git.dzc.ganhuo.R;
import git.dzc.ganhuo.module.NewsResult;

public class NewsAdapter extends UltimateViewAdapter<NewsAdapter.ViewHolder> {

    private List<NewsResult.NewsModule> data;
    private final OnItemOnclickListener mListener;

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (position < getItemCount() && position < data.size() && (customHeaderView != null ? position > 0 : true)) {
            NewsResult.NewsModule module = data.get(position);
            holder.tvTitle.setText(module.getDesc());
            holder.tvUserName.setText(module.getWho());
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
    public ViewHolder getViewHolder(View view) {
        return new ViewHolder(view,false);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_news_item, parent, false);
        return new ViewHolder(view,true);
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


    public class ViewHolder extends UltimateRecyclerviewViewHolder {
        @Bind(R.id.title)
        TextView tvTitle;
        @Bind(R.id.user_name)
        TextView tvUserName;
        @Bind(R.id.time)
        TextView tvTime;
        public ViewHolder(View view,boolean isItem) {
            super(view);
            if(isItem)ButterKnife.bind(this, view);
        }
    }

    public void insertAll(List<NewsResult.NewsModule> list){
        data.addAll(list);
        notifyDataSetChanged();
    }
}
