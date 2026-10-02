package com.example.myattendance.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myattendance.data.AttendanceRecord
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun AttendanceScreen(viewModel: AttendanceViewModel) {
    var studentName by remember { mutableStateOf("") }
    val currentDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = studentName,
            onValueChange = { studentName = it },
            label = { Text("Student Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (studentName.isNotEmpty()) {
                    val record = AttendanceRecord(name = studentName, date = currentDate, status = "Present")
                    viewModel.insertRecord(record)
                    studentName = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mark Present")
        }
    }
}
