package com.cloud.order.Fallback;

import com.cloud.order.client.ProviderClient;
import org.springframework.stereotype.Component;

@Component
public class ProviderFallbackService implements ProviderClient {
    @Override
    public String paymentConsul() {
        return null;
    }
}
