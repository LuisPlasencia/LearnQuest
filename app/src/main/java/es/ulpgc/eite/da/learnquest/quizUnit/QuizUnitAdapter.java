package es.ulpgc.eite.da.learnquest.quizUnit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.da.learnquest.R;
import es.ulpgc.eite.da.learnquest.data.QuizUnitItem;

public class QuizUnitAdapter extends RecyclerView.Adapter<QuizUnitAdapter.ViewHolder> {

    private List<QuizUnitItem> itemList;
    private final View.OnClickListener clickListener;

    public QuizUnitAdapter(View.OnClickListener listener) {

        itemList = new ArrayList();
        clickListener = listener;
    }

    public void setItems(List<QuizUnitItem> items){
        itemList = items;
        notifyDataSetChanged(); //
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { // crea celdas
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quiz_unit_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) { // rellena celdas
        holder.solveButton.setTag(itemList.get(position));
        holder.title.setText(itemList.get(position).title);
        holder.description.setText(itemList.get(position).description);
        holder.solveButton.setEnabled(!itemList.get(position).isSolved());
        holder.practiseButton.setEnabled(itemList.get(position).isSolved());
        holder.gradeImage.setImageResource(R.drawable.grade);
        holder.solveButton.setOnClickListener(clickListener);
        holder.practiseButton.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final Button solveButton, practiseButton;
        final CardView cardView;
        final TextView title, description;
        final ImageView gradeImage;

        ViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.quizunit_cardview);
            title = view.findViewById(R.id.quizunite_title);
            description = view.findViewById(R.id.quizunite_description);
            gradeImage = view.findViewById(R.id.quizunit_grade);
            solveButton = view.findViewById(R.id.quizunit_solve_button);
            practiseButton = view.findViewById(R.id.quizunit_practica_button);
        }
    }
}
