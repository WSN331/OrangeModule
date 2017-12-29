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

public class AirActivity extends AppCompatActivity {

    @Bind(R.id.air_chart)
    LineChartView airChart;

    private int numberOfLines = 2;
    private int numberOfPoints = 24;

    //private int[] pm1s = {52, 43, 38, 27, 27, 21, 16, 32, 82, 88, 85, 88, 97, 88, 87, 74, 74, 74, 70, 69, 62, 59, 54, 52};;
    private int[][] pms = {{10, 6, 9, 9, 8, 8, 5, 4, 8, 6, 6, 10, 18, 30, 43, 53, 80, 102, 79, 64, 69, 75, 74, 85},
            {21, 20, 21, 19, 17, 15, 14, 17, 29, 27, 17, 24, 35, 47, 63, 76, 117, 135, 122, 105, 121, 126, 132, 143}};

    private List<AxisValue> axisValues = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private LineChartData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air);
        ButterKnife.bind(this);

        gengenateData();
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, AirActivity.class);
        context.startActivity(intent);
    }

    private void gengenateData() {
        for (int i = 0; i < numberOfLines; i++) {
            List<PointValue> values = new ArrayList<>();
            for (int j = 0; j < numberOfPoints; j++) {
                values.add(new PointValue(j, pms[i][j]));
                axisValues.add(new AxisValue(j).setLabel(j + ""));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[i]);
            line.setShape(ValueShape.CIRCLE);
            //line.setHasLabels(true);
            line.setHasLabelsOnlyForSelected(true);
            line.setHasLines(true);
            line.setHasPoints(true);
            lines.add(line);
        }

        data = new LineChartData(lines);
        data.setAxisXBottom(new Axis(axisValues).setHasLines(true).setTextColor(Color.BLACK).setName("时间（单位：h）"));
        data.setAxisYLeft(new Axis().setHasLines(true).setTextColor(Color.BLACK).setName("浓度（单位：μg/m³）"));
        airChart.setLineChartData(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
