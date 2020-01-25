package com.corn.springboot.configure;

import com.corn.springboot.service.ISplitService;
import com.corn.springboot.service.impl.SplitServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Qinyi.
 */
@Configuration
//加载到这两个类配置才生效
@ConditionalOnClass(value = { ISplitService.class, SplitServiceImpl.class})
public class SplitAutoConfigure {

    @Bean
    //该bean未在容器中存在才创建
    @ConditionalOnMissingBean
    ISplitService starterService() {
        return new SplitServiceImpl();
    }
}
