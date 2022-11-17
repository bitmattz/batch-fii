package com.bitmattz.config;

import com.bitmattz.dto.EmailDTO;
import com.bitmattz.models.Fii;
import com.bitmattz.processor.FiiProcessor;
import com.bitmattz.reader.FiiReader;
import com.bitmattz.writer.FiiWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.function.Function;


@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class SpringConfig extends DefaultBatchConfigurer implements BatchConfigurer {

    private final JobBuilderFactory jobs;
    private final StepBuilderFactory steps;
    private final JobBuilderFactory jobBuilderFactory;
    private final EntityManagerFactory entityManagerFactory;

    @Bean("jpaTransactionManager")
    public PlatformTransactionManager jpaTransactionManager() {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Override
    public void setDataSource(DataSource dataSource){

    }

    @Bean
    public Job processJob(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) throws Exception {
        return jobBuilderFactory.get("processJob")
                .incrementer(new RunIdIncrementer())
                .flow(step(stepBuilderFactory)).end().build();
    }

    @Bean
    public Step step(StepBuilderFactory stepBuilderFactory) throws Exception {
        return stepBuilderFactory.get("step").<EmailDTO,EmailDTO>chunk(1)
                .reader(compositeReader()).processor(compositeProcessor())
                .writer(compositeWriter()).build();
    }

    @Bean
    public ItemReader<? extends EmailDTO> compositeReader() {
        return new FiiReader();
    }

    @Bean
    public ItemProcessor<EmailDTO, EmailDTO> compositeProcessor() {
        return new FiiProcessor();
    }

    @Bean
    public ItemWriter<EmailDTO> compositeWriter() {
        return new FiiWriter();
    }

}
