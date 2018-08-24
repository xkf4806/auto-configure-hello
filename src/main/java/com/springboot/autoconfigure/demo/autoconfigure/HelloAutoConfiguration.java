package com.springboot.autoconfigure.demo.autoconfigure;

import com.springboot.autoconfigure.demo.properties.HelloProperties;
import com.springboot.autoconfigure.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: 自动化配置
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
// 开启配置
@Configuration
// 开启使用映射实体对象
@EnableConfigurationProperties(value = HelloProperties.class)
// 存在HelloService时初始化该配置类
@ConditionalOnClass(value = HelloService.class)
// 存在对应配置信息时初始化该配置类
@ConditionalOnProperty(prefix = "hello", value = "enable", matchIfMissing = true)
public class HelloAutoConfiguration {
    /**
     * application.properties配置文件映射前缀实体对象
     */
    @Autowired
    private HelloProperties helloProperties;

    // 创建HelloService实体bean
    @Bean
    // 缺失HelloService实体bean时，初始化HelloService并添加到SpringIoc
    @ConditionalOnMissingBean(value = HelloService.class)
    public HelloService helloService() {
        System.out.println(">>>未找到HelloService Bean对象，开始创建HelloService.");
        HelloService helloService = new HelloService();
        /**
         * 设置消息内容
         */
        helloService.setMsg(helloProperties.getMsg());
        /**
         * 设置是否显示
         */
        helloService.setShow(helloProperties.isShow());
        return helloService;
    }
}
