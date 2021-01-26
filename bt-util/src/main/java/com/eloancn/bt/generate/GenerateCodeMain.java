package com.eloancn.bt.generate;


import com.eloancn.bt.generate.genutils.GenerateCode;
import com.eloancn.bt.generate.genutils.GenerateTable;


/**
 * @ Description   :  代码生成器入口
 * @ Author        :  baolong.sun
 * @ CreateDate    :  2020/11/16 4:15 下午
 * @ UpdateUser    :  baolong.sun
 * @ UpdateDate    :  2020/11/16 4:15 下午
 * @ UpdateRemark  :  修改内容
 * @ Version       :  1.0
 */
public class GenerateCodeMain {


    public static void main(String[] args) {

        /**
         * 数据库链接
         */
        String URL_VALUE = "jdbc:mysql://192.168.2.150:3316/eloan_db?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        /**
         * 数据库连接用户名
         */
        String USERNAME_VALUE = "developer";
        /**
         * 数据库链接密码
         */
        String PASSWORD_VALUE = "developer_select";
        /**
         * java文件存放相对目录
         */
        String coommonJavaPath = "/Users/admin/idea-workspace/spring-bt-t/bt-service/src/main/java/com/eloancn/bt/";
        /**
         * sqlmap文件存放相对目录
         */
        String coommonSqlPath = "/Users/admin/idea-workspace/spring-bt-t/bt-service/src/main/resources/mappers/";
        /**
         * 表名
         */
        String[] tables = {"d_user","d_tender_bus_detail"};
        /**
         * 表名前缀
         */
        String tablePrefix = "d_";

        try {

            for (String tableName : tables) {
                // 初始化table信息
                GenerateTable tableInfo = new GenerateTable(tableName, tablePrefix, URL_VALUE, USERNAME_VALUE, PASSWORD_VALUE);
                // 初始化自动生成代码
                GenerateCode code = new GenerateCode(tableInfo, coommonJavaPath, coommonSqlPath);
                try {
                    // 创建sqlmap文件
                    code.generateSqlMapFile();
                    // 创建Entity文件
                    code.generateEntityFile();
                    // 创建Dao文件
                    code.generateDaoFile();
                    // 创建Service文件
                    code.generateServiceFile();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
