
@Retention(RetentionPolicy.Runtime)
@Target({ElementType.METHOD})
public @interface Mabin{
    String value() default "value:default value";
}
