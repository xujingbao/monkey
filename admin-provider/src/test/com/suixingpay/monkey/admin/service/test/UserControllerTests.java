package com.suixingpay.monkey.admin.service.test;

import com.suixingpay.monkey.admin.service.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Evan Xu on 20/3/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class UserControllerTests {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {
        //
        RequestBuilder request = null;
        // 查下user列表，应该为空
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("{}")));

        //添加用户
        request = post("/users/").param("id", "99").param("name", "单元测试").param("sex", "1").param("age", "30");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        //再次获取，应该有刚才插入的数据
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("{\"\":{\"id\":\"99\",\"name\":\"单元测试\",\"password\":null,\"sex\":\"1\",\"age\":\"30\",\"birth\":null,\"addr\":null}}")));

        //
        request = put("/users/1").param("name", "随行付的单元测试").param("age", "30");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        //再次获取，应该有刚才插入的数据
        request = get("/users/");
        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("{\"\":{\"id\":\"99\",\"name\":\"随行付的单元测试\",\"password\":null,\"sex\":\"1\",\"age\":\"30\",\"birth\":null,\"addr\":null}}")));
    }
}

