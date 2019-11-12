package gnnt.mebs.common.component;

/**********************************************************
 *  BaseResPonse.java  2019-11-12
 *  <p>
 *  描述
 *  </p>
 *  Copyright2019 by GNNT Company. All Rights Reserved.
 *
 *  @author:shuhj
 ***********************************************************/
public class BaseResPonse<T> {
    /**
     * 返回码
     */
    public int code;

    /**
     * 消息
     */
    public String message;

    /**
     * 返回内容
     */
    public T result;

    public BaseResPonse() {
    }

    public BaseResPonse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 返回一个默认错误的返回包
     *
     * @param message 错误消息
     * @param <T>
     * @return
     */
    public static <T> BaseResPonse<T> defaultError(String message) {
        return new BaseResPonse<T>(-1, message);
    }
}
