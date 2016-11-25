#问题跟踪表

| 序号 | 问题发现时间 | 功能模块       | 负责人  | 问题描述                        | 处理人  | 处理情况    | 处理时间   | 处理状态 |
|-----|------------|---------------|--------|--------------------------------|--------|-----------|------------|--------|
| 1   | 2016.11.22 | 整体           | 全员   | 代码缩进问题，java 4个空格，js 2个 | 
| 2   | 2016.11.22 | 后端pom.xml文件 | 廖芳才  | 使用parent以后指定的依赖，不用写版本信息| 廖芳才 | 根据要求处理 |       | 已处理
| 3   | 2016.11.22 | 后端pom.xml文件 | 后端  | 1. import 的内容放在 dependency management 的最前面 2.另外，不是所有定义的 properties 都有用到，没用到的 properties 不要定义 |
| 4   | 2016.11.23 | 后端代码        | 后端   | 配置文件中的自定义key需要加上命名空间，使用驼峰命名规则 |
| 5   | 2016.11.23 | 后端代码        | 后端   | 除了命名规则按照相关规则命名外，名称还需要能表达具体意义|
| 6   | 2016.11.23 | 后端服务配置文件 | 后端   | 在不清楚相关配置参数的使用的时候需要进行查询 |
| 7   | 2016.11.23 | 后端代码        | 后端   | 对于@Bean注入，只能在两个相同类型的Bean同时被注入时使用name属性|
| 8   | 2016.11.24 | 后端代码        | 后端   | exception 不要直接 printStackTrace 要用 log 组件 | 
| 9   | 2016.11.24 | 后端代码        | 后端   | 注意下包引用的顺序，java > javax > apache > spring > 我们自己的 |
| 10  | 2016.11.24 | 后端           | 后端   |  现在需要的就是把 config service 引进来，来管理所有系统的配置 |
| 11  | 2016.11.25 | 整体           | 全员   | 在提交代码的时候不要把不想管的代码同时提交，便于以后的管理 |
| 12  | 2016.11.25 | cde-account-service| 李昌林| pom.xml文件中的项目名为大写的CDE，注意依赖关系的嵌套，pring-boot-starter-data-monogodb 已经包含了 spring-data-commons 这个库了，不需要再额外引用 | 李昌林 | 根据问题描述进行处理 | 2016.11.25 | 已处理 |
| 13  | 2016.11.25 | 后端cde-account-service配置文件     | 李昌林  | 如果是spring自带的配置项，不需要再配置类中引入 | 李昌林 | 修改为自定义属性 | 2016.11.25 | 已处理 |
| 14  | 2016.11.25 |  后端cde-account-service配置文件  | 李昌林 | 日志不写文件，直接输出到 console 就行了 |  |    |     |  未处理  |
| 15  | 2016.11.25 |  后端配置文件  | 后端 | 配置数据库的时候，都要考虑一下数据库集群部署时的情况 |