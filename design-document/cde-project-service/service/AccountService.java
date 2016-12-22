
/**
 * 定义接口，具体实现与相关描述请查看AccountServiceImpl.java文件
 */

public interface AccountService {

	/**
	 * 根据用户名或邮箱名获取用户信息，只返回用户id和用户名
	 * @param  principal 用户名或邮箱名
	 * @return 返回Member信息
	 */
	Member getMemberByPrincipal(final String principal);

	/**
	 * 为用户添加关注的项目
	 * @param accountId 用户id
	 * @param projectId 项目id
	 */
	void addWatchedProject(final String accountId, final String projectId);

	/**
	 * 删除用户关注的项目
	 * @param accountId 用户id
	 * @param projectId 项目id
	 */
	void deleteWatchedProject(final String accountId, final String projectId);

	/**
	 * 为用户添加收藏项目
	 * @param accountId 用户id
	 * @param projectId 项目id
	 */
	void addCollectionProject(final String accountId, final String projectId);

	/**
	 * 删除用户收藏的项目
	 * @param accountId 用户id
	 * @param projectId 项目id
	 */
	void deleteCollectionProject(final String accountId, final String projectId);


}