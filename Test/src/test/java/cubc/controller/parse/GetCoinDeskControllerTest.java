package cubc.controller.parse;

import com.cubc.CubcApplication;
import com.cubc.model.res.parse.GetCoinDeskRes;
import com.cubc.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = CubcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GetCoinDeskControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/api/v1/getCoinDesk";
    }

    @Test
    void testGetCoinDeskData() throws JsonProcessingException {
        ResponseEntity<GetCoinDeskRes> response = restTemplate.getForEntity(baseUrl, GetCoinDeskRes.class);
        System.out.println("result: " + JsonUtil.objectToJson(response));
    }
}
