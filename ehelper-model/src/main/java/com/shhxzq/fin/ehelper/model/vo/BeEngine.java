package com.shhxzq.fin.ehelper.model.vo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "be_engine")
@Data
public class BeEngine implements Serializable {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 引擎ID
     */
    @Column(name = "eng_id")
    private String engId;

    /**
     * 引擎名称
     */
    @Column(name = "eng_nm")
    private String engNm;

    /**
     * 引擎类型
     */
    @Column(name = "eng_st")
    private String engSt;

    /**
     * 引擎关键字
     */
    @Column(name = "eng_ky")
    private String engKy;

    /**
     * 引擎代码
     */
    @Column(name = "eng_co")
    private String engCo;

    /**
     * 实现类
     */
    private String impl;

    /**
     * 自动启动标志，Y-自动启动，N-不自动启动
     */
    @Column(name = "auto_start_flg")
    private String autoStartFlg;

    /**
     * 周期
     */
    @Column(name = "run_interval")
    private Integer runInterval;

    /**
     * 周期类型，DAY-天，HOUR-小时，MINUTE-分钟，SECOND-秒
     */
    @Column(name = "interval_tp")
    private String intervalTp;

    /**
     * 超时
     */
    @Column(name = "time_out")
    private Integer timeOut;

    /**
     * 超时类型，DAY-天，HOUR-小时，MINUTE-分钟，SECOND-秒
     */
    @Column(name = "time_out_tp")
    private String timeOutTp;

    /**
     * 开始时间1
     */
    @Column(name = "str_time_one")
    private String strTimeOne;

    /**
     * 结束时间1
     */
    @Column(name = "end_time_one")
    private String endTimeOne;

    /**
     * 开始时间2
     */
    @Column(name = "str_time_two")
    private String strTimeTwo;

    /**
     * 结束时间2
     */
    @Column(name = "end_time_two")
    private String endTimeTwo;

    /**
     * 开始时间3
     */
    @Column(name = "str_time_three")
    private String strTimeThree;

    /**
     * 结束时间3
     */
    @Column(name = "end_time_three")
    private String endTimeThree;

    /**
     * 创建人
     */
    @Column(name = "c_man")
    private String cMan;

    /**
     * 编辑人
     */
    @Column(name = "e_man")
    private String eMan;

    /**
     * 状态，Y-正常，N-禁用
     */
    private String status;

    /**
     * 是否有效,0:有效，1:无效
     */
    @Column(name = "is_delete")
    private Byte isDelete;

    /**
     * 数据创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 数据更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 查询偏移时间(秒)
     */
    @Column(name = "offset_time")
    private Integer offsetTime;

    private static final long serialVersionUID = 1L;
}