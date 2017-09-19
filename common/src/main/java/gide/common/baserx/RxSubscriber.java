package gide.common.baserx;

import android.app.Activity;
import android.content.Context;

import gide.common.R;
import gide.common.baseapp.BaseApplication;
import gide.common.commonutils.NetWorkUtils;
import gide.common.commonwidget.LoadingDialog;
import rx.Subscriber;

/**
 * Created by zhaofuqi on 2017/9/19.
 * 订阅封装
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {
    private Context mContext;
    private String msg;
    private boolean showDialog = true;

    public void showDialog() {
        this.showDialog = true;
    }

    public void hideDialog() {
        this.showDialog = false;
    }

    public RxSubscriber(Context context, String msg, boolean showDialog) {
        this.mContext = context;
        this.msg = msg;
        this.showDialog = showDialog;
    }

    public RxSubscriber(Context context) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), true);
    }

    public RxSubscriber(Context context, boolean showDialog) {
        this(context, BaseApplication.getAppContext().getString(R.string.loading), showDialog);
    }

    @Override
    public void onCompleted() {
        if (showDialog) {
            LoadingDialog.showDialogForLoading((Activity) mContext, msg, true);
        }
    }

    @Override
    public void onError(Throwable e) {
        if (showDialog) {
            LoadingDialog.cancelDialogForLoading();
        }
        e.printStackTrace();
        //网络
        if (!NetWorkUtils.isNetConnected(BaseApplication.getAppContext())) {
            _onError(BaseApplication.getAppContext().getString(R.string.no_net));
        }
        //服务器
        else if (e instanceof ServerException) {
            _onError(e.getMessage());
        }
        //其它
        else {
            _onError(BaseApplication.getAppContext().getString(R.string.net_error));
        }
    }

    @Override
    public void onNext(T t) {
        _onNext(t);
    }

    protected abstract void _onNext(T t);

    protected abstract void _onError(String message);
}
