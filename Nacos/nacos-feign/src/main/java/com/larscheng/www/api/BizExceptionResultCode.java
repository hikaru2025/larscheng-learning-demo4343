package com.larscheng.www.api;

/**
 * @author xiemin
 * @date 2019/10/9 12:10
 */
public enum BizExceptionResultCode implements IResultCode {
    SUCCESS("200", "操作成功"),
    FAILURE("400", "操作失败"),
    FAIL("999", "系统繁忙,请稍后再试"),
    FREQUENTLY_OPERATION("998", "您的操作过于频繁,请稍后再试"),
    SERVICE_FUSING("997", "请求服务不可用,请稍后再试"),
    UID_GENERATE_FAIL("996", "UID生成失败"),
    TOKEN_ALREADY_EXPIRE("995", "Token已过期"),
    UNAUTHORIZED_ACCESS("994", "无访问权限！"),
    INSERT_DB_FAIL("001", "插入数据失败"),
    UPDATE_DB_FAIL("002", "更新数据失败"),
    DELETE_DB_FAIL("003", "删除数据失败"),
    CLASS_NOT_ENUM_TYPE("004", "声明类型非枚举类型"),
    USER_NOT_ALLOT_STORAGE("005", "当前用户未分配仓库"),
    USER_NOT_ALLOT_STORE("006", "当前用户未分配门店"),
    VIOLATION_OPERATE("007", "%s"),
    UNEXPECTED_EXCEPTION("008", "%s"),
    STORE_NOT_EXIST("009", "门店不存在"),
    STORE_ALREADY_DISABLED("010", "门店已被禁用"),
    STORE_ABSENCE_RELATE_STORAGE("011", "门店尚未分配分拣中心"),
    STORAGE_NOT_EXIST("012", "仓库不存在"),
    STORAGE_ALREADY_DISABLED("013", "仓库已被禁用"),
    STORE_DATA_ULTRA_OPERATE("014", "门店数据越权操作"),
    STORAGE_DATA_ULTRA_OPERATE("015", "仓库数据越权操作"),
    PARAM_ERROR_EXCEPTION("016", "%s"),
    ENUM_TYPE_NOT_EXIST("017", "枚举类型不存在"),
    DISTRIBUTED_LOCK_GET_FAILURE("018", "分布式锁获取失败！"),
    UMENG_PUSH_MESSAGE_PARAM_ERROR("019", "友盟消息推送参数设置错误！"),
    TREE_LEVEL_OVERSTEP_APPOINT("020", "层级不可超出%s级"),
    TREE_NOT_EXIST("021", "当前树不存在"),
    PARENT_TREE_NOT_EXIST("022", "父级树不存在"),
    ENUM_VALUE_NOT_EXIST("023", "枚举取值不存在");

    private final String errorCode;
    private final String errorMsg;

    private BizExceptionResultCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getMessage() {
        return this.errorMsg;
    }

    @Override
    public String getCode() {
        return this.errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
