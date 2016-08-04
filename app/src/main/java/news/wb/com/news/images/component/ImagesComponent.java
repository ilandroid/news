package news.wb.com.news.images.component;

import dagger.Component;
import news.wb.com.news.FragmentScope;
import news.wb.com.news.activity.component.ApplicationComponent;
import news.wb.com.news.images.module.ImagesModule;
import news.wb.com.news.images.presenter.ImagesPresenter;
import news.wb.com.news.images.ui.ImagesFragment;

/**
 * Created by Administrator on 2016/8/3.
 */
@FragmentScope
@Component(modules = ImagesModule.class,dependencies = ApplicationComponent.class)
public interface ImagesComponent {
    ImagesPresenter getPresenter();
    void inject(ImagesFragment fragment);
}