package work.idler.springboot.exception;

/**
 * @Auther:http://www.idler.work
 * @Date:2019/2/11
 * @Description:work.idler.springboot.exception
 * @version:1.0
 */
public class UserNotExistException extends RuntimeException{

    public UserNotExistException() {
        super("用户不存在");
    }
}
