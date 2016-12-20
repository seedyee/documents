####微服务-认证服务API接口

######1、用户登录
	url: /authc/signin
	method: post
parameter list:

- principal: string		|	用户名或者邮箱
- password: string
- verifyCode: string		|	校验码（保留）

return result:	{result: {key: value, key: value, ...}, error: {code: value, message: value}}

- - - -
######2、退出登录
	url: /authc/signout	
	method: post
parameter list:

- id: string

return result:	{error: {code: value, message: value}}

- - - -
- - - -

####微服务-用户账号服务API接口
######1、用户注册

	url: /accounts	
	method: post
parameter list:

- email: string
- name: string
- password:string
- verifyCode: string		|	校验码（保留）


error: {code: value, message: value}}

- - - -

######2、查询用户
	url: /accounts/{id}/mobiles || {id}/emails || {id}/basicInfo
	method: get
parameter list:

return {key: value, key: value, ...}
基本信息：basicInfo

- id: string
- name: string	|	用户名
- avatar: string	|	用户头像url
- company: string	|	公司
- address: string	|	地址
- business: string	|	行业
- position: string	|	职位
- personal: string	|	个人介绍
- timestamp: data	|	注册时间
- realName: string	|	用户真实姓名
- email: string		|	默认邮箱
- mobile: string	   |	默认电话
- publicEmail: boolean 	|	邮箱是否公开(true-公开，false)
- publicMobile: boolean	|	电话是否公开(true-公开，false)

电话信息：mobiles（电话认证--保留）

- mobileId: string
- mobile: string	|	电话
- public: boolean | 是否公开 (true-公开，false)
- default: boolean | 是否默认 (true-默认，false)
- verified: boolean 		|		是否认证（true-认证，false)

邮箱信息：emails

- emailId: string
- email: string	|	邮箱名
- public: boolean | 是否公开 (true-公开，false)
- default: boolean | 是否默认 (true-默认，false)
- verified: boolean	|	是否认证（true-认证，false）

- - - -

######3、修改用户
	url: /accounts/{id}/mobiles/{id} || {id}/emails/{id} || {id}/password || {id}/basicInfo	|| {id}/name method: post
parameter list:

- basicsInfo: {key: value, key: value, ...}
- mobile: {key: value, key: value, ...}
- email: {key: value, key: value, ...}
- password: {key: value, key: value, ...}

return : {code: value, message: value}

基本信息：basicsInfo

- 其它字段信息请看查询用户的API

电话信息：mobiles

- verified: boolean	|	是否认证（true-认证，false）
- public : boolean  |  是否公开（true-认证，false）

邮箱信息：emails

- verified: boolean	|	是否认证（true-认证，false）
- public : boolean  |  是否公开（true-认证，false）

修改密码

- password: string
- password1: string
- password2: string

修改用户名

- name: string

- - - -

######4、新增邮箱或者电话
	url: /accounts/{id}/emails || {id}/mobiles
	method: post
parameter list:

- {key: value, key: value, ...}

return : {code: value, message: value}

电话信息：mobile

- mobile: string

邮箱信息：email

- email: string

- - - -

######5、删除用户信息（邮箱信息、手机信息）
	url: /accounts/{id}/mobiles/{id} || {id}/emails/{id}  
	method: DELETE

return : {code: value, message: value}

电话信息：mobiles

邮箱信息：emails

- - - -
- - - -

####微服务-日志服务API接口

######6、查询安全信息
	url: /accounts/{id}/sessionLog	|| {id}/securityLog
	method: get
parameter list:

- id: string

return result:	{result: {key: value, key: value, ...}, error: {code: value, message: value}}

会话信息：sessionLog

- ip: string	|	当前id
- lastVisit: date	|	最后访问时间
- equipment: string		|	设备
- location: string		|	位置
- timestamp: date		|	登录时间

安全日志：securityLog

- id: string
- action: string	|	操作
- actor: string		|	操作人
- actorIp: string		|	操作机器ip
- actorLocation: string		|	当前位置
- timestamp: date		|	操作时间
- user: string		|	所属用户
