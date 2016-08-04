package news.wb.com.news.activity.module;

import dagger.Module;
import dagger.Provides;
import news.wb.com.news.MainActivity;
import news.wb.com.news.activity.presenter.MainActivityPresenter;

/**
 * Created by Administrator on 2016/7/28.
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }
    @Provides
    MainActivity provideMainActivity(){
        return mainActivity;
    }
    @Provides
    MainActivityPresenter provideMainActivityPresenter(){
        return new MainActivityPresenter(mainActivity);
    }
}
