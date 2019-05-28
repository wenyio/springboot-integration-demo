package work.idler.elastiec.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import work.idler.elastiec.bean.Book;

import java.util.List;


/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/17
 * @Description:work.idler.elastiec.repository
 * @version:1.0
 */

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    public List<Book> findByBookNameLike(String bookName);
}
