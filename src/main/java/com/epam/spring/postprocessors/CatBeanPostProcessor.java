package com.epam.spring.postprocessors;

import com.epam.spring.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@Component
public class CatBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("cat")) {
            System.out.println("in CatBeanPostProcessor postProcessBeforeInitialization()");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("cat")) {
            System.out.println("in CatBeanPostProcessor postProcessAfterInitialization()");
            Class<?> aClass = bean.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                for (Annotation declaredAnnotation : declaredAnnotations) {
                    if (declaredAnnotation.annotationType() == InjectRandomInt.class ) {
                        try {
                            field.setAccessible(true);
                            field.set(bean, 10000L);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return bean;
    }
}
