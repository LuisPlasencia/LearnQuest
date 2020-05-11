//package es.ulpgc.eite.da.learnquest.statistics;
//
//import android.graphics.Color;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//import es.ulpgc.eite.da.learnquest.R;
//import es.ulpgc.eite.da.learnquest.data.User;
//
//public class StatisticsAdapter extends RecyclerView.Adapter<es.ulpgc.eite.da.learnquest.statistics.StatisticsAdapter.ViewHolder> {
//
//    private List<User> userList;
//    private final View.OnClickListener clickListener;
//    public int color;
//
//    public StatisticsAdapter(View.OnClickListener listener) {
//        userList = new ArrayList();
//        clickListener = listener;
//        color = 0;
//    }
//
//    public void setItems(List<User> items){
//        userList = items;
//        notifyDataSetChanged();
//    }
//
//    @Override
//    public es.ulpgc.eite.da.learnquest.statistics.StatisticsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.statistics_list_content, parent, false);
//        return new es.ulpgc.eite.da.learnquest.statistics.StatisticsAdapter.ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(es.ulpgc.eite.da.learnquest.quests.QuestsAdapter.ViewHolder holder, int position) {
//        holder.itemView.setTag(itemList.get(position));
//        holder.itemView.setOnClickListener(clickListener);
//
//        holder.title.setText(itemList.get(position).subjectName);
//
//        //Log.d("QuestsAdapter", itemList.get(position).getSubject());
//        holder.percentage.setText(String.valueOf(itemList.get(position).getPercentage()));
//        holder.questImage.setImageResource(itemList.get(position).getPhoto());
//
//
//        final int baseColor = Color.WHITE;      //cambiando el color base podemos tener una paleta de colores distinta
//
//        Random mRandom = new Random(System.currentTimeMillis());
//
//        int baseRed = Color.red(baseColor);
//        int baseGreen = Color.green(baseColor);
//        int baseBlue = Color.blue(baseColor);
//
//        int red = (baseRed + mRandom.nextInt(256)) / 2;
//        int green = (baseGreen + mRandom.nextInt(256)) / 2;
//        int blue = (baseBlue + mRandom.nextInt(256)) / 2;
//
//        color = Color.rgb(red, green, blue);
//
//        holder.cardView.setCardBackgroundColor(color);
//    }
//
//    @Override
//    public int getItemCount() {
//        return itemList.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        final CardView cardView;
//        final TextView title;
//        final TextView percentage;
//        final ImageView questImage;
//
//        ViewHolder(View view) {
//            super(view);
//            cardView = view.findViewById(R.id.questsunit_cardview);
//            title = view.findViewById(R.id.subjectName);
//            percentage = view.findViewById(R.id.quest_level_id);
//            questImage = view.findViewById(R.id.quest_level_icon);
//        }
//    }
//}
