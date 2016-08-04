package news.wb.com.news.activity.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import news.wb.com.news.R;
import news.wb.com.news.activity.adapter.NewsAdapter;

/**
 * Created by Administrator on 2016/8/1.
 */
public class NewsFragment extends Fragment {

    @Bind(R.id.news_tab)
    TabLayout NewsTab;
    @Bind(R.id.news_content)
    ViewPager NewsContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = View.inflate(getActivity(), R.layout.fragment_news, null);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    private void initView() {
        String[] titles = {"头条", "NBA", "汽车", "笑话"};
        NewsAdapter adapter = new NewsAdapter(getChildFragmentManager());
        for (int i = 0; i < titles.length; i++) {
            mNewsTab.addTab(mNewsTab.newTab().setText(titles[i]));
            adapter.addFragment(NewsListFragment.newInstance(i),titles[i]);
        }
        NewsContent.setOffscreenPageLimit(3);
        NewsContent.setAdapter(adapter);
        NewsTab.setupWithViewPager(NewsContent);
    }
}
