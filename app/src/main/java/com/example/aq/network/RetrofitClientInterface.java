package com.example.aq.network;

import com.example.aq.model.InviteAnswer;
import com.example.aq.model.InviteQuest;
import com.example.aq.model.Sere;
import com.example.aq.model.ComplexSereList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
    @POST("person/invite")
    Call<InviteAnswer> createInviteQuest(@Body InviteQuest inviteQuest);


    //@FormUrlEncoded
    @GET("person/id/{id}")
    Call<InviteAnswer> createInviteQuest(@Path("id") int id);



    @GET("admin/persons")
    Call<ComplexSereList> getAllPersonsList();

    @GET("admin/persons/pending")
    Call<ComplexSereList> getAllPendingList();

    @GET("admin/persons/approved")
    Call<ComplexSereList> getApprovedList();

    @GET("admin/persons/rejected")
    Call<ComplexSereList> getRejectedList();

    @GET("admin/persons/fired")
    Call<ComplexSereList> getFiredList();
}
