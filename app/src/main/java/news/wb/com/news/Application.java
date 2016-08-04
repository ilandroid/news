package news.wb.com.news;

import android.content.Context;
import android.location.LocationManager;
import news.wb.com.news.activity.component.ApplicationComponent;
import news.wb.com.news.activity.module.ApplicationModule;


/**
 * Created by Administrator on 2016/7/23.
 */
public class Application extends android.app.Application {
    LocationManager locationManager;
    private static ApplicationComponent appcomponent;

    public static Application get(Context context){
        return (Application) context.getApplicationContext();
    }

    public void onCreate(){
        super.onCreate();
        appcomponent =
                .builder()
                .appModule(new ApplicationModule(this))
                .build();
    }

    public static ApplicationComponent getAppcomponent(){
        return appcomponent;
    }
}
