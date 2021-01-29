package com.eloancn.bt.entity;

import  java.math.BigDecimal;
/**
 * Tender实体
 * 
 * @author 系统生成
 *
 */
public class Tender  {

	private static final long serialVersionUID = 1L;

	/**
	 * 表名
	 */
	public static final String tableName = "d_tender";
	/**
     * 主键
     */
	private Integer id;
	/**
     * 编号(流水号)
     */
	private BigDecimal serialnumber;
	/**
     * 标的标题
     */
	private String title;
	/**
     * 总金额
     */
	private BigDecimal amount;
	/**
     * 年利率  annual interest rate
     */
	private BigDecimal interestrate;
	/**
     * 实际年利率,在mode为竞标模式时与interestrate不同
     */
	private BigDecimal realinterestrate;
	/**
     * 有效期限 7天或14天
     */
	private BigDecimal timelimit;
	/**
     * 借款分期 2-12期
     */
	private BigDecimal phases;
	/**
     * 还款方式 1等额本金 2等额本息 3还本付息
     */
	private BigDecimal repaymenttype;
	/**
     * 借款用途
     */
	private BigDecimal usetype;
	/**
     * 标的模式 竟标模式、大额模式
     */
	private BigDecimal mode;
	/**
     * 
     */
	private BigDecimal type;
	/**
     * 详细说明
     */
	private String detaildescription;
	/**
     * 标状态 0: 尚未发布 1: 进行中   2:成功   3:审核不通过-流标    4:已撤回    5:锁定 6:待审 7:已还清
     */
	private BigDecimal status;
	/**
     * 发标人ID
     */
	private Integer ownerid;
	/**
     * 创建时间
     */
	private BigDecimal cdate;
	/**
     * 发布时间
     */
	private BigDecimal publisheddate;
	/**
     * 结束时间
     */
	private BigDecimal enddate;
	/**
     * 竞标金额  使用云币
     */
	private BigDecimal bidding;
	/**
     * 标的完成进度
     */
	private BigDecimal progress;
	/**
     * 点击次数
     */
	private Integer hits;
	/**
     * 结标方式  0：正常结标，  1：申请结标
     */
	private BigDecimal endway;
	/**
     * 受理时间
     */
	private BigDecimal accepttime;
	/**
     * 原因
     */
	private String reason;
	/**
     * 区域ID
     */
	private Integer areaid;
	/**
     * 标的显示顺序
     */
	private Integer showsequence;
	/**
     * 
     */
	private Integer reuserdata;
	/**
     * 
     */
	private BigDecimal reuserdatatime;
	/**
     * 
     */
	private BigDecimal backtime;
	/**
     * 
     */
	private Integer version;
	/**
     * 用户借款成功次数
     */
	private Integer jiekuanacount;
	/**
     * 
     */
	private Integer wmpstype;
	/**
     * 尽调状态   0未尽调 1已尽调
     */
	private Integer istune;
	/**
     * 原始标id
     */
	private Integer originalid;
	/**
     * 确认借贷时间
     */
	private Integer confirmtime;
	/**
     * 省code
     */
	private String provinceCode;
	/**
     * 市code
     */
	private String cityCode;
	/**
     * 县code
     */
	private String countyCode;
	/**
     * 0-默认 1-新业务 2-不是新业务
     */
	private Integer isnew;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(BigDecimal serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getInterestrate() {
		return interestrate;
	}
	public void setInterestrate(BigDecimal interestrate) {
		this.interestrate = interestrate;
	}
	public BigDecimal getRealinterestrate() {
		return realinterestrate;
	}
	public void setRealinterestrate(BigDecimal realinterestrate) {
		this.realinterestrate = realinterestrate;
	}
	public BigDecimal getTimelimit() {
		return timelimit;
	}
	public void setTimelimit(BigDecimal timelimit) {
		this.timelimit = timelimit;
	}
	public BigDecimal getPhases() {
		return phases;
	}
	public void setPhases(BigDecimal phases) {
		this.phases = phases;
	}
	public BigDecimal getRepaymenttype() {
		return repaymenttype;
	}
	public void setRepaymenttype(BigDecimal repaymenttype) {
		this.repaymenttype = repaymenttype;
	}
	public BigDecimal getUsetype() {
		return usetype;
	}
	public void setUsetype(BigDecimal usetype) {
		this.usetype = usetype;
	}
	public BigDecimal getMode() {
		return mode;
	}
	public void setMode(BigDecimal mode) {
		this.mode = mode;
	}
	public BigDecimal getType() {
		return type;
	}
	public void setType(BigDecimal type) {
		this.type = type;
	}
	public String getDetaildescription() {
		return detaildescription;
	}
	public void setDetaildescription(String detaildescription) {
		this.detaildescription = detaildescription;
	}
	public BigDecimal getStatus() {
		return status;
	}
	public void setStatus(BigDecimal status) {
		this.status = status;
	}
	public Integer getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(Integer ownerid) {
		this.ownerid = ownerid;
	}
	public BigDecimal getCdate() {
		return cdate;
	}
	public void setCdate(BigDecimal cdate) {
		this.cdate = cdate;
	}
	public BigDecimal getPublisheddate() {
		return publisheddate;
	}
	public void setPublisheddate(BigDecimal publisheddate) {
		this.publisheddate = publisheddate;
	}
	public BigDecimal getEnddate() {
		return enddate;
	}
	public void setEnddate(BigDecimal enddate) {
		this.enddate = enddate;
	}
	public BigDecimal getBidding() {
		return bidding;
	}
	public void setBidding(BigDecimal bidding) {
		this.bidding = bidding;
	}
	public BigDecimal getProgress() {
		return progress;
	}
	public void setProgress(BigDecimal progress) {
		this.progress = progress;
	}
	public Integer getHits() {
		return hits;
	}
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	public BigDecimal getEndway() {
		return endway;
	}
	public void setEndway(BigDecimal endway) {
		this.endway = endway;
	}
	public BigDecimal getAccepttime() {
		return accepttime;
	}
	public void setAccepttime(BigDecimal accepttime) {
		this.accepttime = accepttime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Integer getAreaid() {
		return areaid;
	}
	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}
	public Integer getShowsequence() {
		return showsequence;
	}
	public void setShowsequence(Integer showsequence) {
		this.showsequence = showsequence;
	}
	public Integer getReuserdata() {
		return reuserdata;
	}
	public void setReuserdata(Integer reuserdata) {
		this.reuserdata = reuserdata;
	}
	public BigDecimal getReuserdatatime() {
		return reuserdatatime;
	}
	public void setReuserdatatime(BigDecimal reuserdatatime) {
		this.reuserdatatime = reuserdatatime;
	}
	public BigDecimal getBacktime() {
		return backtime;
	}
	public void setBacktime(BigDecimal backtime) {
		this.backtime = backtime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Integer getJiekuanacount() {
		return jiekuanacount;
	}
	public void setJiekuanacount(Integer jiekuanacount) {
		this.jiekuanacount = jiekuanacount;
	}
	public Integer getWmpstype() {
		return wmpstype;
	}
	public void setWmpstype(Integer wmpstype) {
		this.wmpstype = wmpstype;
	}
	public Integer getIstune() {
		return istune;
	}
	public void setIstune(Integer istune) {
		this.istune = istune;
	}
	public Integer getOriginalid() {
		return originalid;
	}
	public void setOriginalid(Integer originalid) {
		this.originalid = originalid;
	}
	public Integer getConfirmtime() {
		return confirmtime;
	}
	public void setConfirmtime(Integer confirmtime) {
		this.confirmtime = confirmtime;
	}
	public String getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getCountyCode() {
		return countyCode;
	}
	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}
	public Integer getIsnew() {
		return isnew;
	}
	public void setIsnew(Integer isnew) {
		this.isnew = isnew;
	}
}
