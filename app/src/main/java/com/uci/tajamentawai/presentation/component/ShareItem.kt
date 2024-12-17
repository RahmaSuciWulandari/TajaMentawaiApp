package com.uci.tajamentawai.presentation.component

import android.content.Context
import android.content.Intent
import com.uci.tajamentawai.R

fun shareItem(context: Context){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.TM_share))
        putExtra(Intent.EXTRA_TEXT, context.getString(R.string.message_share))
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.TM_share)
        )
    )
}