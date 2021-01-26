package com.eloancn.bt.entity;

import  java.math.BigDecimal;
/**
 * User实体
 * 
 * @author 系统生成
 *
 */
public class User  {

	private static final long serialVersionUID = 1L;

	/**
	 * 表名
	 */
	public static final String tableName = "d_user";
	/**
     * 
     */
	private Integer id;
	/**
     * 
     */
	private String password;
	/**
     * 
     */
	private String realname;
	/**
     * 
     */
	private String mobile;
	/**
     * 
     */
	private String idcard;
	/**
     * 
     */
	private String email;
	/**
     * 会员角色  1，放款人；  2，贷款人；  3，担保人。不能投资，不能充值
     */
	private Integer role;
	/**
     * 
     */
	private BigDecimal type;
	/**
     * 支付密码
     */
	private String paypassword;
	/**
     * 
     */
	private BigDecimal cdate;
	/**
     * 个人头像
     */
	private String photo;
	/**
     * 列表头像
     */
	private String listphoto;
	/**
     * 
     */
	private String sessionid;
	/**
     * 注册激活码
     */
	private String activecode;
	/**
     * 用户状态
     */
	private Integer status;
	/**
     * 用户注册方式
     */
	private Integer regiesttype;
	/**
     * 用户加密类型
     */
	private Integer encodepasswortype;
	/**
     * 标记引导次数
     */
	private Integer isthreelead;
	/**
     * 
     */
	private String singuser;
	/**
     * 登录加密码
     */
	private String encodechar;
	/**
     * 支付密码加密码
     */
	private String encodepaychar;
	/**
     * 数据同步来源
     */
	private Integer registflag;
	/**
     * 映射新表用户id
     */
	private Integer mapperuid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public BigDecimal getType() {
		return type;
	}
	public void setType(BigDecimal type) {
		this.type = type;
	}
	public String getPaypassword() {
		return paypassword;
	}
	public void setPaypassword(String paypassword) {
		this.paypassword = paypassword;
	}
	public BigDecimal getCdate() {
		return cdate;
	}
	public void setCdate(BigDecimal cdate) {
		this.cdate = cdate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getListphoto() {
		return listphoto;
	}
	public void setListphoto(String listphoto) {
		this.listphoto = listphoto;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getActivecode() {
		return activecode;
	}
	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getRegiesttype() {
		return regiesttype;
	}
	public void setRegiesttype(Integer regiesttype) {
		this.regiesttype = regiesttype;
	}
	public Integer getEncodepasswortype() {
		return encodepasswortype;
	}
	public void setEncodepasswortype(Integer encodepasswortype) {
		this.encodepasswortype = encodepasswortype;
	}
	public Integer getIsthreelead() {
		return isthreelead;
	}
	public void setIsthreelead(Integer isthreelead) {
		this.isthreelead = isthreelead;
	}
	public String getSinguser() {
		return singuser;
	}
	public void setSinguser(String singuser) {
		this.singuser = singuser;
	}
	public String getEncodechar() {
		return encodechar;
	}
	public void setEncodechar(String encodechar) {
		this.encodechar = encodechar;
	}
	public String getEncodepaychar() {
		return encodepaychar;
	}
	public void setEncodepaychar(String encodepaychar) {
		this.encodepaychar = encodepaychar;
	}
	public Integer getRegistflag() {
		return registflag;
	}
	public void setRegistflag(Integer registflag) {
		this.registflag = registflag;
	}
	public Integer getMapperuid() {
		return mapperuid;
	}
	public void setMapperuid(Integer mapperuid) {
		this.mapperuid = mapperuid;
	}
}
