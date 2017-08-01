package exp.microservices.productcompositeservice; /**
 * Created by Sairam on 7/25/17.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
/*
@EnableFeignClients
@ComponentScan
*/
public class ProductCompositeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductCompositeApplication.class, args);
    }
}

