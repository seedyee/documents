
/**
 * 该类主要是实现AccountService.java 接口中的方法，并对说明实现步骤
 */

public class AccountServiceImpl implements AccountService {

	/**
	 * 根据用户名或邮箱名获取用户信息，只返回用户id和用户名
	 * @param  principal 用户名或邮箱名
	 * @return 返回Member信息
	 */
	public Member getMemberByPrincipal(String principal) {
		第一步： 调用 AccountDao 中的 findMember() 方法，获取Member信息
		第二步： 返回第一步中获取的Member信息
	}

	/**
	 * 为用户添加关注的项目
	 * @param accountId 用户id
	 * @param projectId 项目id
	 */
	public void addWatchedProject(String accountId, String projectId) {
		第一步： 调用 AccountDao 中的 addWatchedProject() 方法
		第二步： 判断第一步返回的结果，若为-1，则抛出添加失败异常
	}

	/**
	 * 删除用户关注的项目
	 * @param accountId 用户id
	 * @param projectId 项目id
	 */
	public void deleteWatchedProject(String accountId, String projectId) {
		第一步： 调用 AccountDao 中的 deleteWatchedProject() 方法
		第二步： 判断第一步返回的结果，若为-1，则抛出删除失败异常
	}

	/**
	 * 为用户添加收藏项目
	 * @param accountId 用户id
	 * @param projectId 项目id
	 */
	public void addCollectionProject(String accountId, String projectId) {
		第一步： 调用 AccountDao 中的 addCollectionProject() 方法
		第二步： 判断第一步返回的结果，若为-1，则抛出添加失败异常
	}

	/**
	 * 删除用户收藏的项目
	 * @param accountId 用户id
	 * @param projectId 项目id
	 */
	public void deleteCollectionProject(String accountId, String projectId) {
		第一步： 调用 AccountDao 中的 deleteCollectionProject() 方法
		第二步： 判断第一步返回的结果，若为-1，则抛出删除失败异常
	}

}