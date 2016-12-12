//该类文件是调用cde-oauth-service的登录接口进行登录操作
@FeignClient("authc-service")
public interface OAuthClient {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    String signin();
}