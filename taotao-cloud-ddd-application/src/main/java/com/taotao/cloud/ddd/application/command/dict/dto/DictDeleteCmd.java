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

package com.taotao.cloud.ddd.application.command.dict.dto;

import com.taotao.boot.ddd.model.application.CommonCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "DictDeleteCmd", description = "删除字典命令请求")
public class DictDeleteCmd extends CommonCommand {

    @Schema(name = "id", description = "ID")
    private Long id;
}
