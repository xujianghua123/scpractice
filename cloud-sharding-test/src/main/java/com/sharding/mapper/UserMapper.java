package com.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sharding.entity.Dict;
import com.sharding.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select u.user_id,u.username,d.uvalue ustatus from t_user u left join t_dict d on u.ustatus = d.ustatus")
    public List<User> queryUserStatus();
}
