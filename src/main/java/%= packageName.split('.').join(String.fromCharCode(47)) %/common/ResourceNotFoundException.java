package <%= packageName %>.common;

/**
 * 资源不存在异常，由全局异常处理器统一转为 404 响应。
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
