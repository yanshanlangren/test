package elvis.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.concurrent.ScheduledExecutorService;

/**
 * Description
 * 客户端程序
 * Company Beijing
 * author  youxuan  E-mail:xuanyouwu@163.com
 * date createTime：16/7/13
 * version
 */
public class Client {

    public static final String HOST = "tcp://qingmq:8055";

    public static final String TOPIC = "test";
    private static final String clientid = "client124";
    private MqttClient client;
    private MqttConnectOptions options;
    private String userName = "mdmp_dev_010";
    private String passWord = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY3IiOiIxIiwiYXVkIjoiaWFtIiwiYXpwIjoiaWFtIiwiY3VpZCI6ImlhbXItbzF1ZDZiN20iLCJlaXNrIjoiZktPdzJnQ0JGczh1bHJRQldRcEFiWUlydXhwUF9zVGZxUDlLNF9GT3dfTT0iLCJleHAiOjE1OTE3ODI2NjcsImlhdCI6MTU2MDI0NjY2NywiaXNzIjoic3RzIiwianRpIjoiVldoZWFya0JHNjZFSkhITGpWQlBjOCIsIm5iZiI6MCwib3JnaSI6ImlvdGQtZWI1MDhiYTktZWU3ZS00Nzk1LWE0MTMtMjEyM2YwYzQ4Y2ZkIiwib3d1ciI6InVzci1rTFZWQkRxZCIsInByZWYiOiJxcm46cWluZ2Nsb3VkOmlhbToiLCJydHlwIjoiaWFtX3JvbGUiLCJzdWIiOiJzdHMiLCJ0aGlkIjoiMSIsInR5cCI6IklEIn0.UMIArGo8abYXjjvfXph_Uo3Tumu_PfHh-GZT8EDPmpsm643zMkjEjn8ze6NxbigA1gXoqg1QX7HQfp-Y3qu-w6DqrGKnhpdlWAmiaebov4rRgcSNc2f4kffRl34JuBnY-XALWz1TltaApWZZ_YfI0WOTqoN3GlsRHZzuv0ANVS7_6a0JgJHZczAPhTZnm9IjeaHCdbWdkh_ZPwM6bI1MMZPuN9fpXdZzRRkwE1z_21mk5Yl2Nac4JZPIhEuvehwDyW93e0LMfELwMXk8O5rQtB3B8k9TYK6gvQoefO6Q0kWhEeulvj1BXJexbIQR-h1jU-ZL_zQm4IXHe70cyiVsFA";


    private ScheduledExecutorService scheduler;

    private void start() {
        try {
            // host为主机名，clientid即连接MQTT的客户端ID，一般以唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            client = new MqttClient(HOST, clientid, new MemoryPersistence());
            // MQTT的连接设置
            options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置连接的用户名
            options.setUserName(userName);
            // 设置连接的密码
            options.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            // 设置回调
            client.setCallback(new PushCallback());
            MqttTopic topic = client.getTopic(TOPIC);
            //setWill方法，如果项目中需要知道客户端是否掉线可以调用该方法。设置最终端口的通知消息
            options.setWill(topic, "close".getBytes(), 1, true);

            client.connect(options);
            //订阅消息
            int[] Qos = {1};
            String[] topic1 = {TOPIC};
            client.subscribe(topic1, Qos);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws MqttException {
        Client client = new Client();
        client.start();
    }
}