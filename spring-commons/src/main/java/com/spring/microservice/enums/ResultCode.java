package com.spring.microservice.enums;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/21 10:42 PM
 * @Version 1.0
 **/
@SuppressWarnings("all")
public enum ResultCode {

    SUCCESS(0, "成功"),
    FAILED(-1, "失败"),

    ERROR(3, "系统繁忙，请稍后重试"),
    ILLEGAL_OPERATION(4, "非法操作"),
    FORBIDDEN(5, "禁止"),
    EXISTS(6, "已经存在"),
    SERVICE_UNAVAILABLE(7, "服务不可调用"),
    OVER_LIMIT(8, "访问超限"),
    NOT_EXISTS(9, "不存在"),
    STATUS_INCORRECT(10, "状态不符"),
    MISSING_ARGUMENT(11, "参数确实"),
    NEED_LOGIN(12, "需要登陆"),
    MORE_THAN_ONE(13, "数据异常"),
    UPDATE_OR_INSERT_ERROR(14, "数据更新失败");


    private int index;
    private String desc;

    ResultCode(int index, String desc) {
        this.index = index;
        this.desc = desc;
    }

    public int getIndex() {
        return index;
    }

    public String getMessage() {
        return desc;
    }
}
