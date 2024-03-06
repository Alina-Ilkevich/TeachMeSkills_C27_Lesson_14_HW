package com.teachmeskills.lesson14.validator;

import com.teachmeskills.lesson14.Log;
import com.teachmeskills.lesson14.consts.DocNumberRegexp;
import com.teachmeskills.lesson14.consts.PathToFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocNumberChecking {
    public static void checkDocNumber(){
        try (BufferedReader reader = new BufferedReader(new FileReader(PathToFile.DOC_NUM_FILE))) {
            String docNumber;
            while ((docNumber = reader.readLine()) != null) {
                if (docNumber.length() != 15) {
                    Log.logInfo(new Date(), "The document number must contain 15 characters\n");
                } else if (!docNumber.startsWith("docnum") || !docNumber.startsWith("contract")) {
                    Log.logInfo(new Date(), "The document number must start with docnum or contract\n");
                /*} else if (!docNumber.startsWith("contract")) {
                    Log.logInfo(new Date(), "The document number must start with contract\n");*/
                } else if (!docNumber.matches(DocNumberRegexp.REGEXP)) {
                    Log.logInfo(new Date(), "The document number must not have any service characters\n");
                } else if (docNumber.matches(DocNumberRegexp.DOCNUM_REGEXP)) {
                    Log.logInfo(new Date(), "The file name " + docNumber + " was successfully recorded\n");
                } else if (docNumber.matches(DocNumberRegexp.CONTRACT_REGEXP)) {
                    Log.logInfo(new Date(), "The file name " + docNumber + " was successfully recorded\n");
                }
            }

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        /*if (!docNumber.startsWith("docnum")){
            throw new WrongDocNumberException("The document number must start with docnum");
        }
        if (!docNumber.startsWith("contract")){
            throw new WrongDocNumberException("The document number must start with contract");
        }
        Pattern pattern = Pattern.compile(DocNumberRegexp.REGEXP);
        Matcher matcher = pattern.matcher(docNumber);
        if (!matcher.matches()){
            throw new WrongDocNumberException("The document number must not have any service characters");
        }*/
    }
}
