
/**
 * 不存入数据库
 */

public class Member{

	/**
	 * 用户id
	 */
	private String accountId;

	/**
	 * 项目成员名(用户名)
	 */
	private String name;

	/**
	 * 用户关注的项目的id集合
	 */
	private List<String> watchedProjects;

	/**
	 * 用户收藏的的项目的id集合
	 */
	private List<String> collectProjects;

	//省略get和set方法
}