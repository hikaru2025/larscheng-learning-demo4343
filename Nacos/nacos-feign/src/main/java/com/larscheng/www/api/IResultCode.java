package com.larscheng.www.api;

import java.io.Serializable;

/**
 * @author xiemin
 * @date 2019/10/9 12:11
 */
public interface IResultCode  extends Serializable {
    String getMessage();

    String getCode();
}
