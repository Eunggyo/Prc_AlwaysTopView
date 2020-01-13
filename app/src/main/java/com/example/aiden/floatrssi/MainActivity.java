package com.example.aiden.floatrssi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private Button mStartBtn;
    private TextView mRssiText;
    private TextView mRssiText2;
    private WifiManager mWifiManager;
    private WifiInfo mWifiInfo;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mStartBtn = findViewById(R.id.startBBtn);
        mRssiText = findViewById(R.id.rssiOne);
        mRssiText2 = findViewById(R.id.rssiTwo);
        mWifiManager = (WifiManager)mContext.getSystemService(Context.WIFI_SERVICE);
        mWifiInfo = mWifiManager.getConnectionInfo();

        mStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getrssi = Integer.toString(mWifiInfo.getRssi());
                String getrssi2 = Integer.toString(WifiManager.calculateSignalLevel(mWifiInfo.getRssi(),4));
                mRssiText.setText(getrssi);
                mRssiText2.setText(getrssi2);
            }
        });
    }
}
