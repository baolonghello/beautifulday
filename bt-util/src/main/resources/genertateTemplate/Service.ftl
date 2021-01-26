package ${servicePackagePath};

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
<#list importList as str>
import ${str};
</#list>
/**
 * 业务层接口
 * @ClassName:  ${poName}Service   
 * @Description:TODO 
 * @author: 系统自动生成     
 *
 */
@Service
public class ${poName}Service {


    @Autowired
    private ${poName}Mapper ${firstLowerPoName}Mapper;

    public ${poName} query${poName}ById(Integer id) {
        return ${firstLowerPoName}Mapper.querySingleResultById(id);
    }

    public List<${poName}> query${poName}List(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        List<${poName}> list = ${firstLowerPoName}Mapper.queryListResult(paramMap);
        return list;
    }

    public Integer query${poName}ListCount(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        return ${firstLowerPoName}Mapper.queryListResultCount(paramMap);
    }

    public List<${poName}> query${poName}ListByWhere(Integer id, Integer pageNo, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        paramMap.put("pageNo", pageNo);
        paramMap.put("pageSize", pageSize);
        return ${firstLowerPoName}Mapper.queryListResultByWhere(paramMap);
    }

    public Integer query${poName}ListCountByWhere(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("whereSqlStr", " id=" + id);
        return ${firstLowerPoName}Mapper.queryListResultCountByWhere(paramMap);
    }

    public Integer save(${poName} ${firstLowerPoName}) {
        return ${firstLowerPoName}Mapper.save(${firstLowerPoName});
    }

    public Integer save${poName}Batch(List<${poName}> ${firstLowerPoName}s) {
        return ${firstLowerPoName}Mapper.saveBatch(${firstLowerPoName}s);
    }

    public Integer update${poName}(Integer id) {
        ${poName} ${firstLowerPoName} = this.query${poName}ById(id);
        return ${firstLowerPoName}Mapper.update(${firstLowerPoName});
    }

    public Integer delete${poName}ById(Integer id) {
        return ${firstLowerPoName}Mapper.delete(id);
    }

}