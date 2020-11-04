package iot.qing.interfaces;

import iot.qing.beans.EventBase;

/**
 * 事件管理
 */
public interface EventManagerBase {
    //推送事件
    public void push(EventBase event);
    //拉取事件
    public EventBase pull();
    //监听事件
    public void listen();
    //注册事件
    public void registerEvent(EventBase event);
}
