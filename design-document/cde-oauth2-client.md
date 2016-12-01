## cde-oauth2-client

本篇是微服务项目cde-oauth2-client的一份详细设计文档。该项目是依赖 spring-boot 构建的一个微服务，对接github的OAuth2-service的客户端实现，通过调用 github oauth-service服务，根据用户授权登录，从而获取到用户基本信息。
 
- - - -

#### Table of Contents

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
- - - -

#### 目录层级

* 项目的java文件存放的目录: `cde-oauth2-client/src/main/io/cde/oauth2/client/*`.
* 项目配置文件存放的目录: `cde-oauth2-client/src/main/resources/*`.

- - - -

#### 项目的java文件目录

该目录文件下存放 cde-oauth2-client 项目的所有java文件。在该根目录下只存放有一个该项目程序的入口文件
 `cde-Application.java`.
	
	public class Application{
    	/**
     	* 程序入口.
     	* @param args this args.
     	*/
    	public static void main(final String[] args) {
    		SpringApplication.run(Application.class, args);
    	}
    }


- - - -

#### domain

该目录文件用于存放entity实体，本项目中设计4个entity，分别为 `DomainEntity.java`, `AuthorizationCodeRequestInfo.java`, `AccessTokenRequestInfo.java`, `UserRequestInfo.java`.

1、DomainEntity.java 是个基础类，用于继承。
          			
继承: 无		

属性:

| 标识 		| 类型          | 字段描述  
|------------|---------------|--------|---------
| clientId 	| String         | 项目在github中注册生成的唯一id

方法:  

| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| DomainEntity() | String clientId |   |构造函数|
|getClientId() | String clientId | String clientId |该方法为属性clientId的get方法，作为与github交互时的传递参数，需要通过在该方法上加@JsonProperty("client_id")，使得传递的字段标识为client_id

2、UserRequestInfo.java 用于和github交互时获取用户信息的请求传递参数的entity.

继承: 无		

属性:

| 标识 		| 类型          | 字段描述  
|------------|---------------|--------|---------
| token 	| String         | github认证服务器返回的token认证通过标识
| requestUserUrl 	| String         | 与github交互请求用户数据资源的url

方法:  

| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| UserRequestInfo.java() |String token, String requestUserUrl |   |构造函数|
|getRequestUserUrl(), getToken() | | |token, requestUserUrl两个属性的get方法

3、AuthorizationCodeRequestInfo.java 用于和github交互时获取code的请求传递参数entity.

继承: DomainEntity.java	

属性:

| 标识 		| 类型          | 字段描述  
|------------|---------------|--------|---------
| scope 		| String         | 请求的授权范围标识
| redirectUrl 	| String         | code请求之后的github回调url
| requestAuthorizeUrl 	| String | 请求code的登录验证url
| responseType 	| String         | 请求授权的类型，该项目取固定值 "code"
| state 		| long         | 当前client的状态，可以指定任意值，github认证服务器会原封不动地返回这个值

方法:

| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| AuthorizationCodeRequestInfo() | String clientId, String scope, String redirectUrl, long state, String responseType, String requestAuthorizeUrl |   |构造函数|
|getRedirectUrl(), getState(), getScope(), getResponseType(), getRequestAuthorizeUrl() |  |  |scope, redirectUrl, requestAuthorizeUrl, responseType, state所列属性的get方法

4、AccessTokenRequestInfo.java 用于和github交互时获取token的请求传递参数的entity.

继承: DomainEntity.java	

属性:

| 标识 		| 类型          | 字段描述  
|------------|---------------|--------|---------
| clientSecret 		| String         | 请求的授权范围标识
| code 	| String         | code请求之后的github回调url
| grantType 	| String | 请求code的登录验证url

方法:

| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| AccessTokenRequestInfo() |String clientId, String clientSecret, String code, String grantType|   |构造函数|
|getCode|  |  |属性code的get方法
|getClientSecret|||该方法为属性clientSecret的get方法，作为与github交互时的传递参数，需要通过在该方法上加@JsonProperty("client_secret")，使得传递的字段标识为client_secret
|getGrantType|||该方法为属性grantType的get方法，作为与github交互时的传递参数，需要通过在该方法上加@JsonProperty("grant_type")，使得传递的字段标识为grant_type|

- - - -

#### controller

该目录文件下用于存放声明 RestController 接口的java文件，`OAuthController.java`

1、该接口文件需声明四个成员变量：

	/**
     * 日志记录.
     */
    private final Logger logger = LoggerFactory.getLogger(OAuthController.class);

    /**
     * 获取token的service.
     */
    @Autowired
    private AccessTokenRequestService accessTokenRequestService;

    /**
     * 根据token获取用户数据的service.
     */
    @Autowired
    private UserInfoRequestService userInfoRequestService;

    /**
     * 组装请求code的url的service.
     */
    @Autowired
    private AuthorizationCodeRequestService authorizationCodeRequestService;

2、方法

authentication(): 该方法对应接口 `/authentication` 。调用该接口，返回值为与github授权登录请求code的完整 `url`
		
	@RequestMapping(value = "/authentication", method = RequestMethod.GET)
    private String authentication() {}

callback(): 该方法对应接口 `/callback` ，是github验证服务端的回调接口。回调返回参数 `code` 和 `state` , code 用于请求token，state验证授权登录的唯一性。

	@RequestMapping("/callback")
    private List callback(@RequestParam("code") final String code, @RequestParam("state") final long state) {}


- - - -

#### service

- - - -

#### build

- - - -

#### agent

- - - -

#### 项目的参数配置文件目录

#### bootstrap.yml
#### application.yml
#### log4j2.xml

- - - -


#### 依赖配置文件pom.xml
项目pom.xml文件继承 [cde-parent](https://github.com/seedyee/cde-parent) 项目的依赖配置。
