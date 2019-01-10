package com.yz.jvm.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.Strings.strcat;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class BtraceTest {
    @OnMethod(
            clazz = "kite.lab.utils.NumberUtil",
            method = "sum",
            location = @Location(Kind.RETURN)
    )
    public static void func(@Return int result) {
        println("trace: =======================");
        println(strcat("result:", str(result)));
        jstack();
    }
}
