package studnetsproject.air.foi.visitme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import studentsproject.air.foi.visitme.db.ApiMethods;
import studentsproject.air.foi.visitme.db.Owner;

/**
 * Created by Josipa on 21.1.2016..
 */
public class RegistrationActivity extends Activity {

    private CheckBox mCheckBox;
    private Button button;
    private Context mContext;
    private RestAdapter restAdapter;
    private ApiMethods apiMethods;

    private EditText lastFirstName;

    private EditText number;

    private EditText email;

    private EditText username;

    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);

        mContext = this;
        ActionBar ab = getActionBar();
        //ab.setTitle(currentFrag);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);

        ab.setTitle(getString(R.string.label_reg));

        mCheckBox = (CheckBox) findViewById(R.id.registrationCheckBox);
        button = (Button) findViewById(R.id.regButton);

        lastFirstName = (EditText) findViewById(R.id.prezimeEditText);
        number = (EditText) findViewById(R.id.telephoneEditText);
        email = (EditText) findViewById(R.id.emailEditText);
        username = (EditText) findViewById(R.id.userNameEditText);
        password = (EditText) findViewById(R.id.passEditText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCheckBox.isChecked())
                    Toast.makeText(mContext, getString(R.string.acceptTerms), Toast.LENGTH_SHORT).show();
                else if (lastFirstName.getText().length() == 0 ||
                        number.getText().length() == 0 ||
                        email.getText().length() == 0 ||
                        username.getText().length() == 0 ||
                        password.getText().length() == 0) {
                    Toast.makeText(mContext, getString(R.string.fillAll), Toast.LENGTH_SHORT).show();
                } else {
                    apiMethods = ApiMethods.restAdapter.create(ApiMethods.class);

                    Owner owner = new Owner();

                    owner.setOwn_name(lastFirstName.getText().toString());
                    owner.setUsername(username.getText().toString());
                    owner.setEmail(email.getText().toString());
                    owner.setMobile(number.getText().toString());
                    owner.setPassword(password.getText().toString());

                    apiMethods.register(owner, new Callback<Response>() {
                                @Override
                                public void success(Response response, Response response2) {
                                    Toast.makeText(getApplicationContext(), "Register success.", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void failure(RetrofitError error) {

                                }
                            }

                    );
                }
            }
        });


    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;


        }
        return super.onMenuItemSelected(featureId, item);

    }
}
