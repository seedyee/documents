#返回码文档
##一、服务返回码
###1.1 认证服务与用户服务返回码表
| code		| 错误代码           			|	中文描述             |  英文描述
|---------|-------------------------	|----------------------|------------------
| 1000001	|	ACCOUNT_EXISTED 			|	该用户已经存在        | the account has existed
| 1000020	|	ILLEGAL_ACCOUNT_PASSWORD|	用户名与密码不匹配     | the account and the password is mismatching
| 1000040	|	EMAIL_NOT_VERIFIED		|	邮箱没有通过验证      |  the email is not verified
| 1000060 |	ACCOUNT_NOT_EMAIL		|  用户没有关联该邮箱     |  the account is not attached to the email
| 1000080 |	MOBILE_NOT_VERIFIED		|  该电话还没有认证       |  the mobile is not verified
| 1000100 |	ACCOUNT_NOT_MOBILE		|  用户没有关联该电话号码  |  the account is not attached the mobile
| 1000120 |	EMAIL_EXISTED				|  该邮箱已经被使用过     | the email has existed 
| 1000140 |	MOBILE_EXISTED			|  该号码已经被使用过     | the mobile has existed
| 1000160 |	ILLEGAL_DELETE_EMAIL	|  默认邮箱不能删除       | the default email could not be deleted
| 1000180 |	ILLEGAL_DELETE_MOBILE	|  默认电话不能删除       | the default mobile could not be deleted




##二、系统状态码
| code		|	错误代码		|	描述               |   英文描述
|---------|----------------|--------------------|--------------
| 9999999	|	SYSTEM_ERROR	|	系统错误，请联系管理员| system error, please contact your administrator


