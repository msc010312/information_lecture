package ch34;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 에노테이션의 유지기간

@Target({ElementType.TYPE,ElementType.METHOD})
public @interface CustomAnnotaion {
	String value() default "";
	int number() default 0;
}
