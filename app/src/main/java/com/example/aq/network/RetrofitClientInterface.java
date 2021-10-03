package com.example.aq.network;

import com.example.aq.model.AdminApproved;
import com.example.aq.model.AdminApprovedAnswer;
import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.model.OtherPerson;
import com.example.aq.model.OwnPerson;
import com.example.aq.model.Person;
import com.example.aq.model.Sere;
import com.example.aq.model.ComplexSereList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitClientInterface {
    @GET("serealize")
    Call<List<Sere>> getSereList();

    @GET("serealize_single")
    Call<Sere> getSere();

    @GET("serealize_complex")
    Call<ComplexSereList> getComplexSereList();

    //@FormUrlEncoded
    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @POST("person/invite")
    Call<OwnPerson> createInviteQuest(@Body InviteQuest inviteQuest);


    //@FormUrlEncoded
    @GET("person/id/{id}")
    Call<Person> getPerson(@Path("id") int id);


    @GET("person/{token}")
    Call<OwnPerson> updatePersonData(@Path("token") String token);



    @GET("admin/persons/{token}")
    Call<List<OtherPerson>> getAllPersonsList(@Path("token") String token);


    @GET("admin/persons/pending/{token}")
    Call<List<OtherPerson>> getAllPendingList(@Path("token") String token);

    @GET("admin/persons/approved/{token}")
    Call<List<OtherPerson>> getApprovedList(@Path("token") String token);

    @GET("admin/persons/rejected/{token}")
    Call<List<OtherPerson>> getRejectedList(@Path("token") String token);

    @GET("admin/persons/fired/{token}")
    Call<OtherPerson> getFiredList();



    @POST("admin/approved/person/{token}")
    Call<AdminApprovedAnswer> sendApproved(@Body AdminApproved approved);
}
