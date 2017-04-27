package com.shhxzq.fin.ehelper.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author kangyonggan
 * @since 4/27/17
 */
@Data
public class CommonTransDto {

    /**
     * 银行编号
     */
    private String bankNo;

    /**
     * 卡号
     */
    private String accountNo;

    /**
     * 户名
     */
    private String accountName;

    /**
     * 证件号
     */
    private String idNo;

    /**
     * 付款方银行编号
     */
    private String senderBankNo;

    /**
     * 付款方账号
     */
    private String senderAccountNo;

    /**
     * 付款方账户名
     */
    private String senderAccountName;

    /**
     * 付款方证件号
     */
    private String senderIdNo;

    /**
     * 付款方手机号
     */
    private String mobileNo;

    /**
     * 收款方银行编号
     */
    private String receiverBankNo;

    /**
     * 收款方账号
     */
    private String receiverAccountNo;

    /**
     * 收款方账户名
     */
    private String receiverAccountName;

    /**
     * 收款方证件号
     */
    private String receiverIdNo;

    /**
     * 收款通道
     */
    private String routeCode;

    /**
     * 交易金额
     */
    private BigDecimal amount;

}
