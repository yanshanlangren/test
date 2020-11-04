package iot.qing.interfaces;

import iot.qing.beans.PropertyBase;

import java.util.List;

public interface PropertyManagerBase {

    public void addProperty(PropertyBase property);

    public List<PropertyBase> getProperties();
}
