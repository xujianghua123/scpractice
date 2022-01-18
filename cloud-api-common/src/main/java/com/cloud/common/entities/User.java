package com.cloud.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/21 19:44
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String userName;

    private String userInfo;

}
