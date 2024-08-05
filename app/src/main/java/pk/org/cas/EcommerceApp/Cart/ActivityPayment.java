package pk.org.cas.EcommerceApp.Cart;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import pk.org.cas.EcommerceApp.R;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityPayment extends AppCompatActivity {
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
