package com.yz.jvm.copyproperties;

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

    public static void testProperiesCopy(){
        // 1.BeanCopier
        // 2.org.apache.commons.beanutils.BeanUtils
        // 3.Dozer


    }
}
