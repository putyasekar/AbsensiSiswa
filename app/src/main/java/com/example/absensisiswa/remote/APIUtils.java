package com.example.absensisiswa.remote;

public class APIUtils {

    private APIUtils() {
    }

    public static final String API_URL =
            "http://192.168.0.101/restCI_absensi_siswa/index.php/";

    public static AbsenService getAbsenService() {
        return RetrofitClient.getClient(API_URL)
                .create(AbsenService.class);
    }
}
