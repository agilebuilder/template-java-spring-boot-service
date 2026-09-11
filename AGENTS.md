# AGENTS.md — AI 编码代理导航指南

## 项目概览

`<%= projectName %>`：<%= description %>。Spring Boot 3.3.x + Java <%= javaVersion %> + Maven 的分层架构微服务。

## 目录结构与职责

- `src/main/java/<%= packageName %>/`
  - `controller/`：REST 控制器，只做参数校验与响应组装，不写业务逻辑
  - `service/`：业务逻辑层，控制器通过 service 访问数据
  - `repository/`：数据访问层，当前 `ItemRepository` 为内存实现（ConcurrentHashMap），接入真实数据库时替换为 Spring Data JPA/MyBatis 实现
  - `model/`：领域模型（POJO）
  - `common/`：`ApiResponse`（统一响应体）、`GlobalExceptionHandler`（全局异常）、业务异常类
- `src/main/resources/application.yml`：应用配置，服务端口 <%= port %>
- `src/test/java/<%= packageName %>/`：测试代码，结构镜像 main

## 编码约定

- 所有 REST 接口返回 `ApiResponse<T>`，通过 `ApiResponse.success(data)` / `ApiResponse.error(...)` 构造，不要直接返回裸对象
- 资源不存在时抛出 `ResourceNotFoundException`，由 `GlobalExceptionHandler` 统一转为 404 响应，不要在 controller 里 try-catch
- 参数校验使用 Bean Validation 注解（`@NotBlank` 等）+ `@Valid`，校验失败由全局异常处理器返回 400
- 包根为 `<%= packageName %>`，新代码必须放在该包或其子包下，否则组件扫描不到
- 新增端点遵循 `/api/<资源名>` 前缀约定
- 缩进 4 空格，文件 UTF-8、LF 行尾（见 `.editorconfig`）

## 常用命令

```bash
mvn compile          # 编译
mvn test             # 运行全部单元测试
mvn package          # 打包可执行 jar
mvn spring-boot:run  # 本地启动（端口 <%= port %>）
```

## 变更检查清单

- 修改公共响应结构（`ApiResponse`）时，同步更新 README 的 API 说明
- 新增 controller 时补充对应 MockMvc 测试（参考 `ItemControllerTest`）
- 修改 `application.yml` 配置项时，检查测试是否依赖默认值
