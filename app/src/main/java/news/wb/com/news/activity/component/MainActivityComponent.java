package news.wb.com.news.activity.component;

import dagger.Component;
import news.wb.com.news.MainActivity;
import news.wb.com.news.activity.ActivityScope;
import news.wb.com.news.activity.module.MainActivityModule;
import news.wb.com.news.activity.presenter.MainActivityPresenter;

/**
 * Created by Administrator on 2016/7/28.
 */
@ActivityScope
@Component(modules = MainActivityModule.class,dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);

    MainActivityPresenter presenter();

}
