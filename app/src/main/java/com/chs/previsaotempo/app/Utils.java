package com.chs.previsaotempo.app;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {
    public static String generateData(){
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date());
    }
}
