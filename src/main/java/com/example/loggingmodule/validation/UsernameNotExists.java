package com.example.loggingmodule.validation;

import com.example.loggingmodule.common.ErrorMessage;
import com.example.loggingmodule.validation.validator.UserNameNotExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = UserNameNotExistsValidator.class
)
@Target({
        ElementType.ANNOTATION_TYPE,
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(UsernameNotExists.List.class)
public @interface UsernameNotExists {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default ErrorMessage.ACCOUNT_EXISTED;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Target({
            ElementType.ANNOTATION_TYPE,
            ElementType.METHOD,
            ElementType.FIELD,
            ElementType.CONSTRUCTOR,
            ElementType.PARAMETER,
            ElementType.TYPE_USE
    })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List{
        UsernameNotExists[] value();
    }
}
