package iot.qing;

import iot.qing.myimpl.MyThingModel;

import java.util.List;

/**
 * 物模型基类
 * @param <A> 定义属性key值类型
 * @param <B> 定义属性value类型
 */
public abstract class ThingModel<A,B> {
    //属性列表
    protected List<Property<A,B>> properties = null;
    //服务管理器
    protected ServiceBase serviceManager = null;
    //事件管理器
    protected EventManagerBase eventManager = null;

    /**
     * 管理属性
     */
    //添加属性
    protected abstract MyThingModel addProperty(Property p);
    //获得属性
    protected abstract Property getProperty(A key);

    /**
     * 服务管理
     */
    //注册服务
    protected abstract void registerService(String action, String scriptPath);
    //执行服务
    protected abstract void executeService(String action);

}
