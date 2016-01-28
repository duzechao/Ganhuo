package git.dzc.ganhuo.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;

import git.dzc.ganhuo.MyApplication;
import git.dzc.ganhuo.R;
import git.dzc.ganhuo.adapter.NewsAdapter;
import git.dzc.ganhuo.http.ApiManager;
import git.dzc.ganhuo.module.NewsResult;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class NewsFragment extends Fragment {

    private static final String TYPE = "type";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type = "Android";

    private NewsAdapter adapter;
    private ApiManager apiManager;

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
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        apiManager = MyApplication.getInstance().getApiManager();
        // Set the adapter
        if (view instanceof CustomUltimateRecyclerview) {
            Context context = view.getContext();
            CustomUltimateRecyclerview recyclerView = (CustomUltimateRecyclerview) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            adapter = new NewsAdapter((item, position) -> {

            });
            recyclerView.setAdapter(adapter);
        }
        Observable<NewsResult> observable = apiManager.getNewsData(type,10,1);
        observable.subscribeOn(Schedulers.io()).cache().observeOn(AndroidSchedulers.mainThread()).subscribe(newsModule -> {
//            Log.d("noNext",newsModule.getResults().get(0).getDesc());
            adapter.insertAll(newsModule.getResults());
        }, throwable -> {
            Log.d("error",throwable.toString());
        });


        return view;
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
