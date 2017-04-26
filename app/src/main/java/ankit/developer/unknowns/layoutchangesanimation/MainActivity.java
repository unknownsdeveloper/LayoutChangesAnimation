package ankit.developer.unknowns.layoutchangesanimation;

import android.animation.LayoutTransition;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText textIn;
    Button btnAdd;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textIn = (EditText)findViewById(R.id.textIn);

        btnAdd = (Button)findViewById(R.id.add);

        container = (LinearLayout)findViewById(R.id.container);



        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                final View addView = inflater.inflate(R.layout.row,null);

                TextView textOut = (TextView)addView.findViewById(R.id.textout);

                textOut.setText(textIn.getText().toString());

                Button btnRemove = (Button)addView.findViewById(R.id.remove);

                btnRemove.setOnClickListener(new View.OnClickListener() {

                    @Override

                    public void onClick(View view) {

                        ((LinearLayout)addView.getParent()).removeView(addView);

                    }

                });

                container.addView(addView);

                textIn.setText("");

            }

        });



        //Apply animations on Layout Changes

        LayoutTransition transition = new LayoutTransition();
        container.setLayoutTransition(transition);


    }
}
