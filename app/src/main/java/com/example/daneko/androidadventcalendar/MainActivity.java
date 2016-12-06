package com.example.daneko.androidadventcalendar;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;

import com.example.daneko.androidadventcalendar.proguard.Sub;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;

import rx.Observable;
import rx.subscriptions.CompositeSubscription;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    CompositeSubscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subscription = new CompositeSubscription();
        initSubmitProcess();

        findViewById(R.id.proguard).setOnClickListener(view -> new Sub().log());
    }

    void initSubmitProcess() {
        Button submit = (Button) findViewById(R.id.submit);
        Observable<String> formA =
                RxTextView.textChanges((TextView) findViewById(R.id.form_a)).map(CharSequence::toString);
        Observable<String> formB =
                RxTextView.textChanges((TextView) findViewById(R.id.form_b)).map(CharSequence::toString);
        Observable<String> formC =
                RxTextView.textChanges((TextView) findViewById(R.id.form_c)).map(CharSequence::toString);

        Observable<FormValues> value = Observable.combineLatest(formA, formB, formC, FormValues::new);

        subscription.add(value.subscribe(v -> {
            submit.setEnabled(v.isValid());
        }));


        Observable<Integer> clickCount = RxView.clicks(submit).scan(0, (a, ignore) -> a + 1).filter(count -> count > 0);

        subscription.add(Observable.combineLatest(value, clickCount, Pair::create)
                .filter(pair -> pair.first.isValid())
                .distinctUntilChanged(pair -> pair.second)
                .subscribe(pair -> {
                    Timber.v("click value is %s", pair.first);
                }));
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
