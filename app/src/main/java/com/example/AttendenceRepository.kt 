package com.example.myattendance.data

class AttendanceRepository(private val attendanceDao: AttendanceDao) {
    suspend fun insertRecord(record: AttendanceRecord) {
        attendanceDao.insertRecord(record)
    }

    suspend fun getRecordsByDate(date: String): List<AttendanceRecord> {
        return attendanceDao.getRecordsByDate(date)
    }

    suspend fun getTotalPresent(): Int {
        return attendanceDao.getTotalPresent()
    }
}
