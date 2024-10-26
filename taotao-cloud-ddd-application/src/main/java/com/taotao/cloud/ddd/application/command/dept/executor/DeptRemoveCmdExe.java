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

package com.taotao.cloud.ddd.application.command.dept.executor;

import com.taotao.cloud.ddd.application.command.dept.dto.DeptRemoveCmd;
import com.taotao.cloud.ddd.domain.dept.service.DeptDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 删除部门执行器.
 */
@Component
@RequiredArgsConstructor
public class DeptRemoveCmdExe {

    private final DeptDomainService deptDomainService;

    /**
     * 执行删除部门.
     * @param cmd 删除部门参数
     */
    // @DS(TENANT)
    public void executeVoid(DeptRemoveCmd cmd) {
        deptDomainService.remove(cmd.getIds());
    }
}
