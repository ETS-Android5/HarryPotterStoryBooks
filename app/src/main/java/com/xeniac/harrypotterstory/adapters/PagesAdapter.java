package com.xeniac.harrypotterstory.adapters;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.xeniac.harrypotterstory.R;
import com.xeniac.harrypotterstory.models.DataItemPages;

import java.util.List;

public class PagesAdapter extends RecyclerView.Adapter<PagesAdapter.ViewHolder> {

    public static byte TEXT_SIZE_FLAG = 0;
    private List<DataItemPages> mItems;
    private Context mContext;

    public PagesAdapter(Context context, List<DataItemPages> items) {
        this.mContext = context;
        this.mItems = items;
    }

    @NonNull
    @Override
    public PagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                      int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.list_item_pages, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DataItemPages item = mItems.get(position);

        holder.numberTV.setText(item.getNumber());
        holder.textTV.setText(item.getText());

        float currentSize = holder.textTV.getTextSize();

        switch (TEXT_SIZE_FLAG) {
            case 0:
                holder.textTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSize);
                break;
            case 1:
                holder.textTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSize + 3.0f);
                break;
            case -1:
                holder.textTV.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentSize - 3.0f);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView numberTV;
        TextView textTV;

        ViewHolder(View itemView) {
            super(itemView);

            numberTV = itemView.findViewById(R.id.tv_list_pages_number);
            textTV = itemView.findViewById(R.id.tv_list_pages_text);

            mView = itemView;
        }
    }
}