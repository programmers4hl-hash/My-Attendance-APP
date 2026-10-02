package com.example.myattendance.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myattendance.data.AttendanceRecord
import com.example.myattendance.data.AttendanceRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AttendanceViewModel(private val repository: AttendanceRepository) : ViewModel() {
    private val _attendanceRecords = MutableStateFlow<List<AttendanceRecord>>(emptyList())
    val attendanceRecords: StateFlow<List<AttendanceRecord>> = _attendanceRecords.asStateFlow()

    fun insertRecord(record: AttendanceRecord) {
        viewModelScope.launch {
            repository.insertRecord(record)
        }
    }

    fun getRecordsByDate(date: String) {
        viewModelScope.launch {
            _attendanceRecords.value = repository.getRecordsByDate(date)
        }
    }
}
