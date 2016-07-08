package com.szhynet.lib.mpermission;

/**
 * Created by Sxxjava on 16/7/6.
 */
public interface PermissionProxy<T>
{
    void grant(T source, int requestCode);

    void denied(T source, int requestCode);

    void rationale(T source, int requestCode);

    boolean needShowRationale(int requestCode);
}
