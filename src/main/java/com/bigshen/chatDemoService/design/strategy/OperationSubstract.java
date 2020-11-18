package com.bigshen.chatDemoService.design.strategy;

/**
 * @Description:
 * @Author: BIGSHEN
 * @Date: 2019/12/21 16:09
 */
public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1-num2;
    }
}
