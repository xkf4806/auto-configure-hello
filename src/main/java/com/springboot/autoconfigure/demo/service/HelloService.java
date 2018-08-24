package com.springboot.autoconfigure.demo.service;

/**
 * Description: 自定义业务实现
 *
 * @author xj.x
 * @version 1.0
 * @date 2018/8/24
 */
public class HelloService {

    private String msg;
    private Boolean show = true;

    public String sayHello() {
        return show ? msg : "Hidden";
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
