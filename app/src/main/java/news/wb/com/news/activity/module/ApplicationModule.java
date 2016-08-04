package news.wb.com.news.activity.module;

import android.app.Application;
import android.os.Handler;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2016/7/23.
 */
@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application){
        this.application= application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){

        return application;
    }

    @Singleton
    @Provides
    Handler provideHandler(){
        return new Handler();
    }
}
