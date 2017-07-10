package com.yz.jvm.test.convertor;

import com.yz.jvm.test.dto.TestReq;
import com.yz.jvm.test.dto.TestVo;
import org.springframework.cglib.beans.BeanCopier;

public class TestConvertor {
    private static final BeanCopier TEST_REQ = BeanCopier.create(TestVo.class, TestReq.class, false);

    public static TestReq toTestReq(TestVo vo) {
        if (vo == null) {
            return null;
        }
        TestReq target = new TestReq();
        TEST_REQ.copy(vo, target, null);
        return target;
    }
}
