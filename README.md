![license](./docs/img/license-Apache--2.0-green.svg)

---
 高效的单元测试


## 工程结构  ![badge-jdk-8] ![badge-junit-platform] ![badge-junit-jupiter] ![badge-junit-vintage]

```
src
├── pom       // parent 
├── lucky-middleware-mock   // ignore
├── lucky-test-tool（fastjunit）         // 【fastjunit 核心主体】
    |-- annotation
    |-- data                // 数据提供方法
    |-- H2                  // 内存数据库封装方法
    |-- extend              // junit5 自定义的 ExtendWith
    |-- runner              // ExtendWith 的集合
    |-- utils          
├── lucky-test-demo         // 引用 fastjunit 并编写的 demo，如果一些依赖库下载不到可以自行去除      
├── lucky-testng-engine    // testNg 兼容 junit5 的引擎 
```

> 子模块 `lucky-test-tool` 就是对应着 fastjunit 本身，其它模块可以不用关注。

- **使用文档：** https://luckycoffee.github.io/docs/


## 开发规范 ##
- IDEA 安装阿里巴巴的代码检测插件，上传前代码分析下：**Alibaba Java Coding Guide**


## 功能列表 ##

- 兼容主流开发框架：Junit4,Junit5,Jmockit，所以单元测试一个 fastjunit 就够了
- 灵活的参数化测试，支持：CSV,JSON,String 的数据格式
- 单元测试造数据很痛苦？看看我们的 [dataProvider](https://luckycoffee.github.io/docs/test-basic/dataProvider/)
- [简单易用的数据库测试工具](https://luckycoffee.github.io/docs/db/h2/)

目前处于前期阶段，所有的东西正在不断完善和新增中。

## 发布日志 ##

[v1.0.0-beta - 2020/09/21](https://luckycoffee.github.io/docs/changelog/)



## 文档

https://luckycoffee.github.io/docs/

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
