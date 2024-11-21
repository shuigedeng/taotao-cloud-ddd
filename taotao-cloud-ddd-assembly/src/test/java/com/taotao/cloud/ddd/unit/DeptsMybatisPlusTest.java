package com.taotao.cloud.ddd.unit;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Assertions;

import com.taotao.cloud.ddd.infrastructure.persistent.dept.mapper.DeptMapper;
import java.sql.Connection;
import java.util.List;
import java.util.Set;
import javax.sql.DataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.TestPropertySource;

@MybatisPlusTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
	"spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver",
	"spring.datasource.url=jdbc:mysql://127.0.0.1:3306/taotao-cloud-goods?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false&rewriteBatchedStatements=true&zeroDateTimeBehavior=convertToNull&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&allowMultiQueries=true&autoReconnect=true&useCursorFetch=true",
	"spring.datasource.username=root",
	"spring.datasource.password=123456",
})
//@TestPropertySource(locations = "classpath:application-dev.yml")
class DeptsMybatisPlusTest {
	static {
		System.setProperty("spring.profiles.active", "dev");
	}
	@Autowired
	private DeptMapper deptMapper;

	//@BeforeAll
	//static void setupClass(@Autowired DataSource dataSource) throws Exception {
	//	try (Connection conn = dataSource.getConnection()) {
	//		ScriptUtils.executeSqlScript(conn, new ClassPathResource("/sql/test_schema.sql"));
	//		ScriptUtils.executeSqlScript(conn, new ClassPathResource("/sql/test_data.sql"));
	//	}
	//}

	@Test
	void testSelectIdsByRoleId() {
		List<Long> permissions = deptMapper.selectIdsByRoleId(1L);
		Assertions.assertEquals(4,permissions.size(), "");
	}

//	@Test
//	void testSelectPermissionCodesByUser_emptyPkOrg() {
//		Set<String> permissions = mapper.selectPermissionCodesByUser("wangfei012", 1, 1, "");
//		assertThat(permissions).hasSize(3);
//	}
//
//	@Test
//	void testSelectPermissionCodesByUser_invalidUser() {
//		Set<String> permissions = mapper.selectPermissionCodesByUser("nobody", 1, 1,
//			"0001A410000000A3I0V2");
//		assertThat(permissions).hasSize(0);
//	}
}
