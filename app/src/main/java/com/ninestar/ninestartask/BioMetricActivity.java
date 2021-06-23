package com.ninestar.ninestartask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.ninestar.ninestartask.view.BaseActivity;
import com.ninestar.ninestartask.view.HomeActivity;

import java.util.concurrent.Executor;

public class BioMetricActivity extends BaseActivity {

    private Button mAuthButton;
    private Executor executor;
    private androidx.biometric.BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_biometric;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuthButton = findViewById(R.id.authentication_button);
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(BioMetricActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull @org.jetbrains.annotations.NotNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(BioMetricActivity.this, "Authentication error : " + errString, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull @org.jetbrains.annotations.NotNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(BioMetricActivity.this, "Authentication success", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BioMetricActivity.this, HomeActivity.class));
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(BioMetricActivity.this, "Authentication failed !!! : ", Toast.LENGTH_LONG).show();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Authentication")
                .setSubtitle("Login using fingerprint authentication")
                .setNegativeButtonText("Cancel")
                .build();

        mAuthButton.setOnClickListener(v -> {
            biometricPrompt.authenticate(promptInfo);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        biometricPrompt.authenticate(promptInfo);
    }

}