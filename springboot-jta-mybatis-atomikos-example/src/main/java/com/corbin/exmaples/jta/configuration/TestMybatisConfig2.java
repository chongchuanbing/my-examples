package com.corbin.exmaples.jta.configuration;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages="com.gloyel.twodbgn.mapper.cloud",sqlSessionTemplateRef="cloudSqlSessionTemplate")
public class TestMybatisConfig2 {

    @Bean(name="cloudDataSource")
    @DependsOn("transactionManager")
    public DataSource testDataSource() throws SQLException {
        SQLServerXADataSource sqlServerXADataSource = new SQLServerXADataSource();
        sqlServerXADataSource.setURL("jdbc:sqlserver://ip:端口;databaseName=mytest;encrypt=true;trustServerCertificate=true");
        sqlServerXADataSource.setUser("username");
        sqlServerXADataSource.setPassword("password");

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(sqlServerXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("cloudDataSource");

        atomikosDataSourceBean.setMinPoolSize(3);
        atomikosDataSourceBean.setMaxPoolSize(25);

        return atomikosDataSourceBean;
    }
    @Bean(name="cloudSqlSessionFactory")
    @DependsOn("cloudDataSource")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("cloudDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    @Bean(name="cloudSqlSessionTemplate")
    @DependsOn("cloudSqlSessionFactory")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("cloudSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
