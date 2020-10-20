package com.sp.accountservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;


@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spcloud.cassandra.keyspacename.name}")
    private String keySpaceName;
    @Value("${spcloud.cassandra.port}")
    private int port;
    @Value("${spcloud.cassandra.contact.point}")
    private String contactPoint;
    @Value("${spcloud.cassandra.username}")
    private String username;
    @Value("${spcloud.cassandra.password}")
    private String password;

    @Override
    protected String getKeyspaceName() {
        return keySpaceName;
    }
    @Override
    protected int getPort() {
        return port;
    }
    @Override
    protected String getContactPoints() {
        return contactPoint;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.sp.accountservice.entity"};
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean = super.cluster();
        clusterFactoryBean.setUsername(username);
        clusterFactoryBean.setPassword(password);
        return clusterFactoryBean;
    }
}
