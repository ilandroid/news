package news.wb.com.news;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import news.wb.com.news.activity.component.ApplicationComponent;
import news.wb.com.news.activity.presenter.BasePresenter;
import news.wb.com.news.activity.view.MvpView;

/**
 * Created by Administrator on 2016/7/22.
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements MvpView {
    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(Application.getAppcomponent());
        if (mPresenter!=null)
            mPresenter.attach(this);
        initView();
        initData();
        initEvent();
    }

    protected abstract void setupComponent(ApplicationComponent appComponent);

    protected void initEvent() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除关联
        if (mPresenter!=null)
            mPresenter.detach();
    }

    //初始化视图
    protected abstract void initView();
    //初始化数据
    protected abstract void initData();

    @Override
    public void showLoading(String msg) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage(msg);
        dialog.show();
    }

    @Override
    public void hideLoading() {

    }

}