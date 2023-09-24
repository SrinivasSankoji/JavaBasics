package com.jio.ngo.functionalinterface;

@FunctionalInterface
public interface Provisioning {
    String getDeviceType();

    default void getCommType(){
       /* We can override in the Implementation class*/
    }
    static void getAssetType(){
        /* We cannot override in the Implementation class*/
    }

}
