package elvis.effectivejava.singleton;

public enum EnumSingleTon {
    INSTANCE;

    private void alert(){
        System.out.println("1231");
    }

    public static void main(String[] args){
        EnumSingleTon.INSTANCE.alert();
    }
}
