package com.example.henri.pwsm;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.graphics.Color.rgb;

public class pwsm extends LinearLayout {


    Context context;
    validator v;
    int score;
    EditText pass;
    ProgressBar bar;
    TextView info;
    TextView text;
    LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);


    public pwsm(Context context, validator v) {
        super(context);
        this.context = context;
        init(context);
        this.v = v;

    }


    public void init(Context context) {


        setOrientation(VERTICAL);
        setLayoutParams(params);
        text = new TextView(context);
        text.setText("Password Strength");
        text.setGravity(Gravity.CENTER_HORIZONTAL);
        text.setLayoutParams(params);
        pass = new EditText(context);
        pass.setId(0);
        pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        pass.setLayoutParams(params);
        bar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
        info = new TextView(context);
        info.setId(0 + 1);
        info.setLayoutParams(params);
        info.setGravity(Gravity.CENTER_HORIZONTAL);

        addView(pass);
        addView(bar);
        addView(text);
        addView(info);


        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String aux = s.toString();
                score = v.validate(aux);

                bar.setProgress(getProgress());
                bar.getProgressDrawable().setColorFilter(getColor(), android.graphics.PorterDuff.Mode.SRC_IN);
                info.setText(getText());
                info.setTextColor(getColor());


            }
        });

    }


    public int getColor() {

        if (score == 1) {

            return Color.RED;
        } else if (score == 2) {

            return Color.YELLOW;
        } else if (score == 3) {

            return rgb(255, 165, 0);
        } else if (score >= 4) {

            return Color.GREEN;
        }

        return Color.RED;
    }


    public int getProgress() {

        return score * 20;

    }

    public String getText() {

        if (score == 1) {

            return "Weak";
        } else if (score == 2) {

            return "Ok";
        } else if (score == 3) {

            return "Fair";
        } else if (score == 4) {

            return "Good";
        } else if (score >= 5) {

            return "Strong";
        }

        return "Very Weak";
    }
}
