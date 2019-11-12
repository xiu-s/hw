package gnnt.mebs.common.vo;

/*******************************************************************
 * LoginUser.java  2019/2/21
 * <P>
 * 登录用户<br/>
 * <br/>
 * </p>
 * Copyright2018 by GNNT Company. All Rights Reserved.
 *
 * @author:shuhj
 *
 ******************************************************************/
public class LoginUser {

    /**
     * 用户名
     */
    public String userName;
    /**
     * 昵称
     */
    public String nickName;
    /**
     * 签名
     */
    public String sign;


    public LoginUser(String userName, String nickName, String sign) {
        this.userName = userName;
        this.nickName = nickName;
        this.sign = sign;
    }
}