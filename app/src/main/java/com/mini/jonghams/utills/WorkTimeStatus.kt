package com.mini.jonghams.utills

import java.util.*

fun isOnWorkingTime(startTime: Int, endTime: Int): Boolean {
    var startCal = Calendar.getInstance()
    startCal.set(
        startCal.get(Calendar.YEAR),
        startCal.get(Calendar.MONTH),
        startCal.get(Calendar.DATE),
        startTime,
        0,
        0
    )
    var startTimeStamp = startCal.time.time

    val endCal = Calendar.getInstance()
    endCal.set(
        endCal.get(Calendar.YEAR),
        endCal.get(Calendar.MONTH),
        endCal.get(Calendar.DATE),
        endTime,
        0,
        0
    )
    var endTimeStamp = endCal.time.time

    var workingCal = Calendar.getInstance()

    workingCal.set(
        workingCal.get(Calendar.YEAR),
        workingCal.get(Calendar.MONTH),
        workingCal.get(Calendar.DATE),
        workingCal.get(Calendar.HOUR_OF_DAY),
        workingCal.get(Calendar.MINUTE),
        0
    )
    var workingTimeStamp = workingCal.time.time

    return workingTimeStamp in startTimeStamp..endTimeStamp
}