package com.hanhu.generator;


import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.GeneratorBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Scanner;

/**
 * MybatisPlus 代码生成器
 * 基于 mybatis-plus-generator 3.5.1
 * @author hanhu
 * @Date 2022-01-23 17:59
 */
public class CodeGenerator {

    //作者
    private static final String author = "hanhu";
    //数据库URL
    private static final String url ="jdbc:mysql://localhost:3306/online_classes?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia" + "/Shanghai";
    //private static final String url = "jdbc:mysql://localhost:3306;databaseName=online_classes";
    // 数据库用户名
    private static final String username = "root";
    //数据库密码
    private static final String passwd = "123456";
    //指定数据库表的前缀。指定后，在生成文件时，模板会自动截取掉前缀字符，如表名为sys_user，指定前缀为sys_,生成实体是自动识别生成为user
    //多个前缀可以用逗号隔开，例如 sys_,bs_，根据项目需要配置
    private static final String tablePrefix = "tb_";
    //设置生成实体时的公共父类，例如 com.baomidou.global.BaseEntity  ，根据项目需要配置
    private static final String superEntityPackageString = "onway.org.cn.comm.web.entity.BaseEntity";
    //设置生成Controller时的公共父类，例如 com.baomidou.global.BaseController   ，根据项目需要配置
    private static final String superControllerPackageString = "onway.org.cn.comm.web.controller.BaseController";

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入" + tip + "：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {

        //数据库配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig
                // 驱动连接的URL、数据库连接用户名、数据库连接密码
                .Builder(url, username, passwd)
                // 类型转换,数据库=》JAVA类型  mysql: MySqlTypeConvert() sqlserver:SqlServerTypeConvert() oracle:OracleTypeConvert()
                .typeConvert(new MySqlTypeConvert())
                // 关键字处理 ,这里选取了mysql5.7文档中的关键字和保留字（含移除） 说明：官方文档中没有关于sqlserver，oracle数据库的配置
                //.keyWordsHandler(new MySqlKeyWordsHandler())
                // 数据库信息查询类,默认由 dbType 类型决定选择对应数据库内置实现：mysql:MySqlQuery(),sqlserver :SqlServerQuery(),Oracle:OracleQuery()
                .dbQuery(new MySqlQuery())
                // 数据库 schema name
                .schema("mybatis-plus")
                .build();

        //全局策略配置
        GlobalConfig globalConfig = GeneratorBuilder.globalConfigBuilder()
                // 覆盖已生成文件
                .fileOverride()
                // 指定输出目录
                .outputDir(System.getProperty("user.dir") + "/" + "online-classes-generator" + "/src/main/java")
                //禁止打开生成目录
                 .disableOpenDir()
                // 生成swagger注解
                .enableSwagger()
                // 作者名
                .author(author)
                // 时间策略
                .dateType(DateType.TIME_PACK)
                // 注释日期格式
                .commentDate("yyyy-MM-dd")
                .build();

        //包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                // 父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
                //.parent(scanner("父包名(例如包名为：com.hanhu.serve,父包名：com.hanhu)"))
                .parent("com.hanhu")
                // 父包模块名
                //.moduleName(scanner("子包名(例如包名为：com.hanhu.serve,子包名为：serve)"))
                .moduleName("generator")
                //其他entity ，service，controller 使用默认值即可，如果需要单独指定，在此处配置就行
                .entity("entity")
                .mapper("mapper")
                .service("service")
                .serviceImpl("service.impl")
                .controller("controller")
                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, System.getProperty("user.dir") + "/" + "online-classes-generator" +"/src/main/resources/mapper"))    //配置 **Mapper.xml 路径信息：项目的 resources 目录的 Mapper 目录下

                .build();

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                //表名匹配，按指定的表名生成对应的文件
                .addInclude(scanner("数据库表名，多个表名用英文逗号分割").split(","))
                //指定数据库表的前缀。指定后，在生成文件时，模板会自动截取掉前缀字符，如表名为sys_user，指定前缀为sys_,生成实体是自动识别生成为user
                .addTablePrefix(tablePrefix)

                /**实体模型配置*/
                .entityBuilder()
                //数据库表映射到实体的命名策略,NamingStrategy.underline_to_camel 指下划线转驼峰，NamingStrategy.no_change 无改变
                .naming(NamingStrategy.underline_to_camel)
                //表字段转驼峰命名
                .columnNaming(NamingStrategy.underline_to_camel)
                //开启实体Lombok注解模式
                .enableLombok()
                //开启 Boolean 类型字段移除 is 前缀
                .enableRemoveIsPrefix()
                //开启生成实体时生成字段注解
                .enableTableFieldAnnotation()
                //设置Entity父类
                .superClass(superEntityPackageString)
                //lombok模型

                /*service接口模型配置*/
                .serviceBuilder()
                //格式化 Service文件名称
                .formatServiceFileName("%sService")

                /*controller模型配置*/
                .controllerBuilder()
                //设置Controller父类
                .superClass(superControllerPackageString)
                //开启驼峰转连字符
                .enableHyphenStyle()
                //开启生成@RestController 控制器
                .enableRestStyle()




                /*mapper配置*/
                .mapperBuilder()
                //开启 @Mapper 注解
                .enableMapperAnnotation()
                //启用 BaseResultMap 生成
                .enableBaseResultMap()
                //启用 BaseColumnList
                .enableBaseColumnList()
                .build();

        // 配置模板
        //TemplateConfig templateConfig = new TemplateConfig.Builder().disable().build();//激活所有默认模板

        //添加以上配置到AutoGenerator中
        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig); // 数据源配置
        autoGenerator.global(globalConfig); // 全局策略配置
        autoGenerator.packageInfo(packageConfig);    // 包配置
        autoGenerator.strategy(strategyConfig);

        //autoGenerator.template(templateConfig); // 配置模板
        // 生成代码
        autoGenerator.execute();

    }
}
