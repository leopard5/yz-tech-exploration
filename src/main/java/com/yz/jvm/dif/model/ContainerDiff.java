package com.yz.jvm.dif.model;

import com.github.dadiyang.equator.FieldInfo;
import com.github.dadiyang.equator.GetterBaseEquator;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author yazhong
 */
@Data
public class ContainerDiff extends GetterBaseEquator implements Serializable {
    private static final long serialVersionUID = -3152519062066839331L;

    private List<String> ignoreFields = Arrays.asList("totalWeight", "tareWeight");

    private String containerNo;
    private String blNo;

    private String voyage;
    private String vesselName;
    private String vesselNameNoSpace;
    private String transitPortCode;
    private String transitPortName;
    private String sealNo;
    private String truckNo;

    private BigDecimal pieces;
    private BigDecimal weight;
    private BigDecimal volume;

    private BigDecimal vgm;
    private BigDecimal totalWeight;
    private BigDecimal tareWeight;


    private String containerSize;
    private String containerType;
    private String containerOwner;
    private String containerStatus;
    private String containerHigh;

    private String imoClass;

    @Override
    protected boolean isFieldEquals(FieldInfo fieldInfo) {
        if (ignoreFields.contains(fieldInfo.getFieldName())) {
            return true;
        }
        if (fieldInfo.getFirstVal() instanceof Date) {
            Date first = (Date) fieldInfo.getFirstVal();
            Date second = (Date) fieldInfo.getSecondVal();
            if (Objects.equals(first, second)) {
                return true;
            }
            // 忽略毫秒数
            return Objects.equals(Math.round(first.getTime() / 1000), Math.round(second.getTime() / 1000));
        }
        return super.isFieldEquals(fieldInfo);
    }
}
