package org.example.datasource.unpooled;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.example.datasource.Connection;
import org.example.datasource.DataSource;
import org.example.datasource.DataSourceType;
import org.example.datasource.connection.DubboConnection;
import org.example.mapping.HttpStatement;
import org.example.session.Configuration;

/**
 * 无池化连接池
 */
public class UnpooledDataSource implements DataSource {
    private Configuration configuration;
    private HttpStatement httpStatement;
    private DataSourceType dataSourceType;

    @Override
    public Connection getConnection() {
        switch (dataSourceType){
            case HTTP:
                //TODO 预留接口，暂时不需要实现
                break;
            case Dubbo:
                //配置信息
                String application = httpStatement.getApplication();
                String interfaceName = httpStatement.getInterfaceName();
                // 获取服务
                ApplicationConfig applicationConfig = configuration.getApplicationConfig(application);
                RegistryConfig registryConfig = configuration.getRegistryConfig(application);
                ReferenceConfig<GenericService> reference = configuration.getReferenceConfig(interfaceName);
                return new DubboConnection(applicationConfig, registryConfig, reference);
            default:
                break;
        }throw new RuntimeException("DataSourceType：" + dataSourceType + "没有对应的数据源实现");
    }
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public void setHttpStatement(HttpStatement httpStatement) {
        this.httpStatement = httpStatement;
    }

    public void setDataSourceType(DataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

}
