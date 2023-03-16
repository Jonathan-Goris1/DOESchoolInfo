package com.example.doeschoolinfo.presentation.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.doeschoolinfo.domain.model.SchoolInfoItem

@Composable
fun HomeScreen(
    homeViewModel: HomeScreenViewModel = hiltViewModel()
) {
    val homeUiState = homeViewModel.uiState.collectAsState().value

    SchoolInfoItem(homeUiState = homeUiState)

}

@Composable
fun SchoolInfoItem(
    homeUiState: HomeUiState
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(8.dp),

        ) {
        when (homeUiState) {
            is HomeUiState.Success -> {
                items(homeUiState.schoolsInfo ?: emptyList()) { schoolInfo ->
                    SchoolInfoCard(schoolInfo = schoolInfo)
                }
            }
            is HomeUiState.Error -> {

            }
            is HomeUiState.Loading -> {}
        }
    }

}

@Composable
fun SchoolInfoCard(
    schoolInfo: SchoolInfoItem
) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        ) {
            Row {
                Text(
                    text = "${schoolInfo.school_name}",
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )


            }
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 1.dp,
                color = Color.LightGray
            )

        }
    }
}

//val borough: String?,
//val phone_number: String,
//val primary_address_line_1: String,
//val directions1: String,
//val website: String,
//val school_email: String,