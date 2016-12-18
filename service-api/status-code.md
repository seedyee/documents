# 返回码文档

## 一、服务返回码

### 1.1、认证服务与用户服务返回码表

| Code	  | Name                              | Description                                 | Chinese Description
|---------|-----------------------------------|---------------------------------------------|---------------------
| 1000010	|	EXISTED_ACCOUNT			         |account already exists                        | 账户已存在
| 1000011 |  INVALID_ACCOUNT_ID               | invalid account id                           | 无效的用户id
| 1000020	|	UNMATCHED_ACCOUNT_AND_PASSWORD   |account and password do not match            | 账户与密码不匹配
| 1000021 |  UNMATCHED_PASSWORD1_AND_PASSWORD2|password1 and password2 do not match         | 两次密码不匹配
| 1000030	|	UNVERIFIED_EMAIL		             |email has not been verified                  | 邮箱未验证
| 1000040 |	UNASSOCIATED_ACCOUNT_AND_EMAIL   | account and email have not bean associated  | 账户与邮箱未关联
| 1000050 |	UNVERIFIED_MOBILE		         | mobile has not bean verified                 | 电话号码未验证
| 1000060 |	UNASSOCIATED_ACCOUNT_AND_MOBILE| account and email have not bean associated    | 账户与电话号码未关联
| 1000070 |	USED_EMAIL				         | email has been used                          | 该邮箱已被使用
| 1000080 |	USED_MOBILE			            | mobile has been used                         | 该电话号码已被使用
| 1000090 |	UNDELETABLE_DEFAULT_EMAIL	      | default email cannot be deleted              | 不可删除默认邮箱
| 1000100 |	UNDELETABLE_DEFAULT_MOBILE	      | default mobile cannot be deleted             | 不可删除默认电话号码
| 1000110 |  ILLEGAL_ACCOUNT_NAME             | illegal account name                         | 非法的用户名
| 1000111 |  ILLEGAL_PASSWORD                 | illegal password                             | 非法的密码字符
| 1000112 |  ILLEGAL_EMAIL                    | illegal email                                | 非法的邮箱字符
| 1000113 |  ILLEGAL_MOBILE                   | illegal mobile                               | 非法的移动电话号码字符
| 1000114 |  MISS_REQUIRED_PARAMETER          | miss required parameter                      | 缺少必要参数	


## 二、系统状态码

| Code		|	Name                             | Description                                  | Chinese Description
|---------|-----------------------------------|-----------------------------------------------|---------------------
| 9999999	|	SYSTEM_ERROR	                   | system error                                  | 系统错误
| 9990010 |  INSERT_FAILED                    | insert failed                                 | 插入数据失败
| 9990020 |  UPDATE_FAILED                    | update failed                                 | 更新数据失败
| 9990030 |  DELETE_FAILED                    | delete failed                                 | 删除数据失败
