package javaTest;

import org.apache.naming.factory.BeanFactory;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

/**
 * @author : xujianghua
 * @description : TODO
 * @date : 2021/6/9 23:11
 */
public class test01 {

    public static void main(String[] args) {

        test01 test01 = new test01();
        System.out.println(String.class.getClassLoader());
        System.out.println(BeanFactory.class.getClassLoader().getParent());
        System.out.println(test01.getClass().getClassLoader());
    }

    @Test
    public void test(){
        int arr[] = {5,2,8,3,7,1,4,6};
        this.selectSort(arr);
    }

    private void selectSort(int[] arr){

        for(int i = 0;i< arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex > i){
                int firstNum = arr[minIndex];
                for (int k = minIndex;k>i;k--){
                    arr[k] = arr[k-1];
                }
                arr[i] = firstNum;
            }
        }

        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + "\t");
        }

    }
}
