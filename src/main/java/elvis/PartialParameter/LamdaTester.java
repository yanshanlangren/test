package elvis.PartialParameter;

import org.springframework.core.convert.converter.Converter;

public class LamdaTester {

    public static void main(String[] args){
        int num = 9;
//        num++;
        Converter<Integer, String> strConverter = y-> String.valueOf(y + num);
        System.out.println(strConverter.convert(1));
    }
}
