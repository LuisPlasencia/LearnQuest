package es.ulpgc.eite.da.learnquest.statistics;

import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.User;

public class StatisticsAdapter extends RecyclerView.Adapter<es.ulpgc.eite.da.learnquest.statistics.StatisticsAdapter.ViewHolder> {

    private List<User> userList;
    private final View.OnClickListener clickListener;
    public int color;

    public StatisticsAdapter(View.OnClickListener listener) {
        userList = new ArrayList();
        clickListener = listener;
        color = 0;
    }

    public void setItems(List<User> items){
        userList = items;
        notifyDataSetChanged();
    }

    @Override
    public es.ulpgc.eite.da.learnquest.statistics.StatisticsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.statistics_list_content, parent, false);
        return new es.ulpgc.eite.da.learnquest.statistics.StatisticsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StatisticsAdapter.ViewHolder holder, int position) {
        holder.itemView.setTag(userList.get(position));
        holder.itemView.setOnClickListener(clickListener);

        int mathExperience = userList.get(position).getEnglishPercentage();
        int englishExperience = userList.get(position).getMathPercentage();
        int geographyExperience = userList.get(position).getGeographyPercentage();

        holder.username.setText(userList.get(position).getUsername());
        holder.level.setText(String.valueOf("Level: " + userList.get(position).getLevel()));
        holder.percentageMaths.setText(String.valueOf(mathExperience + "%"));
        holder.percentageEnglish.setText(String.valueOf(englishExperience + "%"));
        holder.percentageGeography.setText(String.valueOf(geographyExperience + "%"));


        holder.maths_Image.setImageResource(getSubjectPhoto(mathExperience));
        holder.english_Image.setImageResource(getSubjectPhoto(englishExperience));
        holder.geography_Image.setImageResource(getSubjectPhoto(geographyExperience));


        holder.mProgressBar.setProgress(mathExperience);
        holder.eProgressBar.setProgress(englishExperience);
        holder.gProgressBar.setProgress(geographyExperience);


        String photo = userList.get(position).getPhotoAdress();
        if(photo.equals("Predeterminada")){
            holder.userImage.setImageResource(android.R.drawable.ic_menu_camera);
        }else if(photo.equals("Patata")){
            holder.userImage.setImageResource(R.drawable.patata);
        }else if(photo.equals("Rabano")){
            holder.userImage.setImageResource(R.drawable.rabano);
        }else if(photo.equals("Lechuga")){
            holder.userImage.setImageResource(R.drawable.lechuga);
        }


        final int baseColor = Color.WHITE;      //cambiando el color base podemos tener una paleta de colores distinta

        Random mRandom = new Random(System.currentTimeMillis());

        int baseRed = Color.red(baseColor);
        int baseGreen = Color.green(baseColor);
        int baseBlue = Color.blue(baseColor);

        int red = (baseRed + mRandom.nextInt(256)) / 2;
        int green = (baseGreen + mRandom.nextInt(256)) / 2;
        int blue = (baseBlue + mRandom.nextInt(256)) / 2;

        color = Color.rgb(red, green, blue);

        holder.cardView.setCardBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final CardView cardView;
        final TextView username;
        final TextView level;
        final TextView percentageMaths;
        final TextView percentageEnglish;
        final TextView percentageGeography;
        final ImageView maths_Image;
        final ImageView english_Image;
        final ImageView geography_Image;
        final ImageView userImage;
        final ProgressBar mProgressBar;
        final ProgressBar eProgressBar;
        final ProgressBar gProgressBar;

        ViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.statistics_cardview);
            username = view.findViewById(R.id.user_name);
            level = view.findViewById(R.id.user_level);
            percentageMaths = view.findViewById(R.id.quest_level_id1);
            percentageEnglish = view.findViewById(R.id.quest_level_id2);
            percentageGeography = view.findViewById(R.id.quest_level_id3);
            userImage = view.findViewById(R.id.user_profile_icon);
            maths_Image = view.findViewById(R.id.quest_level_icon_maths);
            english_Image = view.findViewById(R.id.quest_level_icon_english);
            geography_Image = view.findViewById(R.id.quest_level_icon_geography);
            mProgressBar = view.findViewById(R.id.progressBar_Maths);
            eProgressBar = view.findViewById(R.id.progressBar_english);
            gProgressBar = view.findViewById(R.id.progressBar_geography);

        }
    }

    private int getSubjectPhoto(int percentage) {
        if (percentage > 70) {
            return R.drawable.dragon;
        } else if (percentage > 25) {
            return R.drawable.pig;
        }
        return R.drawable.child;
    }

}
