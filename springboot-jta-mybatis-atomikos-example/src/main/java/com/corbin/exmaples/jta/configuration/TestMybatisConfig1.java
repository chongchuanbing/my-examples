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
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages="com.gloyel.twodbgn.mapper.local",sqlSessionTemplateRef="localSqlSessionTemplate")
public class TestMybatisConfig1 {
    @Primary
    @Bean(name="localDataSource")
    @DependsOn("transactionManager")
    public DataSource testDataSource() throws SQLException {
        SQLServerXADataSource sqlServerXADataSource = new SQLServerXADataSource();
        sqlServerXADataSource.setURL("jdbc:sqlserver://localhost:1433;databaseName=mytest;encrypt=true;trustServerCertificate=true");
        sqlServerXADataSource.setUser("username");
        sqlServerXADataSource.setPassword("password");

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(sqlServerXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("localDataSource");

        atomikosDataSourceBean.setMinPoolSize(3);
        atomikosDataSourceBean.setMaxPoolSize(25);

        return atomikosDataSourceBean;
    }
    @Primary
    @Bean(name="localSqlSessionFactory")
    @DependsOn("localDataSource")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("localDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    @Primary
    @Bean(name="localSqlSessionTemplate")
    @DependsOn("localSqlSessionFactory")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("localSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
