package com.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.entity.Course;
import com.sharding.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DictMapper extends BaseMapper<Dict> {
}
