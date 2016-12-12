class OAuth2Service {

/**
 *
 * 获取用户登录授权的url.
 */
getRequestCodeUrl() {
    第一步：执行 ServiceBuilder 中的 getOAuth20Service() 方法，获取到 OAuth20Service 的实例
    第二步：根据 OAuth20Service 实例的 getAuthorizationUrl() 方法，获取到用户登录授权的url
    第三步：将url返回
  }

/**
 *
 * 根据code通过agent代理请求第三方API，获取token信息.
 */
getAccessTokenByCode(final String code) {
    第一步：执行 agent 包下的 getAccessToken() 方法，获取到token
    第二步：存储token到redis
    第二步：将token返回
  }

/**
 *
 * 根据token通过agent代理请求第三方API，获取用户基本信息.
 */
getUserWithToken(final OAuth2AccessToken token) {
    第一步：执行 agent 包下的 getUserInfo() 方法，获取到用户基本信息。
    第二步：将用户基本信息数据存入mongodb数据库
    第三步：jwt生成和redis缓存
    第四步：将用户账号或是邮箱返回，用于登录操作
  }

/**
 * 验证state是否有效
 * 
 */
check(final String state) {
    第一步：查询redis缓存，判断state是否存在。
    第二步：返回查询结果，如果存在则返回true，如果不存在则返回false
  }
}
