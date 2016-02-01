package git.dzc.ganhuo.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kogitune.activity_transition.ActivityTransitionLauncher;
import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerviewViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;
import git.dzc.ganhuo.MyApplication;
import git.dzc.ganhuo.R;
import git.dzc.ganhuo.activity.ImageInfoActivity;
import git.dzc.ganhuo.adapter.NewsAdapter;
import git.dzc.ganhuo.http.ApiManager;
import git.dzc.ganhuo.module.NewsResult;
import git.dzc.ganhuo.utils.PtrUtils;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsFragment extends Fragment {

    private static final String imgType = "福利";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type = "Android";

    private NewsAdapter adapter;
    private ApiManager apiManager;

    private int size = 20;
    private int page = 1;

    CustomUltimateRecyclerview recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NewsFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NewsFragment newInstance(String type) {
        NewsFragment fragment = new NewsFragment();
        fragment.setType(type);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getArguments() != null) {
//            type = getArguments().getString(TYPE);
//            Log.d("fragment onCreate",type);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_news_list, container, false);
        apiManager = MyApplication.getInstance().getApiManager();
        if (rootView instanceof CustomUltimateRecyclerview) {
            Context context = rootView.getContext();
            recyclerView = (CustomUltimateRecyclerview) rootView;
            if (imgType.equalsIgnoreCase(type)) {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }
            adapter = new NewsAdapter(getActivity(),(item, view, position) -> {
                if (imgType.equalsIgnoreCase(item.getType())) {
                    Intent intent = new Intent(getActivity(), ImageInfoActivity.class);
                    intent.putExtra("url", item.getUrl());
                    ActivityTransitionLauncher.with(getActivity()).from(view).launch(intent);
                }else{
                    Uri uri = Uri.parse(item.getUrl());
                    Intent  intent = new  Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
            recyclerView.setCustomSwipeToRefresh();
            PtrUtils.setDefaultStyle(recyclerView.mPtrFrameLayout, getActivity());
            recyclerView.mPtrFrameLayout.setPtrHandler(new PtrDefaultHandler() {
                @Override
                public void onRefreshBegin(PtrFrameLayout frame) {
                    refresh();
                }
            });
            recyclerView.setOnLoadMoreListener((itemsCount, maxLastVisiblePosition) -> {
                loadMore();
            });
            recyclerView.enableLoadmore();
            recyclerView.setAdapter(adapter);
            recyclerView.mPtrFrameLayout.autoRefresh();
        }


        return rootView;
    }

    private void refresh() {
        page = 1;
        request(size, page);
    }

    private void loadMore() {
        request(size, ++page);
    }

    private void request(int size, int page) {
        recyclerView.disableLoadmore();
        Observable<NewsResult> observable = apiManager.getNewsData(type, size, page);
        observable.subscribeOn(Schedulers.io()).cache().observeOn(AndroidSchedulers.mainThread()).subscribe(newsModule -> {
//            Log.d("noNext",newsModule.getResults().get(0).getDesc());
            if(newsModule.getResults()==null||newsModule.getResults().isEmpty()){
                recyclerView.disableLoadmore();
            }else{
                if (page > 1) {
                    adapter.addAll(newsModule.getResults());
                } else {
                    adapter.insertAll(newsModule.getResults());
                }
                recyclerView.enableLoadmore();
            }
        }, throwable -> Log.d("error", throwable.toString()), () -> recyclerView.mPtrFrameLayout.refreshComplete());
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }




}
