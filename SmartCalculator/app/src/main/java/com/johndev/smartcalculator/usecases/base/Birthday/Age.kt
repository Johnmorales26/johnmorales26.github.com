package Birthday

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

class Age {

    @RequiresApi(Build.VERSION_CODES.O)
    private val fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateAge(myTypeDateBorn: MyTypeDate, myTypeDateCurrent: MyTypeDate): String{
        val dayBorn = if (myTypeDateBorn.day < 10){
            "0${myTypeDateBorn.day}"
        } else {
            myTypeDateBorn.day.toString().trim()
        }
        val monthBorn = if (myTypeDateBorn.month < 10){
            "0${myTypeDateBorn.month}"
        } else {
            myTypeDateBorn.month.toString().trim()
        }
        val dayCurrent = if (myTypeDateCurrent.day < 10){
            "0${myTypeDateCurrent.day}"
        } else {
            myTypeDateCurrent.day.toString().trim()
        }
        val monthCurrent = if (myTypeDateCurrent.month < 10){
            "0${myTypeDateCurrent.month}"
        } else {
            myTypeDateCurrent.month.toString().trim()
        }
        val dateBorn = LocalDate.parse("${dayBorn}/${monthBorn}/${myTypeDateBorn.year}", fmt)
        val dateCurrent = LocalDate.parse("${dayCurrent}/${monthCurrent}/${myTypeDateCurrent.year}", fmt)

        val period = Period.between(dateBorn, dateCurrent)

        return "${period.years} Años, ${period.months} Meses, ${period.days} días"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateNextBirthday(myTypeDateBorn: MyTypeDate, myTypeDateCurrent: MyTypeDate): String{
        val dayBorn = if (myTypeDateBorn.day < 10){
            "0${myTypeDateBorn.day}"
        } else {
            myTypeDateBorn.day.toString().trim()
        }
        val monthBorn = if (myTypeDateBorn.month < 10){
            "0${myTypeDateBorn.month}"
        } else {
            myTypeDateBorn.month.toString().trim()
        }
        val dayCurrent = if (myTypeDateCurrent.day < 10){
            "0${myTypeDateCurrent.day}"
        } else {
            myTypeDateCurrent.day.toString().trim()
        }
        val monthCurrent = if (myTypeDateCurrent.month < 10){
            "0${myTypeDateCurrent.month}"
        } else {
            myTypeDateCurrent.month.toString().trim()
        }

        val dateBorn = LocalDate.parse("${dayBorn}/${monthBorn}/${myTypeDateBorn.year}", fmt)
        val dateCurrent = LocalDate.parse("${dayCurrent}/${monthCurrent}/${myTypeDateCurrent.year}", fmt)
        val dateNextBirthday = LocalDate.parse("${dayBorn}/${monthBorn}/${myTypeDateCurrent.year}", fmt)

        val period = Period.between(dateCurrent, dateNextBirthday)

        return "${period.years} Años, ${period.months} Meses, ${period.days} días"
    }



}