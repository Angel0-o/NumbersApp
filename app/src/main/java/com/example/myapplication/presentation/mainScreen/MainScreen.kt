package com.example.myapplication.presentation.mainScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    appList: List<NumberModel>,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val sortedList by mainViewModel.numbersByOrder.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Box(
            Modifier
                .border(width = 2.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .height(300.dp)
                .verticalScroll(rememberScrollState())
        ) {
            OutlinedTextField(
                value = sortedList,
                onValueChange = {},
                enabled = false,
                modifier = Modifier.fillMaxWidth(),
            )
        }
            LazyVerticalGrid(columns = GridCells.Fixed(3), content = {
                items(appList.size) { index ->
                    AppItem(appList[index])
                }
            }
            )

        }
}

@Composable
fun AppItem(
    number: NumberModel,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
            .border(2.dp, Color.Black, RoundedCornerShape(16.dp))
            .clickable {
                mainViewModel.addNumber(
                    AddNumberUseCase.Params(
                        number = number.number
                    )
                )
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