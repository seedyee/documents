/**
 * 项目实体，主要描述项目的相关信息,数据存储到 cde-account-service数据库中名为project的collection中
 */

class Project {

	/**
	 * 主键，项目的唯一标识. 使用mongodb的主键生成策略
	 */
	String id;

	/**
	 * 项目所有者id.
	 */
	String accountId;

	/**
	 * 项目参与者id集合.
	 */
	List<String> members;

	/**
	 * 项目名称.
	 */
	String projectName;

	/**
	 * 项目描述.
	 */
	String describe;

	/**
	 * 该项目是否是公开.
	 */
	boolean isPublice;

	/**
	 * 项目创建时间.
	 */
	Date timestamp;

	//省略get和set方法

}