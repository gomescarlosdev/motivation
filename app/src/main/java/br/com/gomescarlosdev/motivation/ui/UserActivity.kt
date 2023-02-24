package br.com.gomescarlosdev.motivation.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.gomescarlosdev.motivation.R
import br.com.gomescarlosdev.motivation.databinding.ActivityUserBinding
import br.com.gomescarlosdev.motivation.util.AppSharedPreferences
import br.com.gomescarlosdev.motivation.util.MotivationConstants

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        supportActionBar?.hide()
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            handleSave()
        }
    }

    private fun handleSave() {
        val userName = binding.editUserName.text.toString()
        if (userName != "") {
            AppSharedPreferences(this).storeString(
                MotivationConstants.KEY.USER_NAME,
                userName
            )
            finish()
        } else {
            Toast.makeText(
                this,
                R.string.validation_mandatory_name,
                Toast.LENGTH_SHORT
            ).show()
        }

    }

//
//    private fun verifyUserName(){
//        val name = AppSharedPreferences(this).getStoredString(MotivationConstants.KEY.USER_NAME)
//        if(name != ""){
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }
//    }
}