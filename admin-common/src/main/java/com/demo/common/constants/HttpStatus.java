package com.demo.common.constants;

/**
 * @author lxh
 * {@code @Description}
 * {@code @createTime} 2024-05-10 12:35:45
 */
public enum HttpStatus {
    /**
     * 操作成功
     */
    SUCCESS( 200),
    /**
     * 对象创建成功
     */
    CREATED(201),
    /**
     * 请求已接受
     */
    ACCEPTED (202),
    /**
     * 操作已执行成功，但没有返回数据
     */
    NO_CONTENT(204),
    /**
     * 资源已被移除
     */
    MOVED_PERMANENTLY(301),
    /**
     * 重定向
     */
    SEE_OTHER(303),

    /**
     * 资源没有被修改
     */
    NOT_MODIFIED (304),


    /**
     * 参数列表错误（缺少，格式不正确）
     */
    BAD_REQUEST(400),
    /**
     * 禁止访问，授权过期
     */
    FORBIDDEN(401),

    /**
     * 未授权
     */
    UNAUTHORIZED (403),
    /**
     * 资源、服务未找到
     */
    NOT_FOUND(404),
    /**
     * 请求方法错误
     */
    BAD_METHOD(405),
    /**
     * 资源冲突，或资源被锁
     */
    CONFLICT(409),
    /**
     * 不支持的数据媒体类型
     */
    UNSUPPORTED_MEDIA_TYPE(415),
    /**
     * 服务器内部错误
     */
    ERROR(500),
    /**
     * 接口未实现
     */
    NOT_IMPLEMENTED(501),
    /**
     * 服务不可用
     */
    SERVICE_UNAVAILABLE(503),
    /**
     * 系统警告消息
     */
    WARNING(601);

    private final int code;
    HttpStatus(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
