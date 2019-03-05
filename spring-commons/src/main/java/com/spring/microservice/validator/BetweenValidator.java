package com.spring.microservice.validator;

import com.spring.microservice.annotation.valid.Between;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/21 9:28 PM
 * @Version 1.0
 **/
public class BetweenValidator implements ConstraintValidator<Between, Number> {

    private long min;
    private long max;

    /**
     * Initializes the validator in preparation for
     * {@link #isValid(Object, ConstraintValidatorContext)} calls.
     * The constraint annotation for a given constraint declaration
     * is passed.
     * <p>
     * This method is guaranteed to be called before any use of this instance for
     * validation.
     * <p>
     * The default implementation is a no-op.
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(Between constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    /**
     * Implements the validation logic.
     * The state of {@code value} must not be altered.
     * <p>
     * This method can be accessed concurrently, thread-safety must be ensured
     * by the implementation.
     *
     * @param number  object to validate
     * @param context context in which the constraint is evaluated
     * @return {@code false} if {@code value} does not pass the constraint
     */
    @Override
    public boolean isValid(Number number, ConstraintValidatorContext context) {
        if (number == null) {
            return false;
        }
        Class<? extends Number> numberClass = number.getClass();
        switch (numberClass.getSimpleName()) {
            case "Integer":
                return number.intValue() >= min && number.intValue() <= max;
            case "Long":
                return number.longValue() >= min && number.longValue() <= max;
            default:
                return false;
        }
    }
}