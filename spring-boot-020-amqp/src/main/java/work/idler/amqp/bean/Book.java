package work.idler.amqp.bean;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/17
 * @Description:work.idler.amqp.bean
 * @version:1.0
 */
public class Book {
    private String bootName;
    private String autor;

    public Book() {
    }

    public Book(String bootName, String autor) {
        this.bootName = bootName;
        this.autor = autor;
    }

    public String getBootName() {
        return bootName;
    }

    public void setBootName(String bootName) {
        this.bootName = bootName;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
