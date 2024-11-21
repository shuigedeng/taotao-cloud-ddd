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

package com.taotao.cloud.ddd.application.service.impl;

import com.taotao.cloud.ddd.application.command.dept.dto.DeptCreateCmd;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptGetQry;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptIdsGetQry;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptListQry;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptModifyCmd;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptRemoveCmd;
import com.taotao.cloud.ddd.application.command.dept.dto.clientobject.DeptCO;
import com.taotao.cloud.ddd.application.command.dept.executor.DeptCreateCmdExe;
import com.taotao.cloud.ddd.application.command.dept.executor.DeptModifyCmdExe;
import com.taotao.cloud.ddd.application.command.dept.executor.DeptRemoveCmdExe;
import com.taotao.cloud.ddd.application.command.dept.executor.query.DeptGetQryExe;
import com.taotao.cloud.ddd.application.command.dept.executor.query.DeptIdsGetQryExe;
import com.taotao.cloud.ddd.application.command.dept.executor.query.DeptListQryExe;
import com.taotao.cloud.ddd.application.service.DeptsService;
import com.taotao.cloud.ddd.domain.dept.entity.DeptEntity;
import com.taotao.cloud.ddd.domain.dept.repository.DeptDomainRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 部门管理.
 */
@Service
@RequiredArgsConstructor
public class DeptsServiceImpl implements DeptsService {

    private final DeptListQryExe deptListQryExe;

    private final DeptCreateCmdExe deptCreateCmdExe;

    private final DeptModifyCmdExe deptModifyCmdExe;

    private final DeptRemoveCmdExe deptRemoveCmdExe;

    private final DeptGetQryExe deptGetQryExe;

    private final DeptIdsGetQryExe deptIDSGetQryExe;

	private final DeptDomainRepository deptDomainRepository;

    /**
     * 查询部门列表.
     *
     * @param qry 查询部门列表参数
     * @return 部门列表
     */
    @Override
    public List<DeptCO> findList(DeptListQry qry) {
        return deptListQryExe.execute(qry);
    }

    /**
     * 新增部门.
     *
     * @param cmd 新增部门参数
     */
    @Override
    public void create(DeptCreateCmd cmd) {
        deptCreateCmdExe.executeVoid(cmd);
    }

    /**
     * 修改部门.
     *
     * @param cmd 修改部门参数
     */
    @Override
    public void modify(DeptModifyCmd cmd) {
        deptModifyCmdExe.executeVoid(cmd);
    }

    /**
     * 根据ID删除部门.
     *
     * @param cmd 根据ID删除部门参数
     */
    @Override
    public void remove(DeptRemoveCmd cmd) {
        deptRemoveCmdExe.executeVoid(cmd);
    }

    /**
     * 根据ID查看部门.
     *
     * @param qry 根据ID查看部门参数
     * @return 部门
     */
    @Override
    public DeptCO findById(DeptGetQry qry) {
        return deptGetQryExe.execute(qry);
    }

    /**
     * 根据角色ID查看部门IDS.
     *
     * @param qry 根据角色ID查看部门IDS参数
     * @return 部门IDS
     */
    @Override
    public List<Long> findIds(DeptIdsGetQry qry) {
        return deptIDSGetQryExe.execute(qry);
    }

	@Override
	public List<DeptEntity> findAll() {
		return deptDomainRepository.findAll();
	}
}
