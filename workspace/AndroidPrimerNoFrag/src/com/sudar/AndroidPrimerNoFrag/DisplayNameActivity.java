package com.sudar.AndroidPrimerNoFrag;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayNameActivity extends ActionBarActivity {
  
  public static final String INTENT_KEY_NAME = "inputName";
  
  private TextView mNameView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_display_name);
    this.mNameView = (TextView) findViewById(R.id.text_view_name);
    // Retrieve the passed in name.
    String retrievedName = getIntent().getExtras().getString(INTENT_KEY_NAME);
    String message;
    if (retrievedName == null) {
      message = "You didn't give me a name!";
    } else {
      message = "Hello, " + retrievedName + "!";
    }
    this.mNameView.setTextSize(30);
    this.mNameView.setText(message);

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {

    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.display_name, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    if (id == R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

}
