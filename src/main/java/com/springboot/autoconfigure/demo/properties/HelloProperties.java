package com.springboot.autoconfigure.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Description: 自动化配置实体类
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    /**
     * 消息内容
     */
    private String msg = "hello springboot";
    /**
     * 是否显示消息内容
     */
    private boolean show = true;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
