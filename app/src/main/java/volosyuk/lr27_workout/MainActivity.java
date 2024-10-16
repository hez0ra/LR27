package volosyuk.lr27_workout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import volosyuk.lr27_workout.fragments.WorkoutDetailFragment;
import volosyuk.lr27_workout.fragments.WorkoutListFragment;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    View fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainer = findViewById(R.id.fragment_container);
    }



    @Override
    public void itemClicked(long id) {
        Log.d("MainActivity", "Item clicked with ID: " + id);
        if (fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            details.setWorkout(id);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.commit();
            Log.d("FragmentTransaction", "Fragment replaced successfully.");
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }
    }
}
