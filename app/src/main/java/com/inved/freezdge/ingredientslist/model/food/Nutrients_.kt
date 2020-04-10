package com.inved.freezdge.ingredientslist.model.food

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Nutrients_ {
    @SerializedName("ENERC_KCAL")
    @Expose
    var eNERCKCAL: Double? = null
    @SerializedName("PROCNT")
    @Expose
    var pROCNT: Double? = null
    @SerializedName("FAT")
    @Expose
    var fAT: Double? = null
    @SerializedName("CHOCDF")
    @Expose
    var cHOCDF: Double? = null
    @SerializedName("FIBTG")
    @Expose
    var fIBTG: Double? = null

}