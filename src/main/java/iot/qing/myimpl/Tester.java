package iot.qing.myimpl;

import iot.qing.Property;

public class Tester{
    public static void main(String[] args) throws InterruptedException {
        MyThingModel tm = new MyThingModel();
        tm.addProperty(Property.newInstance("name","elvis"));
        tm.addProperty(Property.newInstance("age","29"));
        tm.registerService("alarm","C:\\Users\\Elvis\\Desktop\\Todo.txt");
        tm.executeService("alarm");
    }
}
