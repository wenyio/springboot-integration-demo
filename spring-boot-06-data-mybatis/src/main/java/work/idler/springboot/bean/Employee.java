package work.idler.springboot.bean;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/13
 * @Description:work.idler.springboot.bean
 * @version:1.0
 */
public class Employee {

    private int id;
    private String lastName;
    private String gender;
    private String email;
    private int dId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }
}
