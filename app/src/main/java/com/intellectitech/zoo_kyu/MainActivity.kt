package com.intellectitech.zoo_kyu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var listOfAnimals = ArrayList<Animal>()
   var adapter:AnimalsAdapter?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Load animals
        listOfAnimals.add(
            Animal("Baboon","Baboon live in  big place with tree",R.drawable.baboon,false))
        listOfAnimals.add(
            Animal("Bulldog","Bulldog live in  big place with tree",R.drawable.bulldog,false))
        listOfAnimals.add(
            Animal("Panda","Panda live in  big place with tree",R.drawable.panda,true))
        listOfAnimals.add(
            Animal("Swallow","Swallow live in  big place with tree",R.drawable.swallow_bird,false))
        listOfAnimals.add(
            Animal("Tiger","Tiger live in  big place with tree",R.drawable.white_tiger,true))
        listOfAnimals.add(
            Animal("Zebra","Zebra live in  big place with tree",R.drawable.zebra,false))

        adapter = AnimalsAdapter(this,listOfAnimals)
        findViewById<ListView>(R.id.lv_view) .adapter =  adapter
    }
    fun delete(index:Int){
        listOfAnimals.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }
    fun  add(index:Int){
        listOfAnimals.add(index,listOfAnimals[index])
        adapter!!.notifyDataSetChanged()
    }
    inner class  AnimalsAdapter: BaseAdapter {
        var  listOfAnimals= ArrayList<Animal>()
        var context: Context?=null
        constructor(context: Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals=listOfAnimals
            this.context=context
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal =  listOfAnimals[p0]
            if( animal.isKiller ==true) {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_killer_ticket, null)



                myView.findViewById<TextView>(R.id.tvDes).text = animal.name!!
                myView.findViewById<TextView>(R.id.tvName).text = animal.des!!
                myView.findViewById<ImageView>(R.id.ivAnimalImage).setImageResource(animal.image!!)
                myView.findViewById<ImageView>(R.id.ivAnimalImage).setOnClickListener {

                    val intent = Intent(context,Animal_info::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)


                }
                return myView

            }else {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.findViewById<TextView>(R.id.tvDes).text = animal.name!!
                myView.findViewById<TextView>(R.id.tvDes).text = animal.des!!
                myView.findViewById<ImageView>(R.id.ivAnimalImage).setImageResource(animal.image!!)
                myView.findViewById<ImageView>(R.id.ivAnimalImage).setOnClickListener {
                    add(p0)

                    val intent = Intent(context,Animal_info::class.java)
                    intent.putExtra("name",animal.name!!)
                    intent.putExtra("des",animal.des!!)
                    intent.putExtra("image",animal.image!!)
                    context!!.startActivity(intent)


                }
                return myView
            }
        }

        override fun getItem(p0: Int): Any {
            return listOfAnimals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return  listOfAnimals.size
        }

    }
}