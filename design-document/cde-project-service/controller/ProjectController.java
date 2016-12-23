/**
 * api
 */

@RestController
public class ProjectController {

	/**
	 * 获取用户项目信息
	 * @param  request 请求对象
	 * @return 返回用户项目信息
	 */
	@RequestMapping(value = "/accounts/projects/all", method = RequestMethod.GET)
	public List<Project> getAllProject(final HttpServletRequest request) {
		第一步： 从request中获取用户id
		第二步： 第一步中获取到的用户id作为参数，执行 ProjectServiceImpl 中的 getAllProject 方法，获取到用户项目信息
		第三步： 返回第二步中获取的用户的项目信息
	}

	/**
	 * 获取用户创建项目信息
	 * @param  request 请求对象
	 * @return 返回用户创建项目信息
	 */
	@RequestMapping(value = "/accounts/projects/created", method = RequestMethod.GET)
	public List<Project> getCreatedProject(final HttpServletRequest request) {
		第一步： 从request中获取用户id
		第二步： 第一步中获取到的用户id作为参数，执行 ProjectServiceImpl 中的 getCreatedProject 方法，获取到用户创建的项目信息
		第三步： 返回第二步中获取的用户创建的项目信息
	}

	/**
	 * 获取用户参与的项目信息
	 * @param  request 请求对象
	 * @return 返回用户参与项目信息
	 */
	@RequestMapping(value = "/accounts/projects/joined", method = RequestMethod.GET)
	public List<Project> getJoinedProject(final HttpServletRequest request) {
		第一步： 从request中获取用户id
		第二步： 第一步中获取到的用户id作为参数，执行 ProjectServiceImpl 中的 getJoinedProject 方法，获取到用户参与的项目信息
		第三步： 返回第二步中获取的用户参与创建的项目信息
	}

	/**
	 * 获取用户关注的项目信息
	 * @param  request 请求对象
	 * @return 返回用户关注的项目信息
	 */
	@RequestMapping(value = "/accounts/projects/watched", method = RequestMethod.GET)
	public List<Project> getWatchedProject(final HttpServletRequest request) {
		第一步： 从request中获取用户id
		第二步： 第一步中获取到的用户id作为参数，执行 ProjectServiceImpl 中的 getWatchedProject 方法，获取到用户关注的项目信息
		第三步： 返回第二步中获取的用户关注创建的项目信息
	}

	/**
	 * 获取用户收藏的项目信息
	 * @param  request 请求对象
	 * @return 返回用户关注的项目信息
	 */
	@RequestMapping(value = "/accounts/projects/collect", method = RequestMethod.GET)
	public List<Project> getCollectionProject(final HttpServletRequest request) {
		第一步： 从request中获取用户id
		第二步： 第一步中获取到的用户id作为参数，执行 ProjectServiceImpl 中的 getCollectionProject 方法，获取到用户收藏的项目信息
		第三步： 返回第二步中获取的用户收藏创建的项目信息
	}

	/**
	 * 获取项目信息
	 * @param  projectId 项目id
	 * @return 返回项目信息
	 */
	@RequestMapping(value = "/accounts/projects/{id}", method = RequestMethod.GET)
	public List<Project> getProjectInfo(@PathVariable final String projectId) {
		第一步： projectId 作为参数，执行 ProjectServiceImpl 中的 getProjectInfo 方法，获取到项目信息
		第二步： 返回第一步中获取的获取到项目信息
	}

	/**
	 * 创建项目
	 * @param request 请求对象
	 * @param project 项目对象
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "/accounts/projects/create", method = RequestMethod.POST)
	public ErrorInfo createProject(final HttpServletRequest request, @RequestBody final Project project) {
		第一步： 获取用户id
		第二步： 判断传递的参数是否符合规则
		第三步： 执行 ProjectServiceImpl 中的 createProject 方法。出现异常则返回错误信息
		第四步： 第三步没有出现异常返回操作成功
	}

	/**
	 * 修改项目信息
	 * @param request 请求对象
	 * @param projectId 项目id
	 * @param project 项目对象
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "/accounts/projects/{id}/update", method = RequestMethod.POST)
	public ErrorInfo updateProjectInfo(final HttpServletRequest request, @PathVariable final String projectId, final Project project) {
		第一步： 获取用户id
		第二步： 判断传递的参数是否符合规则
		第三步： 执行 ProjectServiceImpl 中的 updateProjectInfo 方法。出现异常则返回错误信息
		第四步： 第三步没有出现异常返回操作成功 
	}

	/**
	 * 删除项目信息
	 * @param projectId 项目id
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "/accounts/projects/{id}/delete", method = RequestMethod.POST)
	public ErrorInfo deleteProject(@PathVariable final String projectId) {
		第一步： 执行 ProjectServiceImpl 中的 deleteProject 方法。出现异常则返回错误信息
		第二步： 第一步没有出现异常返回操作成功 
	}

	/**
	 * 获取项目成员
	 * @param projectId 项目id
	 * @return 返回项目成员信息
	 */
	@RequestMapping(value = "/projects/{id}/members", method = RequestMethod.GET)
	public List<Member> getProjectMembers(@PathVariable final String objectId) {
		第一步： 执行 ProjectServiceImpl 中的 getProjectMembers 方法。获取项目成员信息
		第二步： 返回第一步中获取的项目成员信息
	}


	/**
	 * 添加项目成员
	 * @param projectId 项目id
	 * @param accountId 要添加的成员id
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "/projects/{id}/members", method = RequestMethod.POST)
	public ErrorInfo addProjectMember(@PathVariable final String objectId, final String accountId) {
		第一步： 获取参数并判断
		第二步： 执行 ProjectServiceImpl 中的 addProjectMember 方法。
		第三步： 返回操作结果
	}

	/**
	 * 删除项目成员
	 * @param projectId 项目id
	 * @param accountId 要删除的成员id
	 * @return 返回操作结果
	 */
	@RequestMapping(value = "/projects/{id}/members", method = RequestMethod.DELETE)
	public ErrorInfo deleteProjectMember(@PathVariable final String objectId, final String accountId) {
		第一步： 获取参数并判断
		第二步： 执行 ProjectServiceImpl 中的 deleteProjectMember 方法。
		第三步： 返回操作结果
	}

}