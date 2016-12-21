
public interface ProjectRepository extends Repository<Project, String> {

	/**
	 * 查询所有的项目，其中包括我创建的和我参与的项目。
	 * @param  accountId 用户id
	 * @return 返回查询出来的结果
	 */
	List<Project> findByAccountIdOrMembers(String accountId);

	/**
	 * 根据用户id查询该用户创建的所有项目的集合
	 * 
	 * @param  accountId 用户id
	 * @return 返回用户创建的项目的集合
	 */
	List<Project> findByAccountId(String accountId);

	/**
	 * 根据用户id查询用户参与的所有项目的集合
	 * 
	 * @param  accountId 用户id
	 * @return  返回用户参与的所有项目的集合
	 */
	List<Project> findByMembers(String accountId);

	/**
	 * 根据项目id获取项目的详细信息
	 * 
	 * @param  id 项目id
	 * @return 返回项目的详细信息
	 */
	Project findById(String id);
	
}