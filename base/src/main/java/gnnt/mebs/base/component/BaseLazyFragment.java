package gnnt.mebs.base.component;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**********************************************************
 *  BaseLazyFragment.java  2019-11-12
 *  <p>
 *  lazy加载
 *  </p>
 *  Copyright2019 by GNNT Company. All Rights Reserved.
 *
 *  @author:shuhj
 ***********************************************************/
public abstract class BaseLazyFragment<T extends BaseViewModel> extends BaseFragment<T> {

    private boolean mIsViewCreate = false;

    private boolean mIsVisibled = false;

    private boolean mIsFirstLoad = false;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mIsViewCreate = true;
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mIsVisibled = true;
            onVisible();
        } else {
            mIsVisibled = false;
            onInVisible();
        }
    }

    private void onVisible() {
        lazyLoad();
    }

    private void onInVisible() {

    }

    private void lazyLoad() {
        if (mIsViewCreate && mIsVisibled && mIsFirstLoad) {
            loadData();
            mIsFirstLoad = false;
        }
    }

    /**
     * 子类实现加载数据
     */
    protected abstract void loadData();
}
