package news.wb.com.news.activity.component;

import android.app.Application;
import android.os.Handler;
import javax.inject.Singleton;

import dagger.Component;
import news.wb.com.news.activity.module.ApplicationModule;

/**
 * Created by Administrator on 2016/7/23.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    Application getApplication();
    Handler getHandler();
}
