package bo.com.innovasoft.puppy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        siguiente=(Button)findViewById(R.id.btncrearcuenta);
        siguiente.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent siguiente=new Intent(Login.this, CrearCuenta.class);
                startActivity(siguiente);
                finish();
            }
        });

    }
}
