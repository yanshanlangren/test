package elvis.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisTest {

    public static void main(String[] args){
        /**
         * 用Jedis连接Redis服务
         */
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());

        /**
         * Redis Java String实例
         */
//
//        //设置 redis 字符串数据
//        jedis.set("runoobkey", "www.runoob.com");
//        // 获取存储的数据并输出
//        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));

        /**
         * Redis Java List 实例
         */
        jedis.lpush("site-list","Runoob");
        jedis.lpush("site-list","Google");
        jedis.lpush("site-list","Taobao");

        List<String> list = jedis.lrange("site-list",0,2);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        /**
         * Redis Java keys 实例
         */
        Set<String> keys = jedis.keys("*");
        Iterator<String> it = keys.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

//        jedis.
    }
}
