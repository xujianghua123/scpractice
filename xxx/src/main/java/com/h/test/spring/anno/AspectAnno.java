package com.h.test.spring.anno;

import java.lang.annotation.*;

/**
 * @author admin
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AspectAnno {

    String value();
}
