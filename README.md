![license](http://git.luckincoffee.com/tech-train/java-ut-effective/raw/master/docs/img/license-Apache--2.0-green.svg)

---
 高效的单元测试


## 工程结构 ##

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


采用 JUnit5 做为基础框架的原因

```JUnit 5 = JUnit Platform + JUnit Jupiter + JUnit Vintage```
- JUnit 5是一个模块化和可扩展的测试框架，支持Java 8及更高版本。
- JUnit 5由三个部分组成——一个基础平台、一个新的编程和扩展模型Jupiter，以及一个名为Vintage的向后兼容的测试引擎。
- JUnit 5 Jupiter的扩展模型可用于向JUnit中添加自定义功能。
- 扩展模型API测试生命周期提供了钩子和注入自定义参数的方法（即依赖注入）

JUnit5 带来了一个强大的扩展模型。扩展开发人员可以使用这个新模型向JUnit 5中添加自定义功能。

## 开发计划 ##

V 1.0.0 完成以下目标：

1. 扩展 Junit5,自定义 ExtendWith 和实现自己的一些 Annotation
    - 支持文本数据自动映射成 Java 对象，方便 Mock 对象数据提供。
        - 支持的文本格式：CSV,JSON
    - 支持可排序的 Unit Case
    - 隐藏底层 PowerMock,通过自定义的 Annotation 实现静态对象的 Mock
        - 降低开发者对各个框架的学习成本，和各种工具来回切换的繁琐
    - 各参与人员收集自己小组的优秀的工具类集成进来
    - 等待讨论
2. demo 完善各种用例场景
3. 完善项目文档和 FAQ 问题
4. 探讨...

[JUnit 社区收集的一些第三方插件](https://github.com/junit-team/junit5/wiki/Third-party-Extensions)

## 发布日志 ##

[v0.1.0 - 2020年8月5日](/docs/releases/v0.1.0.md)


## 功能列表 ##

实现列表:




## 文档

(**完善中**)

## 快速开始 ##
- JDK 8
- IDEA 需要安装 Lombok


## FAQ ##

- [★★★单测共性问题解答★★★](http://wiki.luckincoffee.com/pages/viewpage.action?pageId=47978784)

- 企业微信群：单元测试和自动化测试项目

## 欢迎贡献


<div>
<table>
  <tbody>
  <tr></tr>
    <tr>
      <td align="center"  valign="middle">
        <a href="" target="_blank">
          <img width="222px"  src="http://git.luckincoffee.com/tech-train/java-ut-effective/raw/master/docs/img/contribute/profile1.jpg">
        </a>
      </td>
      <td align="center"  valign="middle">
        <a href="" target="_blank">
          <img width="222px"  src="http://git.luckincoffee.com/tech-train/java-ut-effective/raw/master/docs/img/contribute/profile1.jpg">
        </a>
      </td>
      <td align="center"  valign="middle">
        <a href="" target="_blank">
          <img width="222px"  src="http://git.luckincoffee.com/tech-train/java-ut-effective/raw/master/docs/img/contribute/profile1.jpg">
        </a>
      </td>
      <td align="center"  valign="middle">
        <a href="https://github.com/mosn" target="_blank">
          <img width="222px"  src="http://git.luckincoffee.com/tech-train/java-ut-effective/raw/master/docs/img/contribute/profile1.jpg">
        </a>
      </td>
    </tr>
    <tr></tr>
  </tbody>
</table>
</div>

## 参考资料

- [junit5](https://junit.org/junit5/docs/current/user-guide/)
