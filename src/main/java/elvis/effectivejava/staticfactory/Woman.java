package elvis.effectivejava.staticfactory;

public class Woman extends Person{

    public static void main(String[] args){
        Person p = Woman.newPersonWithName("Jane");
        if(p instanceof Woman){
            System.out.println("Jane is a woman");
        }
        System.out.println("Jane is not a woman");
    }
}
