package com.abhiyanth.busemkumar.abhiyanth2k18;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class About_abhiyanth extends AppCompatActivity {
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_abhiyanth);
        auth=FirebaseAuth.getInstance();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_news,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public void onBackPressed() {
      startActivity(new Intent(this,DisplayImagesActivity.class));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.nav_contact)
        {

            startActivity(new Intent(this,Contact_page.class));
        }
        if (item.getItemId()==R.id.nav_logut)
        {
            auth.signOut();
            startActivity(new Intent(this,LoginScreen.class));
        }
        if (item.getItemId()==R.id.nav_events)
        {
            startActivity(new Intent(this,Events.class));
        }
        if(item.getItemId()==R.id.nav_workshops)
        {
            startActivity(new Intent(this,Workshops.class));
        }
        if(item.getItemId()==R.id.nav_sponsors)
        {
            startActivity(new Intent(this,Sponsors.class));
        }
        if(item.getItemId()==R.id.nav_notification)
        {
            startActivity(new Intent(this,Notifications.class));
        }
        if(item.getItemId()==R.id.nav_ourteam)
        {
            startActivity(new Intent(this,OurTeam.class));
        }
        if(item.getItemId()==R.id.nav_news)
        {
            startActivity(new Intent(this,DisplayImagesActivity.class));
        }
        if (item.getItemId()==R.id.resetpassword)
        {
            auth.sendPasswordResetEmail(auth.getCurrentUser().getEmail())
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(About_abhiyanth.this, "Verification link was send to your mail", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
        return super.onOptionsItemSelected(item);
    }
    /*
    
public class Utils {
    public static String hmacSha256(String KEY, String VALUE) {
        return hmacSha(KEY, VALUE, "HmacSHA256");
    }
    private static String hmacSha(String KEY, String VALUE, String SHA_TYPE) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(KEY.getBytes("UTF-8"), SHA_TYPE);
            Mac mac = Mac.getInstance(SHA_TYPE);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(VALUE.getBytes("UTF-8"));
            byte[] hexArray = {
                    (byte)'0', (byte)'1', (byte)'2', (byte)'3',
                    (byte)'4', (byte)'5', (byte)'6', (byte)'7',
                    (byte)'8', (byte)'9', (byte)'a', (byte)'b',
                    (byte)'c', (byte)'d', (byte)'e', (byte)'f'
            };
            byte[] hexChars = new byte[rawHmac.length * 2];
            for ( int j = 0; j < rawHmac.length; j++ ) {
                int v = rawHmac[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
    */
}
