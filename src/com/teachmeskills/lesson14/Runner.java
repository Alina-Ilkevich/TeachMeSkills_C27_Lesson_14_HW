package com.teachmeskills.lesson14;

import com.teachmeskills.lesson14.consts.DocNumberRegexp;
import com.teachmeskills.lesson14.validator.DocNumberChecking;

public class Runner {
    public static void main(String[] args) {
        DocNumberChecking.checkDocNumber();
        System.out.println("____________");
    }
}
