package com.example.listview3;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	ListView lv;
	 ArrayList<Student> list=new ArrayList<Student>();
     MyAdapter adapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    lv=(ListView) this.findViewById(R.id.listView1);
    //put static
      list.add(new Student(R.drawable.img1,"Alpha, Bravo", "BSIT"));
      list.add(new Student(R.drawable.img2,"Charlie, Hotel", "BSOA"));
      list.add(new Student(R.drawable.img3,"Mike, India", "BSA"));
      list.add(new Student(R.drawable.img4,"November, Kilo", "BSED"));
      list.add(new Student(R.drawable.img5,"Oscar, Quebec", "BSHRM"));
      list.add(new Student(R.drawable.img6,"Zulu, Uniform", "BSE"));
      list.add(new Student(R.drawable.img7,"Delta, Tango", "BSCREAM"));
      list.add(new Student(R.drawable.img8,"Juliet, Sierra", "AB"));
    //instance
      adapter=new MyAdapter(this,list);
      //associate
      this.lv.setAdapter(adapter);
    
    //add listener
    this.lv.setOnItemClickListener(this);
    
    
    
    }

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	  
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle(list.get(arg2).getStudentName());
		
		ImageView myiv=new ImageView(this);
			myiv.setImageResource(list.get(arg2).getImage());
		TextView myname=new TextView(this);
			myname.setText(list.get(arg2).getStudentName());
		TextView mycourse=new TextView(this);
			mycourse.setText(list.get(arg2).getCourse());
		
		LinearLayout mainLayout=new LinearLayout(this);	
				mainLayout.setOrientation(LinearLayout.HORIZONTAL);
				mainLayout.addView(myiv);
				
		LinearLayout subLayout=new LinearLayout(this);
			subLayout.setOrientation(LinearLayout.VERTICAL);
			subLayout.addView(myname);
			subLayout.addView(mycourse);
			
			mainLayout.addView(subLayout);
			
			builder.setView(mainLayout);
			builder.setNeutralButton("Okey", null);
			
	AlertDialog dialog=builder.create();
		dialog.show();
	
			
	}    
}
