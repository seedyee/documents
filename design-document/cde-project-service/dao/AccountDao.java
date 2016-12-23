public interface AccountDao {

	/**
	 * 根据用户名或用户默认邮箱搜索成员
	 * @param  principal 用户名或用户邮箱
	 * @return  返回成员信息
	 */
	Member findMember(String principal);

	/**
	 * 根据用户id获取用户信息
	 * @param  accountId [description]
	 * @return           [description]
	 */
	Member findMemberById(String accountId);

	/**
	 * 获取项目成员的信息集合
	 * @param  accountIds 项目成员的id集合
	 * @return 返回项目成员信息
	 */
	List<Member> findProjectMembers(List<String> accountIds);

	/**
	 * 为用户添加关注的项目的id
	 * 
	 * @param  accountId 用户id
	 * @param  projectId 关注的项目id
	 * @return  添加成功返回1，否则返回-1
	 */
	int addWatchedProject(String accountId, String projectId);

	/**
	 * 获取用户关注项目的id集合
	 * 
	 * @param  accountId 用户id
	 * @return 返回用户关注的项目的id集合
	 */
	List<String> findWatchedProject(String accountId);

	/**
	 * 删除我关注的项目的id
	 * @param  accountId 用户id
	 * @param  projectId 项目id
	 * @return 删除成功返回1，否则返回-1
	 */
	int deleteWatchedProject(String accountId, String projectId);

	/**
	 * 为用户添加收藏的项目的id
	 * 
	 * @param  accountId 用户id
	 * @param  projectId 收藏的项目id
	 * @return  添加成功返回1，否则返回-1
	 */
	int addCollectionProject(String accountId, String projectId);

	/**
	 * 获取用户收藏项目的id集合
	 * 
	 * @param  accountId 用户id
	 * @return 返回用户收藏的项目的id集合
	 */
	List<String> findCollectionProject(String accountId);

	/**
	 * 删除我收藏的项目的id
	 * @param  accountId 用户id
	 * @param  projectId 项目id
	 * @return 删除成功返回1，否则返回-1
	 */
	int deleteCollectionProject(String accountId, String projectId);
}