package ${packagePath};
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.eloancn.nback.common.contant.Constants;
import com.eloancn.nback.common.result.Result;
import com.eloancn.nback.common.utils.JSONUtils;
import com.eloancn.nback.web.controller.base.BaseController;
<#list importList as str>
import ${str};
</#list>
/**
 * ${poName}Controller 控制层
 * @author 系统自动生成
 *
 */
@Controller
@Scope(value="prototype")
@RequestMapping(value="/${tablePrefix}/${tableMiddle}")

public class ${poName}Controller extends BaseController {
   
   @Autowired
   private ${poName}Service ${firstLowerPoName}Service;
   
   /**
    * 跳转到查询页面
    * @param request
    * @param response
    * @param model
    * @return
    * String
    *
    */
   @RequestMapping(value="/query${poName}Page.html", method = { RequestMethod.POST,RequestMethod.GET })
   public ModelAndView query${poName}Page(HttpServletRequest request,HttpServletResponse response,ModelMap model)  { 
	   ModelAndView mv = new ModelAndView("sys/${firstLowerPoName}List");
	   return mv;
   }
   
   /**
    * 用户查询列表
    * @param request
    * @param response
    * @param username
    * @param pageNo
    * @throws IOException
    * void
    *
    */
    @RequestMapping(value="/query${poName}List.html", method = { RequestMethod.POST,RequestMethod.GET })
	public void query${poName}List(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Map<String, Object> param = getRequestNotContainEmptyParams(request);
		String jsonResult = ${firstLowerPoName}Service.query${poName}PageResultList(param, pageNo, length);
		Result result = JSONUtils.fromJson(jsonResult, Result.class);
		String resultStr = JSONUtils.toJson(result);
		if(result.getCode() == Constants.ApiCall.API_CALL_SUCCESS){
			resultStr = JSONUtils.toJson(result.getResult());
		}
		printWriter(response, resultStr);
	}
   
   /**
    * 新增数据
    * @param request
    * @param response
    * @param username
    * @param pageNo
    * @throws IOException
    */
    @RequestMapping("/save${poName}.html")
	public void save${poName}(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Map<String, Object> param = getRequestNotContainEmptyParams(request);
		String resultStr = ${firstLowerPoName}Service.save${poName}(param);
		printWriter(response, resultStr);
	}
   
    /**
     * 更新数据
     * @param request
     * @param response
     * @param username
     * @param pageNo
     * @throws IOException
     * void
     *
     */
    @RequestMapping("/update${poName}Page.html")
    public void update${poName}Page(HttpServletRequest request,HttpServletResponse response) throws IOException {
    	String uuid = request.getParameter("uuid");
    	String resultStr = ${firstLowerPoName}Service.query${poName}ByUUID(uuid);
    	printWriter(response, resultStr);
    }
   /**
    * 更新数据
    * @param request
    * @param response
    * @param username
    * @param pageNo
    * @throws IOException
    * void
    *
    */
   @RequestMapping("/update${poName}.html")
   public void update${poName}(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    Map<String, Object> param = getRequestParams(request);
		String resultStr = ${firstLowerPoName}Service.update${poName}(param);
		printWriter(response, resultStr);
		
	}
   
   /**
    * 删除数据
    * @param request
    * @param response
    * @param username
    * @param pageNo
    * @throws IOException
    * void
    */
   @RequestMapping("/delete${poName}.html")
	public void delete${poName}(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    String uuid = request.getParameter("uuid");
	    String resultStr = ${firstLowerPoName}Service.logicDeleteByUUID(uuid);
	    printWriter(response, resultStr);
	}
}
