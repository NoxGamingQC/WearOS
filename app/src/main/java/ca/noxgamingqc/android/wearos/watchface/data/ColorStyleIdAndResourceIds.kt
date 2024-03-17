package ca.noxgamingqc.android.wearos.watchface.data

import android.content.Context
import android.graphics.drawable.Icon
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.wear.watchface.style.UserStyleSetting
import androidx.wear.watchface.style.UserStyleSetting.ListUserStyleSetting
import ca.noxgamingqc.android.wearos.R

// Defaults for all styles.
// X_COLOR_STYLE_ID - id in watch face database for each style id.
// X_COLOR_STYLE_NAME_RESOURCE_ID - String name to display in the user settings UI for the style.
// X_COLOR_STYLE_ICON_ID - Icon to display in the user settings UI for the style.
const val CLOUD_COLOR_STYLE_ID = "cloud_style_id"
private val CLOUD_COLOR_STYLE_NAME_RESOURCE_ID = R.string.cloud_style_name
private val CLOUD_COLOR_STYLE_ICON_ID = R.drawable.cloud_style

const val WATERMELON_COLOR_STYLE_ID = "watermelon_style_id"
private val WATERMELON_COLOR_STYLE_NAME_RESOURCE_ID = R.string.watermelon_style_name
private val WATERMELON_COLOR_STYLE_ICON_ID = R.drawable.watermelon_style

const val FOREST_COLOR_STYLE_ID = "forest_style_id"
private val FOREST_COLOR_STYLE_NAME_RESOURCE_ID = R.string.forest_style_name
private val FOREST_COLOR_STYLE_ICON_ID = R.drawable.forest_style

const val SAPPHIRE_COLOR_STYLE_ID = "sapphire_style_id"
private val SAPPHIRE_COLOR_STYLE_NAME_RESOURCE_ID = R.string.sapphire_style_name
private val SAPPHIRE_COLOR_STYLE_ICON_ID = R.drawable.sapphire_style


/**
 * Represents watch face color style options the user can select (includes the unique id, the
 * complication style resource id, and general watch face color style resource ids).
 *
 * The companion object offers helper functions to translate a unique string id to the correct enum
 * and convert all the resource ids to their correct resources (with the Context passed in). The
 * renderer will use these resources to render the actual colors and ComplicationDrawables of the
 * watch face.
 */
enum class ColorStyleIdAndResourceIds(
    val id: String,
    @StringRes val nameResourceId: Int,
    @DrawableRes val iconResourceId: Int,
    @DrawableRes val complicationStyleDrawableId: Int,
    @ColorRes val primaryColorId: Int,
    @ColorRes val secondaryColorId: Int,
    @ColorRes val backgroundColorId: Int,
    @ColorRes val outerElementColorId: Int,
    @ColorRes val hourHandColorId: Int,
    @ColorRes val minuteHandColorId: Int,
    @ColorRes val secondHandColorId: Int
) {
    CLOUD(
        id = CLOUD_COLOR_STYLE_ID,
        nameResourceId = CLOUD_COLOR_STYLE_NAME_RESOURCE_ID,
        iconResourceId = CLOUD_COLOR_STYLE_ICON_ID,
        complicationStyleDrawableId = R.drawable.complication_cloud_style,
        primaryColorId = R.color.cloud_primary_color,
        secondaryColorId = R.color.cloud_secondary_color,
        backgroundColorId = R.color.cloud_background_color,
        outerElementColorId = R.color.cloud_outer_element_color,
        hourHandColorId = R.color.cloud_hour_hand_color,
        minuteHandColorId = R.color.cloud_minute_hand_color,
        secondHandColorId = R.color.cloud_second_hand_color
    ),
    WATERMELON(
        id = WATERMELON_COLOR_STYLE_ID,
        nameResourceId = WATERMELON_COLOR_STYLE_NAME_RESOURCE_ID,
        iconResourceId = WATERMELON_COLOR_STYLE_ICON_ID,
        complicationStyleDrawableId = R.drawable.complication_watermelon_style,
        primaryColorId = R.color.watermelon_primary_color,
        secondaryColorId = R.color.watermelon_secondary_color,
        backgroundColorId = R.color.watermelon_background_color,
        outerElementColorId = R.color.watermelon_outer_element_color,
        hourHandColorId = R.color.watermelon_hour_hand_color,
        minuteHandColorId = R.color.watermelon_minute_hand_color,
        secondHandColorId = R.color.watermelon_second_hand_color
    ),
    FOREST(
        id = FOREST_COLOR_STYLE_ID,
        nameResourceId = FOREST_COLOR_STYLE_NAME_RESOURCE_ID,
        iconResourceId = FOREST_COLOR_STYLE_ICON_ID,
        complicationStyleDrawableId = R.drawable.complication_forest_style,
        primaryColorId = R.color.forest_primary_color,
        secondaryColorId = R.color.forest_secondary_color,
        backgroundColorId = R.color.forest_background_color,
        outerElementColorId = R.color.forest_outer_element_color,
        hourHandColorId = R.color.forest_hour_hand_color,
        minuteHandColorId = R.color.forest_minute_hand_color,
        secondHandColorId = R.color.forest_second_hand_color
    ),

    SAPPHIRE(
        id = SAPPHIRE_COLOR_STYLE_ID,
        nameResourceId = SAPPHIRE_COLOR_STYLE_NAME_RESOURCE_ID,
        iconResourceId = SAPPHIRE_COLOR_STYLE_ICON_ID,
        complicationStyleDrawableId = R.drawable.complication_sapphire_style,
        primaryColorId = R.color.sapphire_primary_color,
        secondaryColorId = R.color.sapphire_secondary_color,
        backgroundColorId = R.color.sapphire_background_color,
        outerElementColorId = R.color.sapphire_outer_element_color,
        hourHandColorId = R.color.sapphire_hour_hand_color,
        minuteHandColorId = R.color.sapphire_minute_hand_color,
        secondHandColorId = R.color.sapphire_second_hand_color
    );

    companion object {
        /**
         * Translates the string id to the correct ColorStyleIdAndResourceIds object.
         */
        fun getColorStyleConfig(id: String): ColorStyleIdAndResourceIds {
            return when (id) {
                CLOUD.id -> CLOUD
                WATERMELON.id -> WATERMELON
                FOREST.id -> FOREST
                SAPPHIRE.id -> SAPPHIRE
                else -> CLOUD
            }
        }

        /**
         * Returns a list of [UserStyleSetting.ListUserStyleSetting.ListOption] for all
         * ColorStyleIdAndResourceIds enums. The watch face settings APIs use this to set up
         * options for the user to select a style.
         */
        fun toOptionList(context: Context): List<ListUserStyleSetting.ListOption> {
            val colorStyleIdAndResourceIdsList = enumValues<ColorStyleIdAndResourceIds>()

            return colorStyleIdAndResourceIdsList.map { colorStyleIdAndResourceIds ->
                ListUserStyleSetting.ListOption(
                    UserStyleSetting.Option.Id(colorStyleIdAndResourceIds.id),
                    context.resources,
                    colorStyleIdAndResourceIds.nameResourceId,
                    Icon.createWithResource(
                        context,
                        colorStyleIdAndResourceIds.iconResourceId
                    )
                )
            }
        }
    }
}