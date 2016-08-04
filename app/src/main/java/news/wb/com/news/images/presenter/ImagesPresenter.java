package news.wb.com.news.images.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import news.wb.com.news.activity.presenter.BasePresenter;
import news.wb.com.news.beans.Images;
import news.wb.com.news.images.ui.ImagesFragment;
import news.wb.com.news.images.view.ImagesView;
import util.OnLoadDataListener;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ImagesPresenter extends BasePresenter<ImagesView> implements OnLoadDataListener<List<Images>> {
    private ImagesFragment mFragment;

    @Inject
    ImagesModel mModel;

    @Inject
    public ImagesPresenter(ImagesFragment fragment) {
        mFragment = fragment;
    }

    public void loadData(){
        mModel.loadData(this);
    }

    @Override
    public void onSuccess(List<Images> data) {
        mFragment.refreshView(data);
    }

    @Override
    public void onError(String msg, int errorCode) {
        Log.d("ImagesPresenter", msg);
        mFragment.showFailedMsg(msg);
    }
}