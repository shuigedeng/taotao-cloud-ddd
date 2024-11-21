package com.taotao.cloud.ddd.unit;


import com.taotao.boot.common.utils.log.LogUtils;
import com.taotao.cloud.ddd.application.service.impl.DeptsServiceImpl;
import com.taotao.cloud.ddd.domain.dept.entity.DeptEntity;
import com.taotao.cloud.ddd.domain.dept.repository.DeptDomainRepository;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class DeptsServiceTest {

	@InjectMocks
	private DeptsServiceImpl deptsService;

	@Mock
	private DeptDomainRepository userRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindUsersByName() {
		LogUtils.info("testFindUsersByName");

		// Arrange - 设置测试数据和模拟行为
		DeptEntity deptEntity = new DeptEntity("John Doe", 1L, "john.doe@example.com", 2);
		Mockito.when(userRepository.findAll()).thenReturn(List.of(deptEntity));

		// Act - 调用被测试的方法
		List<DeptEntity> users = deptsService.findAll();

		// Assert - 验证结果和方法调用次数
		Assertions.assertEquals(1, users.size(), "Should return one user");
		Assertions.assertEquals("John Doe", users.get(0).getName());

		Mockito.verify(userRepository, Mockito.times(1)).findAll();
	}
}
