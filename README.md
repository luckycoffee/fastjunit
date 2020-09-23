


## <font color="red">由于公司法务需要走流程，具体代码暂时去除了，后续完整流程过了再开放，敬请期待！ </font>

<span style="color: green"> Some green text </span> 
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

## 项目说明
项目目前处于初期快速迭代阶段，功能还比较有限。今后会从以下几个点出发。

- 提供便捷的测试工具
- 指导如何进行有效的单元测试
- 探索单元测试可量化的指标
- Devops 下的单元测试如何推进

## 已有功能 ##

- 兼容主流开发框架：Junit4,Junit5,Jmockit，所以单元测试一个 **fastjunit** 就够了
- 灵活的参数化测试，支持：[CSV,JSON,String 的数据格式](https://luckycoffee.github.io/docs/test-basic/parameter-csv/)
- 单元测试造数据很痛苦？看看我们的 [dataProvider](https://luckycoffee.github.io/docs/test-basic/dataProvider/)
- [简单易用的数据库测试工具](https://luckycoffee.github.io/docs/db/h2/)
- [逐步完善的单元测试指导文档](https://luckycoffee.github.io/docs/)

*目前处于前期阶段，所有的东西正在不断完善和新增中,欢迎一起加入共建！*



## 发布日志 ##

[v1.0.0-beta - 2020/09/21](https://luckycoffee.github.io/docs/changelog/)

## 文档

https://luckycoffee.github.io/docs/

## 快速开始 ##
- JDK 8
- IDEA 需要安装 Lombok


## FAQ ##


## 欢迎贡献


## 参考资料

- [junit5](https://junit.org/junit5/docs/current/user-guide/)





[badge-jdk-8]: https://img.shields.io/badge/jdk-8-lightgray.svg "JDK-8"
[badge-junit-platform]: https://img.shields.io/badge/junit-platform-brightgreen.svg "JUnit Platform"
[badge-junit-jupiter]: https://img.shields.io/badge/junit-jupiter-green.svg "JUnit Jupiter Engine"
[badge-junit-vintage]: https://img.shields.io/badge/junit-vintage-yellowgreen.svg "JUnit Vintage Engine"
