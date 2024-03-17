package com.example.diceroller20

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller20.ui.theme.DiceRoller20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRoller20Theme {
                DicerRollerApp()

            }
        }
    }
}

@Composable
fun DicerRollerApp(){
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}


@Preview
@Composable
//A função permitirá que um parâmetro seja passado.O valor do padãro do parâmetro é um objeto, portanto, a parte da assinatura do método
// O valor padrão de um parâmetro permite que qualquer pessoa que chame esse método no futuro decida se deseja passar um valor para o parâmetro.
fun DiceWithButtonAndImage(modifier: Modifier =  Modifier){
    Spacer(modifier = Modifier.height(16.dp))

    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
Column(

    modifier =  modifier,
    horizontalAlignment = Alignment.CenterHorizontally ){
        Image(painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )
    Button(onClick = { result = (1..6).random() }) {
        Text(stringResource(R.string.roll))
    }
}
}
