package com.recyclerviewkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.zhaoyun,
                "Zhao Yun",
                "A brave Warrior Uses Spear"
            ),
            Superhero(
                R.drawable.lubu,
                "Lubu",
                "A Monster who slain everyone"
            ),
            Superhero(
                R.drawable.zhouyu,
                "Zhao Yu",
                "A cool strategist who fought bravely"
            ),
            Superhero(
                R.drawable.liubei,
                "Liu Bei",
                "A Commander of Shu army"
            ),
            Superhero(
                R.drawable.daqiao,
                "Da Qiao",
                "A young women from Wu army"
            ),
            Superhero(
                R.drawable.xiahoudun,
                "Xiahou Dun",
                "A Wei army who has one eyed eye"
            ), Superhero(
                R.drawable.guanyu,
                "Guan Yu",
                "A sworn brother of Liu Bei"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rvHero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this,superheroList){
            val intent = Intent(this,DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)

        }
    }
}