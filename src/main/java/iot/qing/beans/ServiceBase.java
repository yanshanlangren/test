package iot.qing.beans;

public class ServiceBase {
    //服务名称
     String serviceName;
     //标识符
     String ID;

     public enum InvokeType{
         /**
          * 同步
          */
         SYNC,
         /**
          * 异步
          */
         ASYNC
     }

     //调用方式
     InvokeType invokeType;
     //描述
     String description;
     //输入
     String input;
     //输出
     String output;
     //扩展描述
     String extension;

    public String getServiceName() {
        return serviceName;
    }

    public String getID() {
        return ID;
    }

    public InvokeType getInvokeType() {
        return invokeType;
    }

    public String getDescription() {
        return description;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public String getExtension() {
        return extension;
    }

    public static class Builder{
         String serviceName;
         String ID;
         InvokeType invokeType;
         String description;
         String input;
         String output;
         String extension;
         public Builder(String serviceName,String ID,InvokeType invokeType, String description){
             this.serviceName = serviceName;
             this.ID = ID;
             this.invokeType = invokeType;
             this.description = description;
         }
         public Builder input(String input){
             this.input = input;
             return this;
         }
         public Builder output(String output){
             this.output = output;
             return this;
         }
         public Builder extension(String extension){
             this.extension = extension;
             return this;
         }
         public ServiceBase build(){
             return new ServiceBase(this);
         }
    }

    private ServiceBase(Builder builder){
        this.serviceName = builder.serviceName;
        this.ID = builder.ID;
        this.invokeType = builder.invokeType;
        this.description = builder.description;
        this.input = builder.input;
        this.output = builder.output;
        this.extension = builder.extension;
    }
}
