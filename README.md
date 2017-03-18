# springBoot-mybatis-plus

  springboot是个微框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Boot致力于在蓬勃发展的快速应用开发领域（rapid application development  ）    
  多年以来，Spring IO平台饱受非议的一点就是大量的XML配置以及复杂的依赖管理。在去年的SpringOne 2GX会议上，Pivotal的CTO Adrian Colyer回应了这些批评，并且特别提到该平台将来的目标之一就是实现免XML配置的开发体验。Boot所实现的功能超出了这个任务的描述，开发人员不仅不再需要编写XML，而且在一些场景中甚至不需要编写繁琐的import语句。在对外公开的beta版本刚刚发布之时，Boot描述了如何使用该框架在140个字符内实现可运行的web应用，从而获得了极大的关注度，该样例发表在tweet上。    
  
  在Application类上的@EnableAutoConfiguration注解会告知Boot要采用一种特定的方式来对应用进行配置。这种方法会将其他样板式的配置均假设为框架默认的约定，因此能够聚焦于如何尽快地使应用准备就绪以便运行起来。Application类是可运行的，因此，当我们以Java Application的方式运行这个类时，就能启动该应用及其嵌入式的容器，这样也能实现即时地开发。

为了发布版本而构建工程时，Boot的Maven和Gradle插件可以嵌入（hook）到这些构建系统的打包过程中，以生成可执行的“胖jar包（fat jar）”，这种jar包含了工程的所有依赖并且能够以可运行jar的方式执行。使用Maven打包Boot应用只需运行mvn package命令，与之类似，使用Gradle时，执行gradle build命令将会在构建的目标地址下生成可运行的jar。

------boot项目的创建

----  ApplicationStartMain.java
  --------------start----------------
  package cn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.rails.rsems.mapper*")
@SpringBootApplication
public class ApplicationStartMain {

	public static void main(String[] args) {

		SpringApplication.run(ApplicationStartMain.class, args);
	}


}
-------------------- end -------------------
配置文件 配置数据库信息  相当于configpropertis
-------- application.yml

-------------start---------------
server:
  port:8081

# jdbc_config
spring:
  datasource:
     url: jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=gbk&zeroDateTimeBehavior=convertToNull
   # url: jdbc:oracle:thin:@172.28.1.68:1521:orcl
    username: root
    password: lht
    type: com.alibaba.druid.pool.DruidDataSource
    initialSize: 5
    minIdle: 5
    maxActive: 20
    # 配置获取连接等待超时的时间
    maxWait: 60000
    # 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
    timeBetweenEvictionRunsMillis: 60000
    # 配置一个连接在池中最小生存的时间，单位是毫秒
    minEvictableIdleTimeMillis: 300000
    testWhileIdle: true
    validationQuery: SELECT 'x'
    testOnBorrow: false
    testOnReturn: false
    # 打开PSCache，并且指定每个连接上PSCache的大小
    poolPreparedStatements: true
    maxPoolPreparedStatementPerConnectionSize: 20
    # 配置监控统计拦截的filters，去掉后监控界面sql无法统计，'wall'用于防火墙
    filters: stat,wall,log4j
    # 通过connectProperties属性来打开mergeSql功能；慢SQL记录
    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000
    # 合并多个DruidDataSource的监控数据
    #spring.datasource.useGlobalDataSourceStat=true

# mybatis_config
mybatis:
    mapper-locations: classpath*:mapper/**/*.xml
    typeAliasesPackage: cn.rails.rsems.model
    
   -------------end----------------
    
   
   
   mybatis-plus工具类 用来加载数据库数据源和对分页插件的配置
   
   --------------------star--------------------
 ---------  MybatisPlusConfig.Java
package com.cn.rails.rsems.config;

import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Configuration
public class MybatisPlusConfig {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private MybatisProperties properties;

	@Autowired
	private ResourceLoader resourceLoader = new DefaultResourceLoader();

	@Autowired(required = false)
	private Interceptor[] interceptors;

	@Autowired(required = false)
	private DatabaseIdProvider databaseIdProvider;
	
	/**
	 *	 mybatis-plus分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor page = new PaginationInterceptor();
		page.setDialectType("mysql");
		return page;
	}
	/**
	 * 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定
	 * 配置文件和mybatis-boot的配置文件同步
	 * @return
	 */
	@Bean
	public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
		MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
		mybatisPlus.setDataSource(dataSource);
		mybatisPlus.setVfs(SpringBootVFS.class);
		if (StringUtils.hasText(this.properties.getConfigLocation())) {
			mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
		}
		mybatisPlus.setConfiguration(properties.getConfiguration());
		if (!ObjectUtils.isEmpty(this.interceptors)) {
			mybatisPlus.setPlugins(this.interceptors);
		}
		// MP 全局配置，更多内容进入类看注释
		GlobalConfiguration globalConfig = new GlobalConfiguration();
		globalConfig.setDbType(DBType.MYSQL.name());
		// ID 策略 AUTO->`0`("数据库ID自增") INPUT->`1`(用户输入ID") ID_WORKER->`2`("全局唯一ID") UUID->`3`("全局唯一ID")
		globalConfig.setIdType(2);
		mybatisPlus.setGlobalConfig(globalConfig);
		MybatisConfiguration mc = new MybatisConfiguration();
		mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
		mybatisPlus.setConfiguration(mc);
		if (this.databaseIdProvider != null) {
			mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
		}
		if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
			mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
		}
		if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
			mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
		}
		if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
			mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
		}
		return mybatisPlus;
	}
}
---------------------end-----------------------
    
    
    

