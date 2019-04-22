package iot.qing;

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
}
