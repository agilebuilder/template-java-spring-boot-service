# <%= projectName %>

<%= description %>
<% if (author) { %>
> 作者：<%= author %>
<% } %>
## 项目简介

基于 Spring Boot 3.3.x 的微服务工程，采用标准分层架构（controller / service / repository / model / common），内置统一响应体 `ApiResponse` 与全局异常处理 `GlobalExceptionHandler`，并附带健康检查端点与示例 CRUD 接口及单元测试。

## 技术栈

- Java <%= javaVersion %>
- Spring Boot 3.3.x（spring-boot-starter-web、spring-boot-starter-validation）
- Maven 构建
- JUnit 5 + MockMvc 单元测试

## 目录结构

```
src/main/java/<%= packageName %>/                       # 包根目录（目录名由 packageName 变量渲染）
├── Application.java                               # 启动类
├── controller/                                      # 控制器层：REST 端点
│   ├── HealthController.java                        # /api/health 健康检查
│   └── ItemController.java                          # /api/items 示例 CRUD
├── service/                                         # 业务逻辑层
│   └── ItemService.java
├── repository/                                      # 数据访问层（示例为内存实现）
│   └── ItemRepository.java
├── model/                                           # 领域模型
│   └── Item.java
└── common/                                          # 通用组件
    ├── ApiResponse.java                             # 统一响应体
    ├── GlobalExceptionHandler.java                  # 全局异常处理
    └── ResourceNotFoundException.java               # 资源不存在异常
src/main/resources/application.yml                   # 应用配置（端口 <%= port %>）
src/test/java/<%= packageName %>/controller/  # MockMvc 测试示例
```

## 快速开始

本项目由 AgileBuilder 模板生成。重新生成同类项目：

```bash
ag create --git-url <模板仓库地址> --target <目标目录>
```

本地运行：

```bash
mvn spring-boot:run
# 访问 http://localhost:<%= port %>/api/health
```

## 模板变量

| 变量名 | 类型 | 说明 | 默认值 |
| ------ | ---- | ---- | ------ |
| projectName | input | 项目名称（必填，artifactId 取其 kebab-case 形式） | demo-service |
| description | input | 项目描述 | 一个 Spring Boot 微服务 |
| author | input | 作者 | （空） |
| packageName | input | Java 包名 | com.example.demo |
| javaVersion | list | Java 版本（可选 17 / 21） | 17 |
| port | number | 服务端口 | 8080 |

模板内容使用 EJS 渲染（分隔符 `%`），文件中的变量占位符会被替换为实际值。

## 常用命令

```bash
mvn compile                # 编译
mvn test                   # 运行单元测试
mvn package                # 打包可执行 jar（target/ 下）
mvn spring-boot:run        # 本地启动
```

## API 示例

- `GET /api/health`：健康检查
- `GET /api/items`：查询全部 Item
- `GET /api/items/{id}`：按 ID 查询
- `POST /api/items`：新建 Item（JSON body：`{"name": "示例"}`）
- `PUT /api/items/{id}`：更新 Item
- `DELETE /api/items/{id}`：删除 Item

所有接口返回统一结构：`{"code": 0, "message": "success", "data": ...}`。
