package com.yz.jvm.copyproperties;

import com.alibaba.fastjson.JSON;
import com.yz.jvm.test.dto.TestReq;
import com.yz.jvm.test.dto.TestVo;
import org.apache.commons.beanutils.BeanUtils;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * performance test rank
 * 0. mapstruct
 * 1. get set
 * 2. BeanCopier
 * 3. Easy mapper
 * 4. Spring BeanUtils
 * 5. Apache BeanUtils
 * 6. Apache PropertiesUtils
 * 7. Dozer
 */
public class BeanConvertTest {
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
        vo.setId(1234);
        vo.setName("abc");
        vo.setIds(Arrays.asList(1111, 2222));
        vo.setNames(Arrays.asList("ya", "zhong"));


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
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void testBeanMapper() {
        Mapper mapper = new DozerBeanMapper();

        TestVo vo = new TestVo();
        vo.setName("abc");

        TestReq target = mapper.map(vo, TestReq.class);

        System.out.println(JSON.toJSONString(target));
    }


    public static void testPropertyUtils() {

    }

    public static void main(String[] args) {
        testBeanCopy();
//        testBeanUtils();
//        testBeanMapper();
    }


}
