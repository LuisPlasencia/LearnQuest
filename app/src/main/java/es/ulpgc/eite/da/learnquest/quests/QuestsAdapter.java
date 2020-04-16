package es.ulpgc.eite.da.learnquest.quests;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuestItem;

public class QuestsAdapter extends RecyclerView.Adapter<QuestsAdapter.ViewHolder> {

    private List<QuestItem> itemList;
    private final View.OnClickListener clickListener;

    public QuestsAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }

    public void setItems(List<QuestItem> items){
        itemList = items;
    }

    @Override
    public QuestsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quests_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuestsAdapter.ViewHolder holder, int position) {
        holder.title.setText(itemList.get(position).getSubject());
        Log.d("QuestsAdapter", itemList.get(position).getSubject());
        holder.percentage.setText(String.valueOf(itemList.get(position).getPercentage()) + "%");
        holder.questImage.setImageResource(itemList.get(position).getPhoto());
        holder.itemView.setTag(itemList.get(position));
        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final CardView cardView;
        final TextView title, percentage;
        final ImageView questImage;

        ViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.questsunit_cardview);
            title = view.findViewById(R.id.quest_name);
            percentage = view.findViewById(R.id.quest_level_id);
            questImage = view.findViewById(R.id.quest_level_icon);
        }
    }
}
