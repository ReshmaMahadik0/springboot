package com.example.multiple_db_config.dbconfig;

import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Configuration
public class JpaCommonConfig {

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(true);

        Function<DataSource, Map<String, ?>> jpaPropertiesFactory =
                dataSource -> {
                    Map<String, Object> props = new HashMap<>();
                    props.put("hibernate.hbm2ddl.auto", "update");
                    return props;
                };

        return new EntityManagerFactoryBuilder(
                vendorAdapter,
                jpaPropertiesFactory,
                null
        );
    }

}
