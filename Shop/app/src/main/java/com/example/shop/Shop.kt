package com.example.shop

import java.io.Serializable

class Shop (
    val name: String,
    val items: MutableList<Item> = mutableListOf(Item("abc",10),Item("fgh",20),Item("xyz",30))
) : Serializable