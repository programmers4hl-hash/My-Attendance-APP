package com.example.myattendance.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AttendanceRecord::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun attendanceDao(): AttendanceDao
}
