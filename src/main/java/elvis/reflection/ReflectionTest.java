package elvis.reflection;

public class ReflectionTest {
    public <T> T test(String str, Class<T> clazz){

        return clazz.cast(new Object());
    }
}
