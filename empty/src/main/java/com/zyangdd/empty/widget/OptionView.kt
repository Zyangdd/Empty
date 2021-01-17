package com.zyangdd.empty.widget

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.ImageViewCompat
import com.zyangdd.empty.R
import com.zyangdd.empty.databinding.ViewOptionBinding

class OptionView : ConstraintLayout {

    private lateinit var binding: ViewOptionBinding

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        binding = ViewOptionBinding.inflate(LayoutInflater.from(context), this, true)
        isFocusable = true
        isClickable = true
        val inputArr = context.obtainStyledAttributes(attrs, R.styleable.OptionView)

        // set text
        val text = inputArr.getString(R.styleable.OptionView_android_text) ?: ""
        setText(text)

        // set text font size
        if (inputArr.hasValue(R.styleable.OptionView_android_textSize)) {
            val fontSize = inputArr.getDimension(R.styleable.OptionView_android_textSize, 14f)
            setTextFontSize(fontSize)
        }

        // set text color
        if (inputArr.hasValue(R.styleable.OptionView_android_textColor)) {
            val colors = inputArr.getColorStateList(R.styleable.OptionView_android_textColor)
            setTextColor(colors)
        }

        // set text font family
        if (!isInEditMode) {
            if (inputArr.hasValue(R.styleable.OptionView_android_fontFamily)) {
                val fontFamily =
                    inputArr.getResourceId(R.styleable.OptionView_android_fontFamily, 0)
                setTextFontFamily(fontFamily)
            }
        }

        // set subText
        val subText = inputArr.getString(R.styleable.OptionView_subtext) ?: ""
        setSubText(subText)

        // set subText font size
        if (inputArr.hasValue(R.styleable.OptionView_subTextSize)) {
            val subTextFontSize = inputArr.getDimension(R.styleable.OptionView_subTextSize, 14f)
            setSubTextFontSize(subTextFontSize)
        }

        // set subText color
        if (inputArr.hasValue(R.styleable.OptionView_subTextColor)) {
            val subTextColors = inputArr.getColorStateList(R.styleable.OptionView_subTextColor)
            setSubTextColor(subTextColors)
        }

        // set subText show
        val subTextShow = inputArr.getBoolean(R.styleable.OptionView_subTextShow, false)
        setSubTextShow(subTextShow)

        // set subText font family
        if (!isInEditMode) {
            if (inputArr.hasValue(R.styleable.OptionView_subTextFontFamily)) {
                val subTextFontFamily =
                    inputArr.getResourceId(R.styleable.OptionView_subTextFontFamily, 0)
                setSubTextFontFamily(subTextFontFamily)
            }
        }

        // set icon
        if (inputArr.hasValue(R.styleable.OptionView_icon)) {
            val icon = inputArr.getDrawable(R.styleable.OptionView_icon)
            setIcon(icon)
        }

        // set icon size
        if (inputArr.hasValue(R.styleable.OptionView_iconSize)) {
            val iconSize = inputArr.getDimension(R.styleable.OptionView_iconSize, 24f)
            setIconSize(iconSize.toInt())
        }

        // set icon tint
        if (inputArr.hasValue(R.styleable.OptionView_iconTint)) {
            val iconTint = inputArr.getColor(R.styleable.OptionView_iconTint, Color.GRAY)
            setIconTint(iconTint)
        }

        // set arrow tint
        if (inputArr.hasValue(R.styleable.OptionView_arrowTint)) {
            val iconTint = inputArr.getColor(R.styleable.OptionView_arrowTint, Color.GRAY)
            setArrowTint(iconTint)
        }

        // set show arrow
        val showArrow = inputArr.getBoolean(R.styleable.OptionView_showArrow, true)
        showArrow(showArrow)

        // set show divider
        val showDivider = inputArr.getBoolean(R.styleable.OptionView_showBottomDivider, false)
        showDivider(showDivider)

        // set full divider
        val fullDivider = inputArr.getBoolean(R.styleable.OptionView_fullDivider, false)
        setFullDivider(fullDivider)
        inputArr.recycle()
    }

    fun setText(content: CharSequence) {
        binding.textTv.text = content
    }

    private fun setText(content: String) {
        binding.textTv.text = content
    }

    private fun setTextFontSize(fontSize: Float) {
        binding.textTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize)
    }

    private fun setTextColor(colors: ColorStateList?) {
        binding.textTv.setTextColor(colors)
    }

    private fun setTextFontFamily(id: Int) {
        if (id > 0) {
            binding.textTv.typeface = ResourcesCompat.getFont(context, id)
        }
    }

    fun setSubText(content: String) {
        binding.subTextTv.text = content
    }

    private fun setSubTextFontSize(fontSize: Float) {
        binding.subTextTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, fontSize)
    }

    private fun setSubTextColor(colors: ColorStateList?) {
        binding.subTextTv.setTextColor(colors)
    }

    private fun setSubTextFontFamily(id: Int) {
        if (id > 0) {
            binding.subTextTv.typeface = ResourcesCompat.getFont(context, id)
        }
    }

    private fun setSubTextShow(subTextShow: Boolean) {
        binding.subTextTv.visibility = if (subTextShow) View.VISIBLE else View.GONE
    }

    private fun setIcon(icon: Drawable?) {
        binding.iconIv.setImageDrawable(icon)
    }

    private fun setIconSize(iconSize: Int) {
        val layoutParams = binding.iconIv.layoutParams
        layoutParams.width = iconSize
        layoutParams.height = iconSize
        binding.iconIv.layoutParams = layoutParams
    }

    private fun setIconTint(color: Int) {
        ImageViewCompat.setImageTintList(binding.iconIv, ColorStateList.valueOf(color))
    }

    private fun setArrowTint(color: Int) {
        ImageViewCompat.setImageTintList(binding.arrowIv, ColorStateList.valueOf(color))
    }

    private fun showArrow(show: Boolean) {
        binding.arrowIv.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun showDivider(show: Boolean) {
        binding.bottomDividerV.visibility = if (show) View.VISIBLE else View.INVISIBLE
    }

    private fun setFullDivider(full: Boolean) {
        val layoutParams = binding.bottomDividerV.layoutParams as LayoutParams
        layoutParams.startToStart = if (full) LayoutParams.PARENT_ID else R.id.icon_iv
        layoutParams.endToEnd = if (full) LayoutParams.PARENT_ID else R.id.arrow_iv
        binding.bottomDividerV.layoutParams = layoutParams
    }
}