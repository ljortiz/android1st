package com.example.mylistvieww2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener, android.content.DialogInterface.OnClickListener {
	
	ListView lv;
	Button btnAdd;
	AlertDialog.Builder builder;
	
	ArrayList<String> list=new ArrayList<String>();
	ArrayAdapter<String> adapter;
	EditText txtAdd;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
        builder=new AlertDialog.Builder(this);
        
        
        this.lv=(ListView) this.findViewById (R.id.listView1);

         this.adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        this.lv.setOnItemClickListener(this);
        
        
        this.lv=(ListView) this.findViewById(R.id.listView1);
        this.btnAdd=(Button) this.findViewById(R.id.button1);
        this.lv.setAdapter(adapter);
        
        this.btnAdd.setOnClickListener(this);
        //add event listener to the listview
        this.lv.setOnItemClickListener(this);
    
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		txtAdd=new EditText(this);
		
		txtAdd.setHint("Enter Name");
		
		builder.setTitle("add item");
		builder.setView(txtAdd);
		builder.setPositiveButton("OK",this);
		builder.setNegativeButton("Cancel",this);
		
		AlertDialog dialog=builder.create();
			dialog.show();
		
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		AlertDialog.Builder b=new AlertDialog.Builder(this);
		
		
		String s=this.lv.getItemAtPosition(arg2).toString();
		b.setTitle("Selected Item");
		b.setMessage(s);
		b.setNeutralButton("Okey", null);
		
		AlertDialog dialog=b.create();
		 dialog.show();
		 
	}


	@Override
	public void onClick(DialogInterface arg0, int arg1) {
		// TODO Auto-generated method stub
		switch(arg1){
		case DialogInterface.BUTTON_POSITIVE:
		//retrieve the typed data from the EditText
			String s=this.txtAdd.getText().toString();
		//check if there is typed data
			
			if(!s.equals("")){
				//add the typed to the data
				list.add(s);
				//update
				this.adapter.notifyDataSetChanged();
				arg0.dismiss();
				
			}
			else Toast.makeText(this,"Type Name", Toast.LENGTH_SHORT).show();
			
			break;
		case DialogInterface.BUTTON_NEGATIVE:break;
		//dismiss the dialog
			
			
		}
		
	} 
}






name=(EditText) this.findViewById(R.id.editText1);
course=(EditText) this.findViewById(R.id.editText2);
add= (Button)this.findViewById(R.id.button1);
lv=(ListView)this.findViewById(R.id.listView1);


this.add.setOnClickListener(this);
this.adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
this.lv.setOnItemClickListener(this);

this.lv.setAdapter(adapter);

