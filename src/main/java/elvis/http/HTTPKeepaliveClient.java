package elvis.http;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class HTTPKeepaliveClient {
    private Integer maxTotal = 3000;
    private Integer defaultMaxPerRoute = 3000;
    private Integer validateAfterInactivity = 2 * 1000;
    private Integer connectionRequestTimeout = 2 * 1000;
    private Integer connectTimeout = 2 * 1000;
    private Integer socketTimeout = 5 * 1000;
    private Integer requestSentRetryCount = 3;
    private boolean requestSentRetryEnabled = true;
    private Map<String, String> defaultHeaders = new HashMap<>();


    @Bean(destroyMethod = "close")
    public CloseableHttpClient httpClient(PoolingHttpClientConnectionManager connManager) {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectTimeout)
                .setSocketTimeout(socketTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .build();

        DefaultHttpRequestRetryHandler defaultHttpRequestRetryHandler = new DefaultHttpRequestRetryHandler(
                requestSentRetryCount, requestSentRetryEnabled);

        List<Header> headers = defaultHeaders.entrySet().stream()
                .map(e -> new BasicHeader(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultHeaders(headers)
                .setConnectionManager(connManager)
                .setConnectionManagerShared(false)
//                .evictIdleConnections(60, TimeUnit.SECONDS)
                .evictExpiredConnections()
                .setConnectionTimeToLive(60, TimeUnit.SECONDS)
                .setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE)
                .setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE)
                .setRetryHandler(defaultHttpRequestRetryHandler)
                .setDefaultRequestConfig(requestConfig)
                .build();
        return httpClient;
    }

    @Bean(destroyMethod = "close")
    public PoolingHttpClientConnectionManager connManager() {
        PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(maxTotal);
        connManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        connManager.setValidateAfterInactivity(validateAfterInactivity);
        return connManager;
    }

    public static void main(String[] args) {
        HTTPKeepaliveClient cls = new HTTPKeepaliveClient();
        CloseableHttpClient c = cls.httpClient(cls.connManager());
//        c.execute("http://139.198.21.67:9080/test", );
    }
}