package com.dnights.koinsample.model

class Cell {

    private var value: Player? = null

    fun getValue(): Player? {
        return value
    }

    fun setValue(value: Player) {
        this.value = value
    }
}
