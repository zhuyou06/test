package cubc.controller.trans;

import com.cubc.controller.trans.AddCurrencyController;
import com.cubc.model.ApiReqBase;
import com.cubc.model.req.trans.AddCurrencyReq;
import com.cubc.model.res.trans.AddCurrencyRes;
import com.cubc.model.res.trans.QueryCurrencyRes;
import com.cubc.repository.CurrencyRepository;
import com.cubc.service.tran.CurrencyService;
import com.cubc.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {AddCurrencyController.class})
@AutoConfigureMockMvc
public class AddCurrencyControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService service;

    @MockBean
    private CurrencyRepository repository;


    @Test
    public void tesAdd() throws Exception {
        ApiReqBase<AddCurrencyReq> req = new ApiReqBase<>();

        AddCurrencyReq param = AddCurrencyReq.builder()
                .code("TWD")
                .name("新台幣")
                .build();
        req.setParams(param);
        req.setChannelID("11");
        req.setDeviceUUID("11");
        req.setTxDateTime("11");

        System.out.println(JsonUtil.objectToJson(req));


        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/trans/addCurrency")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(JsonUtil.objectToJson(req)))
                .andExpect(status().isOk())
                .andExpect(content().string("新增成功"));
    }
}
