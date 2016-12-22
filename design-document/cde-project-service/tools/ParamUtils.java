

public class ParamUtils {

	/**
	 * 项目名正则表达式规则：以大写或小写字符开头，可以包含字母，数字，“-”，“_”字符
	 */
	private static final String PROJECT_NAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_-]{1,50}$";

	/**
     * Pattern对象.
     */
    private static Pattern pattern = null;

    /**
     * Matcher对象.
     */
    private static Matcher matcher = null;

    /**
     * 匹配项目名
     * @param  name 项目名称
     * @return 匹配成功返回true,否者返回false
     * 
     */
	public static boolean isProjectName(final String name) {
		第一步： 通过 Pattern 的静态方法 compile（regex） 获取 pattern 对象
		第二步： 通过pattern 对象的 matcher(string) 方法获取 matcher对象
		第三步： 调用matcher对象的 find() 方法返回匹配结果
	}

	/**
	 * 判断是否存在为null的参数
	 * 
	 * @param  Object...objects 参数
	 * @return 存在为空的参数返回false，全部不为空返回true
	 */
	public static boolean objectIsNull(Object...objects) {
		//做foreach判断是否为空
	}

}