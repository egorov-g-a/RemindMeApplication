package ru.com.egorov_g_a.remindme.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.com.egorov_g_a.remindme.R;
import ru.com.egorov_g_a.remindme.dto.AbstractEntityDTO;

public class RemindListAdapter<DTO extends AbstractEntityDTO> extends RecyclerView.Adapter<RemindListAdapter.RemindViewHolder> {

    private List<DTO> data;

    public RemindListAdapter(List<DTO> data) {
        this.data = data;
    }

    @Override
    public RemindViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.remind_item, parent, false);

        return new RemindViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RemindViewHolder holder, int position) {
        AbstractEntityDTO item = data.get(position);
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class RemindViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView title;

        public RemindViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public void setData(List<DTO> data) {
        this.data = data;
    }
}
