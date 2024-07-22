import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class InformationActivity extends AppCompatActivity {
     DataBaseHelper myDb;
    Button btn;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        myDb = new DataBaseHelper(this);
        btn = (Button)findViewById(R.id.button6);
        viewAll();
        Intent intent=getIntent();
    }
 public void viewAll() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    // show message
                    showMessage("Error", "Nothing found");
                    return;
                }
StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("MovieName:" + res.getString(0) + "\n");
                    buffer.append("castcrew:" + res.getString(1) + "\n");
                    buffer.append("Rating:" + res.getString(2) + "\n");
                    buffer.append("Timings:" + res.getString(3) + "\n");
                    buffer.append("Theatre:" + res.getString(4) + "\n");
                    buffer.append("Category:" + res.getString(5) + "\n\n\n\n");
}
showMessage("Data", buffer.toString());
            }
 });}
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}

