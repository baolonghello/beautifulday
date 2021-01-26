package com.eloancn.bt.generate.genutils;

import com.eloancn.bt.generate.db.MysqlConnection;
import org.apache.commons.lang.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenerateUtils {

    private static String DB_INT_TYPE = ",BIT,INT,TINYINT,MEDIUMINT,";
    private static String DB_LONG_TYPE = ",BIGINT,";
    private static String DB_DATE_TYPE = ",DATETIME,DATE,TIME,TIMESTAMP,";
    private static String DB_STRING_TYPE = ",VARCHAR,CHAR,TEXT,LONGTEXT,BLOB,LONGBLOB,MEDIUMBLOB,MEDIUMTEXT,TINYBLOB,TINYTEXT,";
    private static String DB_DECIMAL_TYPE = ",DECIMAL,BIGDECIMAL,";
    private static String DB_DOUBLE_TYPE = ",DOUBLE,";


    private static String DECIMAL_TYPE = "BigDecimal";
    private static String INTEGER_TYPE = "Integer";
    private static String STRING_TYPE = "String";
    private static String DATE_TYPE = "Date";
    private static String DOUBLE_TYPE = "Double";
    private static String LONG_TYPE = "Long";


    private static String SQLMAP_DECIMAL_TYPE = "DECIMAL";
    private static String SQLMAP_INTEGER_TYPE = "NUMERIC";
    private static String SQLMAP_STRING_TYPE = "VARCHAR";
    private static String SQLMAP_DATE_TYPE = "TIMESTAMP";

    private static String IMPORT_DATE = " java.util.Date";
    private static String IMPORT_BIGDECIMAL = " java.math.BigDecimal";


    /**
     * 将表名转化为PO类名
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    public static String tableToPoName(String tableName) throws Exception {
        try {
            if (StringUtils.isNotBlank(tableName)) {
                //将表名翻译成PO名称
                String[] strArray = tableName.replace("d_", "").split(GenerateConstants.Separator.UPDERLINE);
                StringBuffer buff = new StringBuffer();
                for (String str : strArray) {
                    //第一个单词大写，多个单词时，首字母都大写
                    buff.append(str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase());
                }
                return buff.toString();
            } else {
                throw new Exception("表名不能为空");
            }
        } catch (Exception e) {
            System.out.println("表名定义规则错误 tableName【" + tableName + "】");
            throw e;
        }
    }

    /**
     * 将表列名转换为变量名
     *
     * @param
     * @return
     */
    public static String columnNameToVariable(String columnName) {
        if (StringUtils.isNotBlank(columnName)) {
            String array[] = columnName.toUpperCase().split(GenerateConstants.Separator.UPDERLINE);

            StringBuffer buff = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                String str = array[i];
                if (i < 1) {
                    buff.append(str.toLowerCase());
                } else {
                    //第一个单词大写，多个单词时，首字母都大写
                    buff.append(str.substring(0, 1) + str.substring(1).toLowerCase());
                }
            }
            return buff.toString();
        }
        return null;
    }

    /**
     * 表字段类型转换为java变量类型
     *
     * @param dbType
     * @return
     * @throws Exception
     */
    public static String dbTypeToVariableType(String dbType) throws Exception {
        if (StringUtils.isBlank(dbType)) {
            return null;
        }
        if (DB_INT_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return INTEGER_TYPE;
        } else if (DB_DATE_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return DATE_TYPE;
        } else if (DB_STRING_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return STRING_TYPE;
        } else if (DB_DECIMAL_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return DECIMAL_TYPE;
        } else if (DB_DOUBLE_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return DOUBLE_TYPE;
        } else if (DB_LONG_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return LONG_TYPE;
        } else {
            //throw new Exception("数据库字段类型没有找到对应的变量类型");
            return STRING_TYPE;
        }
    }

    /**
     * 表字段名转换为sqlmap
     *
     * @param dbType
     * @return
     * @throws Exception
     */
    public static String dbTypeToSqlMapType(String dbType) throws Exception {
        if (StringUtils.isBlank(dbType)) {
            return null;
        }
        if (DB_INT_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return SQLMAP_INTEGER_TYPE;
        } else if (DB_LONG_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return SQLMAP_INTEGER_TYPE;
        } else if (DB_DATE_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return SQLMAP_DATE_TYPE;
        } else if (DB_STRING_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return SQLMAP_STRING_TYPE;
        } else if (DB_DECIMAL_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return SQLMAP_DECIMAL_TYPE;
        } else if (DB_DOUBLE_TYPE.indexOf(GenerateConstants.Separator.COMMA + dbType + GenerateConstants.Separator.COMMA) != -1) {
            return DB_DOUBLE_TYPE;
        } else {
            //throw new Exception("数据库字段类型没有找到对应的变量类型");
            return SQLMAP_STRING_TYPE;
        }
    }

    /**
     * 数据库字段类型是否需要引入包
     *
     * @param type
     * @return
     * @throws Exception
     */
    public static String dbTypeToImportPath(String type) {
        if (StringUtils.isNotBlank(type) && DB_DATE_TYPE.indexOf(GenerateConstants.Separator.COMMA + type.toUpperCase() + GenerateConstants.Separator.COMMA) != -1
        ) {
            return IMPORT_DATE;
        } else if (StringUtils.isNotBlank(type) && DB_DECIMAL_TYPE.indexOf(GenerateConstants.Separator.COMMA + type.toUpperCase() + GenerateConstants.Separator.COMMA) != -1) {
            return IMPORT_BIGDECIMAL;
        }
        return null;
    }

    /**
     * 表字段转换
     *
     * @param tableName
     * @param conn
     * @param columnNames
     * @return
     * @throws Exception
     */
    public static List<GenerateColumn> columnToList(String tableName, Connection conn, List<String> columnNames) throws Exception {

        try {

            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rs = dbmd.getColumns(null, "developer", tableName, null);

            List<GenerateColumn> columnList = new ArrayList<GenerateColumn>();
            Map<Integer, String> columnMap = new HashMap<Integer, String>();
            int i = 0;
            while (rs.next()) {

                String columnName = rs.getString("COLUMN_NAME");
                String typeName = rs.getString("TYPE_NAME");
                if (columnMap.containsValue(columnName)) {
                    continue;
                }
                if (!columnNames.contains(columnName)) {
                    continue;
                }

                columnMap.put(i, columnName);

                GenerateColumn column = new GenerateColumn();
                column.setName(GenerateUtils.columnNameToVariable(columnName));
                column.setStaticFinalName(columnName.toUpperCase());
                column.setFirstUpperName(column.getName().substring(0, 1).toUpperCase() + column.getName().substring(1));
                column.setDbName(columnName);
                column.setType(GenerateUtils.dbTypeToVariableType(typeName));
                column.setSqlMapColumnType(GenerateUtils.dbTypeToSqlMapType(typeName));
                column.setDbType(typeName);
                column.setRemarks(rs.getString("REMARKS"));
                columnList.add(column);
                i++;
            }

            if (!(columnList != null && columnList.size() > 0)) {
                throw new Exception("请检查JDBC配置文件数据库信息是否正确");
            }
            //验证是否满足条件
            validateColumn(columnMap);

            return columnList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            //关闭数据库连接
            MysqlConnection.closeConnection(conn);
        }
    }


    /**
     * 获取标列名
     *
     * @param tableName
     * @param conn
     * @return
     * @throws Exception
     */
    public static List<String> columnList(String tableName, Connection conn) throws Exception {

        try {

            ResultSet rs = conn.createStatement().executeQuery("SELECT *FROM " + tableName + " limit 1");
            ResultSetMetaData md = rs.getMetaData();
            List<String> columnNames = new ArrayList();
            for (int i = 1; i <= md.getColumnCount(); i++) {
                columnNames.add(md.getColumnLabel(i));
            }
            return columnNames;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            //关闭数据库连接
            MysqlConnection.closeConnection(conn);
        }
    }


    public static void validateColumn(Map<Integer, String> columnMap) throws Exception {

        StringBuffer buff = new StringBuffer();
        //判断createTime字段是否存在
        for (int i = 0; i < columnMap.size(); i++) {
            String columnName = columnMap.get(i);
            for (int j = 1; j < columnName.length(); j++) {
                char str = columnName.charAt(j);
                // 当前字符的前一个必须是小写字符并且不能等于下划线，当前字符是大写字符，而且不是数字
                if (str != '_' && !Character.isLowerCase(str) && Character.isLowerCase(columnName.charAt(j - 1))
                        && columnName.charAt(j - 1) != '_' && !Character.isDigit(columnName.charAt(j))) {
                    buff.append(columnName).append(GenerateConstants.Separator.COMMA);
                    break;
                }
            }
        }
    }


}
