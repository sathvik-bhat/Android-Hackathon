package com.knightnight.login_and_stuff.Activities

import java.io.Serializable

class Shop (
    val name: String,
    val items: MutableList<Item> = mutableListOf(Item("abc",10),Item("fgh",20),Item("xyz",30))
) : Serializable