package com.android.example.eyehub_proto.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MultipleResource {

    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perPage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("data")
    public List<Datum> data = null;

    public class Datum {

        @SerializedName("_id")
        public Integer id;
        @SerializedName("name")
        public String name;
        @SerializedName("year")
        public Integer year;


    }
}