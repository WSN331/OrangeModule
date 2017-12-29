package com.yangjian.neworangemodule.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.yangjian.neworangemodule.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

public class FrameActivity extends AppCompatActivity {

    @Bind(R.id.frame_chart)
    LineChartView frameChart;

    private int numberOfLines = 1;
    private int numberOfPoints = 24;

    private int[] batterys = {100, 100, 100, 100, 100, 100, 98, 96, 90, 83, 70, 55, 43, 60, 100, 93, 79, 50, 33, 17, 88, 100, 100, 100};

    private List<AxisValue> axisValues = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private LineChartData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        ButterKnife.bind(this);

        generateData();
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, FrameActivity.class);
        context.startActivity(intent);
    }

    private void generateData() {
        for (int i = 0; i < numberOfLines; i++) {
            List<PointValue> values = new ArrayList<>();
            for (int j = 0; j < numberOfPoints; j++) {
                values.add(new PointValue(j, batterys[j]));
                axisValues.add(new AxisValue(j).setLabel(j + ""));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[3]);
            line.setShape(ValueShape.CIRCLE);
            line.setHasLabels(true);
            line.setHasLabelsOnlyForSelected(false);
            line.setHasLines(true);
            line.setHasPoints(true);
            lines.add(line);
        }

        data = new LineChartData(lines);
        data.setAxisXBottom(new Axis(axisValues).setHasLines(true).setTextColor(Color.BLACK).setName("时间（单位：h）"));
        data.setAxisYLeft(new Axis().setHasLines(true).setTextColor(Color.BLACK).setName("电量（单位：%）"));
        frameChart.setLineChartData(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}

