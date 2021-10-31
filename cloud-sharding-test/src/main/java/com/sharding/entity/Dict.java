package com.sharding.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_dict")
public class Dict {
    private Long dictId;
    private String ustatus;
    private String uvalue;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public String getUvalue() {
        return uvalue;
    }

    public void setUvalue(String uvalue) {
        this.uvalue = uvalue;
    }

    @Override
    public String toString() {
        return "Dict{" +
                "dictId=" + dictId +
                ", ustatus='" + ustatus + '\'' +
                ", uvalue='" + uvalue + '\'' +
                '}';
    }
}
