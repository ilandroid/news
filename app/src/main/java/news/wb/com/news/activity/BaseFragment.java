package news.wb.com.news.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import news.wb.com.news.Application;
import news.wb.com.news.activity.component.ApplicationComponent;
import news.wb.com.news.activity.presenter.BasePresenter;
import news.wb.com.news.activity.view.MvpView;


/**
 * Created by Administrator on 2016/8/1.
 */
public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements MvpView {

    @Inject
    protected T mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setupComponent(Application.getAppcomponent());
        return baseInit();
    }

    //设置组件
    protected abstract void setupComponent(ApplicationComponent appComponent);

    private View baseInit() {
        mPresenter.attach(this);
        View view = initView();
        initData();
        return view;
    }

    protected abstract View initView();

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }
}