package mvc.config;

import lombok.Data;
import mvc.javaCode.model.Car;
import mvc.javaCode.service.CarService;
import mvc.javaCode.service.CarServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

@Data
@Configuration
@ConfigurationProperties(prefix = "hibernate")
public class HiberConfig {

    private String show_sql;

    private String hbm2ddl_auto;

    private String dialect;


    @Bean
    public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        Properties props = new Properties();
        props.put("hibernate.show_sql", show_sql);
        props.put("hibernate.hbm2ddl.auto", hbm2ddl_auto);
        props.put("hibernate.dialect", dialect);


        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(Car.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager(DataSource dataSource) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory(dataSource).getObject());
        return transactionManager;
    }

}

