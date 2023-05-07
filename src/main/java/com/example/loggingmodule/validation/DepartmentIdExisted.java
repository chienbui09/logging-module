package com.example.loggingmodule.validation;

import com.example.loggingmodule.common.ErrorMessage;
import com.example.loggingmodule.validation.validator.DepartmentIdExistedValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = DepartmentIdExistedValidator.class
)
@Target(
        {
                ElementType.METHOD,
                ElementType.FIELD,
                ElementType.ANNOTATION_TYPE,
                ElementType.CONSTRUCTOR,
                ElementType.PARAMETER,
                ElementType.TYPE_USE
        }
)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable((DepartmentIdExisted.List.class))
public @interface DepartmentIdExisted {
    int min() default 0;
    int max() default  Integer.MAX_VALUE;
    String message() default ErrorMessage.DEPARTMENT_NOT_EXISTED;


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(
            {
                    ElementType.TYPE,
                    ElementType.FIELD,
                    ElementType.METHOD,
                    ElementType.ANNOTATION_TYPE,
                    ElementType.PARAMETER,
                    ElementType.CONSTRUCTOR,
                    ElementType.TYPE_USE
            }
    )
    @interface List{
        DepartmentIdExisted[] value();
    }
}
