package com.example.absensisiswa.remote;

import com.example.absensisiswa.model.PersonItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface AbsenService {

    @GET("person/get/")
    Call<List<PersonItem>> getAbsen();

    @FormUrlEncoded
    @POST("person/add")
    Call<PersonItem> addAbsen(@Field("nama") String nama,
                                @Field("kelas") String kelas,
                                @Field("pelajaran") String pelajaran,
                                @Field("keterangan_masuk") String keterangan_masuk,
                                @Field("tanggal") String tanggal);


    @FormUrlEncoded
    @PUT("person/update/")
    Call<PersonItem> updateAbsen(@Field("id") int id,
                                   @Field("nama") String nama,
                                   @Field("kelas") String kelas,
                                   @Field("pelajaran") String pelajaran,
                                   @Field("keterangan_masuk") String keterangan_masuk,
                                   @Field("tanggal") String tanggal);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = ("person/delete/"), hasBody = true)
    Call<PersonItem> deleteAbsen(@Field("id") int id);

}
