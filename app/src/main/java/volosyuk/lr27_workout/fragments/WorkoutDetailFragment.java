package volosyuk.lr27_workout.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import volosyuk.lr27_workout.R;
import volosyuk.lr27_workout.Workout;


public class WorkoutDetailFragment extends Fragment {

    private long workoutId;

    public WorkoutDetailFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            workoutId = savedInstanceState.getLong("workoutId");
            setWorkout(workoutId); // Убедитесь, что workoutId установлен
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putLong("workoutId", workoutId);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        if (view != null && workoutId >= 0 && workoutId < Workout.workouts.length) {
            Workout workout = Workout.workouts[(int) workoutId];

            TextView title = view.findViewById(R.id.textTitle);
            title.setText(workout.getName());

            TextView description = view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

    public void setWorkout(long id) {
        this.workoutId = id;
    }
}