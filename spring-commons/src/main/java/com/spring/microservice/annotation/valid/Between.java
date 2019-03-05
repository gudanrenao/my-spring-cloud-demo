package com.spring.microservice.annotation.valid;

import com.spring.microservice.validator.BetweenValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {BetweenValidator.class})
public @interface Between {

    String message() default "{annotation.valid.Between.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * 最小值
     *
     * @return
     */
    long min();

    /**
     * 最大值
     *
     * @return
     */
    long max();
}
