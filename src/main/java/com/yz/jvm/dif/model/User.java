package com.yz.jvm.dif.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Diffable<User> {

    @Override
    public DiffResult diff(User obj) {
//        if (obj.getAge() - this.getAge() < 60 || obj.getAge() - this.getAge() > -60) {
//            obj.setAge(this.getAge());
//        }
        if (StringUtils.isNotEmpty(this.getContext()) && StringUtils.isNotEmpty(obj.getContext())
                && StringUtils.equalsIgnoreCase(this.getContext(), obj.getContext())) {
            obj.setContext(this.getContext());
        }

        return new DiffBuilder(this, obj, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("age", this.getAge(), obj.getAge())
                .append("username", this.getUsername(), obj.getUsername())
                .append("context", this.getContext(), obj.getContext())
                .build();
    }


    private Long age;
    private String username;
    private String context;
}
