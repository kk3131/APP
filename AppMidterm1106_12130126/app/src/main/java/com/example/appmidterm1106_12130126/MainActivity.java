package com.example.appmidterm1106_12130126;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<MyListData> listData = new ArrayList<>();
        listData.add(new MyListData("印度 科契", R.drawable.a1,"印度 科契:\n" +
                "科契以其天然港性質而聞名，曾是印度幾個世紀以來的香料貿易中心，現今不但設有國際胡椒交易所，還擁有一處海軍基地以及公用機場，飛行航線可通往印度各大城市。"));
        listData.add(new MyListData("尼泊爾 加德滿都", R.drawable.a2,"尼泊爾 加德滿都:\n" +
                "加德滿都是世界上最古老有人居住的城市之一，也是自古為尼泊爾的政治文化中心與文明交流要衝，該城市始建於公元2世紀。城市所在的山谷在歷史上被稱為尼泊爾曼陀羅，因此加德滿都一直是喜馬拉雅山脈山麓中內瓦爾人文明的重要城鎮，近代，加德滿都曾作為尼泊爾王國的皇家首都，並設有尼泊爾皇室的宮殿、豪宅和花園等。"));
        listData.add(new MyListData("烏茲別克 絲路", R.drawable.a3,"烏茲別克 絲路:歷史的悠久軌跡讓烏茲別克成為文化豐富又富吸引力的地方，更因為被極具指標性的旅遊指南「孤獨星球（Lonely Planet）」選為2020值得造訪的地區"));
        listData.add(new MyListData("日本 神戶", R.drawable.a4,"日本 神戶:阪神大地震後，醫療產業成為神戶服務業中新的重要產業。日本政府更將神戶醫療產業都市構想列為國家級戰略特區，期待神戶能成為先端醫療產業中心並帶動科研等相關產業的發展。觀光產業也是神戶服務業的重要部分。"));
        listData.add(new MyListData("泰國 曼谷唐人街", R.drawable.a5,"泰國 曼谷唐人街:這裡充滿了中國元素的老建築和牌樓。其中最熱鬧的地方當屬「耀華力路（Yaowarat）」，這裡聚集了眾多美食攤販，以其豐富多樣的街頭小吃聞名於世，可以說是泰國人的美食天堂。"));
        listData.add(new MyListData("蒙古", R.drawable.a6,"蒙古:蒙古國位處內陸，加上緯度高，一年幾乎有1/3的時間在下雪，因此旅遊季節很短暫，集中在5～9月，但因為5月及9月還是偏冷，所以最適合旅遊的季節則是6～8月間，尤其7月有「那達慕大會」，是蒙古族的傳統體育盛會，也是蒙古國的國家慶典，大會中著名的「男子三競技」，也就是賽馬、射箭和摔跤此三種比賽，備受矚目。"));
        listData.add(new MyListData("阿聯酋 拉斯海瑪", R.drawable.a7,"阿聯酋 拉斯海瑪:阿聯酋 拉斯海瑪:旅遊介紹50字\n" +
                "拉斯海瑪位於阿聯酋杜拜，以其豪華度假村、沙灘和遊艇碼頭聞名。這個城市提供無數奢華體驗，包括高爾夫球場、購物中心和多樣的美食選擇。拉斯海瑪是遊客和富豪的理想度假勝地。"));
        listData.add(new MyListData("沙烏地阿拉伯 紅海", R.drawable.a8,"沙烏地阿拉伯 紅海:沙烏地阿拉伯的紅海擁有壯麗的珊瑚礁、清澈的海水和豐富的海洋生物，是潛水和浮潛愛好者的夢幻勝地。這裡的陽光和沙灘吸引著全球遊客。"));
        listData.add(new MyListData("越南 峴港", R.drawable.a9,"峴港:是位於越南中部的沿海城市，以其美麗的海灘、壯觀的山景和豐富的文化景點而聞名。峴港是遊客的熱門目的地，擁有如美溪海灘（My Khe Beach）、靈應寺（Linh Ung Pagoda）和五行山（Marble Mountains）等著名景點。這裡的美食和活躍的夜生活也深受遊客喜愛。"));
        listData.add(new MyListData("斯里蘭卡 南部和中部", R.drawable.a10,"斯里蘭卡:印度洋上的美麗島國，以其豐富的文化遺產、壯觀的自然風光和迷人的海灘而聞名。這裡有古老的廟宇、茶園和野生動物園，是旅遊和冒險的理想目的地。"));
        listData.add(new MyListData("韓國 明洞", R.drawable.a11,"明洞:是位於韓國首爾的一個繁華商業區，以其熱鬧的購物街、街頭小吃和夜生活聞名。這裡匯集了各類品牌專賣店、化妝品店和時尚服飾店，是購物愛好者的天堂。此外，明洞還有許多美味的餐廳和咖啡館，讓遊客盡享美食之旅。這個地方絕對是來首爾旅行不可錯過的景點之一。"));
        listData.add(new MyListData("中國江西廬山", R.drawable.a12,"中國江西廬山:廬山瀑布：這是廬山的標誌性景點，瀑布高達120米，是中國最高的瀑布之一。\n" +
                "\n" +
                "廬山國家森林公園：這裡有廣闊的森林和多樣的動植物，是遊客享受大自然的好地方。\n" +
                "\n" +
                "廬山風景區：這裡有許多美麗的湖泊、山峰和古代建築，是遊客拍照和散步的好地方。\n" +
                "\n" +
                "廬山寺廟：廬山有許多歷史悠久的寺廟，如廬山大峰寺和廬山萬松寺，遊客可以在這裡體驗佛教文化。"));

        MyListAdapter adapter = new MyListAdapter(listData, this);
        recyclerView.setAdapter(adapter);
    }
}
