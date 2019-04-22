package iot.qing.myimpl;

import iot.qing.Property;
import iot.qing.ThingModel;

import java.util.ArrayList;
import java.util.List;

public class MyThingModel extends ThingModel<String, String>{

    public MyThingModel(){
        this.serviceManager = new MyService();
        this.properties = new ArrayList<Property<String, String>>();
        this.eventManager = new MyEventManager();
    }

    private List<Property<String, String>> getPropertyList(){
        return this.properties;
    }

    public Property getProperty(int index){
        return this.getPropertyList().get(index);
    }

    @Override
    public MyThingModel addProperty(Property p) {
        this.getPropertyList().add(p);
        eventManager.push(new PropertyCreatedEvent("PropertyCreatedEvent"));
        return this;
    }

    @Override
    protected Property getProperty(String key) {
        List<Property<String, String>> properties= this.getPropertyList();
        for(int i = 0; i<properties.size();i++){
            if(properties.get(i).getKey().equals(key))
                return properties.get(i);
        }
        return null;
    }

    @Override
    protected void registerService(String action, String scriptPath) {
        serviceManager.register(action, scriptPath);
    }

    @Override
    protected void executeService(String action) {
        serviceManager.execute(action);
    }
}
