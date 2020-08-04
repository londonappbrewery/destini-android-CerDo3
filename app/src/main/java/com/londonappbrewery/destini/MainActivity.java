package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mtop;
    Button mbottom;
    TextView mstory;
     int mstate;

    private Que[] question=new Que[]{
            new Que(R.string.T1_Story),
            new Que(R.string.T2_Story),
            new Que(R.string.T3_Story),
            new Que(R.string.T4_End),
            new Que(R.string.T5_End),
            new Que(R.string.T6_End)

    };
    private Ans[] answer=new Ans[]{
            new Ans(R.string.T1_Ans1),
            new Ans(R.string.T1_Ans2),
            new Ans(R.string.T2_Ans1),
            new Ans(R.string.T2_Ans2),
            new Ans(R.string.T3_Ans1),
            new Ans(R.string.T3_Ans2)


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtop=(Button) findViewById(R.id.buttonTop);
        mbottom=(Button) findViewById(R.id.buttonBottom);
        mstory=(TextView) findViewById(R.id.storyTextView);
       mstate= question[0].getMqueId();


        mtop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateState(mstate,true);

            }
        });
        mbottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                updateState(mstate, false);
            }
        });







    }
    private void updateState(int mstat, boolean check){
        if(mstat == question[0].getMqueId() && check) {
            mstory.setText(question[2].getMqueId());
            mtop.setText(answer[4].getMansId());
            mbottom.setText(answer[5].getMansId());
            mstate=question[2].getMqueId();
        }
        else if(mstat==question[0].getMqueId() && !check){
            mstory.setText(question[1].getMqueId());
            mtop.setText(answer[2].getMansId());
            mbottom.setText(answer[3].getMansId());
            mstate=question[1].getMqueId();
        }
       else if(mstat==question[1].getMqueId() && check){
            mstory.setText(question[2].getMqueId());
            mtop.setText(answer[4].getMansId());
            mbottom.setText(answer[5].getMansId());
            mstate=question[2].getMqueId();
        }
       else if(mstat==question[1].getMqueId() && !check){
           mstory.setText(question[3].getMqueId());
           mtop.setVisibility(View.GONE);
            mbottom.setVisibility(View.GONE);
            mstate=question[3].getMqueId();
        }
       else if(mstat==question[2].getMqueId() && check){
           mstory.setText(question[5].getMqueId());
            mtop.setVisibility(View.GONE);
            mbottom.setVisibility(View.GONE);
        }
       else if(mstat==question[2].getMqueId() && !check){
           mstory.setText(question[4].getMqueId());
            mtop.setVisibility(View.GONE);
            mbottom.setVisibility(View.GONE);
        }

    }


}
