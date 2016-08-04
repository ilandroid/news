package news.wb.com.news.images.module;

import dagger.Module;
import dagger.Provides;
import news.wb.com.news.images.ui.ImagesFragment;

/**
 * Created by Administrator on 2016/8/3.
 */
@Module
public class ImagesModule {
    private ImagesFragment mFragment;

    public ImagesModule(ImagesFragment fragment) {
        mFragment = fragment;
    }

    @Provides
    ImagesFragment provideImagesFragment(){
        return mFragment;
    }
}