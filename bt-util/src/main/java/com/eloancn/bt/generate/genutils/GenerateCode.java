package com.eloancn.bt.generate.genutils;

import com.eloancn.bt.generate.file.FileUtils;
import com.eloancn.bt.generate.freeMarker.FreeMarkerUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenerateCode {


    //
    public static String comDir = "/com/";
    /**
     * 相对于在项目跟路径下文件夹
     */
    public static String TEMPLATE_ROOT = "/src/main/resources/genertateTemplate/";
    /**
     * SQLMAP 模板数据
     */
    public static String TEMPLATE_SQL = "SqlMap.ftl";
    /**
     * po 模板数据
     */
    public static String TEMPLATE_PO = "Entity.ftl";
    /**
     * 业务层 模板数据
     */
    public static String TEMPLATE_DAO = "Dao.ftl";
    /**
     * 业务层实现层  模板数据
     */
    public static String TEMPLATE_SERVICE = "Service.ftl";
    /**
     * sqlMap 生成的文件路径
     */
    public static String SQLMAP_FILE_PATH = "SQLMAP_FILE_PATH";
    /**
     * PO 生成的文件路径
     */
    public static String ENTITY_FILE_PATH = "ENTITY_FILE_PATH";
    /**
     * dao 生成的文件路径
     */
    public static String DAO_FILE_PATH = "DAO_FILE_PATH";
    /**
     * service实现层 生成的文件路径
     */
    public static String SERVICE_FILE_PATH = "SERVICE_FILE_PATH";
    /**
     * Entity 包路径
     */
    public static String ENTITY_PACKAGE_PATH = "ENTITY_PACKAGE_PATH";
    /**
     * DAO 包路径
     */
    public static String DAO_PACKAGE_PATH = "DAO_PACKAGE_PATH";
    /**
     * service 包路径
     */
    public static String SERVICE_PACKAGE_PATH = "SERVICE_PACKAGE_PATH";
    /**
     * Entity 类路径
     */
    public static String ENTITY_CLASS_PATH = "ENTITY_CLASS_PATH";
    /**
     * DAO 类路径
     */
    public static String DAO_CLASS_PATH = "ENTITY_CLASS_PATH";
    /**
     * service 类路径
     */
    public static String SERVICE_CLASS_PATH = "SERVICE_CLASS_PATH";


    public static Map<String, String> filePathMap = new HashMap<String, String>();
    private GenerateTable table;

    public GenerateCode() {

    }

    public GenerateCode(GenerateTable gt, String coommonJavaPath, String coommonSqlPath) {
        this.table = gt;
        initPath(coommonJavaPath, coommonSqlPath);
    }

    /**
     * 初始化文件路径
     *
     * @param
     */
    private void initPath(String coommonJavaPath, String coommonSqlPath) {

        //文件路径
        String sqlMapPathBase = coommonSqlPath;
        String javaPathBase = coommonJavaPath;
        String sqlMapFilePath = (sqlMapPathBase + table.getPoName() + ".xml").replaceAll("//", "/");
        String entityFilePath = (javaPathBase + "/entity/" + table.getPoName() + ".java").replaceAll("//", "/");
        String daoFilePath = (javaPathBase + "/dao/" + table.getPoName() + "Mapper" + ".java").replaceAll("//", "/");
        String serviceFilePath = (javaPathBase + "/service/" + table.getPoName() + "Service" + ".java").replaceAll("//", "/");

        //包路径
        String entityPackagePath = entityFilePath.substring(entityFilePath.indexOf(comDir) + 1, entityFilePath.lastIndexOf("/")).replaceAll("/", ".");
        String daoPackagePath = daoFilePath.substring(daoFilePath.indexOf(comDir) + 1, daoFilePath.lastIndexOf("/")).replaceAll("/", ".");
        String servicePackagePath = serviceFilePath.substring(serviceFilePath.indexOf(comDir) + 1, serviceFilePath.lastIndexOf("/")).replaceAll("/", ".");

        //类路径
        String entityClassPath = entityFilePath.substring(entityFilePath.indexOf(comDir) + 1, entityFilePath.lastIndexOf(".")).replaceAll("/", ".");
        String daoClassPath = daoFilePath.substring(daoFilePath.indexOf(comDir) + 1, daoFilePath.lastIndexOf(".")).replaceAll("/", ".");
        String serviceClassPath = serviceFilePath.substring(serviceFilePath.indexOf(comDir) + 1, serviceFilePath.lastIndexOf(".")).replaceAll("/", ".");

        filePathMap.put(SQLMAP_FILE_PATH, sqlMapFilePath);
        filePathMap.put(ENTITY_FILE_PATH, entityFilePath);
        filePathMap.put(DAO_FILE_PATH, daoFilePath);
        filePathMap.put(SERVICE_FILE_PATH, serviceFilePath);

        Map<String, Object> paramsMap = table.getParamMaps();
        paramsMap.put("entityPackagePath", entityPackagePath);
        paramsMap.put("daoPackagePath", daoPackagePath);
        paramsMap.put("servicePackagePath", servicePackagePath);
        paramsMap.put("entityClassPath", entityClassPath);
        paramsMap.put("daoClassPath", daoClassPath);
        paramsMap.put("serviceClassPath", serviceClassPath);

    }

    /**
     * 生成SQLMap文件
     *
     * @return
     * @throws Exception
     */
    public boolean generateSqlMapFile() throws Exception {

        //读取sqlmap模板
        String template = FileUtils.readerResourcesFile(TEMPLATE_ROOT + TEMPLATE_SQL);
        template = template.replaceAll("#\\{", "00000\\{");
        template = template.replaceAll("%%\\{", "99999\\{");
        //组合模板
        String sqlMapContext = FreeMarkerUtils.getResult(template, table.getParamMaps());
        sqlMapContext = sqlMapContext.replaceAll("00000\\{", "#\\{");
        sqlMapContext = sqlMapContext.replaceAll("99999\\{", "\\$\\{");
        //生成文件
        String filePath = filePathMap.get(SQLMAP_FILE_PATH);
        boolean status = FileUtils.writeFile(filePath, sqlMapContext);
        System.out.println("创建SQLMap文件：" + (status ? "【成功】" : "【失败】") + filePath);
        return status;
    }

    /**
     * 生成Entity文件
     *
     * @return
     * @throws Exception
     */
    public boolean generateEntityFile() throws Exception {

        //读取模板
        String filePath = filePathMap.get(ENTITY_FILE_PATH);
        String template = FileUtils.readerResourcesFile(TEMPLATE_ROOT + TEMPLATE_PO);
        //组合模板
        String sqlMapContext = FreeMarkerUtils.getResult(template, table.getParamMaps());
        //生成文件
        boolean status = FileUtils.writeFile(filePath, sqlMapContext);
        System.out.println("创建Entity文件：" + (status ? "【成功】" : "【失败】") + filePath);
        return status;
    }


    /**
     * 生成Dao文件
     *
     * @return
     * @throws Exception
     */
    public boolean generateDaoFile() throws Exception {

        //引用包路径
        Map<String, Object> paramsMap = table.getParamMaps();
        List<String> importList = new ArrayList<String>();
        importList.add(paramsMap.get("entityClassPath").toString());
        paramsMap.put("importList", importList);
        //读取模板
        String template = FileUtils.readerResourcesFile(TEMPLATE_ROOT + TEMPLATE_DAO);
        //组合模板
        String sqlMapContext = FreeMarkerUtils.getResult(template, paramsMap);
        //生成文件
        String filePath = filePathMap.get(DAO_FILE_PATH);
        boolean status = FileUtils.writeFile(filePath, sqlMapContext);
        System.out.println("创建Dao文件：" + (status ? "【成功】" : "【失败】") + filePath);
        return status;
    }

    /**
     * 生成Service文件
     *
     * @return
     * @throws Exception
     */
    public boolean generateServiceFile() throws Exception {

        //引用包路径
        Map<String, Object> paramsMap = table.getParamMaps();
        List<String> importList = new ArrayList<String>();
        importList.add(paramsMap.get("entityClassPath").toString());
        importList.add(paramsMap.get("daoClassPath").toString());
        paramsMap.put("importList", importList);
        //读取模板
        String template = FileUtils.readerResourcesFile(TEMPLATE_ROOT + TEMPLATE_SERVICE);
        //组合模板
        String sqlMapContext = FreeMarkerUtils.getResult(template, paramsMap);
        //生成文件
        String filePath = filePathMap.get(SERVICE_FILE_PATH);
        boolean status = FileUtils.writeFile(filePath, sqlMapContext);
        System.out.println("创建Service文件：" + (status ? "【成功】" : "【失败】") + filePath);
        return status;
    }


    public GenerateTable getTable() {
        return table;
    }

    public void setTable(GenerateTable table) {
        this.table = table;
    }


}
