package com.example.myapplication.activities.models

import android.os.Parcel
import android.os.Parcelable


data class Student(
    var name        : String?,
    var lastName    : String?,
    var age         : Int,
    var isDeveloper : Boolean = true
) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString ( name     )
        parcel.writeString ( lastName )
        parcel.writeInt    ( age      )
        parcel.writeByte   ( if (isDeveloper) 1 else 0 )
    }

    override fun describeContents(): Int = 0

    companion object CREATOR: Parcelable.Creator<Student> {

        override fun createFromParcel(parcel: Parcel) = Student( parcel )

        override fun newArray(size: Int) = arrayOfNulls<Student?>( size )
    }

}