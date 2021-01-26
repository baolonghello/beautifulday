package ${entityPackagePath};

<#list importList as importStr>
	<#if importStr?? >
import ${importStr};
	</#if>
</#list>
/**
 * ${poName}实体
 * 
 * @author 系统生成
 *
 */
public class ${poName}  {

	private static final long serialVersionUID = 1L;

	/**
	 * 表名
	 */
	public static final String tableName = "${tableName}";
<#list poColumnList as obj>
	/**
     * ${obj.remarks}
     */
	private ${obj.type} ${obj.name};
</#list>
	
<#list poColumnList as obj>
	public ${obj.type} get${obj.firstUpperName}() {
		return ${obj.name};
	}
	public void set${obj.firstUpperName}(${obj.type} ${obj.name}) {
		this.${obj.name} = ${obj.name};
	}
</#list>
}
