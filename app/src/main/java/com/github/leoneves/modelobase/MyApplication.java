package com.github.leoneves.modelobase;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import androidx.multidex.MultiDex;

import com.github.leoneves.modelobase.view.base.BaseActivity;
import com.leoneves.easylogger.Logger;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import pet.sansa.thanos.KNOB;

@ReportsCrashes(
        formUri = "http://167.99.224.129:5959/acra-modelo/_design/acra-storage/_update/report",
        reportType = org.acra.sender.HttpSender.Type.JSON,
        httpMethod = org.acra.sender.HttpSender.Method.PUT,
        formUriBasicAuthLogin="user",
        formUriBasicAuthPassword="password",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.mensagem_acra
)
public class MyApplication extends Application {
    private static BaseActivity activity;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.context = this;
        configurarFileProvider();
        ACRA.init(this);
        KNOB.init(this);
        configurarLogger();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }

    private void configurarFileProvider() {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    private void configurarLogger() {
        Logger.init("SaveInformática").hideThreadInfo().methodCount(0);
        Logger.i("Init Application Save");
    }

    public static BaseActivity getActivity() {
        return activity;
    }

    public static void setActivity(BaseActivity activity) {
        MyApplication.activity = activity;
    }

    public static Context getContext() {
        return context;
    }
}
