package gide.common.baserx;

import android.content.Context;

import rx.Subscriber;

/**
 * Created by zhaofuqi on 2017/9/19.
 * 订阅封装
 */

public class RxSubscriber<T> extends Subscriber<T> {
    private Context mContext;
    private String msg;
    private boolean showDialog = true;

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
