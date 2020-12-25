import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @describle:
 * @author: pangxiaofeng
 * @create: 2020/12/21
 **/
@SpringBootApplication
@ComponentScan("com.fengxiong.*")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
