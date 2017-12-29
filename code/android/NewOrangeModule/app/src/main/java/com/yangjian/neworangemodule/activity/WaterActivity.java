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
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.ColumnChartView;

public class WaterActivity extends AppCompatActivity {

    @Bind(R.id.water_chart)
    ColumnChartView waterChart;

    private int numSubcolumns = 1;
    private int numColumns = 5;

    private int[] waters = {10, 34, 7, 78, 5};
    private String[] labels = {"0-9", "10-60", "60-100", "100-300", "300以上"};

    private List<Column> columns = new ArrayList<>();
    private List<AxisValue> axisValues = new ArrayList<>();

    private ColumnChartData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
        ButterKnife.bind(this);

        generateData();
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, WaterActivity.class);
        context.startActivity(intent);
    }

    private void generateData() {
        for (int i = 0; i < numColumns; i++) {
            List<SubcolumnValue> values = new ArrayList<>();
            for (int j = 0; j < numSubcolumns; j++) {
                values.add(new SubcolumnValue(waters[i], ChartUtils.COLORS[i]));
                axisValues.add(new AxisValue(i).setLabel(labels[i]));
            }

            Column column = new Column(values);
            column.setHasLabels(true);
            columns.add(column);
        }

        data = new ColumnChartData(columns);

        data.setAxisXBottom(new Axis(axisValues).setHasLines(true).setTextColor(Color.BLACK).setName("TDS值(PPM)"));
        data.setAxisYLeft(new Axis().setHasLines(true).setTextColor(Color.BLACK).setName("出现次数"));

        waterChart.setColumnChartData(data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
