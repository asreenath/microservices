package exp.microservices.edgeservice; /**
 * Created by Sairam on 7/9/17.
 */

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
@EnableZuulProxy
public class EdgeApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(EdgeApplication.class).web(true).run(args);
    }
}
