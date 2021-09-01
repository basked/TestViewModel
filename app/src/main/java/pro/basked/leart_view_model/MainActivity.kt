package pro.basked.leart_view_model

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var tv: TextView
    lateinit var mViewModel: MainViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.textView)
            // Модель получаем из Провайдера
        mViewModel = ViewModelProvider(
            this,
            // Чтобы передать данный в конструктор необходима фабрика с контекстом
            MainFactory(application, "Basked")
        ).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        mViewModel.liveData.observe(this, Observer {
            tv.setText(it)
        })
    }
}