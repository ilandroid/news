package news.wb.com.news.activity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2016/7/28.
 */
@Scope
@Retention(RetentionPolicy.CLASS.RUNTIME)
public @interface ActivityScope {}