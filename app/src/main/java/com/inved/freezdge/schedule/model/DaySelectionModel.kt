package com.inved.freezdge.schedule.model

import android.os.Parcel
import android.os.Parcelable

class DaySelectionModel():Parcelable {

    var day: Long? = null
    var lunch: Long? = null
    var dinner: Long? = null

    constructor(parcel: Parcel) : this() {
        day = parcel.readValue(Long::class.java.classLoader) as? Long
        lunch = parcel.readValue(Long::class.java.classLoader) as? Long
        dinner = parcel.readValue(Long::class.java.classLoader) as? Long
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(day)
        parcel.writeValue(lunch)
        parcel.writeValue(dinner)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DaySelectionModel> {
        override fun createFromParcel(parcel: Parcel): DaySelectionModel {
            return DaySelectionModel(parcel)
        }

        override fun newArray(size: Int): Array<DaySelectionModel?> {
            return arrayOfNulls(size)
        }
    }


}