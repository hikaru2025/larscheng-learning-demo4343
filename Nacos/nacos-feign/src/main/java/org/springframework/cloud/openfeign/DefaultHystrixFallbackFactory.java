package org.springframework.cloud.openfeign;

import feign.Target;
import feign.hystrix.FallbackFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.Scope;

/**
 * @author xiemin
 * @date 2019/10/9 11:38
 */
@Scope("prototype")
public class DefaultHystrixFallbackFactory<T> implements FallbackFactory<T> {

    private  Target<T> target;

    public DefaultHystrixFallbackFactory(Target<T> target) {
        this.target = target;
    }

    public void setTarget(Target<T> target) {
        this.target = target;
    }

    public T create(Throwable cause) {
        Class<T> targetType = this.target.type();
        String targetName = this.target.name();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetType);
        enhancer.setUseCache(true);
        enhancer.setCallback(new AssassinFeignFallback(targetType, targetName, cause));
        return (T) enhancer.create();
    }
}
