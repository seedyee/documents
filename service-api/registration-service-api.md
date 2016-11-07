####微服务-认证服务API文档

######1、用户登录
	url: /authc/sigin		|	method: post
parameter list:

- principal: string		|	用户名或者邮箱
- password: string
- verifyCode: string		|	校验码（保留）

return result:	{result: {key: value, key: value, ...}, error: code}
- - - -
######2、退出登录
	url: /authc/signout		|	method: post
parameter list:

- id: string

return result:	{error: code}
- - - -
- - - -
####微服务-用户账号服务API文档
######1、用户注册

	url: /users	|	method: post
parameter list:

- email: string
- usersname: string
- password:string
- verifyCode: string		|	校验码（保留）


return : {result: {key: value, key: value, ...}, error: code}
- - - -

######2、查询用户
	url: /users/:id		|	method: get
parameter list:

- id: string

return : {result:{ basicsInformation: {...}, mobiles: [{...}, {...}, ...],   emails: [{...}, {...}, ...] }, error: code}

基本信息：basicsInformation

- id: string
- usersname: string	|	用户名
- avatar: string	|	用户头像url
- company: string	|	所在公司
- companyAddress: string	|		公司地址
- companyBusiness: string	|	行业
- posation: string	|	职业
- personal: string	|	个人简介
- registrationDate: data	|	注册时间
- realName: string	|	用户真实姓名

电话信息：mobiles（电话认证--保留）

- id: string
- mobile: string	|	电话
- isDefault: string	|	是否默认（1-默认，0）
- isVerify: string 		|		是否认证（1-认证，0)

邮箱信息：emails

- id: string
- email: string	|	邮箱名
- isDefault: string	|	是否默认（1-默认，0）
- isApprove: string	|	是否认证（1-认证，0）字段名
- foreignState: string 		|	是否公开（primary || private） 

- - - -

######3、修改用户
	url: /users/ :id/mobiles || id/emails || id/bsinformation		|	method: post
parameter list:

- basicsInformation: {key: value, key: value, ...}
- mobiles: {key: value, key: value, ...}
- emails: {key: value, key: value, ...}

return : {result:{ basicsInformation: {...}, mobiles: [{...}, {...}, ...],   emails: [{...}, {...}, ...] }, error: code}

基本信息：basicsInformation

- id: string
- password: string 
- newPassword: string
- 其它字段信息请看查询用户的API

电话信息：mobiles

- id: string
- isDefault: string	|	是否默认（1-默认，0）

邮箱信息：emails

- id: string
- isDefault: string	|	是否默认（1-默认，0）
- foreignState: string 		|	是否公开（primary || private）

- - - -

######4、新增邮箱或者电话
	url: /users/:id/email || id/mobile		|	method: post
parameter list:

- mobile: {key: value, key: value, ...}
- email: {key: value, key: value, ...}

return : {result:{mobiles: [{...}, {...}, ...],   emails: [{...}, {...}, ...] }, error: code}

电话信息：mobile

- phone: string

邮箱信息：email

- email: string

- - - -

######5、删除用户信息（邮箱信息、手机信息）
	url: /users/delete		|	method: post
parameter list:

- mobiles: [id, ...]
- emails: [id, ...]

return : {result:{mobiles: [{...}, {...}, ...],   emails: [{...}, {...}, ...] }, error: code}

电话信息：mobiles

- id: string

邮箱信息：emails

- id: string

- - - -

日志微服务
######6、查询安全信息
	url: /users/:id/security		|	method: get
parameter list:

- id: string

return : {result:{sessions: [{...}, {...}, ...],    logs : [{...}, {...}, ...] }, error: null}

会话信息：sessions

- ip: string	|	当前id
- lastVisit: date	|	最后访问时间
- equipment: string		|	设备
- location: string		|	位置
- loginTime: date		|	登录时间

安全日志：logs

- id: string
- action: string	|	操作
- actor: string		|	操作人
- actorIp: string		|	操作机器ip
- actorLocation: string		|	当前位置
- createdTime: date		|	操作时间
- user: string		|	所属用户
