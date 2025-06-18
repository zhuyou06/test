package cubc.controller.trans;

import com.cubc.CubcApplication;
import com.cubc.controller.trans.CurrencyController;
import com.cubc.model.req.trans.CurrencyReq;
import com.cubc.model.res.trans.CurrencyRes;
import com.cubc.service.tran.CurrencyService;
import com.cubc.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = CubcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CurrencyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    //@Autowired
   // private CurrencyService service;

    private String baseUrl;

    private String code = "TWD";

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/api/v1/currency";
    }



    @Test
    @Order(1)
    public void tesAdd() {
        CurrencyReq req = CurrencyReq.builder()
                .code("TWD")
                .name("台幣")
                .build();


        ResponseEntity<CurrencyRes> response = restTemplate.postForEntity(baseUrl, req, CurrencyRes.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        CurrencyRes responseBody = Objects.requireNonNull(response.getBody());

        assertThat(responseBody.getCode()).isEqualTo("TWD");
        assertThat(responseBody.getName()).isEqualTo("台幣");

        System.out.println("result: " +JsonUtil.objectToJson(responseBody));

    }

    @Test
    @Order(2)
    void testQueryByCode(){

        ResponseEntity<CurrencyRes> response = restTemplate.getForEntity(baseUrl + "/" + code, CurrencyRes.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        CurrencyRes responseBody = Objects.requireNonNull(response.getBody());

        assertThat(responseBody.getCode()).isEqualTo(code);
        assertThat(responseBody.getName()).isEqualTo("台幣");

        System.out.println("result: " +JsonUtil.objectToJson(responseBody));
    }

    @Test
    @Order(3)
    void testQuery()  {
        //ResponseEntity<List<CurrencyRes>>  response = restTemplate.getForEntity(baseUrl, new ParameterizedTypeReference<List<CurrencyRes>>() {});


        ResponseEntity<List<CurrencyRes>> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CurrencyRes>>() {}
        );


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody()).isNotEmpty();

        assertThat(response.getBody()).anyMatch(c -> c.getCode().equals("TWD"));

        System.out.println("result: " +JsonUtil.objectToJson(response.getBody()));
    }

    @Test
    @Order(4)
    void testUpdate() throws JsonProcessingException {
        CurrencyReq req = CurrencyReq.builder()
                .code("TWD")
                .name("台幣111")
                .build();

        ResponseEntity<CurrencyRes> response = restTemplate.exchange(
                baseUrl,
                HttpMethod.PUT,
                new HttpEntity<>(req),
                CurrencyRes.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        CurrencyRes responseBody = Objects.requireNonNull(response.getBody());

        assertThat(responseBody.getCode()).isEqualTo(code);
        assertThat(responseBody.getName()).isEqualTo("台幣111");

        System.out.println("result: " +JsonUtil.objectToJson(responseBody));
    }

    @Test
    @Order(5)
    void testDeleteCurrency() {
        ResponseEntity<Void> response = restTemplate.exchange(
                baseUrl + "/" + code,
                HttpMethod.DELETE,
                null,
                Void.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

        ResponseEntity<CurrencyRes> verifyResponse = restTemplate.getForEntity(baseUrl + "/" + code, CurrencyRes.class);
        //assertThat(verifyResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
