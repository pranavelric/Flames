package com.flame.flames.ui.home


import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableField
import com.flame.flames.R
import com.flame.flames.ui.base.BaseViewModel
import com.flame.flames.ui.dialogs.MyBottomSheetDialogFragment
import com.flame.flames.utils.snackbar
import org.apache.commons.lang3.ArrayUtils
import java.util.*

class HomeViewModel : BaseViewModel() {

    var name = ObservableField<String>()
    var partnerName = ObservableField<String>()
    var FLAMES = "FLAMES"
    var arrFLAMES = FLAMES.toCharArray()


    var yourName: String? = null
    var mPartnerName: String? = null

    var arryourName: Array<String>? = null
    var arrpartnerName: Array<String>? = null

      var image_resource = ObservableField<Int>()

    private lateinit var myBottomSheetDialogFragment: MyBottomSheetDialogFragment

    fun onClickFlameTest(view: View) {


        if (name.get().isNullOrBlank()) {
            view.snackbar("Please enter your name")
        } else if (partnerName.get().isNullOrBlank()) {
            view.snackbar("Please enter your partners name")
        } else {


            flameTest(name.get()!!, partnerName.get()!!)
            displayOutput(view)



            myBottomSheetDialogFragment =
                MyBottomSheetDialogFragment(image_resource.get()!!).apply {
                    show((view.context as AppCompatActivity).supportFragmentManager, tag)
                }



            FLAMES = "FLAMES"
            arrFLAMES = FLAMES.toCharArray()


            name.set("")
            partnerName.set("")
        }

    }


    private fun flameTest(name: String, partnerName: String) {


        yourName = name.toLowerCase(Locale.ROOT).trim().replace("\\s+".toRegex(), "")
        arryourName = yourName!!.split("".toRegex()).toTypedArray()





        mPartnerName = partnerName.toLowerCase(Locale.ROOT).trim().replace("\\s+".toRegex(), "")
        arrpartnerName = partnerName!!.split("".toRegex()).toTypedArray()

        eliminateCommonLetters()


    }

    private fun eliminateCommonLetters() {

        for (i in arryourName!!) {
            for (j in arrpartnerName!!) {
                if (i == j) {
                    arryourName = ArrayUtils.removeElement(arryourName, i)
                    arrpartnerName = ArrayUtils.removeElement(arrpartnerName, j)
                    break
                }
            }
        }


        val arrCompleteName: Array<String> = ArrayUtils.addAll(arryourName, *arrpartnerName!!)

        val stringBuilder = StringBuilder()
        for (string in arrCompleteName) {
            stringBuilder.append(string)
        }

        FlamesTest(stringBuilder.toString())
    }

    private fun FlamesTest(completeName: String) {
        var index: Int
        var flamesLength = 6
        while (FLAMES.length != 1) {
            index = completeName.length % flamesLength
            if (index == 0) {
                FLAMES = FLAMES.replace(arrFLAMES[FLAMES.length - 1].toString(), "")
                arrFLAMES = FLAMES.toCharArray()
            } else {
                FLAMES = FLAMES.replace(arrFLAMES[index - 1].toString(), "")
                FLAMES = FLAMES.substring(index - 1) + FLAMES.substring(0, index - 1)
                arrFLAMES = FLAMES.toCharArray()
            }
            flamesLength--
        }
    }

    private fun displayOutput(view: View) {



        when (arrFLAMES[0]) {

            'F' -> {


                   image_resource.set(R.drawable.friends)
            }

            'L' -> {

                   image_resource.set(R.drawable.love)
            }
            'A' -> {



                image_resource.set(R.drawable.affection)
            }
            'M' -> {


                   image_resource.set(R.drawable.marriage)

            }
            'E' -> {

                 image_resource.set(R.drawable.enemies)

            }
            'S' -> {


                image_resource.set(R.drawable.sister)
            }
        }




    }


}