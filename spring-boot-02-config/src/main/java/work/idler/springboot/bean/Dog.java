package work.idler.springboot.bean;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/7
 * @Description:work.idler.springboot.bean
 * @version:1.0
 */
public class Dog {

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
