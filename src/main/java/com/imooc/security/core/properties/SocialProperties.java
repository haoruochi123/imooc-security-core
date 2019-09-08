package com.imooc.security.core.properties;

/**
 * @author 郝若池
 * @title: SocalProperties
 * @description: TODO
 * @date 2019/9/7/007 16:37
 */
public class SocialProperties {
    private QQProperties qq = new QQProperties();

    public QQProperties getQq() {
        return qq;
    }

    public void setQq(QQProperties qq) {
        this.qq = qq;
    }
}
