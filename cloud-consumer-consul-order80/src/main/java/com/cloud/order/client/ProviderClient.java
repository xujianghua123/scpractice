package com.cloud.order.client;

import com.cloud.order.Fallback.ProviderFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "consul-provider-payment",fallback = ProviderFallbackService.class)
public interface ProviderClient {

    @RequestMapping(value = "/payment/consul/paymentConsul")
    String paymentConsul();

}
