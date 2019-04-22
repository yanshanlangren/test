package iot.qing.myimpl;

import iot.qing.LogUtils;
import iot.qing.ServiceBase;

import java.io.File;
import java.io.IOException;

public class MyService implements ServiceBase {

    @Override
    public void register(String action,String scriptPath) {
        File script = new File(scriptPath);
        if(script.exists()){
            LogUtils.log("action ["+action+"] registered, path ["+scriptPath+"]");
            serviceMap.put(action,scriptPath);
        }
    }

    @Override
    public void execute(String action) {
        String script = serviceMap.get(action);
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("");
            process.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
