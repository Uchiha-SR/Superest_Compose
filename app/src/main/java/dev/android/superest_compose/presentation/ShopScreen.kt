package dev.android.superest_compose.presentation
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import dev.android.superest_compose.R
import dev.android.superest_compose.data.ProductItem
import dev.android.superest_compose.data.ProductItemData
import dev.android.superest_compose.presentation.component.SearchBar
import dev.android.superest_compose.presentation.component.SliderBanner
import dev.android.superest_compose.presentation.component.TopBar
import dev.android.superest_compose.ui.theme.colorPrimary
import dev.android.superest_compose.ui.theme.gray
import javax.annotation.meta.Exclusive

@OptIn(ExperimentalPagerApi::class)
@Preview

@Composable
fun HomePage() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    //   Surface(color = MaterialTheme.colors.background) {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        item {
            TopBar()
            SearchBar(textState)
            SliderBanner(modifier = Modifier)
        }
        item {
            Row(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Exlcusive Offer",
                    style = TextStyle(
                        fontSize = 18.sp,
                        //     fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    ),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "View All",
                    style = MaterialTheme.typography.subtitle2.copy(color = colorPrimary)
                )
            }
        }
        item {
            ExclusiveOfferList()
        }
        item {
            Row(
                modifier = Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Best Selling",
                    style = TextStyle(
                        fontSize = 18.sp,
                        //     fontFamily = FontFamily(Font(R.font.helvetica_neue_bold))
                    ),
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "View All",
                    style = MaterialTheme.typography.subtitle2.copy(color = colorPrimary)
                )

            }
        }

    }
}


@Composable
private fun ExclusiveOfferList() {
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
        items(ProductItemData.list.size) {
            productCard(ProductItemData.list[it])
        }
    }
}

@Composable
private fun productCard(product: ProductItem) {
    Card(
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White,
        modifier = Modifier
            .padding(10.dp)
            .width(180.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {

            Image(
                modifier = Modifier.size(140.dp),
                bitmap = ImageBitmap.imageResource(id = product.image),
                contentDescription = "flower_card"
            )
            Row(modifier = Modifier.padding(top = 20.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = product.title,
                        style = TextStyle(
                            color = gray,
                            fontSize = 16.sp,
                            //   fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                        )
                    )
                    Text(
                        text = "$${product.price}",
                        style = TextStyle(
                            color = gray,
                            fontSize = 16.sp,
                            //   fontFamily = FontFamily(Font(R.font.helvetica_neue_medium))
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .background(
                            color = colorPrimary,
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Icon(
                        Icons.Default.Add,
                        tint = Color.White,
                        modifier = Modifier.padding(10.dp),
                        contentDescription = "flower_card_icon"
                    )
                }
            }
        }
    }
}


@Preview("Menu Item Card • Dark")
@Composable
private fun MenuItemCardDarkPreview() {

        productCard(
            product = ProductItem(

                    id = 6,
                    title = "Organic Bananas",
                    description = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet.",
                    image = R.drawable.product7,
                    unit = "7pcs, Priceg",
                    price = 4.99,
                    nutritions = "100gr",
                    review = 4.0
                )
        )
    }
