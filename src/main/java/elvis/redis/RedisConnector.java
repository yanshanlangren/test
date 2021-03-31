package elvis.redis;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class RedisConnector {

    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;

    public RedisConnector(String host, int port) {
        try {
            this.socket = new Socket(host, port);
            this.outputStream = this.socket.getOutputStream();
            this.inputStream = this.socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String set(final String key, String value) {
        StringBuilder sb = new StringBuilder();
        //虽然输出的时候，会被转义，然而我们传送的时候还是要带上\r\n
        sb.append("*3").append("\r\n");
        sb.append("$3").append("\r\n");
        sb.append("SET").append("\r\n");
        sb.append("$").append(key.length()).append("\r\n");
        sb.append(key).append("\r\n");
        sb.append("$").append(value.length()).append("\r\n");
        sb.append(value).append("\r\n");
        byte[] bytes = new byte[1024];
        try {
            outputStream.write(sb.toString().getBytes());
            inputStream.read(bytes);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new String(bytes);
    }

    public String info(String zone) {
        StringBuilder sb = new StringBuilder();
        //虽然输出的时候，会被转义，然而我们传送的时候还是要带上\r\n
        sb.append("*2").append("\r\n");
        sb.append("$4").append("\r\n");
        sb.append("INFO").append("\r\n");
        sb.append("$").append(zone.length()).append("\r\n");
        sb.append(zone).append("\r\n");
        byte[] bytes = new byte[10240];
        try {
            outputStream.write(sb.toString().getBytes());
            inputStream.read(bytes);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
//        RedisConnector redisClient = new RedisConnector("127.0.0.1", 6379);
        RedisConnector redisClient = new RedisConnector("192.168.0.50", 6379);
        String result;
//        result = redisClient.set("eat", "please eat");
        result = redisClient.info("replication");
        System.out.println(result);
    }
}
