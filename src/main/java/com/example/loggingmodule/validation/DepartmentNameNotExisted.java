package com.example.loggingmodule.validation;

import com.example.loggingmodule.common.ErrorMessage;
import com.example.loggingmodule.validation.validator.DepartmentNameNotExistedValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = DepartmentNameNotExistedValidator.class
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
@Repeatable(DepartmentNameNotExisted.List.class)
public @interface DepartmentNameNotExisted {

    int min() default 0;
    int max() default Integer.MAX_VALUE;

    String message() default ErrorMessage.DEPARTMENT_NOT_EXISTED;
    Class<?>[] group() default {};

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
        DepartmentNameNotExisted[] value();
    }
}
