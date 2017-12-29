package com.yangjian.neworangemodule.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yangjian.neworangemodule.R;
import com.yangjian.neworangemodule.adapter.FileAdapter;
import com.yangjian.neworangemodule.bean.UFile;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UdiskActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private int numberOfFile = 9;
    private List<UFile> data = new ArrayList<>();
    private int[] icons = {R.drawable.folder, R.drawable.folder, R.drawable.folder, R.drawable.folder, R.drawable.folder,
                            R.drawable.pdf, R.drawable.doc, R.drawable.mp3, R.drawable.mp4};
    private String[] names = {"文件夹1", "文件夹2", "文件夹3", "文件夹4", "文件夹5", "pdf文件", "doc文件", "MP3文件", "MP4文件"};

    private FileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udisk);
        ButterKnife.bind(this);

        generateData();
        adapter = new FileAdapter(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(UdiskActivity.this));
        recyclerView.setAdapter(adapter);
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, UdiskActivity.class);
        context.startActivity(intent);
    }

    private void generateData() {
        for (int i = 0; i < numberOfFile; i++) {
            UFile file = new UFile(names[i], icons[i]);
            data.add(file);
        }
    }
}
