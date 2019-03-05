package com.spring.microservice.dto;

import com.spring.microservice.enums.ResultCode;

import java.io.Serializable;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/21 10:41 PM
 * @Version 1.0
 **/
public class ResponseVO {

    private ResponseHeader head;

    private Object data;

    public ResponseVO() {
        this.head = new ResponseHeader(0, "");
    }

    public ResponseVO(ResultCode resultCode) {
        this.head = new ResponseHeader(resultCode);
    }

    public ResponseVO(Integer errCode, String errMsg) {
        this.head = new ResponseHeader(errCode, errMsg);
    }

    public ResponseVO(ResultCode resultCode, Object data) {
        this.head = new ResponseHeader(resultCode);
        this.data = data;
    }

    public ResponseVO(Object data, Integer errCode, String errMsg) {
        this.head = new ResponseHeader(errCode, errMsg);
        this.data = data;
    }

    public void setErrCode(Integer errCode) {
        head.setErrCode(errCode);
    }

    public void setErrMsg(String errMsg) {
        head.setErrMsg(errMsg);
    }

    public ResponseHeader getHead() {
        return this.head;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseVO buildSuccess() {
        return new ResponseVO(ResultCode.SUCCESS);
    }

    public static ResponseVO buildSuccess(Object data) {
        ResponseVO responseVO = buildSuccess();
        responseVO.setData(data);
        return responseVO;
    }

    public static ResponseVO buildError(int errCode, String errMsg) {
        return buildError(errCode, errMsg, null);
    }

    public static ResponseVO buildError(ResultCode resultCode) {
        return buildError(resultCode.getIndex(), resultCode.getMessage(), null);
    }

    public static ResponseVO buildError(int errCode, String errMsg, Object data) {
        ResponseVO responseVO = new ResponseVO(errCode, errMsg);
        responseVO.setData(data);
        return responseVO;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "head=" + head +
                ", data=" + data +
                '}';
    }

    static class ResponseHeader implements Serializable {

        private int errCode;

        private String errMsg;

        public ResponseHeader() {
        }

        public ResponseHeader(int errCode, String errMsg) {
            this.errCode = errCode;
            this.errMsg = errMsg;
        }

        public ResponseHeader(ResultCode resultCode) {
            this.errCode = resultCode.getIndex();
            this.errMsg = resultCode.getMessage();
        }

        public int getErrCode() {
            return errCode;
        }

        public void setErrCode(int errCode) {
            this.errCode = errCode;
        }

        public String getErrMsg() {
            return errMsg;
        }

        public void setErrMsg(String errMsg) {
            this.errMsg = errMsg;
        }

        @Override
        public String toString() {
            return "ResponseHeader{" +
                    "errCode=" + errCode +
                    ", errMsg='" + errMsg + '\'' +
                    '}';
        }
    }

}