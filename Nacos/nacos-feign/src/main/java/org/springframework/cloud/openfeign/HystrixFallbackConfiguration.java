package org.springframework.cloud.openfeign;

import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiemin
 * @date 2019/10/9 15:09
 */
@Configuration
@ConditionalOnClass(Feign.class)
public class HystrixFallbackConfiguration {
    /** 覆盖{@link #FeignAutoConfiguration}中的默认配置 */

    @Configuration
    @ConditionalOnClass(name = "feign.hystrix.HystrixFeign")
    protected static class HystrixFeignTargeterConfiguration {
        @Bean
        @ConditionalOnMissingBean
        public Targeter feignTargeter() {
            return new HystrixFallbackTargeter();
        }
    }
}
