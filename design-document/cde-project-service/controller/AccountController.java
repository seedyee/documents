/**
 * api
 */

@RestController
public class AccountController {

	/**
	 * 搜索用户
	 * @param  principal 用户名或用户邮箱名
	 * @return 返回用户信息
	 */
	@RequestMapping(value = "/accounts/projects/members", method = RequestMethod.GET)
	public Member getMemberByPrincipal(final String principal) {
		第一步： 获取参数并验证
		第二步： 执行 AccountServiceImpl 中的 getMemberByPrincipal 方法，获取用户信息
		第三步： 返回第二步获取的用户信息
	}

	/**
	 * 为用户添加关注项目
	 * @param  request 请求对象
	 * @param  projectId 项目id
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "accounts/projects/{id}/watched", method = RequestMethod.POST)
	public ErrorInfo addWatchedProject(final HttpServletRequest request, @PathVariable final String projectId) {
		第一步： 获取参数
		第二步： 执行 AccountServiceImpl 中的 addWatchedProject 方法
		第三步： 返回操作结果
	}

	/**
	 * 删除用户关注项目项
	 * @param  request 请求对象
	 * @param  projectId 项目id
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "accounts/projects/{id}/watched", method = RequestMethod.DELETE)
	public ErrorInfo deleteWatchedProject(final HttpServletRequest request, @PathVariable final String projectId) {
		第一步： 获取参数
		第二步： 执行 AccountServiceImpl 中的 deleteWatchedProject 方法
		第三步： 返回操作结果
	}

	/**
	 * 为用户添加收藏项目
	 * @param  request 请求对象
	 * @param  projectId 项目id
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "accounts/projects/{id}/collect", method = RequestMethod.POST)
	public ErrorInfo addCollectionProject(final HttpServletRequest request, @PathVariable final String projectId) {
		第一步： 获取参数
		第二步： 执行 AccountServiceImpl 中的 addCollectionProject 方法
		第三步： 返回操作结果
	}

	/**
	 * 删除用户收藏项目项
	 * @param  request 请求对象
	 * @param  projectId 项目id
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "accounts/projects/{id}/watched", method = RequestMethod.DELETE)
	public ErrorInfo deleteCollectionProject(final HttpServletRequest request, @PathVariable final String projectId) {
		第一步： 获取参数
		第二步： 执行 AccountServiceImpl 中的 deleteCollectionProject 方法
		第三步： 返回操作结果
	}
}