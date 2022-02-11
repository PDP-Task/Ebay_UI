package uz.context.ebaydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.context.ebaydemo.adapter.BraveAdapter
import uz.context.ebaydemo.adapter.DealsAdapter
import uz.context.ebaydemo.adapter.FavoriteAdapter
import uz.context.ebaydemo.model.Deals
import uz.context.ebaydemo.model.Favorite

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerviewFav: RecyclerView
    private lateinit var recyclerViewDeal: RecyclerView
    private lateinit var recyclerViewBrave: RecyclerView
    private lateinit var dealsAdapter: DealsAdapter
    private lateinit var favoriteAdapter: FavoriteAdapter
    private lateinit var braveAdapter: BraveAdapter
    private val favoriteList: ArrayList<Favorite> = ArrayList()
    private val braveList: ArrayList<Favorite> = ArrayList()
    private val dealList: ArrayList<Deals> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerviewFav = findViewById(R.id.recyclerview)
        recyclerViewDeal = findViewById(R.id.recyclerview_deals)
        recyclerViewBrave = findViewById(R.id.recyclerview_brave)
        recyclerViewBrave.layoutManager = GridLayoutManager(this, 3)
        recyclerviewFav.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        braveAdapter = BraveAdapter(this, braveList())
        recyclerViewBrave.adapter = braveAdapter
        recyclerViewDeal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        favoriteAdapter = FavoriteAdapter(this, favoriteList())
        dealsAdapter = DealsAdapter(dealList())
        recyclerviewFav.adapter = favoriteAdapter
        recyclerViewDeal.adapter = dealsAdapter
    }

    private fun favoriteList(): ArrayList<Favorite> {
        for (i in 0..30) {
            favoriteList.add(Favorite("Android Watch2", R.drawable.watch_img_3_))
            if (i % 2 == 0) {
                favoriteList.add(Favorite("Android Watch", R.drawable.img_watch_))
            } else {
                favoriteList.add(Favorite("Android Watch2", R.drawable.watch_img_2))
            }
        }
        favoriteList.add(Favorite("Android Watch2", R.drawable.watch_img_3_))
        return favoriteList
    }

    private fun dealList(): ArrayList<Deals> {
        for (i in 0..30) {
            if (i % 2 == 0) {
                dealList.add(Deals(R.drawable.ear_ph_1, "Earphone", 199.00))
            } else {
                dealList.add(Deals(R.drawable.ear_ph_2, "Earphone Android", 455.9))
            }
        }
        return dealList
    }

    private fun braveList(): ArrayList<Favorite> {
        braveList.add(Favorite("Brave",R.drawable.watch_img_2))
        braveList.add(Favorite("Brave",R.drawable.ear_ph_1))
        braveList.add(Favorite("Brave",R.drawable.watch_img_2))
        braveList.add(Favorite("Brave",R.drawable.ear_ph_1))
        braveList.add(Favorite("Brave",R.drawable.watch_img_2))
        braveList.add(Favorite("Brave",R.drawable.ear_ph_1))
        return braveList
    }
}