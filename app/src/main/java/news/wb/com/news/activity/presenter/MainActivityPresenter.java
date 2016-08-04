package news.wb.com.news.activity.presenter;

import javax.inject.Inject;

import news.wb.com.news.MainActivity;
import news.wb.com.news.R;
import news.wb.com.news.activity.view.MainView;

/**
 * Created by Administrator on 2016/7/28.
 */
public class MainActivityPresenter extends BasePresenter<MainView> {
    private MainActivity mMainActivity;
    private static final int NEWS = 0;
    private static final int IMAGES = 1;
    private static final int WEATHER = 2;
    private static final int ABOUT = 3;
    private int currentType = NEWS;

    @Inject
    public MainActivityPresenter(MainActivity mainActivity) {
        mMainActivity = mainActivity;
    }

    public void loadData() {
//        mMainActivity.showLoading("Loading...");
    }

    public void switchNav(int itemId) {
        switch (itemId) {
            case R.id.navigation_item_news:
                if (currentType == NEWS) return;
                currentType = NEWS;
                mMainActivity.switch2News();
                break;
            case R.id.navigation_item_images:
                if (currentType == IMAGES) return;
                currentType = IMAGES;
                mMainActivity.switch2Images();
                break;
            case R.id.navigation_item_weather:
                if (currentType == WEATHER) return;
                currentType = WEATHER;
                mMainActivity.switch2Weather();
                break;
            case R.id.navigation_item_about:
                if (currentType == ABOUT) return;
                currentType = ABOUT;
                mMainActivity.switch2About();
                break;
            default:
                break;
        }
    }
}