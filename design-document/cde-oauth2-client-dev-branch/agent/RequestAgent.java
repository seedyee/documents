class RequestAgent {

/**
 * 根据获取的code，请求token.
 */
getAccessToken(final String code){
    第一步：根据 RequestInfoBuilder 中的 getOAuth20Service 获取获取到 Auth20Service。
    第二步：利用 Auth20Service 的同步或者异步的方法获取到 token。
    第三步：将token返回出去。

  }

/**
 *
 * 根据获取的token，请求用户基本信息.
 */
getUserInfo(final OAuth2AccessToken token) {
    第一步：根据 RequestInfoBuilder 中的 getOAuth20Service 获取获取到 Auth20Service。
    第二步：利用 Auth20Service 的同步或者异步的方法获取到返回数据。
    r第三步：将用户数据返回出去。
  }
}
