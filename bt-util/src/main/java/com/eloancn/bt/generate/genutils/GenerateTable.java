package com.eloancn.bt.generate.genutils;

import com.eloancn.bt.generate.db.MysqlConnection;
import com.eloancn.bt.generate.file.FileUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateTable {

    public GenerateTable() {

    }

    public GenerateTable(String tableName, String tablePrefix, String dbUrl, String dbUsername, String dbUserPass) throws Exception {

        this.tableName = tableName;
        this.tablePrefix = tablePrefix;
        this.dbUrl = dbUrl;
        this.dbUsername = dbUsername;
        this.dbUserPass = dbUserPass;
        init();
    }

    /**
     * 表前缀
     */
    private String tablePrefix;
    /**
     * 去掉模块后的第一个单词
     */
    private String tableMiddle;
    /**
     * 表名
     */
    private String tableName;
    /**
     * po名称
     */
    private String poName;
    /**
     * poName 首字母小写
     */
    private String firstLowerPoName;

    /**
     * db链接
     */
    private String dbUrl;
    /**
     * db用户名
     */
    private String dbUsername;
    /**
     * db密码
     */
    private String dbUserPass;

    private Map<String, Object> paramMaps = new HashMap<String, Object>();

    /**
     * 项目的跟路径
     */
    private String workspacesPath;

    private Map<String, String> excludeColumnMap = new HashMap<String, String>();
    /**
     * 包路径
     */
    private List<String> importList = new ArrayList<String>();
    /**
     * 类型Map
     */
    private Map<String, String> typeMap = new HashMap<String, String>();

    /**
     * 字段列
     */
    private List<GenerateColumn> columnList = new ArrayList<GenerateColumn>();
    /**
     * po定义的变量
     */
    private List<GenerateColumn> poColumnList = new ArrayList<GenerateColumn>();

    private void init() throws Exception {


        //将表名转化为PO类名
        this.poName = GenerateUtils.tableToPoName(tableName);
        this.tableMiddle = this.poName.toLowerCase().substring(tablePrefix.length());
        // 首字母小写
        this.firstLowerPoName = this.poName.substring(0, 1).toLowerCase() + this.poName.substring(1);
        // 初始化项目跟路径
        this.workspacesPath = FileUtils.getClassResourcesPath();
        this.initColumn();
        this.initMap();
        this.initExcludeColumn();
    }

    /**
     * 初始化字段列
     *
     * @throws Exception
     */
    private void initColumn() throws Exception {

        List<String> columnNames = GenerateUtils.columnList(tableName, (Connection) MysqlConnection.newConnection(dbUrl, dbUsername, dbUserPass));
        this.columnList = GenerateUtils.columnToList(tableName, (Connection) MysqlConnection.newConnection(dbUrl, dbUsername, dbUserPass), columnNames);
        for (GenerateColumn column : this.columnList) {
            typeMap.put(column.getType(), column.getType());
        }
    }

    /**
     * 初始化 map参数，用于与模板合成
     */
    private void initMap() {

        paramMaps.put("poName", this.poName);
        paramMaps.put("firstLowerPoName", this.firstLowerPoName);
        paramMaps.put("tableName", this.tableName);
        paramMaps.put("tablePrefix", this.tablePrefix.toLowerCase());
        paramMaps.put("tableMiddle", this.tableMiddle);
        paramMaps.put("columnList", this.columnList);
        paramMaps.put("poColumnList", this.poColumnList);
        paramMaps.put("importList", this.importList);
    }

    /***
     * 初始化排除的列
     */
    private void initExcludeColumn() {

        Map<String, String> importMap = new HashMap<String, String>();
        for (GenerateColumn column : this.columnList) {
            if (!excludeColumnMap.containsKey(column.getName())) {
                poColumnList.add(column);
                String importStr = GenerateUtils.dbTypeToImportPath(column.getType());
                if (!importMap.containsKey(importStr)) {
                    importMap.put(importStr, null);
                    importList.add(importStr);
                }
            }
        }
    }

    public String getTableName() {

        return tableName;
    }

    public void setTableName(String tableName) {

        this.tableName = tableName;
    }

    public List<GenerateColumn> getColumnList() {

        return columnList;
    }

    public void setColumnList(List<GenerateColumn> columnList) {

        this.columnList = columnList;
    }

    public String getPoName() {

        return poName;
    }

    public void setPoName(String poName) {

        this.poName = poName;
    }

    public String getTablePrefix() {

        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {

        this.tablePrefix = tablePrefix;
    }

    public String getTableMiddle() {

        return tableMiddle;
    }

    public void setTableMiddle(String tableMiddle) {

        this.tableMiddle = tableMiddle;
    }

    public String getFirstLowerPoName() {

        return firstLowerPoName;
    }

    public void setFirstLowerPoName(String firstLowerPoName) {

        this.firstLowerPoName = firstLowerPoName;
    }

    public Map<String, Object> getParamMaps() {

        return paramMaps;
    }

    public void setParamMaps(Map<String, Object> paramMaps) {

        this.paramMaps = paramMaps;
    }

    public String getWorkspacesPath() {

        return workspacesPath;
    }

    public void setWorkspacesPath(String workspacesPath) {

        this.workspacesPath = workspacesPath;
    }

    public Map<String, String> getExcludeColumnMap() {

        return excludeColumnMap;
    }

    public void setExcludeColumnMap(Map<String, String> excludeColumnMap) {

        this.excludeColumnMap = excludeColumnMap;
    }

    public List<GenerateColumn> getPoColumnList() {

        return poColumnList;
    }

    public void setPoColumnList(List<GenerateColumn> poColumnList) {

        this.poColumnList = poColumnList;
    }

    public List<String> getImportList() {

        return importList;
    }

    public void setImportList(List<String> importList) {

        this.importList = importList;
    }

    public Map<String, String> getTypeMap() {

        return typeMap;
    }

    public void setTypeMap(Map<String, String> typeMap) {

        this.typeMap = typeMap;
    }


    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbUserPass() {
        return dbUserPass;
    }

    public void setDbUserPass(String dbUserPass) {
        this.dbUserPass = dbUserPass;
    }
}
