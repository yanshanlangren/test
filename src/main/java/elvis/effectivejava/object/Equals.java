package elvis.effectivejava.object;

public class Equals {
    public static void main(String[] args){
        Person p1,p2;
        p1 = new Person("zy", 25);
        p2 = new Person("zy", 25);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p1.equals(p2));

    }

    static class Person{
        String name;
        int age;
        Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object a){
            super.equals(a);
            if(a instanceof Person){
                if(((Person)a).age == this.age && ((Person)a).name.equals(this.name)){
                    return true;
                }
            }
            return false;
        }
    }
}
