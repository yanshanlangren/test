package iot.qing.myimpl;

import iot.qing.EventBase;

public class PropertyCreatedEvent implements EventBase {
    private String eventName;

    public PropertyCreatedEvent(String eventName){
        this.eventName = eventName;
    }

    @Override
    public String toString(){
        return eventName;
    }
}
