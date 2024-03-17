package com.teachmeskills.lesson14.logger;

import com.teachmeskills.lesson14.consts.PathToFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.teachmeskills.lesson14.consts.PathToFile.EXECUTION_LOG_FILE;


public class Logger {
    public static void logInfo(Date date, String infoMessage){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToLog = sdf.format(date);
        String message = "[INFO] -> " + dateToLog + " -> " + infoMessage;
        try /*(BufferedReader reader = new BufferedReader(new FileReader(PathToFile.DOC_NUM_FILE)))*/{
            Files.write(Paths.get(EXECUTION_LOG_FILE),message.getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e){

        }
    }

    public static void logError(Date date, String errorMessage, Exception exception){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateToLog = sdf.format(date);
        String message = "[ERROR] -> " + dateToLog + " -> " + errorMessage + "\n";
        try /*(BufferedReader reader = new BufferedReader(new FileReader(PathToFile.DOC_NUM_FILE)))*/{
            Files.write(Paths.get(PathToFile.ERROR_LOG_FILE),message.getBytes(), StandardOpenOption.APPEND);
            StringBuilder sb = new StringBuilder();
            sb.append("[ERROR] -> " + dateToLog + " -> " + errorMessage + "\n");
            StackTraceElement[] traceElements = exception.getStackTrace();
            for (StackTraceElement element : traceElements){
                sb.append(element.toString() + "\n");
            }
        }catch (IOException e){

        }
    }
}
