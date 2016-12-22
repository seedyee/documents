
/**
 * 该类实现ProjectService.java接口中的方法，并对实现步骤说明。
 */
public class ProjectServiceImpl implements ProjectService {
	/**
	 * 获取用户所有项目信息
	 * @param  accountId 用户id
	 * @return 返回用户所有项目信息
	 */
	public List<Project> getAllProject(final String accountId) {
		第一步：执行 ProjectRepository 中的 findByAccountIdOrMembers() 方法，获取到用户所有项目信息List
		第二步：返回用户所有项目信息List
	}

	/**
	 * 获取用户创建的项目信息
	 * @param  accountId 用户id
	 * @return 返回用户创建的项目的信息
	 */
	public List<Project> getCreatedProject(final String accountId) {
		第一步： 执行 ProjectRepository 中的 findByAccountId() 方法，获取到用户创建的项目信息List
		第二步： 返回用户创建的项目的信息
	}

	/**
	 * 获取用户参与的项目的信息
	 * @param  accountId 用户id
	 * @return 返回用户参与的项目的信息
	 */
	public List<Project> getJoinedProject(final String accountId) {
		第一步： 执行 ProjectRepository 中的 findByMembers() 方法，获取到用户参数的项目信息
		第二步： 返回用户参与的项目的信息 
	}

	/**
	 * 获取用户关注的项目的信息
	 * @param  accountId 用户id
	 * @return 返回用户关注的项目的信息
	 */
	public List<Project> getWatchedProject(final String accountId) {
		第一步： 执行 AccountDao 中的 findWatchedProject() 方法，获取到用户关注的项目id集合
		第二步： 根据第一步中获取到的用户关注的项目id集合执行 ProjectDao 中的 findAccountProjects() 方法，获取项目信息集合
		第三步： 返回用户关注的项目信息集合
	}
	
	/**
	 * 获取用户收藏的项目的信息
	 * @param  accountId 用户id
	 * @return 返回用户收藏的项目的信息
	 */
	public List<Project> getCollectionProject(final String accountId) {
		第一步： 执行 AccountDao 中的 findCollectionProject() 方法，获取到用户收藏的项目id集合
		第二步： 根据第一步中获取到的用户收藏的项目id集合执行 ProjectDao 中的 findAccountProjects() 方法，获取项目信息集合
		第三步： 返回用户收藏的项目信息集合
	}

	/**
	 * 获取项目的基本信息
	 * @param  projectId 项目id
	 * @return 返回项目的基本信息
	 */
	public Project getProjectInfo(final String projectId) {
		第一步： 执行 ProjectRepository 中的 findById() 方法，获取项目基本信息
		第二步： 返回项目基本信息，若项目部存在返回null
	}

	/**
	 * 创建项目
	 * @param project 需要创建的项目信息
	 */
	public void createProject(final Project project) {
		第一步： 执行 ProjectRepository 中的 save() 方法
		第二步： 判断第一步返回的结果，若为空，则抛出创建失败异常
	}

	/**
	 * 修改项目的基本信息
	 * @param project 需要修改项目的信息
	 */
	public void updateProjectInfo(final Project project) {
		第一步： 执行 ProjectDao 中的 updateProject() 方法
		第二步： 判断第一步返回的结果，若为-1，则抛出更新失败异常
	}

	/**
	 * 删除项目
	 * @param 项目id
	 */
	public void deleteProject(final String projectId) {
		第一步： 执行 ProjectRepository 中的 delete() 方法
		第二步： 判断第一步返回的结果
	}

	/**
	 * 获取项目成员的信息
	 * @param  objectId 项目id
	 * @return 返回项目成员的信息
	 */
	public List<Member> getProjectMembers(final String objectId) {
		第一步： 执行 ProjectDao 中的 findProjectMembersId() 方法，获取项目成员id集合
		第二步： 根据第一步中获取到的项目成员的id集合执行 AccountDao 中的 findProjectMembers() 方法，获取项目成员信息
		第三步： 返回第二步中获取到的项目成员信息
	}

	/**
	 * 添加项目成员
	 * @param objectId  项目id
	 * @param accountId 要添加的成员的id
	 */
	public void addProjectMember(final String objectId, final String accountId) {
		第一步： 执行 ProjectDao 中的 addProjectMember() 方法
		第二步： 判断第一步返回的结果，若为-1，则抛出添加失败异常
	}

	/**
	 * 删除项目成员
	 * @param objectId  项目id
	 * @param accountId 成员id
	 */
	public void deleteProjectMember(final String objectId, final String accountId) {
		第一步： 执行 ProjectDao 中的 deleteProjectMember() 方法
		第二步： 判断第一步返回的结果，若为-1，则抛出更新失败异常
	}

}