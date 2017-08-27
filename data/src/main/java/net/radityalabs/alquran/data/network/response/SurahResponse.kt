package net.radityalabs.alquran.data.network.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SurahResponse(
        val baseResponse: BaseResponse,
        @SerializedName("data")
        @Expose
        val data: List<SurahEntity>
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readParcelable<BaseResponse>(BaseResponse::class.java.classLoader),
            source.createTypedArrayList(SurahEntity.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeParcelable(baseResponse, 0)
        writeTypedList(data)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SurahResponse> = object : Parcelable.Creator<SurahResponse> {
            override fun createFromParcel(source: Parcel): SurahResponse = SurahResponse(source)
            override fun newArray(size: Int): Array<SurahResponse?> = arrayOfNulls(size)
        }
    }
}

data class SurahEntity(
        @SerializedName("number")
        @Expose
        val number: Int,
        @SerializedName("name")
        @Expose
        val name: String,
        @SerializedName("englishName")
        @Expose
        val englishName: String,
        @SerializedName("numberOfAyahs")
        @Expose
        val numberOfAyahs: Int,
        @SerializedName("englishNameTranslation")
        @Expose
        val englishNameTranslation: String,
        @SerializedName("revelationType")
        @Expose
        val revelationType: String
) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(number)
        writeString(name)
        writeString(englishName)
        writeInt(numberOfAyahs)
        writeString(englishNameTranslation)
        writeString(revelationType)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SurahEntity> = object : Parcelable.Creator<SurahEntity> {
            override fun createFromParcel(source: Parcel): SurahEntity = SurahEntity(source)
            override fun newArray(size: Int): Array<SurahEntity?> = arrayOfNulls(size)
        }
    }
}