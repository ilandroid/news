package news.wb.com.news.images.view;

import java.util.List;

import news.wb.com.news.activity.view.MvpView;
import news.wb.com.news.beans.Images;

/**
 * Created by Administrator on 2016/8/3.
 */
public interface ImagesView extends MvpView {
    void refreshView(List<Images> data);
    void showFailedMsg(String msg);
}