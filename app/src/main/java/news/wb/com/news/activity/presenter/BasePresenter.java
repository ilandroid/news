package news.wb.com.news.activity.presenter;

import news.wb.com.news.activity.view.MvpView;

/**
 * Created by Administrator on 2016/8/1.
 */
public class BasePresenter<T extends MvpView> implements Presenter<T> {
    private T mV;

    public void attach(T v) {
        mV = v;
    }

    public void detach() {
        mV = null;
    }

    //判断view层是否关联上
    public boolean isViewAttached() {
        return mV != null;
    }
}