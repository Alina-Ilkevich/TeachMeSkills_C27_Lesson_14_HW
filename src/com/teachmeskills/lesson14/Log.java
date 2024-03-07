package com.teachmeskills.lesson14;

import com.teachmeskills.lesson14.consts.PathToFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.teachmeskills.lesson14.consts.PathToFile.EXECUTION_LOG_FILE;


public class Log {
    public static void logInfo(Date date, String infoMessage) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(PathToFile.DOC_NUM_FILE))){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateLog = sdf.format(date);
            String message = "[INFO] -> " + dateLog + " -> " + infoMessage;
            Files.write(Paths.get(EXECUTION_LOG_FILE),message.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e){

        }
    }

    public static void logError(Date date, String errorMessage, Exception exception){
        try (BufferedReader reader = new BufferedReader(new FileReader(PathToFile.DOC_NUM_FILE))){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateLog = sdf.format(date);
            String message = "[ERROR] -> " + dateLog + " -> " + errorMessage + "\n";
            Files.write(Paths.get(PathToFile.ERROR_LOG_FILE),errorMessage.getBytes(), StandardOpenOption.APPEND);
            StringBuilder sb = new StringBuilder();
            sb.append("[ERROR] -> " + dateLog + " -> " + errorMessage + "\n");
            StackTraceElement[] traceElements = exception.getStackTrace();
            for (StackTraceElement element : traceElements){
                sb.append(element.toString() + "\n");
            }
        }catch (IOException e){

        }
    }
}
