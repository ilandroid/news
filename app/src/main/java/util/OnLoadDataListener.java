package util;

/**
 * Created by Administrator on 2016/8/3.
 */
public interface OnLoadDataListener<T> {
    void onSuccess(T data);
    void onError(String msg,int errorCode);
}