package id.calocallo.gbkapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import id.calocallo.gbkapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var selectFromUser: String? = null
    private lateinit var binding: ActivityMainBinding
    private var selectFromCom: String? = null
    private var selected1: Boolean = false
    private var btn1: View? = null
    private var btn2: View? = null
    private var textResult: String? = null

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBatuUser.setOnClickListener {
            if (!selected1) {
                selected1 = true
                btn1 = it
                binding.btnBatuUser.background = ContextCompat.getDrawable(this, R.color.teal_200)
                binding.btnBatuUser.radius = 12f
                selectFromUser = "batu"
                doSuit()
                Log.e("selectedUser", "$selectFromUser")
            }
        }
        binding.btnGuntingUser.setOnClickListener {
            if (!selected1) {
                selected1 = true
                btn1 = it
                binding.btnGuntingUser.background = ContextCompat.getDrawable(this, R.color.teal_200)
                binding.btnGuntingUser.radius = 12f
                selectFromUser = "gunting"
                doSuit()
                Log.e("selectedUser", "$selectFromUser")

            }
        }
        binding.btnKertasUser.setOnClickListener {
            if (!selected1) {
                selected1 = true
                btn1 = it
                selectFromUser = "kertas"
                binding.btnKertasUser.background = ContextCompat.getDrawable(this, R.color.teal_200)
                binding.btnKertasUser.radius = 12f
                doSuit()
                Log.e("selectedUser", "$selectFromUser")

            }
        }

        binding.btnReset.setOnClickListener {
            if (btn1 == null) {
                Toast.makeText(this, "Harus ada yang dipilih dari pengguna", Toast.LENGTH_SHORT)
                    .show()
            } else {
                selected1 = false
//            selected1 = false
//                btn1 = null
//                btn2 = null
                selectFromUser = ""
                selectFromCom = ""
                btn1?.background = ContextCompat.getDrawable(this, R.color.white)
                btn2?.background = ContextCompat.getDrawable(this, R.color.white)
                binding.txtResult.text = getString(R.string.vs)
                binding.txtResult.setPadding(0, 0, 0, 0)
                binding.txtResult.background = ContextCompat.getDrawable(this, android.R.color.transparent)
            }
        }


    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private fun doSuit() {
        if (selectFromUser != null) {
            Handler(Looper.getMainLooper()).postDelayed({
                val com = arrayOf("gunting", "batu", "kertas")
                val random = Random.nextInt(com.size)
                selectFromCom = com[random]
                when (selectFromCom) {
                    "gunting" -> {
                        binding.btnGuntingCom.background = ContextCompat.getDrawable(this, R.color.teal_200)
                        binding.btnGuntingCom.radius = 12f
                        btn2 = binding.btnGuntingCom
                    }
                    "batu" -> {
                        binding.btnBatuCom.background = ContextCompat.getDrawable(this, R.color.teal_200)
                        binding.btnBatuCom.radius = 12f
                        btn2 = binding.btnBatuCom
                    }
                    else -> {
                        binding.btnKertasCom.background = ContextCompat.getDrawable(this, R.color.teal_200)
                        binding.btnKertasCom.radius = 12f
                        btn2 = binding.btnKertasCom
                    }
                }
                when (selectFromUser) {
                    "batu" -> {
                        when (selectFromCom) {
                            "batu" -> {
                                binding.txtResult.text = getString(R.string.draw)
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                            "gunting" -> {
                                binding.txtResult.text = getString(R.string.player2_win)
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                            "kertas" -> {
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                binding.txtResult.text = getString(R.string.player1_win)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                        }
                    }
                    "gunting" -> {
                        when (selectFromCom) {
                            "batu" -> {
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                binding.txtResult.text = getString(R.string.player2_win)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                            "gunting" -> {
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                binding.txtResult.text = getString(R.string.draw)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                            "kertas" -> {
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                binding.txtResult.text = getString(R.string.player1_win)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                        }
                    }
                    "kertas" -> {
                        when (selectFromCom) {
                            "batu" -> {
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                binding.txtResult.text = getString(R.string.player1_win)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                            "gunting" -> {
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                binding.txtResult.text = getString(R.string.player2_win)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                            "kertas" -> {
                                binding.txtResult.setPadding(10, 10, 10, 10)
                                binding.txtResult.background =
                                    ContextCompat.getDrawable(this, R.color.white)
                                binding.txtResult.text = getString(R.string.draw)
                                textResult = binding.txtResult.text.toString()
                                Log.e("result", "$textResult")
                            }
                        }
                    }
                }

            }, 500)

        }
    }


}
