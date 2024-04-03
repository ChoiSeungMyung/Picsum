package com.example.lookpin.feature.photodetail.ui

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.lookpin.feature.photodetail.PhotoDetailViewEffect
import com.example.lookpin.feature.photodetail.PhotoDetailViewModel
import com.example.lookpin.feature.photodetail.R
import com.example.lookpin.feature.photodetail.model.PhotoDetailUiModel

@Composable
internal fun PhotoDetailRoute(
    viewModel: PhotoDetailViewModel = hiltViewModel(),
) {
    val effect by viewModel.effect.collectAsStateWithLifecycle()
    val uiModel by viewModel.photoUiModel.collectAsStateWithLifecycle()

    when (effect) {
        is PhotoDetailViewEffect.Error -> PhotoDetailErrorScreen(
            onButtonClick = viewModel::refreshPhoto,
        )

        PhotoDetailViewEffect.Success -> PhotoDetailScreen(
            uiModel = uiModel,
            onCheckClick = viewModel::onCheckClick,
            onButtonClick = {}, // No functionality
            onImageLoadError = viewModel::imageLoadError,
        )

        null -> Unit // init screen
    }
}

@Composable
private fun PhotoDetailScreen(
    modifier: Modifier = Modifier,
    uiModel: PhotoDetailUiModel?,
    onCheckClick: (Boolean) -> Unit,
    onButtonClick: () -> Unit,
    onImageLoadError: () -> Unit,
) {
    if (uiModel == null) return

    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f),
        )

        AsyncImage(
            model = uiModel.imageUrl,
            contentDescription = "Selected Image",
            onError = { onImageLoadError() },
            modifier = Modifier
                .fillMaxWidth(),
        )

        Spacer(
            modifier = Modifier
                .weight(1f),
        )

        Row(
            horizontalArrangement = spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Checkbox(
                checked = uiModel.checked,
                onCheckedChange = onCheckClick,
                modifier = Modifier
                    .size(64.dp),
            )

            Button(
                onClick = onButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
            ) {
                Text(
                    text = stringResource(R.string.button_text),
                )
            }
        }
    }
}

@Composable
private fun PhotoDetailErrorScreen(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize(),
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f),
        )

        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "Warning",
            tint = Color.Red,
            modifier = Modifier
                .size(100.dp),
        )
        Text(
            text = stringResource(R.string.message_error),
            modifier = Modifier
                .padding(top = 8.dp),
        )

        Button(
            onClick = onButtonClick,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(R.string.button_refresh),
            )
        }
    }
}
