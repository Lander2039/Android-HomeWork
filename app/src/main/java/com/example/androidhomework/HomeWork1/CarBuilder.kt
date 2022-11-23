package com.example.androidhomework.HomeWork1

class CarBuilder(val builder: Builder) {


    fun hasFourWheelDrive() = builder.fourWheelDrive
    fun whichEngineVolume() = builder.engineVolume
    fun howManysecuritySystems() = builder.securitySystems

    companion object Builder{
        var engineVolume: Int = 0
        var fourWheelDrive: Boolean = false
        var securitySystems: Int = 0

        fun setengineVolume(engineVolume: Int)= apply { this.engineVolume = engineVolume }
        fun setFourWheelDrive(fourWheelDrive: Boolean)= apply { this.fourWheelDrive = fourWheelDrive}
        fun setsecuritySystems(securitySystems: Int)= apply { this.securitySystems = securitySystems}

        fun build(): CarBuilder{
            return CarBuilder(this)
        }

    }
}