package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.recipeapp.data.Recipes
import com.example.recipeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarDetail)
        //menampilkan tombol back
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPES_DATA) as Recipes

        Glide.with(this).load(dataRecipes.photo).into(binding.imgDetail)

        binding.apply {
            tvNameRecipeDetail.text = dataRecipes.name
            tvCaloriesDetail.text = dataRecipes.calories
            tvCarboDetail.text = dataRecipes.carbo
            tvDescriptionDetail.text = dataRecipes.description
            tvIngredientsDetail.text = dataRecipes.ingredients
            tvInstructionDetail.text = dataRecipes.instructions
            tvProteinDetail.text = dataRecipes.protein
        }

    }
    companion object{
        const val RECIPES_DATA = "recipes"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}