package iot.qing;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务管理
 */
public interface ServiceBase {
    //已注册的服务
    final Map<String, String> serviceMap= new HashMap<String, String>();
    //注册服务
    void register(String action, String scriptPath);
    //执行服务
    void execute(String action);
}
