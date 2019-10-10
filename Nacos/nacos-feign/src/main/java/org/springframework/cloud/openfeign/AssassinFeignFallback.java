package org.springframework.cloud.openfeign;

import com.larscheng.www.api.R;
import com.larscheng.www.api.ResultCode;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiemin
 * @date 2019/10/9 11:50
 */
public class AssassinFeignFallback<T> implements MethodInterceptor {
    private static final Logger log = LoggerFactory.getLogger(AssassinFeignFallback.class);
    private final Class<T> targetType;
    private final String targetName;
    private final Throwable cause;

    private final String code = "code";


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String errorMessage = this.cause.getMessage();
        log.error("AssassinFeignFallback:[{}.{}] serviceId:[{}] message:[{}]", new Object[]{this.targetType.getName(), method.getName(), this.targetName, errorMessage});
        Class<?> returnType = method.getReturnType();
        if (R.class != returnType) {
            return null;
        } else if (!(this.cause instanceof FeignException)) {
            R.fail(ResultCode.INTERNAL_SERVER_ERROR, errorMessage);
        }
        else {
            FeignException exception = (FeignException)this.cause;
            String message = exception.getMessage();
            return R.fail(message);
        }
        return null;
    }



    public AssassinFeignFallback(Class<T> targetType, String targetName, Throwable cause) {
        this.targetType = targetType;
        this.targetName = targetName;
        this.cause = cause;
    }
}
