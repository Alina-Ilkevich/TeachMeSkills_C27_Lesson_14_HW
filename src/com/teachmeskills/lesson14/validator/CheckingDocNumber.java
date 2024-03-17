package com.teachmeskills.lesson14.validator;

import com.teachmeskills.lesson14.logger.Logger;
import com.teachmeskills.lesson14.consts.DocNumberRegexp;
import com.teachmeskills.lesson14.consts.PathToFile;

import java.io.*;
import java.util.Date;

public class CheckingDocNumber {
    public static void checkDocNumber(){
        try (BufferedReader reader = new BufferedReader(new FileReader(PathToFile.DOC_NUM_FILE));

             FileWriter validDocNumWriter = new FileWriter(PathToFile.VALID_NUM_FILE, true);
             FileWriter invalidDocNumWriter = new FileWriter(PathToFile.INVALID_NUM_FILE);
             FileWriter errorLogWriter = new FileWriter(PathToFile.ERROR_LOG_FILE);
             FileWriter executionLogWriter = new FileWriter(PathToFile.EXECUTION_LOG_FILE)) {

            String docNumber;

            while ((docNumber = reader.readLine()) != null) {
                if (docNumber.length() != 15){
                    invalidDocNumWriter.write(docNumber
                            + " Its length is not equal to 15 characters\n");
                    Logger.logInfo(new Date(),"The document number " + docNumber
                            +  " was not verified because its length is not equal to 15 characters " +
                            "and has been written to invalid_doc_number.txt\n");
                } else if (!docNumber.toLowerCase().startsWith("docnum")
                        && !docNumber.toLowerCase().startsWith("contract")) {
                    invalidDocNumWriter.write(docNumber
                            + " The document number must start with docnum or contract\n");
                    Logger.logInfo(new Date(), "The document number " + docNumber  +
                            " has not been verified, as it should start with docnum or contract " +
                            "and has been written to invalid_doc_number.txt\n");
                } else if (!docNumber.matches(DocNumberRegexp.REGEXP)){
                    invalidDocNumWriter.write(docNumber
                            + " The document number contains service characters\n");
                    Logger.logInfo(new Date(), "The document number " + docNumber  +
                            " has not been verified because it contains service characters " +
                            "and has been written to invalid_doc_number.txt\n");
                } else {
                    validDocNumWriter.write(docNumber + "\n");
                    Logger.logInfo(new Date(), "The document number " + docNumber  +
                            " has been successfully verified and has been written to valid_doc_number.txt\n");
                }
            }
        } catch (IOException e) {
            Logger.logError(new Date(),"Something went wrong",e);
        }
    }
}
