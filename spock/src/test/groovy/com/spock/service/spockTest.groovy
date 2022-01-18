package com.spock.service

import com.spock.entity.Order
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @Description:
 *
 * @Author: xjh* @Date: 2021/12/21 15:32
 */
class spockTest extends Specification{

    def "test"(){
        given:
        def a = 1.1
        def b = 1
        5 * (b = a * b)
        println b

    }

    @Unroll
    def "and..when..then #test"(){
        given:
        def a = 1
        def b = 2

        and:
        def ord = new Order(orderAmt: 0,orderId: 1,goodsInfo: "abc")

        when:
        ord = new Order(orderId: a,orderAmt:b)

        then:
        with(ord){
            orderId == 1
            orderAmt == 2
            goodsInfo == null
        }
    }

    @Unroll
    def "regex"(){

        def regex = ~ '^\\d.*'

        expect:
        str =~ regex

        where:
        str <<['123adf','addf','1adf','_od2ds']
    }
}
