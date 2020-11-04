package iot.qing.beans;

/**
 * 事件对象
 */
public class EventBase {
    //服务名称
    String eventName;
    //标识符
    String ID;

    public enum EventType{
        //信息
        INFO,
        //警告
        WARNING,
        //故障
        ERROR
    }
    //事件类型
    EventType eventType;
    //描述
    String description;
    //输出参数
    String output;
    //扩展描述
    String extension;

    public String getEventName() {
        return eventName;
    }

    public String getID() {
        return ID;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getDescription() {
        return description;
    }

    public String getOutput() {
        return output;
    }

    public String getExtension() {
        return extension;
    }

    private EventBase(Builder builder){
        this.eventName = builder.eventName;
        this.ID = builder.ID;
        this.eventType = builder.eventType;
        this.description = builder.description;
        this.output = builder.output;
        this.extension = builder.extension;
    }

    public static class Builder{
        String eventName;
        String ID;
        EventType eventType;
        String description;
        String output;
        String extension;

        public Builder(String eventName,String ID,EventType eventType,String description){
            this.eventName = eventName;
            this.ID = ID;
            this.eventType = eventType;
            this.description = description;
        }

        public Builder output(String output){
            this.output = output;
            return this;
        }

        public Builder extension(String extension){
            this.extension = extension;
            return this;
        }

        public EventBase build(){
            return new EventBase(this);
        }
    }
}
