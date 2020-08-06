
![license](http://git.luckincoffee.com/tech-train/java-ut-effective/raw/master/docs/img/license-Apache--2.0-green.svg)

---
 高效的单元测试


## 工程结构 ##

```
src
├── lucky-test-parent       // parent 
├── lucky-test-tool         // 自己封装的一些测试工具和集成一些优秀的开源工具【可独立引用,独立开源】
├── lucky-middleware-mock   // 瑞幸中间件 mock 方案【需要引入瑞幸内部特定的中间件】
├── lucky-test-demo         // 测试用例场景 最佳实践 demo

```


## 开发计划 ##

V 1.0.0 完成以下目标：

1. 扩展 Junit,自定义 Runner 和实现自己的一些 Annotation
    - 支持文本数据自动映射成 Java 对象，方便 Mock 对象数据提供。
        - 支持的文本格式：CSV,JSON
    - 支持可排序的 Unit Case
    - 隐藏底层 PowerMock,通过自定义的 Annotation 实现静态对象的 Mock
        - 降低开发者对各个框架的学习成本，和各种工具来回切换的繁琐
    - 等待讨论...
2. demo 完善各种用例场景
3. 完善项目文档和 FAQ 问题
4. 探讨...



## 发布日志 ##

[v0.1.0 - 2020年8月5日](/docs/releases/v0.1.0.md)


## 功能列表 ##

实现列表:




## 文档

(**完善中**)

## 快速开始 ##


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
