package git.dzc.ganhuo.utils;

import android.content.Context;


import git.dzc.ganhuo.R;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

/**
 * Created by zajo on 15/11/26.
 */
public class PtrUtils {
    private PtrUtils() {
    }


    public static PtrUIHandler setDefaultStyle(PtrFrameLayout ptrFrameLayout, Context context){
        return setMaterialHead(ptrFrameLayout,context);
    }

    public static PtrUIHandler setMaterialHead(PtrFrameLayout ptrFrameLayout, Context context){
        // header
        MaterialHeader header = new MaterialHeader(context);
        int[] colors = context.getResources().getIntArray(R.array.refresh_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
//        header.setPadding(0, Utils.dip2px(context,15), 0, Utils.dip2px(context,10));
        header.setPtrFrameLayout(ptrFrameLayout);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.setPinContent(true);
        ptrFrameLayout.disableWhenHorizontalMove(true);
        ptrFrameLayout.setEnabledNextPtrAtOnce(true);
        return header;
    }
}
