package elvis.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Description
 * 服务器向多个客户端推送主题，即不同客户端可向服务器订阅相同主题
 * Company Beijing
 * author  youxuan  E-mail:xuanyouwu@163.com
 * date createTime：16/7/13
 * version
 */
public class Server {

    public static final String HOST = "tcp://qingmq:8055";
    public static final String TOPIC = "test";
    public static final String TOPIC125 = "test1";
    private static final String clientid = "server";

    private MqttClient client;
    private MqttTopic topic;
    private String userName = "mdmp_dev_010";
    private String passWord = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhY3IiOiIxIiwiYXVkIjoiaWFtIiwiYXpwIjoiaWFtIiwiY3VpZCI6ImlhbXItbzF1ZDZiN20iLCJlaXNrIjoiZktPdzJnQ0JGczh1bHJRQldRcEFiWUlydXhwUF9zVGZxUDlLNF9GT3dfTT0iLCJleHAiOjE1OTE3ODI2NjcsImlhdCI6MTU2MDI0NjY2NywiaXNzIjoic3RzIiwianRpIjoiVldoZWFya0JHNjZFSkhITGpWQlBjOCIsIm5iZiI6MCwib3JnaSI6ImlvdGQtZWI1MDhiYTktZWU3ZS00Nzk1LWE0MTMtMjEyM2YwYzQ4Y2ZkIiwib3d1ciI6InVzci1rTFZWQkRxZCIsInByZWYiOiJxcm46cWluZ2Nsb3VkOmlhbToiLCJydHlwIjoiaWFtX3JvbGUiLCJzdWIiOiJzdHMiLCJ0aGlkIjoiMSIsInR5cCI6IklEIn0.UMIArGo8abYXjjvfXph_Uo3Tumu_PfHh-GZT8EDPmpsm643zMkjEjn8ze6NxbigA1gXoqg1QX7HQfp-Y3qu-w6DqrGKnhpdlWAmiaebov4rRgcSNc2f4kffRl34JuBnY-XALWz1TltaApWZZ_YfI0WOTqoN3GlsRHZzuv0ANVS7_6a0JgJHZczAPhTZnm9IjeaHCdbWdkh_ZPwM6bI1MMZPuN9fpXdZzRRkwE1z_21mk5Yl2Nac4JZPIhEuvehwDyW93e0LMfELwMXk8O5rQtB3B8k9TYK6gvQoefO6Q0kWhEeulvj1BXJexbIQR-h1jU-ZL_zQm4IXHe70cyiVsFA";

    private MqttMessage message;

    public Server() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }

    public void subscribe() throws MqttException {
        //订阅消息
        int[] Qos = {1};
        String[] topic1 = {TOPIC};
        client.subscribe(topic1, Qos);
    }

    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(1);
        try {
            client.setCallback(new PushCallback());
            client.connect(options);
            topic = client.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "
                + token.isComplete());
    }

    public static void main(String[] args) throws MqttException {
        Server server = new Server();
        server.subscribe();

        server.message = new MqttMessage();
        server.message.setQos(1);
        server.message.setRetained(true);
        server.message.setPayload("服务器发送消息".getBytes());
        server.publish(server.topic, server.message);

        System.out.println(server.message.isRetained() + "------ratained状态");
    }
}