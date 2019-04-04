package elvis.effectivejava.object;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber){
        this.areaCode = (short)areaCode;
        this.prefix = (short)prefix;
        this.lineNumber = (short)lineNumber;
    }

    @Override
    public boolean equals(Object o){
        if(o == this)
            return true;
        if(!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNumber == this.lineNumber
                && pn.prefix == this.prefix
                && pn.areaCode == this.areaCode;
    }

    @Override
    public int hashCode(){
        return 1;
    }

    public static void main(String[] args){
        Map<PhoneNumber, String> m = new HashMap<PhoneNumber,String>();
        m.put(new PhoneNumber(1,2,3),"Elvis");

        System.out.println(m.get(new PhoneNumber(1,2,3)));
        System.out.println(m.get(new PhoneNumber(3,2,1)));
    }

}
