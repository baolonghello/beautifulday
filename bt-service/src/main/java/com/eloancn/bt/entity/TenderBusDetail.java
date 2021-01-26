package com.eloancn.bt.entity;

import  java.math.BigDecimal;
import  java.util.Date;
/**
 * TenderBusDetail实体
 * 
 * @author 系统生成
 *
 */
public class TenderBusDetail  {

	private static final long serialVersionUID = 1L;

	/**
	 * 表名
	 */
	public static final String tableName = "d_tender_bus_detail";
	/**
     * 
     */
	private Integer id;
	/**
     * 标ID
     */
	private Integer tid;
	/**
     * 懒猫标类型0未推送1募集中2还款中3已结标4流标
     */
	private Integer lazyCatStatus;
	/**
     * 满标时间
     */
	private Integer tenderFullTime;
	/**
     * 懒猫标类型修改时间yyyymmdd
     */
	private Integer lazyStatusChangeTime;
	/**
     * 平台账号
     */
	private String accountNumber;
	/**
     * 账户类型:1投资人2借款人
     */
	private String accountType;
	/**
     * 保险费
     */
	private BigDecimal premiumFee;
	/**
     * 配偶保险费
     */
	private BigDecimal premiumSpouseFee;
	/**
     * 共借人保险费
     */
	private BigDecimal premiumCoborrowerFee;
	/**
     * 投保的共借人数量
     */
	private Integer premiumCoborrowerCount;
	/**
     * 运营商担保费
     */
	private BigDecimal guaranteeAgentFee;
	/**
     * 担保人担保费
     */
	private BigDecimal guaranteeFee;
	/**
     * 征信费
     */
	private BigDecimal creditReferenceFee;
	/**
     * 风险保证金
     */
	private BigDecimal riskMarginFee;
	/**
     * C+保险费
     */
	private BigDecimal premiumCplusFee;
	/**
     * C+理财基金
     */
	private BigDecimal savingsCplusFee;
	/**
     * 平均月收入
     */
	private BigDecimal avgIncome;
	/**
     * 家庭资产
     */
	private String familyAssets;
	/**
     * 借款用途
     */
	private String loanUsage;
	/**
     * 
     */
	private String raymentSource;
	/**
     * 是否存管存量标:1存量标 2新标
     */
	private Integer isStock;
	/**
     * 版本号
     */
	private Integer version;
	/**
     * 服务费
     */
	private BigDecimal serviceFee;
	/**
     * 线下服务费
     */
	private BigDecimal offlineServiceFee;
	/**
     * 多次贷信息（非业务标签）字段
     */
	private Integer moreTenderDiplayInfo;
	/**
     * 多次贷贷种标记
     */
	private Integer moreTenderType;
	/**
     * 创建时间
     */
	private Date createTime;
	/**
     * 最后更新时间
     */
	private Date updateTime;
	/**
     * 确认借贷来源:1PC前台 2APP
     */
	private Integer loanSource;
	/**
     * 一次还清标记 0否 1是
     */
	private Integer onceRepaymentSign;
	/**
     * 是否还旧标示 -1-缺省（默认）  0-否 1-是 
     */
	private Integer isRepayOld;
	/**
     * 1- 一次贷转多次贷  2-多次贷转一次贷
     */
	private Integer conversionType;
	/**
     * 备注
     */
	private String remark;
	/**
     * 付款委托验秘流水号
     */
	private String agentSerilanumber;
	/**
     * 付款委托类型 0-非付款委托 1-老通道付款委托 2-新通道付款委托
     */
	private Integer agentType;
	/**
     * 借贷标的核销类型. 0:不涉及,1:账销案存,2:账销案销
     */
	private Integer chargeoffType;
	/**
     * 本金压缩率
     */
	private BigDecimal principalCompressRate;
	/**
     * 显示利率
     */
	private BigDecimal interestRateDisplay;
	/**
     * IRR
     */
	private BigDecimal irrRate;
	/**
     * 确认借贷方式;1.普通;2.刷脸;3.人工审核
     */
	private Integer confirmType;
	/**
     * 确认借贷人工审核入表时间
     */
	private Date confirmCheckTime;
	/**
     * 确认借贷审核状态;1.不审核;2.待审核;3.审核通过;4.审核不通过;
     */
	private Integer confirmCheckStatus;
	/**
     * 附加服务费
     */
	private BigDecimal extraServiceFee;
	/**
     * 确认借款位置,1:后置;3:前置
     */
	private Integer confirmCheckPosition;
	/**
     * 企业或个转企四要素校验状态 1-成功 2-失败
     */
	private String enterpriseVerificationStatus;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getLazyCatStatus() {
		return lazyCatStatus;
	}
	public void setLazyCatStatus(Integer lazyCatStatus) {
		this.lazyCatStatus = lazyCatStatus;
	}
	public Integer getTenderFullTime() {
		return tenderFullTime;
	}
	public void setTenderFullTime(Integer tenderFullTime) {
		this.tenderFullTime = tenderFullTime;
	}
	public Integer getLazyStatusChangeTime() {
		return lazyStatusChangeTime;
	}
	public void setLazyStatusChangeTime(Integer lazyStatusChangeTime) {
		this.lazyStatusChangeTime = lazyStatusChangeTime;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public BigDecimal getPremiumFee() {
		return premiumFee;
	}
	public void setPremiumFee(BigDecimal premiumFee) {
		this.premiumFee = premiumFee;
	}
	public BigDecimal getPremiumSpouseFee() {
		return premiumSpouseFee;
	}
	public void setPremiumSpouseFee(BigDecimal premiumSpouseFee) {
		this.premiumSpouseFee = premiumSpouseFee;
	}
	public BigDecimal getPremiumCoborrowerFee() {
		return premiumCoborrowerFee;
	}
	public void setPremiumCoborrowerFee(BigDecimal premiumCoborrowerFee) {
		this.premiumCoborrowerFee = premiumCoborrowerFee;
	}
	public Integer getPremiumCoborrowerCount() {
		return premiumCoborrowerCount;
	}
	public void setPremiumCoborrowerCount(Integer premiumCoborrowerCount) {
		this.premiumCoborrowerCount = premiumCoborrowerCount;
	}
	public BigDecimal getGuaranteeAgentFee() {
		return guaranteeAgentFee;
	}
	public void setGuaranteeAgentFee(BigDecimal guaranteeAgentFee) {
		this.guaranteeAgentFee = guaranteeAgentFee;
	}
	public BigDecimal getGuaranteeFee() {
		return guaranteeFee;
	}
	public void setGuaranteeFee(BigDecimal guaranteeFee) {
		this.guaranteeFee = guaranteeFee;
	}
	public BigDecimal getCreditReferenceFee() {
		return creditReferenceFee;
	}
	public void setCreditReferenceFee(BigDecimal creditReferenceFee) {
		this.creditReferenceFee = creditReferenceFee;
	}
	public BigDecimal getRiskMarginFee() {
		return riskMarginFee;
	}
	public void setRiskMarginFee(BigDecimal riskMarginFee) {
		this.riskMarginFee = riskMarginFee;
	}
	public BigDecimal getPremiumCplusFee() {
		return premiumCplusFee;
	}
	public void setPremiumCplusFee(BigDecimal premiumCplusFee) {
		this.premiumCplusFee = premiumCplusFee;
	}
	public BigDecimal getSavingsCplusFee() {
		return savingsCplusFee;
	}
	public void setSavingsCplusFee(BigDecimal savingsCplusFee) {
		this.savingsCplusFee = savingsCplusFee;
	}
	public BigDecimal getAvgIncome() {
		return avgIncome;
	}
	public void setAvgIncome(BigDecimal avgIncome) {
		this.avgIncome = avgIncome;
	}
	public String getFamilyAssets() {
		return familyAssets;
	}
	public void setFamilyAssets(String familyAssets) {
		this.familyAssets = familyAssets;
	}
	public String getLoanUsage() {
		return loanUsage;
	}
	public void setLoanUsage(String loanUsage) {
		this.loanUsage = loanUsage;
	}
	public String getRaymentSource() {
		return raymentSource;
	}
	public void setRaymentSource(String raymentSource) {
		this.raymentSource = raymentSource;
	}
	public Integer getIsStock() {
		return isStock;
	}
	public void setIsStock(Integer isStock) {
		this.isStock = isStock;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public BigDecimal getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}
	public BigDecimal getOfflineServiceFee() {
		return offlineServiceFee;
	}
	public void setOfflineServiceFee(BigDecimal offlineServiceFee) {
		this.offlineServiceFee = offlineServiceFee;
	}
	public Integer getMoreTenderDiplayInfo() {
		return moreTenderDiplayInfo;
	}
	public void setMoreTenderDiplayInfo(Integer moreTenderDiplayInfo) {
		this.moreTenderDiplayInfo = moreTenderDiplayInfo;
	}
	public Integer getMoreTenderType() {
		return moreTenderType;
	}
	public void setMoreTenderType(Integer moreTenderType) {
		this.moreTenderType = moreTenderType;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getLoanSource() {
		return loanSource;
	}
	public void setLoanSource(Integer loanSource) {
		this.loanSource = loanSource;
	}
	public Integer getOnceRepaymentSign() {
		return onceRepaymentSign;
	}
	public void setOnceRepaymentSign(Integer onceRepaymentSign) {
		this.onceRepaymentSign = onceRepaymentSign;
	}
	public Integer getIsRepayOld() {
		return isRepayOld;
	}
	public void setIsRepayOld(Integer isRepayOld) {
		this.isRepayOld = isRepayOld;
	}
	public Integer getConversionType() {
		return conversionType;
	}
	public void setConversionType(Integer conversionType) {
		this.conversionType = conversionType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAgentSerilanumber() {
		return agentSerilanumber;
	}
	public void setAgentSerilanumber(String agentSerilanumber) {
		this.agentSerilanumber = agentSerilanumber;
	}
	public Integer getAgentType() {
		return agentType;
	}
	public void setAgentType(Integer agentType) {
		this.agentType = agentType;
	}
	public Integer getChargeoffType() {
		return chargeoffType;
	}
	public void setChargeoffType(Integer chargeoffType) {
		this.chargeoffType = chargeoffType;
	}
	public BigDecimal getPrincipalCompressRate() {
		return principalCompressRate;
	}
	public void setPrincipalCompressRate(BigDecimal principalCompressRate) {
		this.principalCompressRate = principalCompressRate;
	}
	public BigDecimal getInterestRateDisplay() {
		return interestRateDisplay;
	}
	public void setInterestRateDisplay(BigDecimal interestRateDisplay) {
		this.interestRateDisplay = interestRateDisplay;
	}
	public BigDecimal getIrrRate() {
		return irrRate;
	}
	public void setIrrRate(BigDecimal irrRate) {
		this.irrRate = irrRate;
	}
	public Integer getConfirmType() {
		return confirmType;
	}
	public void setConfirmType(Integer confirmType) {
		this.confirmType = confirmType;
	}
	public Date getConfirmCheckTime() {
		return confirmCheckTime;
	}
	public void setConfirmCheckTime(Date confirmCheckTime) {
		this.confirmCheckTime = confirmCheckTime;
	}
	public Integer getConfirmCheckStatus() {
		return confirmCheckStatus;
	}
	public void setConfirmCheckStatus(Integer confirmCheckStatus) {
		this.confirmCheckStatus = confirmCheckStatus;
	}
	public BigDecimal getExtraServiceFee() {
		return extraServiceFee;
	}
	public void setExtraServiceFee(BigDecimal extraServiceFee) {
		this.extraServiceFee = extraServiceFee;
	}
	public Integer getConfirmCheckPosition() {
		return confirmCheckPosition;
	}
	public void setConfirmCheckPosition(Integer confirmCheckPosition) {
		this.confirmCheckPosition = confirmCheckPosition;
	}
	public String getEnterpriseVerificationStatus() {
		return enterpriseVerificationStatus;
	}
	public void setEnterpriseVerificationStatus(String enterpriseVerificationStatus) {
		this.enterpriseVerificationStatus = enterpriseVerificationStatus;
	}
}
