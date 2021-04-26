package ilyasov.kotlincalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var num1:Double = 0.0
    private var num2:Double = 0.0
    private var res:Double = 0.0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numberText1:EditText = findViewById(R.id.editTextNumber_1)
        numberText1.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                try {
                    num1 = s.toString().toDouble()
                }
                catch (ex:Exception) {
                    num1 = 0.0
                }
            }
            override fun afterTextChanged(s: Editable) {}
        })
        val numberText2:EditText = findViewById(R.id.editTextNumber_2)
        numberText2.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s:CharSequence, start:Int, count:Int, after:Int) {}
            override fun onTextChanged(s:CharSequence, start:Int, before:Int, count:Int) {
                try {
                    num2 = s.toString().toDouble()
                }
                catch (ex:Exception) {
                    num2 = 0.0
                }
            }
            override fun afterTextChanged(s: Editable) {}
        })
        val resultView:TextView = findViewById(R.id.resultView)
        val btnPlus:Button = findViewById(R.id.buttonPlus)
        btnPlus.setOnClickListener {
                res = num1 + num2
                resultView.text = "Result: $res"
        }
        val btnMinus:Button = findViewById(R.id.buttonMinus)
        btnMinus.setOnClickListener {
            res = num1 - num2
            resultView.text = "Result: $res"
        }
        val btnMul:Button = findViewById(R.id.buttonMul)
        btnMul.setOnClickListener {
            res = num1 * num2
            resultView.text = "Result: $res"
        }
        val btnDiv:Button = findViewById(R.id.buttonDiv)
        btnDiv.setOnClickListener {
            res = num1 / num2
            resultView.text = "Result: $res"
        }
        val getResultButton:Button = findViewById(R.id.buttonEq)
        getResultButton.setOnClickListener {
            numberText1.setText(res.toString())
            num1 = res
        }
    }
}