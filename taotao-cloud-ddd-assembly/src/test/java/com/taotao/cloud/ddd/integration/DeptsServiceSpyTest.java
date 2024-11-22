/*
 * Copyright (c) 2020-2030, Shuigedeng (981376577@qq.com & https://blog.taotaocloud.top/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.taotao.cloud.ddd.integration;

import com.taotao.boot.test.TtcBootTestBase;
import com.taotao.cloud.ddd.application.service.DeptsService;
import com.taotao.cloud.ddd.application.service.DictsService;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
// @ActiveProfiles("test")
// @TestPropertySource({"classpath:application-test.yml"})
// @SpringBootTest(classes = TaoTaoCloudDDDApplication.class, properties =
// "spring.main.allow-bean-definition-overriding=true")
@SpringBootTest
public class DeptsServiceSpyTest extends TtcBootTestBase {

    @MockitoBean
    private DeptsService deptsService;

    @MockitoSpyBean
    private DictsService dictsService;

    @Test
    @DisplayName("SpyBean的正确打桩姿势")
    public void testMock() {
        //		Mockito.when(demoService.listDemos(1L)).thenReturn(null);
        //
        //		//当传参是20L时，真实调用
        //		Mockito.when(demoService.listDemos(2L)).thenCallRealMethod();
        //
        //		//当传参是30L时，抛出异常
        //		Mockito.when(demoService.listDemos(3L)).thenThrow(new Exception("test error"));

    }

    @Test
    public void testSpy() {
        // 调用真实方法
        //		Assert.assertEquals(demoRepository.hasReturnAndArgs("20"), "10");
        //		Mockito.doReturn("30").when(demoRepository).hasReturnAndArgs(Mockito.anyString());
        //		Assert.assertEquals(demoRepository.hasReturnAndArgs("20"), "30");
        //		Mockito.verify(demoRepository, times(1)).hasReturnAndArgs(Mockito.anyString());
        //		Assert.assertEquals(demoRepository.hasReturnAndArgs("20"), "30");
    }

    @Test
    public void testMvc() throws Exception {
        // perform,执行一个RequestBuilders请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
        //		mockMvc.perform(MockMvcRequestBuilders
        //				// 模拟发个post请求
        //				.post("/mockit/getUser")
        //				// 接受参数
        //				.accept(MediaType.APPLICATION_JSON)
        //				// 请求类型
        //				.contentType(MediaType.APPLICATION_JSON)
        //				// 填充内容
        //				.content("json")
        //			// 期待的结果状态值 200
        //			.andExpect(status().isOk())
        //			// 添加ResultHandler结果处理器，比如调试时 打印结果(print方法)到控制台
        //			.andDo(MockMvcResultHandlers.print());

        final String result = mockMvc.perform(
                        MockMvcRequestBuilders.get("/echo/").param("name", "看山"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn()
                .getResponse()
                .getContentAsString(StandardCharsets.UTF_8);

        Assertions.assertEquals("Hello, 看山", result);
    }

}
