package work.idler.elastiec;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import work.idler.elastiec.bean.Article;
import work.idler.elastiec.bean.Book;
import work.idler.elastiec.repository.BookRepository;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03ElastiecApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02(){
//        Book book = new Book();
//        book.setId(1);
//        book.setBookName("鲁滨逊漂流记");
//        book.setAuthor("丹尼尔·笛福");
//        bookRepository.index(book);

        for (Book book1 : bookRepository.findByBookNameLike("记")) {
            System.out.println(book1);
        }
    }

    @Test
    public void contextLoads() {
        //1.给Es中索引(保存)一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("Hello world");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("idler").type("news").build();

        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试搜索
    @Test
    public void search(){

        //查询表达式
        String json ="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("idler").addType("news").build();

        //执行
        SearchResult execute = null;
        try {
            execute = jestClient.execute(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(execute.getJsonString());

    }

}
