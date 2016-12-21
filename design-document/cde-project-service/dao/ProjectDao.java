
public interface ProjectDao {
	
	/**
	 * 更行项目基本信息
	 * @param  project 要更新的项目的信息，包含项目id
	 * @return 更新成功返回1，否则返回-1
	 */
	int updateProject(Project project);

	/**
	 * 获取项目成员的id集合
	 * @param  objectId 项目id
	 * @return 返回项目成员的id集合
	 */
	List<String> findProjectMembersId(String objectId);

	/**
	 * 添加项目成员id
	 * @param  objcetId  项目id
	 * @param  accountId 用户id
	 * @return 添加成功返回1，否则返回-1
	 */
	int addProjectMember(String objcetId, String accountId);

	/**
	 * 删除项目成员id
	 * @param  objcetId  项目id
	 * @param  accountId 用户id
	 * @return 删除成功返回1，否则返回-1
	 */
	int deleteProjectMember(String objcetId, String accountId);
	
}