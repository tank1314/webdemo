package com.framework.tank.json.result;


/**
 * @author yuwei
 */
public abstract class ResultBuilder {

    public static Result build(String code, String msg) {
        return build(code, msg, "");
    }
    public static Result build(String code, boolean popup, String msg) {
        return build(code, popup, msg, "");
    }

    public static Result build(String code, String msg, String data) {
        return build(code, false, msg, data);
    }

    public static Result build(String code, boolean popup, String msg, String data) {
        Result result = new Result();
        result.setCode(code);
        result.setPopup(popup);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }


    public static String toJson(String code, String msg, String data) {
        return toJson(code, false, msg, data);
    }

    public static String toJson(String code, boolean popup, String msg, String data) {
        return build(code, popup, msg, data).toJson();
    }

    public static String toString(String code, String msg) {
        return toString(code, msg, "");
    }

    public static String toString(String code, boolean popup, String msg) {
        return toString(code, popup, msg, "");
    }

    public static String toString(String code, String msg, String data) {
        return toString(code, false, msg, data);
    }

    public static String toString(String code, boolean popup, String msg, String data) {
        return build(code, popup, msg, data).toString();
    }
    
}
