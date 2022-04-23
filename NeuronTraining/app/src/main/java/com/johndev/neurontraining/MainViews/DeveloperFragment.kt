package com.johndev.neurontraining.MainViews

import android.content.Context
import android.os.Handler
import android.util.Log
import com.danielstone.materialaboutlibrary.MaterialAboutFragment
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem
import com.danielstone.materialaboutlibrary.items.MaterialAboutItemOnClickAction
import com.danielstone.materialaboutlibrary.model.MaterialAboutList
import com.johndev.neurontraining.Demo
import com.mikepenz.community_material_typeface_library.CommunityMaterial
import com.mikepenz.iconics.IconicsDrawable


class DeveloperFragment : MaterialAboutFragment() {

    val THEME_LIGHT = 0

    private fun createDynamicItem(subText: String, c: Context): MaterialAboutActionItem? {
        val item = MaterialAboutActionItem.Builder()
            .text("Dynamic UI")
            .subText(subText)
            .icon(
                IconicsDrawable(c)
                    .icon(CommunityMaterial.Icon.cmd_refresh)
                    .sizeDp(18)
            )
            .build()
        item.onClickAction = MaterialAboutItemOnClickAction {
            item.subText = "Random number: " + (Math.random() * 10).toInt()
            refreshMaterialAboutList()
        }
        return item
    }

    override fun getMaterialAboutList(c: Context): MaterialAboutList? {
        val list: MaterialAboutList = Demo.createMaterialAboutList(c, THEME_LIGHT)
        list.cards[2].items.add(createDynamicItem("Tap for a random number", c))
        val time = MaterialAboutActionItem.Builder()
            .text("Unix Time In Millis")
            .subText("Time")
            .icon(
                IconicsDrawable(c)
                    .icon(CommunityMaterial.Icon.cmd_clock)
                    .sizeDp(18)
            )
            .build()
        list.cards[2].items.add(time)
        return list
    }

    val handler: Handler = Handler()
    var runnable: Runnable = object : Runnable {
        override fun run() {
            Log.i("MaterialAboutFragment", "Updating with time")
            if (list.cards.size > 0) {
                (list.cards[2].items[7] as MaterialAboutActionItem).subText =
                    "" + System.currentTimeMillis()
                refreshMaterialAboutList()
            }
            handler.postDelayed(this, 1000)
        }
    }


    override fun onResume() {
        super.onResume()
        runnable.run()
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }


}