
/*
 *定义接口，具体实现与相关描述请查看ProjectServiceImpl.java文件
 */
public interface ProjectService {

	/**
	 * 获取用户所有项目信息
	 * @param  accountId 用户id
	 * @return 返回用户所有项目信息
	 */
	List<Project> getAllProject(final String accountId);

	/**
	 * 获取用户创建的项目信息
	 * @param  accountId 用户id
	 * @return 返回用户创建的项目的信息
	 */
	List<Project> getCreatedProjects(final String accountId);

	/**
	 * 获取用户参与的项目的信息
	 * @param  accountId 用户id
	 * @return 返回用户参与的项目的信息
	 */
	List<Project> getJoinedProjects(final String accountId);

	/**
	 * 获取用户关注的项目的信息
	 * @param  accountId 用户id
	 * @return 返回用户关注的项目的信息
	 */
	List<Project> getWatchedProjects(final String accountId);
	
	/**
	 * 获取用户收藏的项目的信息
	 * @param  accountId 用户id
	 * @return 返回用户收藏的项目的信息
	 */
	List<Project> getCollectionProjects(final String accountId);

	/**
	 * 获取项目的基本信息
	 * @param  projectId 项目id
	 * @return 返回项目的基本信息
	 */
	Project getProjectInfo(final String accountId, final String projectId);

	/**
	 * 创建项目
	 * @param  projectId 项目id
	 * @param project 需要创建的项目信息
	 */
	void createProject(final String accountId, final Project project);

	/**
	 * 修改项目的基本信息
	 * @param  projectId 项目id
	 * @param project 需要修改项目的信息
	 */
	void updateProjectInfo(final String accountId, final Project project);

	/**
	 * 删除项目
	 * @param 项目id
	 */
	void deleteProject(final String projectId);

	/**
	 * 获取项目成员的信息
	 * @param  objectId 项目id
	 * @return 返回项目成员的信息
	 */
	List<Member> getProjectMembers(final String objectId);

	/**
	 * 添加项目成员
	 * @param objectId  项目id
	 * @param accountId 要添加的成员的id
	 */
	void addProjectMember(final String objectId, final String accountId);

	/**
	 * 删除项目成员
	 * @param objectId  项目id
	 * @param accountId 成员id
	 */
	void deleteProjectMember(final String objectId, final String accountId);

}