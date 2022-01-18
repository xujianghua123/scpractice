package com.spock.service

import com.spock.SpockApplication
import com.spock.entity.Order
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @Description:
 *
 * @Author: xjh* @Date: 2021/12/17 11:34
 */
@ContextConfiguration(classes = SpockApplication.class)
class SpockServiceSpec extends Specification {

    @Autowired
    private SpockService spoService

    @Unroll
    def "test1"() {
        expect:
        spoService.test1(param) == result

        where:
        param   ||  result
        1       ||  2
        2       ||  6
        3       ||  3
    }

    @Unroll
    def "test2"(){
        given: "设置参数"
        expect:
        spoService.test2(n)
        where:
        n || _
        1 || _
        0 || _
        -1|| _
    }

    def "given-when-then test"(){

        given:
        def order = new Order(orderId: 1,orderAmt: 1.99,goodsInfo: "奶茶")

        when:
        Long id = order.orderId

        then:
        id == 1

    }
}
