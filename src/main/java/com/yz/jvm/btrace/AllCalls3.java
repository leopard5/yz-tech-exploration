package com.yz.jvm.btrace;

import com.sun.btrace.AnyType;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.printArray;

/**
 * This script demonstrates the possibility to intercept
 * method calls that are about to be executed from the body of
 * a certain method. This is achieved by using the {@linkplain Kind#CALL}
 * location value.
 */
@BTrace
public class AllCalls3 {
    @OnMethod(clazz = "javax.swing.JButton", method = "/.*/",
            location = @Location(value = Kind.CALL, clazz = "/.*/", method = "/.*/"))
    public static void o(@Self Object self, @ProbeMethodName String pmn, AnyType[] args) { // all calls to methods
        // self - this for the method call
        // pmn - textual representation of the method
        // contents of args array:
        // [0]..[n] - original method call arguments
        printArray(args);
    }
} 
