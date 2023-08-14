package org.application.config;


import com.example.infrastructurespringdata.repository.impl.CommentsRepositoryImpl;
import com.example.infrastructurespringdata.repository.impl.PlantsRepositoryImpl;
import com.example.infrastructurespringdata.repository.impl.UserRepositoryImpl;
import org.example.service.CommentsServiceImpl;
import org.example.service.PlantsServiceImpl;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;


public class ApiRestInitializer implements ApplicationContextInitializer {

    private final ConfigurableApplicationContext infraContext;

    public ApiRestInitializer(ConfigurableApplicationContext infraContext) {
        this.infraContext = infraContext;
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableListableBeanFactory registry = applicationContext.getBeanFactory();
        registry.registerSingleton("PlantsService", new PlantsServiceImpl(infraContext.getBean(PlantsRepositoryImpl.class)));
        registry.registerSingleton("UserService", new UserServiceImpl(infraContext.getBean(UserRepositoryImpl.class)));
        registry.registerSingleton("CommentsService", new CommentsServiceImpl(infraContext.getBean(CommentsRepositoryImpl.class)));
    }
}
