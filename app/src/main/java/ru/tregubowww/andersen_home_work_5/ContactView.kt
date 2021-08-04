package ru.tregubowww.andersen_home_work_5

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes

class ContactView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defaultAttributeSet: Int = 0
) : View(context, attrs, defaultAttributeSet) {

    private var colorBackgroundContact = 0
    private var colorText = Color.BLACK

    private var paintBackgroundContact: Paint
    private var paintText: Paint

    var phoneNumber: String = ""
        set(value) {
            invalidate()
            field = value
        }

    var name: String = ""
        set(value) {
            invalidate()
            field = value
        }

    private val rectF = RectF()

    init {
        context.withStyledAttributes(attrs, R.styleable.ContactView) {
            colorBackgroundContact = getColor(R.styleable.ContactView_colorBackgroundContact, Color.WHITE)

        }

        paintBackgroundContact = Paint().apply {
            color = colorBackgroundContact
            isAntiAlias = true
        }

        paintText = Paint().apply {
            color = colorText
            textSize = 50f
            isAntiAlias = true
        }
    }

    override fun onDraw(canvas: Canvas?) {
        rectF.apply {
            left = 0f
            right = width.toFloat()
            top = 0f
            bottom = height.toFloat()
        }
        val widthDrawTextPhoneNumber = width * 0.05f
        val heightDrawTextPhoneNumber = height * 0.4f
        val widthDrawTextName = width * 0.05f
        val heightDrawTextName = height * 0.8f



        canvas?.apply {
            drawRoundRect(rectF, 10f, 10f, paintBackgroundContact)
            drawText(phoneNumber, widthDrawTextPhoneNumber, heightDrawTextPhoneNumber, paintText)
            drawText(name, widthDrawTextName, heightDrawTextName, paintText)
        }
    }
}
