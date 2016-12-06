package com.example.daneko.androidadventcalendar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.support.v7.app.AppCompatActivity;

import com.example.daneko.androidadventcalendar.proguard.Sub;

import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    CompositeSubscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subscription = new CompositeSubscription();

        findViewById(R.id.proguard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Sub().log();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }

    public static class FormValues {
        String formA;
        String formB;
        String formC;

        public FormValues(String formA, String formB, String formC) {
            this.formA = formA;
            this.formB = formB;
            this.formC = formC;
        }

        public boolean isValid() {
            return !isInvalid();
        }

        boolean isInvalid() {
            return TextUtils.isEmpty(formA) ||
                    TextUtils.isEmpty(formB) ||
                    TextUtils.isEmpty(formC);
        }

        @Override
        public String toString() {
            return "FormValues{" +
                    "formA='" + formA + '\'' +
                    ", formB='" + formB + '\'' +
                    ", formC='" + formC + '\'' +
                    '}';
        }
    }

}
