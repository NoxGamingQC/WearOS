package ca.noxgamingqc.android.wearos.watchface.analog.data

// Defaults for the watch face. All private values aren't editable by the user, so they don't need
// to be exposed as settings defaults.
const val DRAW_HOUR_PIPS_DEFAULT = true

private const val HOUR_HAND_LENGTH_FRACTION = 0.29028f
private const val HOUR_HAND_WIDTH_FRACTION = 0.06336f

// Because the minute length is something the user can edit, we make it publicly
// accessible as a default. We also specify the minimum and maximum values for the user
// settings as well.
const val MINUTE_HAND_LENGTH_FRACTION_DEFAULT = 0.45000f
const val MINUTE_HAND_LENGTH_FRACTION_MINIMUM = 0.15000f
const val MINUTE_HAND_LENGTH_FRACTION_MAXIMUM = 0.45000f
private const val MINUTE_HAND_WIDTH_FRACTION = 0.0183f

private const val SECOND_HAND_LENGTH_FRACTION = 0.42383f
private const val SECOND_HAND_WIDTH_FRACTION = 0.00934f

// Used for corner roundness of the arms.
private const val ROUNDED_RECTANGLE_CORNERS_RADIUS = 50.5f
private const val SQUARE_RECTANGLE_CORNERS_RADIUS = 0.0f

private const val CENTER_CIRCLE_DIAMETER_FRACTION = 0.0000f
private const val OUTER_CIRCLE_STROKE_WIDTH_FRACTION = 0.00067f
private const val NUMBER_STYLE_OUTER_CIRCLE_RADIUS_FRACTION = 0.00184f

private const val GAP_BETWEEN_OUTER_CIRCLE_AND_BORDER_FRACTION = 0.03738f
private const val GAP_BETWEEN_HAND_AND_CENTER_FRACTION =
    0f + CENTER_CIRCLE_DIAMETER_FRACTION / 1.0f

private const val NUMBER_RADIUS_FRACTION = 0.45f

/**
 * Represents all data needed to render an analog watch face.
 */
data class WatchFaceData(
    val activeColorStyle: ColorStyleIdAndResourceIds = ColorStyleIdAndResourceIds.CLOUD,
    val ambientColorStyle: ColorStyleIdAndResourceIds = ColorStyleIdAndResourceIds.CLOUD,
    val hourHandColorStyle: ColorStyleIdAndResourceIds = ColorStyleIdAndResourceIds.CLOUD,
    val minuteHandColorStyle: ColorStyleIdAndResourceIds = ColorStyleIdAndResourceIds.CLOUD,
    val secondHandColorStyle: ColorStyleIdAndResourceIds = ColorStyleIdAndResourceIds.CLOUD,
    val drawHourPips: Boolean = DRAW_HOUR_PIPS_DEFAULT,
    val hourHandDimensions: ArmDimensions = ArmDimensions(
        lengthFraction = HOUR_HAND_LENGTH_FRACTION,
        widthFraction = HOUR_HAND_WIDTH_FRACTION,
        xRadiusRoundedCorners = ROUNDED_RECTANGLE_CORNERS_RADIUS,
        yRadiusRoundedCorners = ROUNDED_RECTANGLE_CORNERS_RADIUS
    ),
    val minuteHandDimensions: ArmDimensions = ArmDimensions(
        lengthFraction = MINUTE_HAND_LENGTH_FRACTION_DEFAULT,
        widthFraction = MINUTE_HAND_WIDTH_FRACTION,
        xRadiusRoundedCorners = ROUNDED_RECTANGLE_CORNERS_RADIUS,
        yRadiusRoundedCorners = ROUNDED_RECTANGLE_CORNERS_RADIUS
    ),
    val secondHandDimensions: ArmDimensions = ArmDimensions(
        lengthFraction = SECOND_HAND_LENGTH_FRACTION,
        widthFraction = SECOND_HAND_WIDTH_FRACTION,
        xRadiusRoundedCorners = ROUNDED_RECTANGLE_CORNERS_RADIUS,
        yRadiusRoundedCorners = ROUNDED_RECTANGLE_CORNERS_RADIUS
    ),
    val centerCircleDiameterFraction: Float = CENTER_CIRCLE_DIAMETER_FRACTION,
    val numberRadiusFraction: Float = NUMBER_RADIUS_FRACTION,
    val outerCircleStokeWidthFraction: Float = OUTER_CIRCLE_STROKE_WIDTH_FRACTION,
    val numberStyleOuterCircleRadiusFraction: Float = NUMBER_STYLE_OUTER_CIRCLE_RADIUS_FRACTION,
    val gapBetweenOuterCircleAndBorderFraction: Float =
        GAP_BETWEEN_OUTER_CIRCLE_AND_BORDER_FRACTION,
    val gapBetweenHandAndCenterFraction: Float = GAP_BETWEEN_HAND_AND_CENTER_FRACTION
)