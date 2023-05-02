package com.example.myapplication.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.data.models.NumberModel
import com.example.myapplication.domain.usecases.number.AddNumberUseCase
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.coroutineScope

@Composable
fun MainScreen(
    appList: List<NumberModel>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        AppGrid(appList)
    }
}

@Composable
fun AppGrid(appList: List<NumberModel>,
            mainViewModel: MainViewModel = hiltViewModel()) {
    LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
        items(appList.size) { index ->
            AppItem(appList[index])
            mainViewModel.addNumber(
                AddNumberUseCase.Params(
                    number = appList[index].number
                ))
        }
    }
    )
}

@Composable
fun AppItem(number: NumberModel,
            mainViewModel: MainViewModel = hiltViewModel()) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
            .border(2.dp, Color.Black, RoundedCornerShape(16.dp))
            .clickable {

            }
    ) {
        Text(
            text = number.number.toString(),
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MyApplicationTheme {
        MainScreen(appList = listOf())
    }
}