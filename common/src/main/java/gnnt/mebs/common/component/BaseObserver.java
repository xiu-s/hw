package gnnt.mebs.common.component;

import android.util.Log;

import io.reactivex.observers.DisposableObserver;

/**********************************************************
 *  BaseObserver.java  2019-11-12
 *  <p>
 *  描述
 *  </p>
 *  Copyright2019 by GNNT Company. All Rights Reserved.
 *
 *  @author:shuhj
 ***********************************************************/
public abstract class BaseObserver<T> extends DisposableObserver<BaseResPonse<T>> {
    @Override
    public void onNext(BaseResPonse<T> response) {
        Log.e("debug", "response = ${response.errorCode}");
        int errorCode = response.code;
        String message = response.message;
        if ((errorCode == 0) || (errorCode == 200)) {
            onSuccess(response.result);
        } else {
            onError(new ApiException(errorCode, message));
        }
    }

    @Override
    public void onError(Throwable e) {
        String erMsg = ExceptionHandler.handleException(e);
    }

    public abstract void onError(String errMsg);

    public abstract void onSuccess(T data);

    /**********************************************************
     *  ApiException.java  2019-11-12
     *  <p>
     *  描述
     *  </p>
     *  Copyright2019 by GNNT Company. All Rights Reserved.
     *
     *  @author:shuhj
     ***********************************************************/
    public static class ApiException extends Exception {
        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ApiException(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
