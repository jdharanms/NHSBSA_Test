package nhs.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RegularAmountValidator.class)
public @interface RegularAmountConstrain {
	
	String message() default "{Invalid Regular Amount}";
	
	String[] value();
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
