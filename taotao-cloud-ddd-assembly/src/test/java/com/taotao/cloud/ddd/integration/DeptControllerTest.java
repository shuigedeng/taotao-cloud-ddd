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

import com.taotao.cloud.ddd.TaoTaoCloudDDDApplicationTestBase;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class DeptControllerTest extends TaoTaoCloudDDDApplicationTestBase {

	@Test
	public void testGetMethod() throws Exception {
		/**
		 * get请求
		 */
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/example") // 发起GET请求，访问路径为"/example"
			.accept(MediaType.APPLICATION_JSON)// 接受JSON格式的响应
			.param("id", "123") //参数
			.param("first_flag", String.valueOf(true)); //参数

		MvcResult result = MockMvc.perform(requestBuilder)
			.andExpect(MockMvcResultMatchers.status().isOk())  // 验证请求的HTTP状态码为200
			.andExpect(MockMvcResultMatchers.jsonPath("$.message")
				.value("success"))  // 验证响应中的JSON字段"message"的值为"success"
			.andReturn();// 返回MockMvcResult对象

		MockHttpServletResponse response = result.getResponse(); //得到返回值
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE); //设置响应 Content-Type
		System.out.println(response); // 打印

	}
}
