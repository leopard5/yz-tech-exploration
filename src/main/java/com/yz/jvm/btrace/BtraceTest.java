package com.yz.jvm.btrace;

import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.Strings.strcat;
import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class BtraceTest {
    @OnMethod(
            clazz = "com.yz.jvm.btrace.Calculator",
            method = "add",
            location = @Location(Kind.RETURN)
    )
    public static void func(
            @ProbeClassName String pcm,
            @ProbeMethodName String pmn,
            @Return int result,
            @Duration long duration,
            int a,
            int b
    ) {
        println("trace: =======================");
        println(strcat("ProbeClassName:", str(pcm)));
        println(strcat("ProbeMethodName:", str(pmn)));
        println(strcat("result:", str(result)));
        println(strcat("Duration:", str(duration)));
        println(strcat("a:", str(a)));
        println(strcat("b:", str(b)));
        jstack();
    }
}
