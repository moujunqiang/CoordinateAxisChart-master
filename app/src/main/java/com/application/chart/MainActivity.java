package com.application.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kiba.coordinateaxischart.ChartConfig;
import com.kiba.coordinateaxischart.CoordinateAxisChart;
import com.kiba.coordinateaxischart.FunctionLine;
import com.kiba.coordinateaxischart.type.CircularType;
import com.kiba.coordinateaxischart.type.ExpType;
import com.kiba.coordinateaxischart.type.LinearType;
import com.kiba.coordinateaxischart.type.LogType;
import com.kiba.coordinateaxischart.type.PowerType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CoordinateAxisChart coordinateAxisChart;
    Button linearBtn, powerBtn, logBtn, sinBtn, expBtn, resetBtn, sureBtn;
    private EditText etA, etB, etC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinateAxisChart = (CoordinateAxisChart) findViewById(R.id.coordinateAxisChart);
        linearBtn = (Button) findViewById(R.id.linear);
        powerBtn = (Button) findViewById(R.id.power);
        logBtn = (Button) findViewById(R.id.log);
        sinBtn = (Button) findViewById(R.id.sin);
        expBtn = (Button) findViewById(R.id.exp);
        resetBtn = (Button) findViewById(R.id.reset);
        sureBtn = (Button) findViewById(R.id.sure);
        etA= (EditText) findViewById(R.id.et_a);
        etB= (EditText) findViewById(R.id.et_b);
        etC= (EditText) findViewById(R.id.et_c);

        ChartConfig config = new ChartConfig();
        config.setMax(12);
        config.setPrecision(1);
        config.setSegmentSize(50);
        coordinateAxisChart.setConfig(config);

        linearBtn.setOnClickListener(this);
        powerBtn.setOnClickListener(this);
        logBtn.setOnClickListener(this);
        sinBtn.setOnClickListener(this);
        expBtn.setOnClickListener(this);
        resetBtn.setOnClickListener(this);
        sureBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.linear:
                FunctionLine<LinearType> line1 = new FunctionLine<>(new LinearType(2, 1), Color.parseColor("#43A047"));
                coordinateAxisChart.addFunctionLine(line1);
                break;
            case R.id.log:
                FunctionLine<LogType> line3 = new FunctionLine<>(new LogType(1, 0, 1, 0), Color.parseColor("#757575"));
                coordinateAxisChart.addFunctionLine(line3);
                break;
            case R.id.sin:
                FunctionLine<CircularType> line4 = new FunctionLine<>(new CircularType(1, 0, 1, 0, CircularType.Circular.SIN), Color.parseColor("#FFCA28"));
                coordinateAxisChart.addFunctionLine(line4);
                break;
            case R.id.exp:
                FunctionLine<ExpType> line5 = new FunctionLine<>(new ExpType(1, 0, 2), Color.parseColor("#00B0FF"));
                coordinateAxisChart.addFunctionLine(line5);
                break;
            case R.id.reset:
                coordinateAxisChart.reset();
                return;
            case R.id.sure:
                if (TextUtils.isEmpty(etA.getText().toString())) {
                    Toast.makeText(this, "请输入A", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etB.getText().toString())) {
                    Toast.makeText(this, "请输入B", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etC.getText().toString())) {
                    Toast.makeText(this, "请输入C", Toast.LENGTH_SHORT).show();
                    return;
                }
                float a = Float.parseFloat(etA.getText().toString());
                float b = Float.parseFloat(etB.getText().toString());
                float c = Float.parseFloat(etC.getText().toString());

                FunctionLine<PowerType> line2 = new FunctionLine<>(new PowerType(a, b, c), Color.parseColor("#e53935"));
                coordinateAxisChart.addFunctionLine(line2);
                break;
        }
        coordinateAxisChart.invalidate();
    }
}
