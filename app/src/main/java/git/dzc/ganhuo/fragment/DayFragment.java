package git.dzc.ganhuo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marshalchen.ultimaterecyclerview.CustomUltimateRecyclerview;

import java.util.Calendar;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import git.dzc.ganhuo.MyApplication;
import git.dzc.ganhuo.R;
import git.dzc.ganhuo.http.ApiManager;
import git.dzc.ganhuo.module.DayResult;
import git.dzc.ganhuo.utils.PtrUtils;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 */
public class DayFragment extends Fragment {


    @Bind(R.id.recycler_view)
    CustomUltimateRecyclerview recyclerView;

    private ApiManager apiManager;
    private Calendar calendar;


    public DayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_day, container, false);
        ButterKnife.bind(this, view);
        apiManager = MyApplication.getInstance().getApiManager();
        calendar = Calendar.getInstance();
        intiViews();
        return view;
    }

    private void intiViews(){
        recyclerView.setCustomSwipeToRefresh();
        PtrUtils.setDefaultStyle(recyclerView.mPtrFrameLayout,getActivity());
        recyclerView.mPtrFrameLayout.autoRefresh();
    }

    private void requestData(boolean isRefresh){
        if(isRefresh){
            calendar.setTime(new Date());
            Observable<DayResult> observable = apiManager.getDayData(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
            observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(result->{
            },throwable -> {

            },()->{
                recyclerView.mPtrFrameLayout.refreshComplete();
            });
        }

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
