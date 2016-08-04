package news.wb.com.news;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import news.wb.com.news.activity.component.ApplicationComponent;
import news.wb.com.news.activity.module.MainActivityModule;
import news.wb.com.news.activity.presenter.MainActivityPresenter;
import news.wb.com.news.activity.ui.NewsFragment;
import news.wb.com.news.activity.view.MainView;
import news.wb.com.news.images.ui.ImagesFragment;

public class MainActivity extends BaseActivity<MainActivityPresenter> implements MainView{

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.main_content)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.navigation_view)
    NavigationView navigationView;
    @Bind(R.id.appbar)
    Toolbar toolbar;
    @Bind(R.id.frame_content)
    FrameLayout frameLayout;
    private ActionBarDrawerToggle drawerToggle;


    @Override
    protected void setupComponent(ApplicationComponent appComponent) {
        DaggerMainActivityComponent.builder()
                .mainModule(new MainActivityModule(this))
                .appComponent(Application.getAppcomponent())
                .build().inject(this);
    }

    public void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
    }

    @Override
    protected void initData() {
        mPresenter.loadData();
    }


    public void switch2News() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new NewsFragment()).commit();
        Application.getAppcomponent().getHandler().postDelayed(toolbar.setTitle(R.string.navigation_news), 10);
    }

    @Override
    public void switch2Images() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,new ImagesFragment()).commit();
        toolbar.setTitle(R.string.navigation_images);
    }

    @Override
    public void switch2Weather() {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content, new WeatherFragment()).commit();
        toolbar.setTitle(R.string.navigation_weather);
    }

    @Override
    public void switch2About() {
        toolbar.setTitle(R.string.navigation_about);
    }


    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }
}
