## cde-oauth2-client

项目是依赖 spring-boot 构建的一个微服务。通过调用 github oauth-service，根据用户授权登录，从而获取用户基本信息的一个微服务。
 
- - - -

#### Table of Contents

* [开始](#开始)
* [目录层级](#目录层级)
* [项目的java文件目录](#项目的java文件目录)
  * [domain](#domain)
  * [controller](#controller)
  * [service](#service)
  * [build](#build)
  * [agent](#agent)
* [项目的参数配置文件目录](#项目的参数配置文件目录)
  * [bootstrap.yml](#bootstrap.yml)
  * [application.yml](#application.yml)
  * [log4j2.xml](#log4j2.xml)
* [依赖配置文件pom.xml](#依赖配置文件pom.xml)

- - - -

##### 开始

* 本篇是对微服务项目cde-oauth2-client的一份详细设计文档。**OAuth2-client**, 对接OAuth2-service的客户端实现。项目pom.xml文件继承 [cde-parent](https://github.com/seedyee/cde-parent) 项目的依赖配置。

- - - -

##### 目录层级

* 项目的java文件存放的目录: `cde-oauth2-client/src/main/io/cde/oauth2/client/*`.
* 项目配置文件存放的目录: `cde-oauth2-client/src/main/resources/*`.

- - - -

##### 项目的java文件目录

该目录下存放 cde-oauth2-client 项目的所有java文件。在该根目录下只存放有一个该项目程序的入口文件
 `cde-Application.java`.

{

    public class Application{
    	/**
     	* 程序入口.
     	* @param args this args.
     	*/
    	public static void main(final String[] args) {
    		SpringApplication.run(Application.class, args);
    	}
    }

}



###### domain
###### controller
###### service
###### build
###### agent

- - - -

##### 项目的参数配置文件目录

###### bootstrap.yml
###### application.yml
###### log4j2.xml

- - - -


##### 依赖配置文件pom.xml
