package com.cloud.payment.dao;

import com.cloud.common.entities.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {

    int create(Order order);

    /**
     * 刪除
     * @author
     * @date 2021/07/30
     **/
    int delete(int id);

    /**
     * 更新
     * @author
     * @date 2021/07/30
     **/
    int update(Order order);

    /**
     * 查询 根据主键 id 查询
     * @author
     * @date 2021/07/30
     **/
    Order load(int id);

    /**
     * 查询 分页查询
     * @author
     * @date 2021/07/30
     **/
    List<Order> pageList(int offset, int pagesize);

    /**
     * 查询 分页查询 count
     * @author
     * @date 2021/07/30
     **/
    int pageListCount(int offset,int pagesize);
}
