package bo.com.innovasoft.puppy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class Splash_Screen extends AppCompatActivity {


    RingProgressBar ringProgressBar1,ringProgressBar2;

    int progress = 0;
    Handler myHandler = new Handler(){

        @Override
        public void handleMessage(Message msg){
            if (msg.what == 0)
            {
                if (progress<100)
                {
                    progress ++;
                    ringProgressBar1.setProgress(progress);
                    ringProgressBar2.setProgress(progress);
                }
            }

        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        ringProgressBar1 = (RingProgressBar)findViewById(R.id.progress_bar_1);
        ringProgressBar2 = (RingProgressBar)findViewById(R.id.progress_bar_2);


        ringProgressBar1.setOnProgressListener(new RingProgressBar.OnProgressListener(){
        @Override
            public void progressToComplete(){
            Toast.makeText(Splash_Screen.this, "Completed!!", Toast.LENGTH_SHORT).show();

        }
        });


        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++)
                {
                    try {
                        Thread.sleep(100);
                        myHandler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash_Screen.this, Login.class);
                startActivity(intent);
            }
        },10000);



    }
}
