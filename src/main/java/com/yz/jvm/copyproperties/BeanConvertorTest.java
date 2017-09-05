package com.yz.jvm.copyproperties;

import com.alibaba.fastjson.JSON;
import com.yz.jvm.test.dto.TestReq;
import com.yz.jvm.test.dto.TestVo;
import org.apache.commons.beanutils.BeanUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.InvocationTargetException;

// 1.BeanCopier
// 2.org.apache.commons.beanutils.BeanUtils
// BeanUtils.copyProperties VS PropertyUtils.copyProperties
// 3.Dozer
public class BeanConvertorTest {
    private static final BeanCopier TEST_REQ = BeanCopier.create(TestVo.class, TestReq.class, false);

    public static TestReq toTestReq(TestVo vo) {
        if (vo == null) {
            return null;
        }
        TestReq target = new TestReq();
        TEST_REQ.copy(vo, target, null);
        return target;
    }

    public static void testBeanCopy() {
        TestVo vo = new TestVo();
        vo.setName("abc");

        TestReq target = toTestReq(vo);
        System.out.println(JSON.toJSONString(target));
    }

    public static void testBeanUtils() {
        try {
            TestVo vo = new TestVo();
            vo.setName("abc");

            TestReq target = new TestReq();
            BeanUtils.copyProperties(target, vo);

            System.out.println(JSON.toJSONString(target));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public static void testBeanMapper() {
        Mapper mapper = new DozerBeanMapper();

        TestVo vo = new TestVo();
        vo.setName("abc");

        TestReq target = mapper.map(vo,TestReq.class);

        System.out.println(JSON.toJSONString(target));
    }


    public static void main(String[] args) {
        testBeanCopy();
        testBeanUtils();
        testBeanMapper();
    }
}
