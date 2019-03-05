
### 推荐书籍
J2EE的核心模式

### Spring Web MVC的配置bean
WebMvcProperties

### 消息转换相关关键类
HttpMessageConverter/WebMvcConfigurationSupport
WebMvcConfigurer/AbstractHttpMessageConverter

### 数据输出转换器的顺序可以自定义
通过重写extendMessageConverters

### SpringBoot默认没有添加xml转换器
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-xml</artifactId>
</dependency>

### 自定义消息转换(扩展自描述消息)
可以通过extends AbstractHttpMessageConverter 并重写extendMessageConverters，添加转换器

### 为什么默认生成的SpringBoot的RestController返回json，当添加了xml依赖后，变成了输出xml
SpringBoot默认没有添加xml处理器实现，处理依赖于messageConverters的参入顺序，采用轮询的方式逐一尝试是否可以canWrite(POJO)，
如果返回true，说明可以序列化该POJO,而Jackson2恰好能处理，所以一开始响应格式为json
  
## Spring Boot start
### 启动方式
#### 图形化方式(https://start.spring.io/)
#### maven插件形式
mvn archetype:generate -DgroupId=com.zw -DartifactId=my-spring -Dversion=1.0.0 -DinteractiveMode=false
注：interactiveMode 安装模式，为false的时候表示是静默安装
### 构建多模块应用
1.修改主工程类型<packaging>为pom类型
2.新建web工程(模块),将主工程遗留代码移到模块中web java目录下
### 打包
1.命令行：mvn -Dmaven.test.skip -U clean package
### 启动
除了jar和war,还有目录启动方式(解决老旧的jar不支持SpringBoot新方式)：进入解压的jar，找到BOOT-INF中的MANIFEST.MF，复制里面的Main-CLass属性
执行：在解压的目录中执行：java 复制的Main-Class
### 构建可执行jar或war
#### ....jar没有主清单属性？
需要一个spring boot <plugin> <groupId>org.springframework.boot<artifactId>spring-boot-maven-plugin
原因：jar规范中，有一个MANIFEST.MF,里面有一个Main-Class属性，API:java.util.jar.Manifest#getAttributes
#### 从jar切换到war执行
一种办法：
    1.修改<package>war
    2.创建webapp/WEB-INF目录(相对于src/main目录)
    3.新建一个空的web.xml
另一种：直接添加maven-war-plugin插件,设置failOnMissingWebXml true
### Environment
两种是实现方式：
    普通类型：StandardEnvironment
    Web类型：StandardServletEnvironment 
Environment关联着PropertySources,PropertySources关联多个PropertySource,
其中有一个关键的实现是SystemEnvironmentPropertySource

## Spring Boot 验证
### 常用验证技术
#### Spring Assert API
#### JVM/java assert 断言
#### @Valid
### 自定义valid
@Constraint(validatedBy = {BetweenValidator.class})
public @interface Between
## Spring Boot 事件机制
### Spring Boot 核心事件
ApplicationEnvironmentPreparedEvent
ApplicationPreparedEvent
ApplicationStartingEvent
ApplicationReadyEvent
ApplicationFailedEvent
## Spring Cloud Config
## Spring Cloud Eureka
### 服务注册
分为服务注册、服务同步、服务续约
### 通信协议
默认使用Jersey和XStream配合JSON作为Server与Client之间的通信协议