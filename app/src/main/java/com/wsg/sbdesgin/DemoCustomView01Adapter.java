package com.wsg.sbdesgin;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.nshmura.recyclertablayout.RecyclerTabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Shinichi Nishimura on 2015/07/22.
 */
public class DemoCustomView01Adapter extends RecyclerTabLayout.Adapter<DemoCustomView01Adapter.ViewHolder> {

    private DemoImitationLoopPagerAdapter mAdapater;
    private Context context;

    public DemoCustomView01Adapter(Context context, ViewPager viewPager) {
        super(viewPager);
        this.context = context;
        mAdapater = (DemoImitationLoopPagerAdapter) mViewPager.getAdapter();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_custom_view01_tab, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setClickable(false);
        Drawable drawable = context.getResources().getDrawable(
                mAdapater.getIconValueAt(position));
        drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                drawable.getMinimumHeight());
        holder.imageView.setCompoundDrawables(null, drawable, null, null);
        SpannableString name = new SpannableString(mAdapater.getValueAt(position));
        if (position == getCurrentIndicatorPosition()) {
            holder.title.setTextColor(Color.BLACK);
            holder.imageView.setChecked(true);
            name.setSpan(new StyleSpan(Typeface.BOLD), 0, name.length(), 0);
        } else {
            holder.title.setTextColor(Color.WHITE);
            holder.imageView.setChecked(false);
        }
        holder.title.setText(name);
    }

    @Override
    public int getItemCount() {
        return mAdapater.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cus_image)
        RadioButton imageView;
        @BindView(R.id.cus_title)
        TextView title;
        @BindView(R.id.cus_root)
        LinearLayout root;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getViewPager().setCurrentItem(getAdapterPosition());
                }
            });
        }
    }
}
