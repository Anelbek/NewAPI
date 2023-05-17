//package com.example.newapi.module
//
//import android.content.Context
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.example.newapi.model.request.response.MoviesDatabase
//
//@Composable
//fun DBScreen(row1: String, row2: String) {
//    Row(
//        modifier = Modifier
//            .background(MaterialTheme.colors.primary)
//            .fillMaxWidth()
//            .padding(5.dp)
//    ) {
//        Text(row1, color = Color.White,
//            modifier = Modifier
//                .weight(0.1f))
//        Text(row2, color = Color.White,
//            modifier = Modifier
//                .weight(0.2f))
//    }
//}
//
//@Composable
//fun MovieRow(id: Int, title: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(5.dp)
//    ) {
//        Text(id.toString(), modifier = Modifier
//            .weight(0.1f))
//        Text(title, modifier = Modifier.weight(0.2f))
//
//    }
//}
//
//@Composable
//fun CustomTextField(
//    title: String,
//    textState: String,
//    onTextChange: (String) -> Unit,
//    keyboardType: KeyboardType
//) {
//    OutlinedTextField(
//        value = textState,
//        onValueChange = { onTextChange(it) },
//        keyboardOptions = KeyboardOptions(
//            keyboardType = keyboardType
//        ),
//        singleLine = true,
//        label = { Text(title)},
//        modifier = Modifier.padding(10.dp),
//        textStyle = TextStyle(fontWeight = FontWeight.Bold,
//            fontSize = 30.sp)
//    )
//}