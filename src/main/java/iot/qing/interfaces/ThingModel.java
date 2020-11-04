package iot.qing.interfaces;

import iot.qing.beans.EventBase;
import iot.qing.beans.PropertyBase;
import iot.qing.beans.ServiceBase;

public interface ThingModel {

    /**
     * 管理属性
     */
    //添加属性
    public void addProperty(PropertyBase p);
    //获得属性
    public PropertyBase getProperty(String key);

    /**
     * 服务管理
     */
    //注册服务
    public void registerService(ServiceBase service);
    //执行服务
    public void executeService(String action);

    /**
     * 事件管理
     */
    public void registerEvent(EventBase event);
}
