package elvis.stream;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User u = (User) obj;
            if(u.getAge() == this.getAge()&& u.getName().equals(this.getName()))
                return true;
        }
        return false;
    }
}
