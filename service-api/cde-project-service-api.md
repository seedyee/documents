####微服务-用户项目服务API接口

* api中所需的用户id从jwt中获取，不需要在url中作为一个参数传递

######1、查询所有项目

	url: /accounts/projects/all
	method: get


return [{key: value, ...}, {key: value, ...}, ...]

- - - -

######1、我创建的项目

	url: /accounts/projects/created
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

- - - -

######1、我参与的项目

	url: /accounts/projects/joined
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

- - - -

######1、我关注的项目

	url: /accounts/projects/watched
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

- - - -

######1、我收藏的项目

	url: /accounts/projects/stared
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

- - - -

######1、添加项目

	url: /accounts/projects/create
	method: post
	
return : {code: value, message: value}

- - - -

######1、更新项目

	url: /accounts/projects/{id}/update
	method: post

return : {code: value, message: value}

- - - -

######1、删除项目

	url: /accounts/projects/{id}/del
	method: delete

return : {code: value, message: value}

- - - -

######1、搜索成员

	url: /accounts/projects/members
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

- - - -

######1、查询项目成员

	url: /projects/{id}/members
	method: get

return [{key: value, ...}, {key: value, ...}, ...]

- - - -

######1、添加项目成员

	url: /projects/{id}/members
	method: post

return : {code: value, message: value}

- - - -

######1、删除项目成员

	url: /projects/{id}/members
	method: delete

return : {code: value, message: value}

- - - -


项目实体对象 project:

* String  | id: 主键
* String  | accountId: 项目所有者
* List    | members: 项目成员(用户id的集合)
* String  | projectName: 项目名称
* String  | describe: 项目描述
* boolean | isPublic: 公开/私有
* Data    | timestamp: 创建时间

- - - -