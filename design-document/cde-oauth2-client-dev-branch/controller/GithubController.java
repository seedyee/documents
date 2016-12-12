public class GithubController {

/**
 * 获取登录授权url.
 */
@RequestMapping(value = "/authc-url", method = RequestMethod.GET)
authc() {
    第一步：调用 OAuth2Service 中的 getRequestCodeUrl 方法，获取到第三方用户登录授权的url
    第二步：将url返回出去
  }

@RequestMapping(value = "/callback")
callback(final HttpServletRequest request) {
    第一步：获取回调中的参数code和state
    第二步：调用 OAuth2Service 中的 check() 方法，判断state参数是否有效
    第三步：判断第二步结果，如果为true则继续执行下一步，如果没有则返回错误信息
    第四步：执行 OAuth2Service 的 getAccessTokenByCode() 方法，获取到token
    第五步：执行 OAuth2Service 的 getUserWithToken() 方法，获取到用户名或者邮箱
    第六步：根据 用户名或者邮箱 执行shiro 的登录操作
    第七步：将基本用户数据返回
  }
}