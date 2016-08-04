package news.wb.com.news.activity.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/1.
 */
public class NewsAdapter extends FragmentPagerAdapter {
    List<NewsListFragment> mFragments = new ArrayList<>();
    List<String> mTitles = new ArrayList<>();

    public NewsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(NewsListFragment f, String title) {
        mFragments.add(f);
        mTitles.add(title);
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }
}
