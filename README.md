[![Build Status](https://travis-ci.org/liuwill/spring-boot-pdf.svg)](https://travis-ci.org/liuwill/spring-boot-pdf)

Spring Boot生成PDF文档
=========

> 通过Spring Boot实现PDF文件导出功能，PDF文件生成使用itext的第三方库。集成freemarker使用，可以直接从html文件生成对应内容的pdf，这样就可以将pdf文件的视图和数据分离。这里还使用了AbstractView，通过ModelAndView的方式就可以下载PDF。

## 依赖的包
* `spring-boot` 加载Spring MVC
* `Freemarker` 生成html文本
* `itext` 生成PDF
* `JUnit` 进行单元测试

```gradle
    dependencies {
        // tag::jetty[]
        compile("org.springframework.boot:spring-boot-starter-web") {
            exclude module: "spring-boot-starter-tomcat"
        }
        compile("org.springframework.boot:spring-boot-starter-jetty")
        // end::jetty[]
        // tag::actuator[]
        compile("org.springframework.boot:spring-boot-starter-actuator")
        compile("org.springframework.boot:spring-boot-starter-aop")
        compile("org.springframework:spring-context-support")
    
        compile	'com.itextpdf:itextpdf:5.5.8'
        compile	'com.itextpdf:itext-asian:5.2.0'
        compile	'com.itextpdf.tool:xmlworker:5.5.9'
    
        compile	'org.freemarker:freemarker:2.3.23'
        compile 'javax.servlet:javax.servlet-api:3.1.0'
    
        testCompile (group: 'junit', name: 'junit', version: '4.12')
        testCompile("org.springframework.boot:spring-boot-starter-test")
    }
```

## 运行相关
通过执行`gradle bootRun`来运行Spring Boot,运行起来之后，访问[http://localhost:8888/download]()查看结果。