package elvis.kafka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class KafkaClient {

    //public static final String topicString = "Brain_Interaction_248_12067PUSH,Brain_Interaction_248_12066PUSH";
    //public static final String topicString = "ptah_eventbus";
//	public static final String topicString = "Brain_Interaction_3940";
    public static final String topicString = "Brain_Interaction_3940_14167PUSH";

    public static final String bootstrapURL = "172.19.11.88:9092,172.19.11.89:9092,172.19.11.90:9092";
    //public static final String bootstrapURL = "172.16.1.30:9092";

    public static void main(String[] args) throws FileNotFoundException {

        Properties props = new Properties();

        String[] topicName = topicString.split(",");

        props.put("bootstrap.servers", bootstrapURL);
        props.put("group.id", "temp1");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        props.put("auto.offset.reset", "earliest");
        props.put("isolation.level", "read_committed");
//        props.put("auto.offset.reset", "earliest");
//        props.put("isolation.level", "read_committed");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(topicName));

        PrintWriter out=new PrintWriter(new File("C:\\Users\\KXJL2018110202\\Desktop\\tpsx\\Brain_Interaction_3940_14167PUSH.txt"));

        int count = 0;
        while(true) {
            ConsumerRecords<String, String> records = consumer.poll(3000);

//	        System.out.println("1 turn");

            for(ConsumerRecord<String, String> record: records) {
//                System.out.println(record.offset()+"\t"+record.key()+"\t"+ record.value()+"\t"+ record.topic());
                System.out.println("接到"+ ++count +"条消息");
                out.append(record.value()+"\r\n");
            }
        }

    }

}
