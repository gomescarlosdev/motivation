package br.com.gomescarlosdev.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.gomescarlosdev.motivation.R
import br.com.gomescarlosdev.motivation.databinding.ActivityMainBinding
import br.com.gomescarlosdev.motivation.mocks.Mock
import br.com.gomescarlosdev.motivation.util.AppSharedPreferences
import br.com.gomescarlosdev.motivation.util.MotivationConstants
import br.com.gomescarlosdev.motivation.util.MotivationConstants.FILTER.ALL
import br.com.gomescarlosdev.motivation.util.MotivationConstants.FILTER.HAPPY
import br.com.gomescarlosdev.motivation.util.MotivationConstants.FILTER.SUNNY


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Esconde a barra com o 'titulo' da activity
        supportActionBar?.hide()

        handleFilter(R.id.image_all)

        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.textHelloUser.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        showUserName()
    }

    override fun onClick(view: View) {
        if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)) {
            handleFilter(view.id)
        }
        if (view.id == R.id.button_new_phrase) {
            handleNewPhrase()
        }
        if(view.id == R.id.text_hello_user){
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    private fun showUserName() {
        val hello =
            "${getString(R.string.hello)}, ${
                AppSharedPreferences(this)
                    .getStoredString(MotivationConstants.KEY.USER_NAME)
            }"

        binding.textHelloUser.text = hello
    }

    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = SUNNY
            }
        }
        handleNewPhrase()
    }

    private fun handleNewPhrase() {
        when (categoryId) {
            ALL -> binding.textPhrase.text = Mock().getPhrase(ALL)
            HAPPY -> binding.textPhrase.text = Mock().getPhrase(HAPPY)
            SUNNY -> binding.textPhrase.text = Mock().getPhrase(SUNNY)
        }
    }
}