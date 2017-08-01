package exp.microservices.recommendationservice.service;

import exp.microservices.recommendationservice.model.Recommendation;
import exp.microservices.recommendationservice.service.util.SetProcTimeBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magnus on 04/03/15.
 */
@RestController
@RequestMapping("/recommendationservice/v1")
@Api(value="recommendationservice", description="Operations pertaining to recommendations of a product")
public class RecommendationService {

    private static final Logger LOG = LoggerFactory.getLogger(RecommendationService.class);

    @Autowired
    private SetProcTimeBean setProcTimeBean;

    /*
    private int port;

    @Value("local.server.port")
    public void setPort (int port) {
        LOG.info("getReviews will be called on port: {}", port);
        this.port = port;
    }
    */

    /**
     * Sample usage: curl $HOST:$PORT/recommendation?productId=1
     *
     * @param productId
     * @return
     */
    @ApiOperation(value = "View product recommendation details", response = Recommendation.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved recommendation"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping("/recommendation/{productId}")
    public List<Recommendation> getRecommendations(@PathVariable int productId) {

        int pt = setProcTimeBean.calculateProcessingTime();
        LOG.info("/recommendation called, processing time: {}", pt);

        sleep(pt);

        List<Recommendation> list = new ArrayList<Recommendation>();
        list.add(new Recommendation(productId, 1, "Author 1", 1, "Content 1"));
        list.add(new Recommendation(productId, 2, "Author 2", 2, "Content 2"));
        list.add(new Recommendation(productId, 3, "Author 3", 3, "Content 3"));

        LOG.info("/recommendation response size: {}", list.size());

        return list;
    }

    private void sleep(int pt) {
        try {
            Thread.sleep(pt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sample usage:
     *
     *  curl "http://localhost:10002/set-processing-time?minMs=1000&maxMs=2000"
     *
     * @param minMs
     * @param maxMs
     */
    @RequestMapping("/set-processing-time")
    public void setProcessingTime(
        @RequestParam(value = "minMs", required = true) int minMs,
        @RequestParam(value = "maxMs", required = true) int maxMs) {

        LOG.info("/set-processing-time called: {} - {} ms", minMs, maxMs);

        setProcTimeBean.setDefaultProcessingTime(minMs, maxMs);
    }
}
