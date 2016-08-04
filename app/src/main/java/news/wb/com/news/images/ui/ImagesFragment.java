package news.wb.com.news.images.ui;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import news.wb.com.news.R;
import news.wb.com.news.activity.BaseFragment;
import news.wb.com.news.activity.component.ApplicationComponent;
import news.wb.com.news.beans.Images;
import news.wb.com.news.images.module.ImagesModule;
import news.wb.com.news.images.presenter.ImagesPresenter;
import news.wb.com.news.images.view.ImagesView;

/**
 * Created by Administrator on 2016/8/3.
 */
public class ImagesFragment extends BaseFragment<ImagesPresenter> implements ImagesView, View.OnClickListener {

    @Bind(R.id.list)
    RecyclerView mList;
    @Bind(R.id.refresh)
    SwipeRefreshLayout mRefresh;
    @Bind(R.id.floatButton)
    FloatingActionButton mFloatButton;
    private ImagesAdapter mAdapter;
    private LinearLayoutManager mManager;

    @Override
    protected void setupComponent(ApplicationComponent appComponent) {
        DaggerImagesComponent.builder()
                .imagesModule(new ImagesModule(this))
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    protected View initView() {
        View rootView = View.inflate(getActivity(), R.layout.fragment_images, null);
        ButterKnife.bind(this, rootView);
        mRefresh.setOnRefreshListener(new ImagesOnRefreshListener());
        mAdapter = new ImagesAdapter(getActivity());
        mManager = new LinearLayoutManager(getActivity());
        mList.setLayoutManager(mManager);
        mList.setItemAnimator(new DefaultItemAnimator());
        mList.setAdapter(mAdapter);
        mList.setOnScrollListener(new ImagesOnScrollListener());
        mFloatButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    protected void initData() {
        mPresenter.loadData();
    }

    @Override
    public void refreshView(List<Images> data) {
        if (mRefresh.isRefreshing())
            mRefresh.setRefreshing(false);
        mAdapter.refreshData(data);
    }

    @Override
    public void showFailedMsg(String msg) {
        Snackbar.make(getActivity().findViewById(R.id.main_draw), "数据加载失败！", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        //回到顶部,并且刷新数据
        mList.scrollToPosition(0);
        mRefresh.setRefreshing(true);
        mPresenter.loadData();
    }

    class ImagesOnScrollListener extends RecyclerView.OnScrollListener {
        private int mPosition;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            mPosition = mManager.findLastVisibleItemPosition();
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE && mPosition == mAdapter.getItemCount() - 1)
                Snackbar.make(getActivity().findViewById(R.id.main_draw), "没有更多内容，请刷新！", Snackbar.LENGTH_SHORT).show();
        }
    }

    class ImagesOnRefreshListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            mPresenter.loadData();
        }
    }

}