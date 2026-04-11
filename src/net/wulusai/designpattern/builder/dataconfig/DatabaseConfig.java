package net.wulusai.designpattern.builder.dataconfig;

/**
 * 数据库配置类 - 产品类
 * 使用建造者模式构建复杂的数据库配置对象
 */
public class DatabaseConfig {
    // 必填参数
    private final String host;
    private final int port;
    
    // 可选参数
    private final String username;
    private final String password;
    private final String databaseName;
    private final int maxConnections;
    private final int timeout;
    private final boolean useSSL;
    private final String charset;
    private final boolean autoReconnect;

    /**
     * 私有构造函数，只能通过Builder创建
     */
    private DatabaseConfig(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.username = builder.username;
        this.password = builder.password;
        this.databaseName = builder.databaseName;
        this.maxConnections = builder.maxConnections;
        this.timeout = builder.timeout;
        this.useSSL = builder.useSSL;
        this.charset = builder.charset;
        this.autoReconnect = builder.autoReconnect;
    }

    // Getter方法
    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public int getTimeout() {
        return timeout;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public String getCharset() {
        return charset;
    }

    public boolean isAutoReconnect() {
        return autoReconnect;
    }

    /**
     * 显示配置信息
     */
    public void showConfig() {
        System.out.println("===== 数据库配置信息 =====");
        System.out.println("主机: " + host);
        System.out.println("端口: " + port);
        System.out.println("用户名: " + username);
        System.out.println("数据库名: " + databaseName);
        System.out.println("最大连接数: " + maxConnections);
        System.out.println("超时时间: " + timeout + "ms");
        System.out.println("使用SSL: " + useSSL);
        System.out.println("字符集: " + charset);
        System.out.println("自动重连: " + autoReconnect);
        System.out.println("=========================");
    }

    /**
     * 静态内部建造者类
     * 支持链式调用
     */
    public static class Builder {
        // 必填参数
        private final String host;
        private final int port;
        
        // 可选参数 - 设置默认值
        private String username = "root";
        private String password = "";
        private String databaseName = "test";
        private int maxConnections = 10;
        private int timeout = 5000;
        private boolean useSSL = false;
        private String charset = "UTF-8";
        private boolean autoReconnect = true;

        /**
         * 构造方法 - 传入必填参数
         * @param host 主机地址
         * @param port 端口号
         */
        public Builder(String host, int port) {
            this.host = host;
            this.port = port;
        }

        /**
         * 设置用户名（链式调用）
         * @param username 用户名
         * @return Builder对象本身，支持链式调用
         */
        public Builder username(String username) {
            this.username = username;
            return this;
        }

        /**
         * 设置密码（链式调用）
         * @param password 密码
         * @return Builder对象本身，支持链式调用
         */
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        /**
         * 设置数据库名（链式调用）
         * @param databaseName 数据库名
         * @return Builder对象本身，支持链式调用
         */
        public Builder databaseName(String databaseName) {
            this.databaseName = databaseName;
            return this;
        }

        /**
         * 设置最大连接数（链式调用）
         * @param maxConnections 最大连接数
         * @return Builder对象本身，支持链式调用
         */
        public Builder maxConnections(int maxConnections) {
            if (maxConnections <= 0) {
                throw new IllegalArgumentException("最大连接数必须大于0");
            }
            this.maxConnections = maxConnections;
            return this;
        }

        /**
         * 设置超时时间（链式调用）
         * @param timeout 超时时间（毫秒）
         * @return Builder对象本身，支持链式调用
         */
        public Builder timeout(int timeout) {
            if (timeout <= 0) {
                throw new IllegalArgumentException("超时时间必须大于0");
            }
            this.timeout = timeout;
            return this;
        }

        /**
         * 设置是否使用SSL（链式调用）
         * @param useSSL 是否使用SSL
         * @return Builder对象本身，支持链式调用
         */
        public Builder useSSL(boolean useSSL) {
            this.useSSL = useSSL;
            return this;
        }

        /**
         * 设置字符集（链式调用）
         * @param charset 字符集
         * @return Builder对象本身，支持链式调用
         */
        public Builder charset(String charset) {
            this.charset = charset;
            return this;
        }

        /**
         * 设置是否自动重连（链式调用）
         * @param autoReconnect 是否自动重连
         * @return Builder对象本身，支持链式调用
         */
        public Builder autoReconnect(boolean autoReconnect) {
            this.autoReconnect = autoReconnect;
            return this;
        }

        /**
         * 构建DatabaseConfig对象
         * @return 构建完成的DatabaseConfig对象
         */
        public DatabaseConfig build() {
            // 可以在这里添加验证逻辑
            if (host == null || host.isEmpty()) {
                throw new IllegalStateException("主机地址不能为空");
            }
            if (port < 1 || port > 65535) {
                throw new IllegalStateException("端口号必须在1-65535之间");
            }
            return new DatabaseConfig(this);
        }
    }
}
