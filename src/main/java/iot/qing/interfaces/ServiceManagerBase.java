package iot.qing.interfaces;

import iot.qing.beans.ServiceBase;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务管理
 */
public interface ServiceManagerBase {
    //已注册的服务
    final Map<String, String> serviceMap= new HashMap<String, String>();
    //注册服务
    void register(ServiceBase service);
    //执行服务
    void execute(String action);
}
