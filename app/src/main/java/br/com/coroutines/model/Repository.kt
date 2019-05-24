package br.com.coroutines.model

import com.google.gson.annotations.SerializedName

data class Repository(val id:Int,

                      @SerializedName("node_id")
                      val nodeId:String,
                      val name:String,

                      @SerializedName("full_name")
                      val full_name:String)
