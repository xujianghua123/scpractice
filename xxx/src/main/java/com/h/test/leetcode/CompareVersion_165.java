package com.h.test.leetcode;

import org.junit.Test;

public class CompareVersion_165 {

    @Test
    public void test(){
        String version1 = "1.0";
        String version2 = "1.0.0";
        System.out.println(compareVersion(version1,version2));
    }

    public int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i = 0;
        for(;i<split1.length && i < split2.length;i++){
            if(Integer.valueOf(split1[i]) > Integer.valueOf(split2[i])){
                return 1;
            }else if(Integer.valueOf(split1[i]) < Integer.valueOf(split2[i])){
                return -1;
            }
        }

        if(split1.length > split2.length){
            if(!isZero(split1,i)){
                return 1;
            }
        }else if(split1.length < split2.length){
            if(!isZero(split2,i)) {
                return -1;
            }
        }
        return 0;
    }

    private boolean isZero(String[] split,int index){
        for(;index < split.length;index++){
            if(!Integer.valueOf(split[index]).equals(0)){
                return false;
            }
        }
        return true;
    }
}
