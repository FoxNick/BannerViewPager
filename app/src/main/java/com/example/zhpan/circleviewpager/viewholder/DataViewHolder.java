package com.example.zhpan.circleviewpager.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhpan.circleviewpager.DataBean;
import com.example.zhpan.circleviewpager.R;
import com.zhpan.bannerview.holder.ViewHolder;
import com.example.zhpan.circleviewpager.utils.ImageLoaderUtil;

/**
 * Created by zhpan on 2017/10/30.
 * Description:
 */

public class DataViewHolder implements ViewHolder<DataBean> {
    private ImageView mImageView;
    private TextView mTvDescribe;

    @Override
    public View createView(ViewGroup viewGroup, Context context, int position) {
        // 返回页面布局文件
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, viewGroup, false);
        mImageView = view.findViewById(R.id.banner_image);
        mTvDescribe = view.findViewById(R.id.tv_describe);
        return view;
    }

    @Override
    public void onBind(final Context context, DataBean data, final int position, final int size) {
        final DataBean dataBean = data;
        ImageLoaderUtil.loadImg(mImageView, dataBean.getUrl(), R.drawable.placeholder);
        mTvDescribe.setText(dataBean.getDescribe());
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, position + "点击了" + dataBean.getDescribe() + "  页面数" + size, Toast.LENGTH_SHORT).show();
            }
        });
    }
}