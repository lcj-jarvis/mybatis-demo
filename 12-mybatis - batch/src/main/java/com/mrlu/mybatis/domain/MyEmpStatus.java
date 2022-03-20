package com.mrlu.mybatis.domain;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-26 15:53
 */
public enum MyEmpStatus {

    Login("100","用户登录"),LOGOUT("200","用户登出"),REMOVE("300","用户不存在");

    private String code;
    private String message;

    MyEmpStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 通过状态码获取枚举的类型
     * @param code
     * @return
     */
    public static MyEmpStatus getMyEmpStatusByCode(String code){
        switch (code){
            case "100":
                return Login;
            case "200":
                return LOGOUT;
            case "300":
                return REMOVE;
            default:
                return LOGOUT;
        }
    }
}
