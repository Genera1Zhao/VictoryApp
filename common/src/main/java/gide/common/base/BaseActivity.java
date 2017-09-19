package gide.common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import gide.common.baserx.RxManager;
import gide.common.commonutils.TUtil;

/**
 * Created by zhaofuqi on 2017/9/19.
 * 基类
 */

public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity {

    public T mPresenter;
    public E mModel;
    public Context mContext;
    public RxManager mRxManager;
    public boolean isConfigChange = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isConfigChange = false;
        mRxManager = new RxManager();
        doBeforeSetcontentView();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {

        }

    }

    //-----------------------子类实现-----------------
    //获取布局文件
    public abstract int getLayoutId();

    //无需mvp不用管此方法
    public abstract void initPresenter();

    //初始化view
    public abstract void initView();

    /**
     * 设置layout前配置
     */
    private void doBeforeSetcontentView() {

    }
}
