package elvis.http;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.io.IOUtils;

public class HTTPServer {

    static File file ;
    static String filePath = "C:\\Users\\Elvis\\Desktop\\HTTPServer.log";
    static FileWriter writer;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(9500), 0);
        server.createContext("/imhttproxy/sendmessage", new TestHandler());
        server.start();
    }

    public static void log(String message) throws IOException {
//		if(file == null) {
//			file = new File(filePath);
//		}
        if(writer == null) {
            writer = new FileWriter(filePath,true);
        }

        writer.write( getTimeString() + " "+ message +"\r\n");
        writer.flush();
    }

    public static String getTimeString() {
        return new SimpleDateFormat("[yyyy-MM-dd hh:mm:ss.SSS]").format(new Date())+ " ";
    }

    static  class TestHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String postString = IOUtils.toString(exchange.getRequestBody());
            log(postString);

            System.out.println(getTimeString() + postString);

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            String response = "{\"state\":\"ok\"}";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

}
