package com.axwel.watchit

data class ExampleDataClass(
        val valueString: String,
        val valueInt: Int
): Data {
    override fun getString(): String = valueString

    override fun getInt(): Int = valueInt
}
