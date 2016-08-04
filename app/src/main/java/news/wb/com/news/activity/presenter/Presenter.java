package news.wb.com.news.activity.presenter;

import news.wb.com.news.activity.view.MvpView;

/**
 * Created by Administrator on 2016/8/1.
 */
public interface Presenter<T extends MvpView> {
    //关联view层
    void attach(T v);
    //解除关联
    void detach();
}