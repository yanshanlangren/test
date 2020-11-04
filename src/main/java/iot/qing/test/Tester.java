package iot.qing.test;

import iot.qing.beans.EventBase;
import iot.qing.beans.PropertyBase;
import iot.qing.beans.ServiceBase;
import iot.qing.interfaces.ThingModel;
import iot.qing.myimpl.MyThingModel;

public class Tester{
    public static void main(String[] args) {
        ThingModel light = new MyThingModel();

        PropertyBase property = new PropertyBase.Builder("light","MyLight",int.class, PropertyBase.ReadWriteType.READ_ONLY,"这是我的测试灯")
                .range(1,3)
                .pace("20")
                .unit("cm")
                .build();
        light.addProperty(property);

        ServiceBase service = new ServiceBase.Builder("BrightenLight","MyLightService",ServiceBase.InvokeType.ASYNC,"调暗灯光")
                .build();
        light.registerService(service);

        EventBase event = new EventBase.Builder("ExceedHeat","MyExceedHeadEvent",EventBase.EventType.WARNING,"温度过高")
                .build();
        light.registerEvent(event);
    }
}
