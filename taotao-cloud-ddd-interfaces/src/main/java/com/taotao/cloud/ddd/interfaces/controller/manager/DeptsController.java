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

package com.taotao.cloud.ddd.interfaces.controller.manager;

import com.taotao.boot.common.model.Result;
import com.taotao.boot.webagg.controller.BusinessController;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptCreateCmd;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptGetQry;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptIdsGetQry;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptListQry;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptModifyCmd;
import com.taotao.cloud.ddd.application.command.dept.dto.DeptRemoveCmd;
import com.taotao.cloud.ddd.application.command.dept.dto.clientobject.DeptCO;
import com.taotao.cloud.ddd.application.service.DeptsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "DeptsController", description = "部门管理")
@RequiredArgsConstructor
@RequestMapping("v1/depts")
public class DeptsController extends BusinessController {

    private final DeptsService deptsService;

    @PostMapping("list")
    @Operation(summary = "部门管理", description = "查询菜单列表")
    @PreAuthorize("hasAuthority('depts:list')")
    public Result<List<DeptCO>> findList(@RequestBody DeptListQry qry) {
        return Result.success(deptsService.findList(qry));
    }

    @PostMapping
    @Operation(summary = "部门管理", description = "新增菜单")
    @PreAuthorize("hasAuthority('depts:create')")
    public Result<Boolean> create(@RequestBody DeptCreateCmd cmd) {
        deptsService.create(cmd);
        return Result.success(true);
    }

    @PutMapping
    @Operation(summary = "部门管理", description = "修改菜单")
    @PreAuthorize("hasAuthority('depts:modify')")
    public Result<Boolean> modify(@RequestBody DeptModifyCmd cmd) {
        deptsService.modify(cmd);
        return Result.success(true);
    }

    @GetMapping("{id}")
    @Operation(summary = "部门管理", description = "查看菜单")
    public Result<DeptCO> findById(@PathVariable("id") Long id) {
        return Result.success(deptsService.findById(new DeptGetQry(id)));
    }

    @DeleteMapping
    @Operation(summary = "部门管理", description = "删除菜单")
    @PreAuthorize("hasAuthority('depts:remove')")
    public Result<Boolean> remove(@RequestBody Long[] ids) {
        deptsService.remove(new DeptRemoveCmd(ids));
        return Result.success(true);
    }

    @GetMapping("{roleId}/ids")
    @Operation(summary = "部门管理", description = "部门IDS")
    public Result<List<Long>> findIds(@PathVariable("roleId") Long roleId) {
        return Result.success(deptsService.findIds(new DeptIdsGetQry(roleId)));
    }
}
