#返回码文档
##一、服务返回码
###1.1 认证服务与用户服务返回码表
| code		| 错误代码           			|	中文描述             |  英文描述
|---------|-------------------------	|----------------------|------------------
| 1000001	|	ACCOUNT_EXISTED 			|	该用户已经存在        | the account has existed
| 1000002	|	ILLEGAL_PASSWORD			|	密码错误             | the password is illegal
| 1000003	|	ILLEGAL_ACCOUNT_PASSWORD|	用户名与密码不匹配     | the account and the password is mismatching
| 1000004	|	ACCOUNT_NOT_EXIST		|	用户不存在           |  the account is not     existed
| 1000005	|	EMAIL_NOT_VERIFIED		|	邮箱没有通过验证      |  the email is not verified
| 1000006 |	ACCOUNT_NOT_EMAIL		|  用户没有关联该邮箱     |  the account is not attached to the email
| 1000007 |	MOBILE_NOT_VERIFIED		|  该电话还没有认证       |  the mobile is not verified
| 1000008 |	ACCOUNT_NOT_MOBILE		|  用户没有关联该电话号码  |  the account is not attached the mobile
| 1000009 |	ILLEGAL_ARGUMENT			|  输入的参数有误        | the inputting argument is wrong
| 1000010 |	EMAIL_EXISTED				|  该邮箱已经被使用过     | the email has existed 
| 1000011 |	MOBILE_EXISTED			|  该号码已经被使用过     | the mobile has existed
| 1000012 |	ILLEGAL_DELETE_EMAIL	|  默认邮箱不能删除       | the default email could not be deleted
| 1000013 |	ILLEGAL_DELETE_MOBILE	|  默认电话不能删除       | the default mobile could not be deleted




##二、系统状态码
| code		|	错误代码		|	描述               |   英文描述
|---------|----------------|--------------------|--------------
| 9999999	|	SYSTEM_ERROR	|	系统错误，请联系管理员| system error, please contact your administrator


