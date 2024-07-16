package com.tech.challenge.zonaAzul.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DataUtils {

    private static final TimeZone TIME_ZONE_GMT = TimeZone.getTimeZone("GMT");

    public static Date obterDataHoraCorrente() {
        final Calendar calendar = Calendar.getInstance(TIME_ZONE_GMT);
        return calendar.getTime();
    }

    public static Date obterDataHoraComHoraIncrementada(Date dataHora, int horasPraIncrementar) {
        final Calendar calendar = Calendar.getInstance(TIME_ZONE_GMT);
        calendar.setTime(dataHora);
        calendar.add(Calendar.HOUR_OF_DAY, horasPraIncrementar);
        return calendar.getTime();
    }

}
