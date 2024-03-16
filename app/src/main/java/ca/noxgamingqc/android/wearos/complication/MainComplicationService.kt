package ca.noxgamingqc.android.wearos.complication

import androidx.wear.watchface.complications.data.ComplicationData
import androidx.wear.watchface.complications.data.ComplicationType
import androidx.wear.watchface.complications.data.PlainComplicationText
import androidx.wear.watchface.complications.data.ShortTextComplicationData
import androidx.wear.watchface.complications.datasource.ComplicationRequest
import androidx.wear.watchface.complications.datasource.SuspendingComplicationDataSourceService
import java.util.Calendar

/**
 * Skeleton for complication data source that returns short text.
 */
class MainComplicationService : SuspendingComplicationDataSourceService() {

    override fun getPreviewData(type: ComplicationType): ComplicationData? {
        return createComplicationData()
    }

    override suspend fun onComplicationRequest(request: ComplicationRequest): ComplicationData {
        return createComplicationData()
    }

    private fun createComplicationData() =
        ShortTextComplicationData.Builder(
            text = PlainComplicationText.Builder(Calendar.getInstance().time.date.toString()).build(),
            contentDescription = PlainComplicationText.Builder(Calendar.getInstance().time.toString()).build()
        ).build()
}