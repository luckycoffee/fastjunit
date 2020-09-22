![license](./docs/img/license-Apache--2.0-green.svg)

---
 高效的单元测试


## 工程结构  ![badge-jdk-8] ![badge-junit-platform] ![badge-junit-jupiter] ![badge-junit-vintage]

```
src
├── pom       // parent 
├── lucky-test-tool         // 自己封装的一些测试工具和集成一些优秀的开源工具【可独立引用,独立开源】
    |-- annotation
    |-- extend              // junit5 自定义的 ExtendWith
    |-- runner              // ExtendWith 的集合
    |-- utils               
├── lucky-middleware-mock   // 瑞幸中间件 mock 方案，依赖于 'lucky-test-tool'【需要引入瑞幸内部特定的中间件】
├── lucky-test-demo         // 测试用例场景 最佳实践 demo，依赖于 上面 2个模块。
    |-- main            // 下面采用 DDD 模拟业务代码
    |   |-- application
    |   |-- domain
    |   |-- infrastructure
    |   |-- interface
    |-- test        // 下面的分包没有根据上面的业务包结构，主要是根据场景分包，方便参考
    |   |-- assert
    |   |-- extend
    |   |-- order
    |   |-- parameterized
    |   |-- reflection

```

- **使用文档：** https://luckycoffee.github.io/docs/
- **文档工程：** http://git.luckincoffee.com/opensource/ut-docs


采用 JUnit5 做为基础框架的原因

```JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage```
- JUnit 5是一个模块化和可扩展的测试框架，支持Java 8及更高版本。
- JUnit 5由三个部分组成——一个基础平台、一个新的编程和扩展模型Jupiter，以及一个名为Vintage的向后兼容的测试引擎。
- JUnit 5 Jupiter的扩展模型可用于向JUnit中添加自定义功能。
- 扩展模型API测试生命周期提供了钩子和注入自定义参数的方法（即依赖注入）

JUnit5 带来了一个强大的扩展模型。扩展开发人员可以使用这个新模型向JUnit 5中添加自定义功能。

![image](./docs/img/junit5.png)

- [junit5](https://junit.org/junit5/docs/current/user-guide/)
- [JUnit 社区收集的一些第三方插件](https://github.com/junit-team/junit5/wiki/Third-party-Extensions)
- [IBM Junit5 博客](https://developer.ibm.com/zh/tutorials/j-introducing-junit5-part1-jupiter-api/#N10191)
- [实现 Junit5 引擎的 testNg](https://github.com/testng-team/testng-junit5)

## 开发规范 ##
- IDEA 安装阿里巴巴的代码检测插件，上传前代码分析下：**Alibaba Java Coding Guide**


## 开发计划 ##

- [v0.0.1](/docs/plan/v0.0.1.md)


## 发布日志 ##

[v0.1.0 - 2020年8月5日](./docs/releases/v0.1.0.md)


## 功能列表 ##
*部分代码还在开发中没集成进来*

1. 兼容 `junit4` `junit5` `testng` 引擎的测试框架，高灵活的扩展能力。
2. 提供 csv ，json 2种格式进行灵活的参数化测试。
3. 支持 Parallel 和 Suite 的单测，进一步提升单测的执行效率。
4. 封装 H2 内存数据库工具，并提供 [h2-functions-4-mysql](http://git.luckincoffee.com/opensource/h2-functions-4-mysql) 函数扩展的插件，方便数据库层面的单测。
5. json 工具，list 对象拷贝工具 （欢迎持续贡献）。





## 文档

(**完善中**)

## 快速开始 ##
- JDK 8
- IDEA 需要安装 Lombok


## FAQ ##


## 欢迎贡献


<div>
<table>
  <tbody>
  <tr></tr>
    <tr>
      <td align="center"  valign="middle">
        <a href="" target="_blank">
          <img width="222px"  src="./docs/img/contribute/profile1.jpg">
        </a>
      </td>
      <td align="center"  valign="middle">
        <a href="" target="_blank">
          <img width="222px"  src="./docs/img/contribute/profile1.jpg">
        </a>
      </td>
      <td align="center"  valign="middle">
        <a href="" target="_blank">
          <img width="222px"  src="./docs/img/contribute/profile1.jpg">
        </a>
      </td>
      <td align="center"  valign="middle">
        <a href="https://github.com/mosn" target="_blank">
          <img width="222px"  src="./docs/img/contribute/profile1.jpg">
        </a>
      </td>
    </tr>
    <tr></tr>
  </tbody>
</table>
</div>

## 参考资料

- [junit5](https://junit.org/junit5/docs/current/user-guide/)





[badge-jdk-8]: https://img.shields.io/badge/jdk-8-lightgray.svg "JDK-8"
[badge-junit-platform]: https://img.shields.io/badge/junit-platform-brightgreen.svg "JUnit Platform"
[badge-junit-jupiter]: https://img.shields.io/badge/junit-jupiter-green.svg "JUnit Jupiter Engine"
[badge-junit-vintage]: https://img.shields.io/badge/junit-vintage-yellowgreen.svg "JUnit Vintage Engine"
