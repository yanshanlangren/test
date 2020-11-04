package iot.qing.myimpl;

import iot.qing.beans.PropertyBase;
import iot.qing.interfaces.PropertyManagerBase;

import java.util.ArrayList;
import java.util.List;

public class MyPropertyManager implements PropertyManagerBase {

    List<PropertyBase> list;

    public MyPropertyManager(){
        list = new ArrayList<PropertyBase>();
    }

    @Override
    public void addProperty(PropertyBase property) {
        list.add(property);
    }

    @Override
    public List<PropertyBase> getProperties() {
        return list;
    }
}
