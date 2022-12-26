package com.example.shiftmobile

import com.google.gson.annotations.SerializedName

data class CardInfo(
   @SerializedName("number") val number: CardNumber,
   @SerializedName("scheme") val scheme: String,
   @SerializedName("type") val type: String,
   @SerializedName("brand") val brand: String,
   @SerializedName("prepaid") val prepaid: Boolean,
   @SerializedName("country") val country: CartCountry,
   @SerializedName("bank") val bank: CardBank
)

data class CardNumber(
    @SerializedName("length") val length: Int,
    @SerializedName("luhn") val luhn: Boolean
)

data class CartCountry(
    @SerializedName("numeric") val numeric: String,
    @SerializedName("alpha2") val alpha2: String,
    @SerializedName("name") val name: String,
    @SerializedName("emoji") val emoji: String,
    @SerializedName("currency") val currency: String,
    @SerializedName("latitude") val latitude: Int,
    @SerializedName("longitude") val longitude: Int
)

data class CardBank(
   @SerializedName("name") val name: String,
   @SerializedName("url") val url: String,
   @SerializedName("phone") val phone: String,
   @SerializedName("city") val city: String
)
