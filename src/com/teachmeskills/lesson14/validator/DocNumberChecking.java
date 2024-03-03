package com.teachmeskills.lesson14.validator;

import com.teachmeskills.lesson14.WrongDocNumberException;
import com.teachmeskills.lesson14.consts.DocNumberRegexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocNumberChecking {
    public static boolean checkDocNumber(String DocNumber) throws WrongDocNumberException {
        Pattern pattern1 = Pattern.compile(DocNumberRegexp.DOCNUM_REGEXP);
        Matcher matcher1 = pattern1.matcher(DocNumber);
        if (!matcher1.matches()){
            throw new WrongDocNumberException("The document number must contain 15 characters, start with docnum," +
                    "and must not have any service characters");
        }
        Pattern pattern2 = Pattern.compile(DocNumberRegexp.CONTRACT_REGEXP);
        Matcher matcher2 = pattern2.matcher(DocNumber);
        if (!matcher2.matches()){
            throw new WrongDocNumberException("The document number must contain 15 characters, start with contract," +
                    "and must not have any service characters");
        }
        /*if (DocNumber.length() != 15){
            throw new WrongDocNumberException("The document number must contain 15 characters");
        }
        if (!DocNumber.startsWith("docnum")){
            throw new WrongDocNumberException("The document number must start with docnum");
        }
        if (!DocNumber.startsWith("contract")){
            throw new WrongDocNumberException("The document number must start with contract");
        }
        if (DocNumber.contains())*/
     return true;
    }
}
