package com.example.navigationdrawer.appdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.navigationdrawer.DrawerParams
import com.example.navigationdrawer.MainNavOption

@Composable
fun <T> AppDrawerItem(item: AppDrawerItemInfo<T>, onClick: (options: T) -> Unit) =
    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxWidth().padding(0.dp),
        onClick = { onClick(item.drawerOption) },
        // shape = RoundedCornerShape(50),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth().padding(20.dp)
        ) {
            Icon(
                painter = painterResource(id = item.drawableId),
                contentDescription = stringResource(id = item.descriptionId),
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = item.title),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }
    }


class MainStateProvider : PreviewParameterProvider<AppDrawerItemInfo<MainNavOption>> {
    override val values = sequence {
        DrawerParams.drawerButtons.forEach { element ->
            yield(element)
        }
    }
}

//@Preview
//@Composable
//fun AppDrawerItemPreview(@PreviewParameter(MainStateProvider::class) state: AppDrawerItemInfo<MainNavOption>) {
//    AppDrawerExampleTheme {
//        AppDrawerItem(item = state, onClick = {})
//    }
//}