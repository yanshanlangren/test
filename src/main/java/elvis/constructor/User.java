package elvis.constructor;

public class User {
    private String name;
    private String gender;
    public User(String name, String gender){
        super();
        this.name = name;
        this.gender = gender;
    }


    protected void interview(){
        System.out.println("大家好, 我是"+this.name+", 我是"+this.gender+"孩");
    }
}
