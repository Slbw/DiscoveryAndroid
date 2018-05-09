package com.ifxme.discoveryandroid.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ifxme.discoveryandroid.R;
import com.ifxme.discoveryandroid.common.BaseActivity;
import com.ifxme.discoveryandroid.common.OnItemClickListener;
import com.ifxme.discoveryandroid.ui.ipc.IPCMainActivity;
import com.ifxme.discoveryandroid.ui.ipc.SecondActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    /**
     * 功能列表
     */
    private RecyclerView rvFunction;
    private List<String> functions;
    private FunctionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        rvFunction = findViewById(R.id.rv_function);
        //不在xml中设置，考虑到xml中利用反射机制来创建layoutmanager，所以代码中设置更高效
        rvFunction.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        functions = new ArrayList<>();
        functions.add("生命周期和启动模式");
        functions.add("IPC机制");
        adapter = new FunctionAdapter(this, functions);
        rvFunction.setAdapter(adapter);
    }

    private void initListener() {
        adapter.setOnItemClickListener(position -> {
            startActivityWithPosition(position);
        });
    }


    private void startActivityWithPosition(int position) {
        Intent intent = new Intent();
        switch (position) {
            case 0://生命周期
                intent.setClass(this, LifecycleActivity.class);
                break;
            case 1://IPC机制
                intent.setClass(this, IPCMainActivity.class);
                break;
            default:
                intent.setClass(this, LifecycleActivity.class);
                break;
        }
        startActivity(intent);
    }


    class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.FunctionHolder> {

        private Context context;
        private List<String> functionList;
        private OnItemClickListener listener;

        public FunctionAdapter(Context context, List<String> list) {
            this.context = context;
            this.functionList = list;
        }

        @NonNull
        @Override
        public FunctionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.list_item_function, parent, false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick((Integer) v.getTag());
                    }
                }
            });
            return new FunctionHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FunctionHolder holder, int position) {
            holder.itemView.setTag(position);
            holder.tvFunction.setText(functionList.get(position));
        }

        @Override
        public int getItemCount() {
            return functionList.size();
        }

        class FunctionHolder extends RecyclerView.ViewHolder {
            TextView tvFunction;

            public FunctionHolder(View itemView) {
                super(itemView);
                tvFunction = itemView.findViewById(R.id.tv_function);
            }
        }

        private void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }
    }
}
