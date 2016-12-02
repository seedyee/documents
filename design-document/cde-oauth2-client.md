## cde-oauth2-client

本篇是微服务项目cde-oauth2-client的一份详细设计文档。该项目是依赖 spring-boot 构建的一个微服务，对接github的OAuth2-service的客户端实现，通过调用 github oauth-service服务，根据用户授权登录，从而获取到用户基本信息。
 
- - - -

#### Table of Contents


* [项目的java包](#项目的java包)
  * [domain](#domain)
  
  * [controller](#controller)
  
  * [service](#service)
  
  * [builder](#builder)
  
  * [agent](#agent)
  
* [项目的参数配置文件](#项目的参数配置文件)

* [依赖配置文件pom.xml](#依赖配置文件pom.xml)



#### 项目的java包

该包下存放 cde-oauth2-client 项目的所有java类，类路径`/io/cde/oauth2/client/*`。在该包的根路径下只存放有一个该项目程序的入口文件
 `Application.java`。该类需有sprin-boot的注解@SpringBootApplication。
 
 方法: 
 
| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| main() | String[] args |   ||通过spring-boot中的SpringApplication类调用run() 方法，启动项目程序


#### domain

该包用于存放entity实体，本项目中设计4个entity，分别为 `BaseRequestInfo.java`, `AuthorizationCodeRequestInfo.java`, `AccessTokenRequestInfo.java`, `UserRequestInfo.java`.

1、BaseRequestInfo.java 是个基础类，承载公用的属性，用于继承。
          			
继承: 无		

属性:

| 标识 		| 类型          | 字段描述  |允许的操作
|------------|---------------|--------|---------
| clientId 	| String         | 项目在github中注册生成的唯一id|可读取，作为与github交互时的传递参数，需通过注解@JsonProperty("client_id")，使得传递的字段标识为client_id

方法:  

| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| BaseRequestInfo() | String clientId |   |构造函数|


2、UserRequestInfo.java 用于和github交互时获取用户信息的请求传递参数的entity.

继承: 无		

属性:

| 标识 		| 类型          | 字段描述   |允许的操作
|------------|---------------|--------|---------
| token 	| String         | github认证服务器返回的token认证通过标识|可读取
| userRequestUrl 	| String         | 与github交互请求用户数据资源的url|可读取

方法:  

| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| UserRequestInfo() |String token, String userRequestUrl |   |构造函数|


3、AuthorizationCodeRequestInfo.java 用于和github交互时登录授权获取code的请求传递参数entity.

继承: BaseRequestInfo.java	

属性:

| 标识 		| 类型          | 字段描述  | 允许的操作
|------------|---------------|--------|---------
| scope 		| String         | 请求的授权范围标识 | 可读取
| redirectUrl 	| String         | code请求之后的github回调url | 可读取
| requestAuthorizeUrl 	| String | 请求code的登录授权验证url | 可读取
| responseType 	| String         | 请求授权的类型，该项目取固定值 "code" | 可读取
| state 		| long           | 可以指定任意值，github认证服务器会原封不动地返回这个值 | 可读取

方法:

| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| AuthorizationCodeRequestInfo() | String clientId, String scope, String redirectUrl, long state, String responseType, String requestAuthorizeUrl |   |构造函数|


4、AccessTokenRequestInfo.java 用于和github交互时获取token的请求传递参数的entity.

继承: BaseRequestInfo.java	

属性:

| 标识 		| 类型          | 字段描述  | 允许的操作
|------------|---------------|--------|---------
| clientSecret 		| String         | 该项目在github注册生成的唯一 client_Secret| 可读取，作为与github交互时的传递参数，需通过注解@JsonProperty("client_secret")，使得传递的字段标识为client_secret
| code 	| String         | 用户授权登录成功后，通过github回调而获取的code,用于请求token | 可读取
| grantType 	| String | 请求的授权模式，该项目中取固定值"authorization_code" | 可读取，作为与github交互时的传递参数，需通过注解@JsonProperty("grant_type")，使得传递的字段标识为grant_type

方法:

| 方法名 		| 参数          | 返回值  | 描述
|------------|---------------|--------|---------
| AccessTokenRequestInfo() |String clientId, String clientSecret, String code, String grantType|   |构造函数|



#### controller

该包下用于存放声明 RestController 接口的java类，`OAuthController.java`


1、方法

getAuthenticationUrl(): 该方法对应接口 `/authentication-url`，请求方式为get 。调用该接口，返回值为是github授权登录请求code的完整 `url`

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
|    |   String    |步骤1，声明变量String url，作为返回值；步骤2，调用service包下AuthorizationCodeRequestService的方法getRequestCodeUrl()，获取请求code的完整url；步骤3，根据步骤2中获取得到的值对步骤1的变量url赋值，并且将其返回|



callback(): 该方法对应接口 `/callback` ，用于github验证服务端的接口回调。回调返回参数 `code` 和 `state` , code 用于请求token，state验证授权登录的唯一性。

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
|参数1，code为github回调中所获取；参数2，state为github回调所获取    |   List    |步骤1，声明变量List list，作为返回值；步骤2，调用service包下AccessTokenRequestService的方法getAccessTokenByCode()，获取得到token；步骤3，根据步骤2中获取得到的token值，调用|service 包下 UserInfoRequestService 的 getUserWithAccessToken 方法，获取的到用户的基本信息；步骤4，根据步骤三中所得的数据对步骤1的变量list赋值，并且将其返回


#### service

该包下的java类是对整个项目的业务逻辑处理的实现，在该包应有三个类 `AuthorizationCodeRequestService.java` `AccessTokenRequestService.java` `UserInfoRequestService.java`

1、AuthorizationCodeRequestService，该类应是处理请求 code（github的登录授权，请求code的url）的 service

方法:

getRequestCodeUrl(): 该方法是用于生成完整的请求url，将其返回。

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
|    |   String    |步骤1，声明变量String url；步骤2，调用builder包下RequestInfoBuilder的方法buildAuthorizationCodeRequestInfo()，获取AuthorizationCodeRequestInfo实例；步骤3，通过UriComponentsBuilder组装url；步骤4，调用UriComponentsBuilder的toUriString()方法生成url，将其赋值予步骤1中声明的变量，并且将其返回|

2、AccessTokenRequestService，该类应是处理请求 token（根据获取到的code再与github交互请求token） 的service

方法: 

getAccessTokenByCode(String code)

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
|参数code，为github回调中获取得到的code  |   String    |步骤1，声明变量String token；步骤2，调用builder包下RequestInfoBuilder的方法buildAccessTokenRequestInfo()，获取AccessTokenRequestInfo实例；步骤3，根据步骤2获取到的实例和 new 关键字新建RequestEntity局部变量；步骤4，调用 agent 包下RequestAgent类的getAccessToken方法，获取得到包含token的ResponseEntity；步骤5，对ResponseEntity进行取值判断，如果token有值则将其赋值给步骤1中声明的变量token，反之返回null|

3、UserInfoRequestService，该类是请求用户基本信息（根据获取到的token，与github交互获取用户的基本信息）的service

方法: 

getUserWithAccessToken(String token)

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
|参数token，为github回调中获取得到的token  |    `List<Object>`   |步骤1，申明变量List list，作为返回值；步骤2，调用builder包下RequestInfoBuilder的方法buildUserRequestInfo()，获取UserRequestInfo实例；步骤3，声明变量HttpHeaders header，调用其set方法，设置"Authorization"对应的值为token；步骤4，根据步骤2和步骤3获取到的实例和 new 关键字新建RequestEntity局部变量；步骤5，调用 agent 包下RequestAgent类的getUserInfo方法，获取得到包含用户信息的ResponseEntity；步骤6，对ResponseEntity进行取值判断，对步骤1中申明的变量赋值，并且将其返回|

#### builder

该包下的java类是builder模式的一种的实现，新建一个`RequestInfoBuilder.java`类，通过这个类代理完成对复杂对象（domain里的entity）的构建过程。

1、成员变量（用于构建对象），在spring-boot中可以通过 `@Value("${变量名}")` 的方式获取配置文件中的值并且赋值。

| 标识 		| 类型          | 描述   |允许的操作
|------------|---------------|--------|---------
| clientId 	| String         | 项目在github中注册生成的唯一id|可读取
| scope 	| String         | 请求的授权范围标识 |可读取
| requestAuthorizeUrl 	| String         | 请求code的登录验证url |可读取
| userRequestUrl 	| String         | 与github交互请求用户数据资源的url |可读取
| clientSecret 	| String         | 该项目在github注册生成的唯一 client_Secret |可读取
| redirectUrl 	| String         | code请求之后的github回调url |可读取
| responseType 	| String         | 请求授权的类型，该项目取固定值 "code" |可读取
| redirectUrl 	| String         | 请求的授权模式，该项目中取固定值"authorization_code" |可读取

2、方法

buildAccessTokenRequestInfo(String code): 该方法用于构建domain包中的 AccessTokenRequestInfo 类

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
| 参数1， code 参数为github回调获取得到的code   |   AccessTokenRequestInfo    |步骤1，调用AccessTokenRequestInfo的构造方法获取到该entity的实例；步骤2，将该实例返回|

buildUserRequestInfo(String token): 该方法用于构建domain包中的 UserRequestInfo 类

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
| 参数1， token 参数为github回调获取得到的token   |   UserRequestInfo    |步骤1，调用UserRequestInfo的构造方法获取到该entity的实例；步骤2，将该实例返回|

buildAuthorizationCodeRequestInfo()

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
| 无   |   AuthorizationCodeRequestInfo    |步骤1，声明一个局部变量state，取值为随机生成的数；步骤2，调用UserRequestInfo的构造方法获取到该entity的实例；步骤3，将该实例返回|

#### agent

该包下的类是对调用第三方API(github)的实现，新建java类 `RequestAgent.java` 

1、成员变量

| 标识 		| 类型          | 描述   |允许的操作
|------------|---------------|--------|---------
| restTemplate 	| RestTemplate | RestTemplate是Spring提供的用于访问Rest服务的客户端，直接通过 new 关键字获取实例|

2、方法：

getAccessToken(RequestEntity<AccessTokenRequestInfo> requestEntity, ParameterizedTypeReference<Map<String, Object>> typeReference): 该方法中通过RestTemplate与github交互而获取到 token 返回值

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
| 参数1，requestEntity为请求url中requestBody的参数承载体；参数2，typeReference为返回值的参数泛型类型   |   ResponseEntity<Map<String, Object>>    |通过RestTemplate调用方法exchange()，获取得到ResponseEntity，将其返回|

getUserInfo(RequestEntity<String> requestEntity, ParameterizedTypeReference<List<Object>> typeReference): 该方法中通过RestTemplate与github交互而获取用户基本信息返回

|  参数          | 返回值类型  | 描述
|---------------------------|--------|---------
| 参数1，requestEntity为请求url中requestBody的参数承载体；参数2，typeReference为返回值的参数泛型类型   |   ResponseEntity<List<Object>>    |通过RestTemplate调用方法exchange()，获取得到ResponseEntity，将其返回|


#### 项目的参数配置文件

* bootstrap.yml

* application.yml

* log4j2.xml




#### 依赖配置文件pom.xml
项目pom.xml文件继承 [cde-parent](https://github.com/seedyee/cde-parent) 项目的依赖配置。
