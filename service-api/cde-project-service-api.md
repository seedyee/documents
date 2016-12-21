####微服务-用户项目信息服务API接口

* api中所需的用户id从jwt中获取，不需要在url中作为一个参数传递

######1、查询所有项目

	url: /accounts/projects/all
	method: get


return [{key: value, ...}, {key: value, ...}, ...]

return parameter list:

- id: string 	| 	项目的id
- projectName:  |	项目名称
- boolean 		| isPublic: 公开/私有

- - - -

######2、我创建的项目

	url: /accounts/projects/created
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

return parameter list:

- id: string 	| 	项目的id
- projectName:  |	项目名称
- boolean 		| isPublic: 公开/私有

- - - -

######3、我参与的项目

	url: /accounts/projects/joined
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

return parameter list:

- id: string 	| 	项目的id
- projectName:  |	项目名称
- boolean 		| isPublic: 公开/私有
- - - -

######4、我关注的项目

	url: /accounts/projects/watched
	method: get
	

return [{key: value, ...}, {key: value, ...}, ...]

return parameter list:

- id: string 	| 	项目的id
- projectName:  |	项目名称
- boolean 		| isPublic: 公开/私有
- - - -

######5、我收藏的项目

	url: /accounts/projects/collect
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

return parameter list:

- id: string 	| 	项目的id
- projectName:  |	项目名称
- boolean 		| isPublic: 公开/私有

- - - -

######6、查询项目的基本信息

	url: /accounts/projects/{id}
	method: get
	

return : {key: value, key: value, ...}

return parameter list:

- id: string    |  项目的id
- projectName: String  |  项目名称
- describe: string  |  项目描述
- isPublic: boolean |  公开/私有
- members: List    | 项目成员(用户名)

- - - -

######7、添加项目

	url: /accounts/projects/create
	method: post
	
parameter list:

- List    | members: 项目成员(用户id的集合)
- String  | projectName: 项目名称
- String  | describe: 项目描述
- boolean | isPublic: 公开/私有

return : {code: value, message: value}

- - - -

######8、更新项目基本信息

	url: /accounts/projects/{id}/update
	method: post

parameter list:

- String  | projectName: 项目名称
- String  | describe: 项目描述
- boolean | isPublic: 公开/私有

return : {code: value, message: value}

- - - -

######9、删除项目

	url: /accounts/projects/{id}/delete
	method: delete

return : {code: value, message: value}

- - - -

######10、搜索成员

	url: /accounts/projects/members
	method: get

parameter list:

- principal: String  |  用户名、邮箱名

return [{key: value, ...}, {key: value, ...}, ...]

return parameter list:

- id: string |  用户id
- principal: string    | 项目成员(用户名)

- - - -

######11、查询项目成员

	url: /projects/{id}/members
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

return parameter list:

- id: string |  用户id
- principal: string    | 项目成员(用户名)

- - - -

######12、添加项目成员

	url: /projects/{id}/members
	method: post

parameter list:

- String  | id: 用户id

return : {code: value, message: value}

- - - -

######13、删除项目成员

	url: /projects/{id}/members
	method: delete

parameter list:

- String  | id: 用户id

return : {code: value, message: value}

- - - -

######14、添加关注项目

	url: /projects/{id}/watched
	method: get

parameter list:

- String  | id: 关注项目的id

return : {code: value, message: value}

- - - -

######15、添加收藏项目

	url: /projects/{id}/collect
	method: get

parameter list:

- String  | id: 收藏项目的id

return : {code: value, message: value}

- - - -



项目实体对象 project:

* id: String  | 	主键
* accountId: String  |	 	项目所有者
* members: List    |	项目成员(用户id的集合)
* projectName: String  |	 项目名称
* describe: String  |	 项目描述
* isPublic: boolean |	 公开/私有
* timestamp: Data    |  创建时间

项目成员实体对象 member:

* id: String 	| 	用户id
* principal: string 	|	成员名(可不存储于数据库)

- - - -