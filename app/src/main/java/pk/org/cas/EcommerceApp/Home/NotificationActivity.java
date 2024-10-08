package pk.org.cas.EcommerceApp.Home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pk.org.cas.EcommerceApp.R;

public class NotificationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView ivBackNot;
    NotificationAdapter notificationAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        recyclerView = findViewById(R.id.rvNotification);
        ivBackNot = findViewById(R.id.ivBackNotification);

        ivBackNot.setOnClickListener(view -> {
            finish();
        });

        notificationAdapter = new NotificationAdapter(getNotificationData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(notificationAdapter);
        recyclerView.setHasFixedSize(true);
        notificationAdapter.setOnItemClickListener(new NotificationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NotificationAdapter.NotificationViewHolder holder, int position) {
                Toast.makeText(NotificationActivity.this, "Click on Notification.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public List<Notification> getNotificationData(){
        List<Notification> notifications = new ArrayList<>();
        notifications.add(new Notification("Order", "You order will be received in 2 days. Thanks", "2 July 1947", R.drawable.profile_icon));
        notifications.add(new Notification("Order", "You order will be received in 2 days. Thanks", "2 July 1947", R.drawable.profile_icon));
        notifications.add(new Notification("Order", "You order will be received in 2 days. Thanks", "2 July 1947", R.drawable.profile_icon));
        return notifications;
    }

}