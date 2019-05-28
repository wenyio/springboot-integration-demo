package work.idler.elastiec.bean;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/17
 * @Description:work.idler.elastiec.bean
 * @version:1.0
 */

@Document(indexName = "idler",type = "book")
public class Book {

    private Integer id;
    private String bookName;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
