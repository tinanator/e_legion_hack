package com.example.aq.network;

import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
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

    @GET("admin/persons")
    Call<List<Person>> getAllPersonsList();

    @GET("admin/persons/pending")
    Call<List<Person>> getAllPendingList();

    @GET("admin/persons/approved")
    Call<List<Person>> getApprovedList();

    @GET("admin/persons/rejected")
    Call<List<Person>> getRejectedList();

    @GET("admin/persons/fired")
    Call<Person> getFiredList();
}
