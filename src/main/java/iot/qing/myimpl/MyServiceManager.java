package iot.qing.myimpl;

import iot.qing.beans.ServiceBase;
import iot.qing.utils.LogUtils;
import iot.qing.interfaces.ServiceManagerBase;

import java.io.IOException;

public class MyServiceManager implements ServiceManagerBase {

    @Override
    public void register(ServiceBase service) {
        LogUtils.log("action ["+service.getServiceName()+"] registered.");
    }

    @Override
    public void execute(String action) {
        LogUtils.log("action ["+action+"] is being invoked.");
    }
}
