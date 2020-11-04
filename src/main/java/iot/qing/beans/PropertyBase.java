package iot.qing.beans;

/**
 * 物模型属性
 */
public class PropertyBase<T> {
    //属性名称
    String propertyName;
    //标识符
    String ID;
    //数据类型
    Class valueType;
    //取值范围
    float min;
    float max;
    //读写类型
    public enum ReadWriteType {
        //只读
        READ_ONLY,
        //读写
        READ_AND_WRITE
    };
    ReadWriteType RWType;
    //步长
    String pace;
    //单位
    String unit;
    //描述
    String description;
    //扩展描述
    String extension;

    public String getPropertyName() {
        return propertyName;
    }

    public String getID() {
        return ID;
    }

    public Class getValueType() {
        return valueType;
    }

    public float getRangeMin() {
        return min;
    }
    public float getRangeMax() {
        return max;
    }

    public ReadWriteType getRWType() {
        return RWType;
    }

    public String getPace() {
        return pace;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    public String getExtension() {
        return extension;
    }

    private PropertyBase(Builder builder){
        builder.propertyName = this.propertyName;
        builder.ID = this.ID;
        builder.valueType = this.valueType;
        builder.min = this.min;
        builder.max = this.max;
        builder.RWType = this.RWType;
        builder.pace = this.pace;
        builder.unit = this.unit;
        builder.description = this.description;
        builder.extension = this.extension;
    }

    public static class Builder{
        String propertyName;
        String ID;
        Class valueType;
        float min;
        float max;
        ReadWriteType RWType;
        String pace;
        String unit;
        String description;
        String extension;
        public Builder(String propertyName,String ID,Class valueType,ReadWriteType RWType,String description){
            this.propertyName = propertyName;
            this.ID = ID;
            this.valueType = valueType;
            this.RWType = RWType;
            this.description = description;
        }

        public Builder range(float min, float max){
            this.min = min;
            this.max = max;
            return this;
        }

        public Builder pace(String pace){
            this.pace = pace;
            return this;
        }

        public Builder unit(String unit){
            this.unit = unit;
            return this;
        }

        public Builder extension(String unit){
            this.extension = extension;
            return this;
        }

        public PropertyBase build(){
            return new PropertyBase(this);
        }
    }
}
