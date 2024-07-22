import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {
    EditText e1,e2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        e1= (EditText) findViewById(R.id.loginid);
        e2= (EditText) findViewById(R.id.pass);
        b1= (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=e1.getText().toString();
                String password=e2.getText().toString();
                if(id.equals("admin") && password.equals("admin"))
                {
                    Intent intent=new Intent(LoginScreen.this,Inserting.class);
                    startActivity(intent);
                }
                if(id.equals("user")&& password.equals("user"))
                {
                    Intent intent=new Intent(LoginScreen.this,CategoryActivity.class);
                    startActivity(intent);
                }
                Intent intent=getIntent();
            }
        });
    }
}
