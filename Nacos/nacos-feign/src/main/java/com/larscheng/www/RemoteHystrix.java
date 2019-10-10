package com.larscheng.www;

import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/10 16:02
 */
@Component
@Log4j2
public class RemoteHystrix implements FallbackFactory<RemoteClient> {




    @Override
    public RemoteClient create(Throwable throwable) {

        return new RemoteClient() {
            @Override
            public String helloNacos() {
                return "请求超时了";
            }
        };
    }
}
