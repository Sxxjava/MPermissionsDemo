package com.szhynet.lib.mpermission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Sxxjava on 16/7/6.
 */
@Target(ElementType.METHOD)
public @interface PermissionDenied
{
    int[] value();
}
