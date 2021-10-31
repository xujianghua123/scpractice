package com.sharding.algorithm;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Arrays;
import java.util.Collection;

public class MyHintShardingAlgorithm implements HintShardingAlgorithm<Integer> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Integer> shardingValue) {
        String key = shardingValue.getLogicTableName() + "_" + shardingValue.getValues().toArray()[0];
        if(availableTargetNames.contains(key)){
            return Arrays.asList(key);
        }
        throw new UnsupportedOperationException("route "+ key +" is not supported ,please check your config");
    }
}

