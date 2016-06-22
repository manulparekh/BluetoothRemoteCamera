package com.example.bluetooth.UIElements.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.bluetooth.R;
import com.example.bluetooth.UIElements.widgets.fonts.FontFamily;

/**
 * Created by hmspl on 5/2/16.
 */
public class CEditText extends EditText {

    public CEditText(Context context) {
        super(context);
        initFonts(context, null);
    }

    public CEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFonts(context, attrs);
    }

    public CEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFonts(context, attrs);
    }

    private void initFonts(Context context, AttributeSet attrs) {
        int selection = FontFamily.ROBOTO_REGULAR;
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CEditText);
            selection = a.getInt(R.styleable.CEditText_typeface, FontFamily.ROBOTO_REGULAR);
        }
        setFontType(selection);
    }

    public void setFontType(int font) {
        setTypeface(FontFamily.getTypeface(getContext(), font));
    }
    
}
