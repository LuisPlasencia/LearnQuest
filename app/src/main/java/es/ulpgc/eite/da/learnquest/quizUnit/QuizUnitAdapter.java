package es.ulpgc.eite.da.learnquest.quizUnit;

import android.util.Log;
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
import es.ulpgc.eite.da.learnquest.data.QuizUnitResult;

public class QuizUnitAdapter extends RecyclerView.Adapter<QuizUnitAdapter.ViewHolder> {

    public static String TAG = QuizUnitAdapter.class.getSimpleName();

    private List<QuizUnitItem> itemList;
    private List<QuizUnitResult> resultList;
    private final View.OnClickListener clickListener;

    public QuizUnitAdapter(View.OnClickListener listener) {
        resultList = new ArrayList<>();
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
        holder.practiseButton.setTag(itemList.get(position));
        holder.title.setText(itemList.get(position).title);
        holder.description.setText(itemList.get(position).description);

        QuizUnitResult currentResult = findCurrentResult(itemList.get(position).getId());
//        if(currentResult != null) {
//            holder.solveButton.setEnabled(false);
//            holder.practiseButton.setEnabled(true);
//            holder.gradeImage.setImageResource(R.drawable.gold_medal);
//        } else {
//            holder.solveButton.setEnabled(true);
//            holder.practiseButton.setEnabled(false);
//            holder.gradeImage.setImageResource(R.drawable.silver_medal);
//        }

        if(currentResult.medalla.equals("gold")){
            holder.gradeImage.setImageResource(R.drawable.gold_medal);
            holder.practiseButton.setEnabled(true);
            holder.solveButton.setEnabled(false);
        } else if(currentResult.medalla.equals("silver")){
            holder.gradeImage.setImageResource(R.drawable.silver_medal);
            holder.solveButton.setEnabled(true);
            holder.practiseButton.setEnabled(false);
        } else if(currentResult.medalla.equals("bronze")){
            holder.gradeImage.setImageResource(R.drawable.bronze_medal);
            holder.solveButton.setEnabled(true);
            holder.practiseButton.setEnabled(false);
        } else{
            holder.solveButton.setEnabled(true);
            holder.practiseButton.setEnabled(false);

        }

        holder.mark.setText(String.valueOf(currentResult.mark) + "%");

        holder.solveButton.setOnClickListener(clickListener);
        holder.practiseButton.setOnClickListener(clickListener);
    }

    private QuizUnitResult findCurrentResult(int quizId) {
        if(resultList == null) {
            Log.d(TAG, "resultList == null");
            return null;
        }
        for(QuizUnitResult result : resultList) {
            if(result.getQuizUnitId() == quizId) {
                return result;
            }
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setResults(List<QuizUnitResult> quizUnitResults) {
        resultList = quizUnitResults;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final Button solveButton, practiseButton;
        final CardView cardView;
        final TextView title, description, mark;
        final ImageView gradeImage;

        ViewHolder(View view) {
            super(view);
            cardView = view.findViewById(R.id.quizunit_cardview);
            title = view.findViewById(R.id.quizunite_title);
            description = view.findViewById(R.id.quizunite_description);
            gradeImage = view.findViewById(R.id.quizunit_grade);
            solveButton = view.findViewById(R.id.quizunit_solve_button);
            practiseButton = view.findViewById(R.id.quizunit_practica_button);
            mark = view.findViewById(R.id.mark);

        }
    }
}
