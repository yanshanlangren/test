package elvis.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ResendTPJKMessage extends Thread{

//    public static final String URL = "http://localhost:9500/imhttproxy/sendmessage";
    public static final String URL = "http://172.19.11.32/platform/prodService/recieve/trace";
    public static final String filePath = "C:\\Users\\KXJL2018110202\\Desktop\\asd\\Brain_Interaction_3940_14167PUSH.txt";

    public static PrintWriter errPW,logPW;

    private String callStr;
    private int count;

    public static void main(String[] args) throws IOException, InterruptedException {

        //读取文件
        File f = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(f));
        String tmp;

        //新建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(20,100,1, TimeUnit.SECONDS,new LinkedBlockingQueue<>());

        long t1 = System.currentTimeMillis();
        System.out.println("Start time: "+ LocalDateTime.now());

        int count = 0;
        while((tmp = br.readLine())!=null&&!tmp.trim().equals("")){

            Runnable r = new ResendTPJKMessage(tmp,count++);
            pool.submit(r);
        }

        while(pool.getActiveCount()>0){
            Thread.sleep(100);
        }

        long t2 = System.currentTimeMillis();
        System.out.println("End time: "+ LocalDateTime.now()+"\r\nTotal time: "+(t2-t1)+"ms");

        if(logPW!=null){
            logPW.close();
        }
        if(errPW!=null){
            errPW.close();
        }
    }

    public static void log(String logStr) throws FileNotFoundException {
        if(logPW==null)
            logPW = new PrintWriter("C:\\\\Users\\\\KXJL2018110202\\\\Desktop\\\\SKIP_Result_54.log");
        logPW.append(logStr+"\r\n");
        logPW.flush();
    }

    public static void saveError(String errorData) throws FileNotFoundException {
        if(errPW==null)
            errPW = new PrintWriter("C:\\\\Users\\\\KXJL2018110202\\\\Desktop\\\\SKIP_ErrorData_54.log");
        errPW.append(errorData+"\r\n");
        errPW.flush();

    }

    public static HttpResponse sendMessage(JSONObject callInfo ) throws IOException {

        HttpClient httpClient = new DefaultHttpClient();

        // 设置超时时间
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);

        HttpPost post = null;
        post = new HttpPost(URL);

        // 构造消息头
        post.setHeader("Content-type", "application/json; charset=utf-8");
        post.setHeader("Connection", "keep-alive");

        // 构建消息实体
        StringEntity entity = new StringEntity(callInfo.toString(), Charset.forName("UTF-8"));
        entity.setContentEncoding("UTF-8");
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        post.setEntity(entity);


        return httpClient.execute(post);
    }

    @Override
    public void run(){
        System.out.println("Task "+count+" started to run.");

//        String[] arr = this.callStr.split(" ");
//        String toParse = this.callStr.substring(this.callStr.indexOf(arr[8])+15,this.callStr.length()-1);
//        JSONObject root = (JSONObject)JSON.parseObject(toParse);
//        JSONObject callInfo = root.getJSONObject("bossAPICallInfo");
//        String callId = callInfo.getString("userData");
        JSONObject callInfo = JSON.parseObject(this.callStr);

        //去掉KXJL_SKIP_PLAY节点. 和任意回答节点
        List<Object> toRemove = new ArrayList<Object>();
        JSONArray toFilter = callInfo.getJSONArray("interactions");
        if(toFilter!=null) {
            for(Object obj:toFilter) {
                JSONObject jsonOutput = (JSONObject) obj;
                if(jsonOutput.get("output")!=null&&jsonOutput.get("output").equals("KXJL_SKIP_PLAY")||(jsonOutput.get("nodeType")!=null&&jsonOutput.get("nodeType").equals("AnyNode"))) {
                    toRemove.add(obj);
                }
            }
            for(Object o:toRemove) {
                toFilter.remove(o);
            }
        }
//            System.out.println("处理之后:\r\n"+callInfo);

        HttpResponse response = null;
        try {
            response = sendMessage(callInfo);
            int statusCode = response.getStatusLine().getStatusCode();
            String responseStr=EntityUtils.toString(response.getEntity());
            if(statusCode != HttpStatus.SC_OK){
                log("请求出错: "+this.count);
                saveError(this.callStr);
            }else{
                try {
                    JSONObject result = JSON.parseObject(responseStr);
                    if (result.containsKey("code")
                            && result.containsKey("message")
                            && result.getIntValue("code") == 0
                            && result.getString("message").equals("ok")) {
                        log("请求成功: " + this.count);
                    }
                } catch (Exception e){
                    log("请求出错: "+this.count+" "+responseStr);
                    saveError(this.callStr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResendTPJKMessage(String callStr, int count){
        super();
        this.callStr = callStr;
        this.count = count;
    }

}
