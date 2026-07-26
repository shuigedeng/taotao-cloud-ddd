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

package com.taotao.cloud.ddd.api.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.StringUtils;

@Schema(title = "scheduled定时任务")
public class ScheduledJobDTO {

    // 任务id
    @Schema(description = "主键 创建时不传，更新时传", example = "1")
    private String id;

    // 任务名
    @Schema(description = "任务名", example = "1")
    private String name;

    /*
    目标字符串
    格式bean.method(params)
    String字符串类型，包含'、boolean布尔类型，等于true或者false
    long长整形，包含L、double浮点类型，包含D、其他类型归类为整形
    */
    @Schema(description = "目标字符串", example = "demoJob.handleMessage('aaa', true, 500L, 1.23D)")
    private String invokeTarget;

    // 周期(month、week、day、hour、minute、secods)
    @Schema(description = "周期(month、week、day、hour、minute、secods)", example = "month")
    private String cycle;

    // 执行策略(1手动，2-自动）
    @Schema(description = "执行策略(1手动，2-自动）", example = "1")
    private Integer policy;

    @Schema(description = "周", example = "1")
    private String week;

    @Schema(description = "月", example = "1")
    private String month;

    @Schema(description = "天", example = "1")
    private String day;

    @Schema(description = "销售", example = "1")
    private String hour;

    @Schema(description = "分钟", example = "1")
    private String minute;

    @Schema(description = "秒", example = "1")
    private String secods;

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id id
     * @return 无返回值
     * @since 2022.03
     */

    public void setId(String id) {
        this.id = id;
    }

    // 备注
    private String remark;

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getRemark() {
        return remark;
    }

    /**
     * 设置
     *
     * @param remark remark
     * @return 无返回值
     * @since 2022.03
     */

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name name
     * @return 无返回值
     * @since 2022.03
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getInvokeTarget() {
        return invokeTarget;
    }

    /**
     * 设置
     *
     * @param invokeTarget invokeTarget
     * @return 无返回值
     * @since 2022.03
     */

    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getCycle() {
        return cycle;
    }

    /**
     * 设置
     *
     * @param cycle cycle
     * @return 无返回值
     * @since 2022.03
     */

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    /**
     * 获取
     *
     * @return 结果数量
     * @since 2022.03
     */

    public Integer getPolicy() {
        return policy;
    }

    /**
     * 设置
     *
     * @param policy policy
     * @return 无返回值
     * @since 2022.03
     */

    public void setPolicy(Integer policy) {
        this.policy = policy;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getWeek() {
        return week;
    }

    /**
     * 设置
     *
     * @param week week
     * @return 无返回值
     * @since 2022.03
     */

    public void setWeek(String week) {
        this.week = week;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getMonth() {
        return month;
    }

    /**
     * 设置
     *
     * @param month month
     * @return 无返回值
     * @since 2022.03
     */

    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getDay() {
        return day;
    }

    /**
     * 设置
     *
     * @param day day
     * @return 无返回值
     * @since 2022.03
     */

    public void setDay(String day) {
        this.day = day;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getHour() {
        return hour;
    }

    /**
     * 设置
     *
     * @param hour hour
     * @return 无返回值
     * @since 2022.03
     */

    public void setHour(String hour) {
        this.hour = hour;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getMinute() {
        return minute;
    }

    /**
     * 设置
     *
     * @param minute minute
     * @return 无返回值
     * @since 2022.03
     */

    public void setMinute(String minute) {
        this.minute = StringUtils.isBlank(minute) ? "0" : minute;
    }

    /**
     * 获取
     *
     * @return 字符串
     * @since 2022.03
     */

    public String getSecods() {
        return secods;
    }

    /**
     * 设置
     *
     * @param secods secods
     * @return 无返回值
     * @since 2022.03
     */

    public void setSecods(String secods) {
        this.secods = StringUtils.isBlank(secods) ? "0" : secods;
    }
}
