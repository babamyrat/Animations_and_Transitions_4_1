package com.example.animations_and_transitions_4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(textView, "translationX", 100f);
                animation.setDuration(1000);
                animation.start();
                animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                        // You can use the animated value in a property that uses the
                        // same type as the animation. In this case, you can use the
                        // float value in the translationX property.
                        float animatedValue = (float)updatedAnimation.getAnimatedValue();
                        textView.setTranslationX(animatedValue);
                    }
                });
            }
        });
    }
}