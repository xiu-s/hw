package gnnt.mebs.common.component;

import com.google.gson.JsonParseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import javax.net.ssl.SSLHandshakeException;

import retrofit2.HttpException;

/**********************************************************
 *  ExceptionHandler.java  2019-11-12
 *  <p>
 *  描述
 *  </p>
 *  Copyright2019 by GNNT Company. All Rights Reserved.
 *
 *  @author:shuhj
 ***********************************************************/
public class ExceptionHandler {
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static String handleException(Throwable exception) {
        String message = "";
        if (exception instanceof HttpException) {
            switch (((HttpException) exception).code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                case GATEWAY_TIMEOUT:
                    message = "网络错误";

            }
        } else if (exception instanceof BaseObserver.ApiException) {

        } else if (exception instanceof JsonParseException || exception instanceof JSONException || exception instanceof ParseException) {
            message = "解析错误";
        } else if (exception instanceof ConnectException) {
            message = "网络链接失败，请稍后重试";
        } else if (exception instanceof SSLHandshakeException) {
            message = "证书验证失败";
        } else if (exception instanceof ConnectTimeoutException) {
            message = "网络链接超时";
        } else if (exception instanceof SocketTimeoutException) {
            message = "连接超时";
        } else {
            message = "网络链接异常，请稍后重试";
        }
        return message;
    }
}
