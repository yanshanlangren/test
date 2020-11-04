package iot.qing.myimpl;

import iot.qing.beans.EventBase;
import iot.qing.beans.PropertyBase;
import iot.qing.beans.ServiceBase;
import iot.qing.interfaces.EventManagerBase;
import iot.qing.interfaces.PropertyManagerBase;
import iot.qing.interfaces.ServiceManagerBase;
import iot.qing.interfaces.ThingModel;

import java.util.List;

public class MyThingModel implements ThingModel{

    //属性管理器
    public PropertyManagerBase propertyManager = null;
    //服务管理器
    public ServiceManagerBase serviceManager = null;
    //事件管理器
    public EventManagerBase eventManager = null;

    public MyThingModel(){
        this.serviceManager = new MyServiceManager();
        this.propertyManager = new MyPropertyManager();
        this.eventManager = new MyEventManager();
    }

    private List<PropertyBase> getPropertyList(){
        return propertyManager.getProperties();
    }

    public PropertyBase getProperty(int index){
        return this.getPropertyList().get(index);
    }

    @Override
    public void addProperty(PropertyBase p) {
        propertyManager.addProperty(p);
    }

    @Override
    public PropertyBase getProperty(String key) {
        List<PropertyBase> properties= this.getPropertyList();
        for(int i = 0; i<properties.size();i++){
            if(properties.get(i).getPropertyName().equals(key))
                return properties.get(i);
        }
        return null;
    }

    @Override
    public void registerService(ServiceBase service) {
        serviceManager.register(service);
    }

    @Override
    public void executeService(String action) {
        serviceManager.execute(action);
    }

    @Override
    public void registerEvent(EventBase event) {
        eventManager.registerEvent(event);
    }
}
