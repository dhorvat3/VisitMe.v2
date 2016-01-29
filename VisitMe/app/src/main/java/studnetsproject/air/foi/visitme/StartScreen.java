package studnetsproject.air.foi.visitme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Klasa Koja prikazuje početni ekran, odabir jezika
 */
public class StartScreen extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }

    public void buttonClick(View view){
        //Kreiranje novog intenta sa glavnom aktivnosti
        Intent intent = new Intent(this, MainActivity.class);
        //Pokretanje glavne aktivnosti
        startActivity(intent);
    }
}
