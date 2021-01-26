package ${packagePath};

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eloancn.destress.common.exception.BusinessException;
import com.eloancn.destress.common.utils.common.Pagination;
import com.eloancn.destress.common.utils.common.BeanUtils;
import com.eloancn.destress.common.param.Param;
import com.eloancn.destress.common.param.ParamBuilder;
import com.google.common.collect.Maps;
import com.eloancn.destress.dao.sql.CustomSQL;
<#list importList as str>
import ${str};
</#list>
/**
 * 业务层实现类接口
 * @ClassName:  ${poName}ServiceImpl   
 * @Description:TODO 
 * @author: 系统自动生成     
 *
 */
@Service
public class ${poName}ServiceImpl extends BaseServiceImpl<${poName}> implements ${poName}Service {
	@Override
	public ${poName} query${poName}ById(int id) throws BusinessException {
		return factory.getDefaultDataSession().querySingleResultById(${poName}.class, id);
	}
	
	@Override
	public Pagination<${poName}> query${poName}PageList(Map<String, Object> param, int pageNo, int pageSize) throws BusinessException {

		Param builder = ParamBuilder.getInstance().getParam();
		builder.add(param);
		Pagination<${poName}> pageResult = queryPagination(${poName}.class, builder, pageNo, pageSize);
		return pageResult;
	}

	@Override
	@Transactional
	public ${poName} save${poName}(Map<String, Object> dataMap) throws BusinessException {

		${poName}  ${firstLowerPoName} = BeanUtils.transMap2BasePO(dataMap, ${poName}.class);
		${firstLowerPoName} = factory.getDefaultDataSession().save(${poName}.class, ${firstLowerPoName});
		return ${firstLowerPoName};
	}

	@Override
	@Transactional
	public ${poName} update${poName}(Map<String, Object> dataMap) throws BusinessException {
		if(dataMap.containsKey(${poName}.FIELD_UUID) && dataMap.get(${poName}.FIELD_UUID) != null){
			${poName} old${poName} = query${poName}ById(Integer.parseInt(String.valueOf(dataMap.get(${poName}.FIELD_ID))));
			if(old${poName} != null && old${poName}.getId() > 0){
				dataMap.put(${poName}.FIELD_ID, old${poName}.getId());
				${poName}  ${firstLowerPoName} = BeanUtils.transMap2BasePO(dataMap, old${poName});
				factory.getDefaultDataSession().update(${poName}.class, ${firstLowerPoName});
				return ${firstLowerPoName};
			}else{
				throw new BusinessException("ResultConstants.FormExceptionInfo.UUID_NULLITY");
			}
		}else{
			throw new BusinessException("ResultConstants.FormExceptionInfo.UUID_NOT_NULL");
		}
	}

	@Override
	public List<${poName}> queryListResultByWhere(CustomSQL whereSqlStr) {

		return factory.getReadDataSession().queryListResultByWhere(${poName}.class, whereSqlStr);
	}

	@Override
	public List<${poName}> queryListResultByWhere(String whereSqlStr) {

		Map<String, Object> param = Maps.newHashMap();
		param.put("whereSqlStr", whereSqlStr);
		Param builder = ParamBuilder.getInstance().getParam();
		builder.add(param);
		return factory.getReadDataSession().queryVOList(${poName}.class, new Throwable(), builder);
	}
	
	@Override
	public long queryListResultCountByWhere(CustomSQL whereSqlStr) {

		return factory.getReadDataSession().queryListResultCountByWhere(${poName}.class, whereSqlStr);
	}
	
}
