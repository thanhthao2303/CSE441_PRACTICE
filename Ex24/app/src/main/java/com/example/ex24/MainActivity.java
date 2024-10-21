package com.example.ex24;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvTyGia;
    TextView txtDate;
    ArrayList<TyGia> dsTyGia;
    MyArrayAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTyGia = findViewById(R.id.lv1); // ListView to display exchange rates
        txtDate = findViewById(R.id.txtdate); // TextView to display the current date

        dsTyGia = new ArrayList<>();
        myAdapter = new MyArrayAdapter(MainActivity.this, R.layout.item, dsTyGia);
        lvTyGia.setAdapter(myAdapter);

        // Lấy và hiển thị ngày hiện tại
        getCurrentDate();

        // Lấy dữ liệu từ API
        TyGiaTask task = new TyGiaTask();
        task.execute();
    }

    // Hàm lấy ngày hiện tại và hiển thị trong TextView txtDate
    private void getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = simpleDateFormat.format(calendar.getTime());
        txtDate.setText("Hôm nay: " + currentDate);
    }

    // AsyncTask để lấy dữ liệu từ API
    class TyGiaTask extends AsyncTask<Void, Void, ArrayList<TyGia>> {

        @Override
        protected ArrayList<TyGia> doInBackground(Void... voids) {
            ArrayList<TyGia> ds = new ArrayList<>();
            try {
                // Đường dẫn URL của API
                URL url = new URL("https://dongabank.com.vn/exchange/export");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                // Nhận luồng dữ liệu từ API
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }

                // Parse dữ liệu JSON
                String json = builder.toString();
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("items");

                // Duyệt qua danh sách các đối tượng JSON và tạo đối tượng TyGia
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    String type = item.getString("type");    // Loại tiền tệ
                    String muatm = item.getString("muatm");  // Tỷ giá mua tiền mặt
                    String bantm = item.getString("bantm");  // Tỷ giá bán tiền mặt

                    // Tạo đối tượng TyGia và thêm vào danh sách
                    TyGia tiGia = new TyGia(type, muatm, bantm);
                    ds.add(tiGia);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return ds; // Trả về danh sách tỷ giá
        }

        @Override
        protected void onPostExecute(ArrayList<TyGia> result) {
            super.onPostExecute(result);
            // Cập nhật danh sách tỷ giá vào ListView
            dsTyGia.clear();
            dsTyGia.addAll(result);
            myAdapter.notifyDataSetChanged();
        }
    }
}
