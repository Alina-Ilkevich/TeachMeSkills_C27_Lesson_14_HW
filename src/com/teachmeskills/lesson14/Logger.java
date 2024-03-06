package com.teachmeskills.lesson14;

import com.teachmeskills.lesson14.consts.PathToFile;
import com.teachmeskills.lesson14.validator.DocNumberChecking;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    public static void logInfo(Date date, String infoMessage) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(PathToFile.DOC_NUM_FILE));
             FileWriter validDocNumWriter = new FileWriter(PathToFile.VALID_NUM_FILE, true);
             FileWriter invalidDocNumWriter = new FileWriter(PathToFile.INVALID_NUM_FILE);
             FileWriter errorLogWriter = new FileWriter(PathToFile.ERROR_LOG_FILE);
             FileWriter executionLogWriter = new FileWriter(PathToFile.EXECUTION_LOG_FILE)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateLog = sdf.format(date);
            String message = "[INFO] -> " + dateLog + " -> " + infoMessage + "\n";
            String docNumber;
            while ((docNumber = reader.readLine()) != null) {
                if (docNumber.length() != 15){

                }
            }
        } catch (IOException e) {
        }
    }
}
