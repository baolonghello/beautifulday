package ${daoPackagePath};


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

<#list importList as str>
import ${str};
</#list>
/**
 * Dao
 * @ClassName:  ${poName}Mapper
 * @Description:TODO 
 * @author: 系统自动生成     
 *
 */
@Mapper
public interface ${poName}Mapper  {

	/**
     * 根据主键查询
     *
     * @param id
     * @return
     */
    ${poName} querySingleResultById(@Param("id") Integer id);

    /**
     * 列表查询
     *
     * @param paramMap
     * @return
     */
    List<${poName}> queryListResult(Map<String, Object> paramMap);

    /**
     * 列表数量查询
     *
     * @param paramMap
     * @return
     */
    Integer queryListResultCount(Map<String, Object> paramMap);

    /**
     * 自定义条件查询
     *
     * @param paramMap
     * @return
     */
    List<${poName}> queryListResultByWhere(Map<String, Object> paramMap);

    /**
     * 自定义条件查询数量
     *
     * @param paramMap
     * @return
     */
    Integer queryListResultCountByWhere(Map<String, Object> paramMap);

    /**
     * 保存
     *
     * @param item
     * @return
     */
    Integer save(${poName} item);

    /**
     * 批量保存
     *
     * @param itemList
     * @return
     */
    Integer saveBatch(List<${poName}> itemList);

    /**
     * 修改
     *
     * @param item
     * @return
     */
    Integer update(${poName} item);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    Integer delete(@Param("id") Integer id);
}
