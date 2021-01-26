<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${daoClassPath}">
	<sql id="baseColumnList">
		<#list columnList as obj>
			u.${obj.dbName} as ${obj.name} <#if obj_has_next>,</#if>
		</#list>
	</sql>
	<sql id="searchCriteria">
		<#list columnList as obj>
		<if test="${obj.name} != null">
			and u.${obj.dbName} = #{${obj.name},jdbcType=${obj.sqlMapColumnType}}
		</if>
		<#if obj.type == "String">
		<if test="${obj.name}Like != null">
			and u.${obj.dbName} like CONCAT('%',#{${obj.name}Like,jdbcType=${obj.sqlMapColumnType}},'%') 
		</if>
		</#if>
		</#list>
	</sql>

	<!-- 查询列表数据 -->
	<select id="queryListResult" parameterType="java.util.Map" resultType="${entityClassPath}">
		select
			<include refid="baseColumnList" />
		from
			${tableName} u
		where
			1=1
			<include refid="searchCriteria" />
			<if test="orderBy != null">
                 order by %%{orderBy}
            </if>
			<if test="pageNo != null and pageSize != null">
            	limit %%{(pageNo - 1) * pageSize}, %%{pageSize}
            </if>
	</select>
	<!-- 查询列表数据数量 -->
	<select id="queryListResultCount" parameterType="java.util.Map" resultType="java.lang.Integer">
		select
			count(u.id)
		from
			${tableName} u
		where
			1=1
		<include refid="searchCriteria" />
	</select>
	<!-- 自定义where条件查询列表 -->
	<select id="queryListResultByWhere" parameterType="java.util.Map" statementType="STATEMENT" resultType="${entityClassPath}">
		select
			<include refid="baseColumnList" />
		from
			${tableName} u
		where
		    %%{whereSqlStr}
			<if test="orderBy != null">
                 order by %%{orderBy}
            </if>
            <if test="pageNo != null and pageSize != null">
                limit %%{(pageNo - 1) * pageSize}, %%{pageSize}
            </if>
	</select>
	<!-- 自定义where条件查询列表数量 -->
	<select id="queryListResultCountByWhere" parameterType="java.util.Map" statementType="STATEMENT" resultType="java.lang.Integer">
		select
			count(u.id)
		from
			${tableName} u
		where
		    %%{whereSqlStr}

	</select>
	
	<!-- 查询一条数据 -->
	<select id="querySingleResultById" parameterType="java.lang.Integer" resultType="${entityClassPath}">
		select
			<include refid="baseColumnList" />
		from
			${tableName} u
		where
			1=1
			and u.ID = #{id,jdbcType=NUMERIC}
	</select>

   <!-- 保存 -->
	<insert id="save" parameterType="${entityClassPath}" useGeneratedKeys="true" keyProperty="id">
		insert into ${tableName}(
	<#list columnList as obj>
		<#if obj.name != "id">
			${obj.dbName}<#if obj_has_next>,</#if>
		</#if>
	</#list>
		)values(
	<#list columnList as obj>
		<#if obj.name != "id">
			#{${obj.name},jdbcType=${obj.sqlMapColumnType}}<#if obj_has_next>,</#if>
		</#if>
	</#list>
		)
	</insert>
	<!-- 批量保存 -->
	<insert id="saveBatch" parameterType="ArrayList">
		insert into ${tableName}(
	<#list columnList as obj>
		<#if obj.name != "id">
			${obj.dbName}<#if obj_has_next>,</#if>
		</#if>
	</#list>
		)values
		<foreach collection="list" item="obj" separator=",">
		(
	<#list columnList as obj>
		<#if obj.name != "id">
			#{obj.${obj.name},jdbcType=${obj.sqlMapColumnType}}<#if obj_has_next>,</#if>
		</#if>
	</#list>
		)
		</foreach>
	</insert>

	<!-- 修改 -->
	<update id="update" parameterType="${entityClassPath}">
		update ${tableName} u
		<set>
			u.id = u.id 
			<#list columnList as obj>
				 <#if obj.name != "id" && obj.name != 'createUser' && obj.name != 'createTime' >
			<if test="${obj.name} != null">
				,u.${obj.dbName}=#{${obj.name},jdbcType=${obj.sqlMapColumnType}} 
			</if>
            	</#if>
			</#list>
		</set>
		where
            u.ID = #{id,jdbcType=NUMERIC}
            
	</update>

	<!-- 物理删除 -->
	<delete id="delete" parameterType="java.lang.Integer">
		delete from ${tableName} where id=#{id,jdbcType=INTEGER}
	</delete>
	
	
</mapper>